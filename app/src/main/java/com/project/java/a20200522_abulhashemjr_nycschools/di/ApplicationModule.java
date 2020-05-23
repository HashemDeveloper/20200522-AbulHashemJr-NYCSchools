package com.project.java.a20200522_abulhashemjr_nycschools.di;

import android.content.Context;

import com.project.java.a20200522_abulhashemjr_nycschools.NYCSchoolsApp;
import com.project.java.remote.repo.ISchoolRepository;
import com.project.java.remote.repo.SchoolRepository;

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
    @Singleton
    @Provides
    ISchoolRepository provideSchoolRepo(SchoolRepository schoolRepository) {
        return schoolRepository;
    }
}
