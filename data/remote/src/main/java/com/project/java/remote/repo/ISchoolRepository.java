package com.project.java.remote.repo;

import androidx.lifecycle.LiveData;

public interface ISchoolRepository {
    void retrieveSchoolList();
    LiveData getViewStatusLiveData();
}
