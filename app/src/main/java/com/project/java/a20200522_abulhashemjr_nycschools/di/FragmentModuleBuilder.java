package com.project.java.a20200522_abulhashemjr_nycschools.di;

import com.project.java.schooldetails.SatScorePage;
import com.project.java.schoollist.SchoolListPage;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModuleBuilder {
    @ContributesAndroidInjector
    abstract SchoolListPage contributeSchoolListPage();
    @ContributesAndroidInjector
    abstract SatScorePage contributeSchoolDetailsPage();
}
