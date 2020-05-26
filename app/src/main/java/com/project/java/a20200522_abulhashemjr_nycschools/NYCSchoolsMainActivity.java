package com.project.java.a20200522_abulhashemjr_nycschools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.project.java.core.base.BaseActivity;
import com.project.java.core.utils.netconnection.ConnectionSetting;
import com.project.java.core.utils.netconnection.IConnectionStateMonitor;
import com.project.java.core.utils.netconnection.PingNetwork;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class NYCSchoolsMainActivity extends BaseActivity implements HasSupportFragmentInjector {
    @Inject
    public IConnectionStateMonitor iConnectionStateMonitor;
    private ConnectionSetting connectionSetting;
    @Inject
    public DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.dispatchingAndroidInjector;
    }

    @Override
    protected int getLayout() {
        return R.layout.nyc_schools_main_layout;
    }

    @Override
    protected int theme() {
        return R.style.AppTheme;
    }

    @Override
    protected int getNavLayout() {
        return R.navigation.nyc_school_navigation_layout;
    }

    @Override
    protected int getContainerId() {
        return R.id.listOfSchool;
    }

    @Override
    protected void setupConnectionStateMonitor() {
        this.iConnectionStateMonitor.setupConnectionStateMonitor();
        this.iConnectionStateMonitor.getObserver().observe(this, networkObserver());
        this.iConnectionStateMonitor.getApiBelowLiveData().observe(this, apiBelowLiveData());
        View view = findViewById(R.id.listOfSchool);
        this.connectionSetting = new ConnectionSetting(this, view);

    }

    private Observer<Boolean> apiBelowLiveData() {
        return isApiBelow21 -> {
            if (isApiBelow21 != null) {
                if (isApiBelow21) {
                    registerReceiver(this.networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        };
    }
    private Observer<Boolean> networkObserver() {
        return isConnected -> {
            if (isConnected != null) {
                if (!isConnected) {
                    displayNetworkSetting();
                } else {
                    dismissSnackBar();
                }
            }
        };
    }

    private boolean isNetworkConnected() {
        final ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean connected = false;

        if (connMgr != null) {
            boolean isWifiConnected = Objects.requireNonNull(connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)).isConnected();
            boolean isMobileConnected = Objects.requireNonNull(connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)).isConnected();
            if (isWifiConnected || isMobileConnected) {
                connected = PingNetwork.isOnline();
            }
        }
        return connected;
    }

    private void displayNetworkSetting() {
        String message = this.getResources().getString(R.string.no_internet);
        String actionTitle = this.getResources().getString(R.string.setting);
        this.connectionSetting.initWifiSetting(false, message, actionTitle, R.color.red_400, R.color.white);
    }
    private void dismissSnackBar() {
        if (this.connectionSetting != null && this.connectionSetting.getSnackbar() != null) {
            this.connectionSetting.getSnackbar().dismiss();
        }
    }

    private BroadcastReceiver networkChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!isNetworkConnected()) {
                displayNetworkSetting();
            } else {
                dismissSnackBar();
            }
        }
    };
}
