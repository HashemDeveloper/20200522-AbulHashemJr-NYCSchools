package com.project.java.core.utils.netconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.project.java.core.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ConnectionStateMonitor extends LiveData<Boolean> implements IConnectionStateMonitor {
    private static final String TAG = ConnectionStateMonitor.class.getCanonicalName();
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConnectivityManager.NetworkCallback networkCallback;
    private ConnectivityManager connectivityManager;
    private MutableLiveData<Boolean> apiBelowLiveData = new MutableLiveData<>();

    @Inject
    public ConnectionStateMonitor(Context context) {
        this.context = context;
        this.connectivityManager = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    protected void onActive() {
        super.onActive();
        this.compositeDisposable.add(operateOnBackground()
                .subscribeOn(Schedulers.io())
                .flatMap((Function<Boolean, SingleSource<DeviceApiType>>) register -> registerNetworkCallbacks())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(deviceApiType -> {
                    if (deviceApiType.equals(DeviceApiType.API_BELOW_21)) {
                        this.apiBelowLiveData.setValue(true);
                    }
                }, this::debug));
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        this.compositeDisposable.add(operateOnBackground()
                .subscribeOn(Schedulers.io())
                .subscribe(run -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        if (this.connectivityManager != null) {
                            this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
                        }
                    }
                }, this::debug));
    }

    private void updateConnection() {
        this.compositeDisposable.add(operateOnBackground()
                .subscribeOn(Schedulers.io())
                .flatMap((Function<Boolean, SingleSource<Boolean>>) run -> getNetworks())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isNetAvailable -> {
                    if (isNetAvailable) {
                        postValue(true);
                    } else {
                        postValue(false);
                    }
                }, this::debug));
    }
    private SingleSource<Boolean> getNetworks() {
        return new Single<Boolean>() {
            @Override
            protected void subscribeActual(SingleObserver<? super Boolean> observer) {
                if (connectivityManager != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Network network = null;
                        for (Network allNetworks : connectivityManager.getAllNetworks()) {
                            network = allNetworks;
                        }
                        if (connectivityManager.getNetworkCapabilities(network) != null) {
                            boolean isWifiConnected = Objects.requireNonNull(connectivityManager.getNetworkInfo(network)).isConnected();
                            boolean isMobileConnected = Objects.requireNonNull(connectivityManager.getNetworkInfo(network)).isConnected();
                            if (isWifiConnected || isMobileConnected) {
                                if (PingNetwork.isOnline()) {
                                    observer.onSuccess(true);
                                } else {
                                    observer.onSuccess(false);
                                }
                            } else {
                                observer.onSuccess(false);
                            }
                        } else {
                            observer.onSuccess(false);
                        }
                    }
                } else {
                    observer.onSuccess(false);
                }
            }
        };
    }
    private SingleSource<DeviceApiType> registerNetworkCallbacks() {
        return new Single<DeviceApiType>() {
            @Override
            protected void subscribeActual(SingleObserver<? super DeviceApiType> observer) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    if (connectivityManager != null) {
                        NetworkRequest request = getNetworkRequest();
                        connectivityManager.registerNetworkCallback(request, networkCallback);
                        observer.onSuccess(DeviceApiType.API_ABOVE_21);
                    }
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (connectivityManager != null) {
                        NetworkRequest request = getNetworkRequest();
                        connectivityManager.requestNetwork(request, networkCallback);
                        observer.onSuccess(DeviceApiType.API_ABOVE_21);
                    }
                } else {
                    // api below 21
                    boolean isWifiConnected = Objects.requireNonNull(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)).isConnected();
                    boolean isMobileConnected = Objects.requireNonNull(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)).isConnected();
                    if (isWifiConnected || isMobileConnected) {
                        if (PingNetwork.isOnline()) {
                            postValue(true);
                        } else {
                            postValue(false);
                        }
                    } else {
                        postValue(false);
                    }
                    observer.onSuccess(DeviceApiType.API_BELOW_21);
                }
            }
        };
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private NetworkRequest getNetworkRequest() {
        return new NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build();
    }

    private void debug(Throwable error) {
        if (BuildConfig.DEBUG) {
            if (error != null) {
                Timber.i(TAG, error.getLocalizedMessage());
            }
        }
    }
    @Override
    public void setupConnectionStateMonitor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (this.networkCallback == null) {
                this.networkCallback = new JLimoNetCallBack(this);
            }
        }
    }

    @Override
    public LiveData<Boolean> getApiBelowLiveData() {
        return this.apiBelowLiveData;
    }

    private Single<Boolean> operateOnBackground() {
        return Single.fromCallable(() -> true);
    }

    @Override
    public ConnectionStateMonitor getObserver() {
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static class JLimoNetCallBack extends ConnectivityManager.NetworkCallback {
        private ConnectionStateMonitor connectionStateMonitor;
        private boolean isNetworkCallbackRegistered = false;
        private boolean isNetAvailabble = false;
        JLimoNetCallBack(ConnectionStateMonitor connectionStateMonitor) {
            this.connectionStateMonitor = connectionStateMonitor;
            Handler callbackHandler = new Handler();
            callbackHandler.postDelayed(() -> {
                if (!this.isNetworkCallbackRegistered) {
                    this.connectionStateMonitor.updateConnection();
                }
            }, 10000);
        }

        @Override
        public void onAvailable(@NotNull Network network) {
            super.onAvailable(network);
            this.isNetworkCallbackRegistered = true;
            this.isNetAvailabble = true;
        }

        @Override
        public void onLost(@NotNull Network network) {
            super.onLost(network);
            this.isNetworkCallbackRegistered = true;
            this.connectionStateMonitor.postValue(false);
        }

        @Override
        public void onUnavailable() {
            super.onUnavailable();
            this.isNetworkCallbackRegistered = true;
            this.connectionStateMonitor.postValue(false);
        }

        @Override
        public void onCapabilitiesChanged(@NotNull Network network, NetworkCapabilities networkCapabilities) {
            if (!networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                this.connectionStateMonitor.postValue(false);
            } else {
                if (this.isNetAvailabble) {
                    this.connectionStateMonitor.postValue(true);
                }
            }
            this.isNetworkCallbackRegistered = true;
        }
    }
    public enum DeviceApiType {
        API_ABOVE_21,
        API_BELOW_21
    }
}
