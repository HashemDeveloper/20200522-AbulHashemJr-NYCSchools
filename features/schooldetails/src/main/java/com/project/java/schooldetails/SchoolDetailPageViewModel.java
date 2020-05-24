package com.project.java.schooldetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.project.java.core.viewmodel.ISavedStateViewModel;
import com.project.java.remote.repo.ISchoolRepository;

import javax.inject.Inject;

public class SchoolDetailPageViewModel extends ViewModel {
    private SavedStateHandle savedStateHandle;
    private ISchoolRepository iSchoolRepository;
    private LiveData viewStatusLiveData;

    public SchoolDetailPageViewModel(SavedStateHandle savedStateHandle, ISchoolRepository iSchoolRepository) {
        this.savedStateHandle = savedStateHandle;
        this.iSchoolRepository = iSchoolRepository;
    }

    public void fetchSATScores(String id) {
        this.iSchoolRepository.fetchSATScore(id);
    }

    public LiveData getViewStatusLiveData() {
        return this.iSchoolRepository.getLiveData();
    }

    static class Factory implements ISavedStateViewModel<SchoolDetailPageViewModel> {
        @Inject
        public ISchoolRepository iSchoolRepository;
        @Inject
        public Factory() {

        }
        @Override
        public SchoolDetailPageViewModel create(SavedStateHandle savedStateHandle) {
            return new SchoolDetailPageViewModel(savedStateHandle, this.iSchoolRepository);
        }
    }
}
