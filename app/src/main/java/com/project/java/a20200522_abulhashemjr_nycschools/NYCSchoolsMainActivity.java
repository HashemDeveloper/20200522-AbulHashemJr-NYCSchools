package com.project.java.a20200522_abulhashemjr_nycschools;

import androidx.fragment.app.Fragment;

import com.project.java.core.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class NYCSchoolsMainActivity extends BaseActivity implements HasSupportFragmentInjector {

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
}
