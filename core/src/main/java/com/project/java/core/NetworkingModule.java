package com.project.java.core;

import com.facebook.stetho.BuildConfig;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@Module
public abstract class NetworkingModule {
    private static final int READ_TIMEOUT = 10000;
    private static final int CONNECTION_TIMEOUT = 10000;
    @Singleton
    @Provides
    static Call.Factory provideOkHttp() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        return new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Content-Type", "application/json;charset=UTF-8")
                            .method(original.method(), original.body())
                            .build();
                    Response response = chain.proceed(request);
                    Timber.e("NYCSchools API Response Code: %s", response.code());
                    try {
                        if (response.code() == 401) {
                            return response;
                        }
                    } catch (Exception e) {
                        if (BuildConfig.DEBUG) {
                            if (e.getLocalizedMessage() != null) {
                                Timber.e("RetrofitError: %s", e.getLocalizedMessage());
                            }
                        }
                    } finally {
                        if (response.body() != null) {
                            response.body().close();
                        }
                    }

                    return response;
                })
                .build();
    }
    @Provides
    @Named("base_url")
    static String provideBaseUrl() {
        return ""; // TODO: Pass in API Base URL
    }
}
