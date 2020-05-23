package com.project.java.a20200522_abulhashemjr_nycschools;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.project.java.a20200522_abulhashemjr_nycschools.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class NYCSchoolsApp extends Application implements HasActivityInjector {
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return this.dispatchingAndroidInjector;
    }
}
