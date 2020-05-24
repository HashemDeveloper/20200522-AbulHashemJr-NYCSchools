package com.project.java.remote.paging;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.project.java.models.SchoolDirectory;
import com.project.java.remote.BuildConfig;
import com.project.java.remote.ISchoolApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
import utils.ViewStatusLiveData;

public class SchoolListPageDataSource extends PageKeyedDataSource<Integer, SchoolDirectory> {
    public static final String PAGE_LIST_STATE = "PageListState";
    private SavedStateHandle savedStateHandle;
    private static final int PAGE_SIZE = 30;
    private int initialOffSet = 0;
    private ISchoolApi iSchoolApi;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ViewStatusLiveData viewStatusLiveData = new ViewStatusLiveData();

    public SchoolListPageDataSource(ISchoolApi iSchoolApi, SavedStateHandle savedStateHandle) {
       this.iSchoolApi = iSchoolApi;
       this.savedStateHandle = savedStateHandle;
    }
     @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, SchoolDirectory> callback) {
        this.viewStatusLiveData.postLoading();
        this.compositeDisposable.add(this.iSchoolApi.getListOfSchools(PAGE_SIZE, initialOffSet)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
            if (result != null && result.isSuccessful()) {
                List<SchoolDirectory> schoolDirectoryList = result.body();
                if (schoolDirectoryList != null && !schoolDirectoryList.isEmpty()) {
                    this.savedStateHandle.set(PAGE_LIST_STATE, schoolDirectoryList);
                    this.viewStatusLiveData.onComplete();
                    callback.onResult(schoolDirectoryList, null, 1);
                }
            }
        }, this::displayError));
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SchoolDirectory> callback) {
        this.savedStateHandle.remove(PAGE_LIST_STATE);
        this.initialOffSet++;
        int count = this.initialOffSet;
        this.compositeDisposable.add(this.iSchoolApi.getListOfSchools(params.key, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    if (result != null && result.isSuccessful()) {
                        List<SchoolDirectory> schoolDirectoryList = result.body();
                        if (schoolDirectoryList != null && !schoolDirectoryList.isEmpty()) {
                            this.viewStatusLiveData.onComplete();
                            this.savedStateHandle.set(PAGE_LIST_STATE, schoolDirectoryList);
                            callback.onResult(schoolDirectoryList, params.key+1);
                        }
                    }
                }, this::displayError));
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SchoolDirectory> callback) {
        this.savedStateHandle.remove(PAGE_LIST_STATE);
        this.compositeDisposable.add(this.iSchoolApi.getListOfSchools(params.key, this.initialOffSet++)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
            if (result != null && result.isSuccessful()) {
                List<SchoolDirectory> schoolDirectoryList = result.body();
                if (schoolDirectoryList != null && !schoolDirectoryList.isEmpty()) {
                    this.viewStatusLiveData.onComplete();
                    this.savedStateHandle.set(PAGE_LIST_STATE, schoolDirectoryList);
                    callback.onResult(schoolDirectoryList, params.key - 1);
                }
            }
        }, this::displayError));
    }

    public LiveData getStatusLiveData() {
        return this.viewStatusLiveData;
    }

    private void displayError(Throwable onError) {
        String errorMessage = "";
        if (onError != null && onError.getLocalizedMessage() != null) {
            errorMessage = onError.getLocalizedMessage();
        }
        this.viewStatusLiveData.postError(errorMessage);
        if (BuildConfig.DEBUG) {
            Timber.e("Error Fetching Data -->%s", errorMessage);
        }
    }
    public static class Factory extends DataSource.Factory<Integer, SchoolDirectory> {
        private SavedStateHandle savedStateHandle;
        private ISchoolApi iSchoolApi;
        private SchoolListPageDataSource schoolListPageDataSource;
        private MutableLiveData<SchoolListPageDataSource> sourceLiveData = new MutableLiveData<>();

        public Factory(ISchoolApi iSchoolApi, SavedStateHandle savedStateHandle) {
            this.iSchoolApi = iSchoolApi;
            this.savedStateHandle = savedStateHandle;
        }
        public LiveData<SchoolListPageDataSource> getSourceLiveData() {
            return this.sourceLiveData;
        }
        @NonNull
        @Override
        public DataSource<Integer, SchoolDirectory> create() {
            this.schoolListPageDataSource = new SchoolListPageDataSource(this.iSchoolApi, this.savedStateHandle);
            this.sourceLiveData.postValue(this.schoolListPageDataSource);
            return this.schoolListPageDataSource;
        }
    }
}
