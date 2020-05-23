package com.project.java.a20200522_abulhashemjr_nycschools.di;

import android.content.Context;

import com.project.java.a20200522_abulhashemjr_nycschools.NYCSchoolsApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    @Singleton
    @Provides
    Context provideAppContext(NYCSchoolsApp app) {
        return app;
    }
}
