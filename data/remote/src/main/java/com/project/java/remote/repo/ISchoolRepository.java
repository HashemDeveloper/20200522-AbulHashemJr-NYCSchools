package com.project.java.remote.repo;

import androidx.lifecycle.LiveData;

public interface ISchoolRepository {
    void fetchSATScore(String id);
    LiveData getLiveData();
}
