package com.project.java.remote.paging;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
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

/**
 *
 */
public class SchoolListPageDataSource extends PageKeyedDataSource<Integer, SchoolDirectory> {
    private ISchoolApi iSchoolApi;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ViewStatusLiveData viewStatusLiveData = new ViewStatusLiveData();

    public SchoolListPageDataSource(ISchoolApi iSchoolApi) {
       this.iSchoolApi = iSchoolApi;
    }
     @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, SchoolDirectory> callback) {
        this.viewStatusLiveData.postLoading();
        this.compositeDisposable.add(this.iSchoolApi.getListOfSchools()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
            if (result != null && result.isSuccessful()) {
                List<SchoolDirectory> schoolDirectoryList = result.body();
                if (schoolDirectoryList != null && !schoolDirectoryList.isEmpty()) {
                    this.viewStatusLiveData.postSuccess(schoolDirectoryList);
                    callback.onResult(schoolDirectoryList, null, 2);
                }
            }
        }, onError -> {
            String errorMessage = "";
            if (onError != null && onError.getLocalizedMessage() != null) {
                errorMessage = onError.getLocalizedMessage();
            }
            this.viewStatusLiveData.postError(errorMessage);
            if (BuildConfig.DEBUG) {
                Timber.e("Error Fetching Data -->%s", errorMessage);
            }
        }));
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SchoolDirectory> callback) {
        //
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, SchoolDirectory> callback) {

    }

    class Factory extends DataSource.Factory<Integer, SchoolDirectory> {
        private ISchoolApi iSchoolApi;
        private SchoolListPageDataSource schoolListPageDataSource;
        private MutableLiveData<SchoolListPageDataSource> sourceLiveData = new MutableLiveData<>();

        public Factory(ISchoolApi iSchoolApi) {
            this.iSchoolApi = iSchoolApi;
        }
        @NonNull
        @Override
        public DataSource<Integer, SchoolDirectory> create() {
            this.schoolListPageDataSource = new SchoolListPageDataSource(this.iSchoolApi);
            this.sourceLiveData.postValue(this.schoolListPageDataSource);
            return this.schoolListPageDataSource;
        }
    }
}
