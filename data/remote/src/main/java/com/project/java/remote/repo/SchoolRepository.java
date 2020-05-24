package com.project.java.remote.repo;

import androidx.lifecycle.LiveData;

import com.project.java.models.SchoolDirectory;
import com.project.java.remote.BuildConfig;
import com.project.java.remote.ISchoolApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
import utils.ViewStatusLiveData;

public class SchoolRepository implements ISchoolRepository {
    private static final String TAG = SchoolRepository.class.getCanonicalName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ViewStatusLiveData viewStatusLiveData = new ViewStatusLiveData();
    @Inject
    public ISchoolApi iSchoolApi;


    @Inject
    public SchoolRepository() {

    }


    @Override
    public void retrieveSchoolList() {
        this.viewStatusLiveData.postLoading();
        // passing empty string Because pagination for this API server currently not working
        this.compositeDisposable.add(this.iSchoolApi.getListOfSchools(30)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
            if (result != null && result.isSuccessful()) {
                List<SchoolDirectory> schoolDirectoryList = result.body();
                this.viewStatusLiveData.postSuccess(schoolDirectoryList);
            }
        }, onError -> {
            String errorMessage = "";
            if (onError != null && onError.getLocalizedMessage() != null) {
                errorMessage = onError.getLocalizedMessage();
            }
            this.viewStatusLiveData.postError(errorMessage);
            if (BuildConfig.DEBUG) {
                Timber.e("%sError in fetching school list: %s", TAG, errorMessage);
            }
        }));
    }

    @Override
    public LiveData getViewStatusLiveData() {
        return this.viewStatusLiveData;
    }
}
