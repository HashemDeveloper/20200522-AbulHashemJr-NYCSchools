package com.project.java.schoollist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.project.java.core.viewmodel.ISavedStateViewModel;
import com.project.java.remote.repo.ISchoolRepository;

import javax.inject.Inject;

public class SchoolListPageViewModel extends ViewModel {
    private SavedStateHandle savedStateHandle;
    private ISchoolRepository iSchoolRepository;

    public SchoolListPageViewModel(SavedStateHandle savedStateHandle, ISchoolRepository iSchoolRepository) {
        this.savedStateHandle = savedStateHandle;
        this.iSchoolRepository = iSchoolRepository;
    }
    public void retrieveList() {
        this.iSchoolRepository.retrieveSchoolList();
    }
    public LiveData getSchoolList() {
        return this.iSchoolRepository.getViewStatusLiveData();
    }

    static class Factory implements ISavedStateViewModel<SchoolListPageViewModel> {
        @Inject
        public ISchoolRepository iSchoolRepository;
        @Inject
        public Factory() {}

        @Override
        public SchoolListPageViewModel create(SavedStateHandle savedStateHandle) {
            return new SchoolListPageViewModel(savedStateHandle, this.iSchoolRepository);
        }
    }
}
