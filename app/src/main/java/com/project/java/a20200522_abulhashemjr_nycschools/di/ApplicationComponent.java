package com.project.java.a20200522_abulhashemjr_nycschools.di;

import com.project.java.a20200522_abulhashemjr_nycschools.NYCSchoolsApp;
import com.project.java.core.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModule.class, ApplicationModule.class, RetrofitModule.class})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder buildApplication(NYCSchoolsApp app);
        ApplicationComponent build();
    }
    void inject(NYCSchoolsApp app);
}
