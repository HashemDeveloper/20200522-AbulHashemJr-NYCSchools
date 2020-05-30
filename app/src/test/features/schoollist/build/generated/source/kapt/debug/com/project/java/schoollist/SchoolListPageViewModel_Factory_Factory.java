// Generated by Dagger (https://dagger.dev).
package com.project.java.schoollist;

import com.project.java.remote.ISchoolApi;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SchoolListPageViewModel_Factory_Factory implements Factory<SchoolListPageViewModel.Factory> {
  private final Provider<ISchoolApi> schoolApiProvider;

  public SchoolListPageViewModel_Factory_Factory(Provider<ISchoolApi> schoolApiProvider) {
    this.schoolApiProvider = schoolApiProvider;
  }

  @Override
  public SchoolListPageViewModel.Factory get() {
    SchoolListPageViewModel.Factory instance = new SchoolListPageViewModel.Factory();
    SchoolListPageViewModel_Factory_MembersInjector.injectSchoolApi(instance, schoolApiProvider.get());
    return instance;
  }

  public static SchoolListPageViewModel_Factory_Factory create(
      Provider<ISchoolApi> schoolApiProvider) {
    return new SchoolListPageViewModel_Factory_Factory(schoolApiProvider);
  }

  public static SchoolListPageViewModel.Factory newInstance() {
    return new SchoolListPageViewModel.Factory();
  }
}
