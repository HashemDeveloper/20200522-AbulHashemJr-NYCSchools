package com.project.java.schoollist;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.project.java.core.viewmodel.ISavedStateViewModel;

import javax.inject.Inject;

public class SchoolListPageViewModel extends ViewModel {
    private SavedStateHandle savedStateHandle;

    public SchoolListPageViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
    }

    static class Factory implements ISavedStateViewModel<SchoolListPageViewModel> {
        @Inject
        public Factory() {}

        @Override
        public SchoolListPageViewModel create(SavedStateHandle savedStateHandle) {
            return new SchoolListPageViewModel(savedStateHandle);
        }
    }
}
