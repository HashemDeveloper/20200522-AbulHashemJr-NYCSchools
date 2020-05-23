package com.project.java.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RemoteServiceModule {
    @Singleton
    @Provides
    static ISchoolApi provideSchoolApi(Retrofit retrofit) {
        return retrofit.create(ISchoolApi.class);
    }
}
