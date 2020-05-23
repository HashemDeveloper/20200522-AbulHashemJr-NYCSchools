package com.project.java.a20200522_abulhashemjr_nycschools.di;

import com.project.java.a20200522_abulhashemjr_nycschools.NYCSchoolsMainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = {FragmentModuleBuilder.class})
    abstract NYCSchoolsMainActivity contributeMainActivity();
}
