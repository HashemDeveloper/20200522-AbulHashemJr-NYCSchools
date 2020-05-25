package com.project.java.schoollist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.project.java.core.viewmodel.ISavedStateViewModel;
import com.project.java.models.SchoolDirectory;
import com.project.java.remote.ISchoolApi;
import com.project.java.remote.paging.SchoolListPageDataSource;

import javax.inject.Inject;

class SchoolListPageViewModel extends ViewModel implements SchoolListPageDataSource.FactoryCreateListener {
    private SavedStateHandle savedStateHandle;
    private ISchoolApi iSchoolApi;
    private SchoolListPageDataSource.Factory schoolListPageDataSourceFactory;
    private LiveData<PagedList<SchoolDirectory>> schoolListData;
    private LiveData statusLiveData;
    private StatusListener statusListener;

    private SchoolListPageViewModel(SavedStateHandle savedStateHandle, ISchoolApi iSchoolApi) {
        this.savedStateHandle = savedStateHandle;
         this.iSchoolApi = iSchoolApi;
    }
    void setupStatusChangeListener(StatusListener listener) {
        this.statusListener = listener;
    }
    LiveData<PagedList<SchoolDirectory>> getSchoolListData() {
        this.schoolListData = new LivePagedListBuilder<>(getSchoolListPageDataSourceFactory(), 20).build();
        return this.schoolListData;
    }


    LiveData getStatusLiveData() {
//        this.statusLiveData = Transformations.switchMap(getSchoolListPageDataSourceFactory().sourceLiveData, SchoolListPageDataSource::getStatusLiveData);
        return this.statusLiveData;
    }
    private SchoolListPageDataSource.Factory getSchoolListPageDataSourceFactory() {
        this.schoolListPageDataSourceFactory = new SchoolListPageDataSource.Factory(this.iSchoolApi, this.savedStateHandle, this);
        return this.schoolListPageDataSourceFactory;
    }

    @Override
    public void onPageDataSourceCreated(SchoolListPageDataSource dataSource) {
        this.statusListener.onStatusChanged(dataSource.getStatusLiveData());
    }

    static class Factory implements ISavedStateViewModel<SchoolListPageViewModel> {
        @Inject
        public ISchoolApi schoolApi;
        @Inject
        public Factory() {}

        @Override
        public SchoolListPageViewModel create(SavedStateHandle savedStateHandle) {
            return new SchoolListPageViewModel(savedStateHandle, this.schoolApi);
        }
    }
    // HACKY Way to listen to view status
    public interface StatusListener {
        void onStatusChanged(LiveData liveData);
    }
}
