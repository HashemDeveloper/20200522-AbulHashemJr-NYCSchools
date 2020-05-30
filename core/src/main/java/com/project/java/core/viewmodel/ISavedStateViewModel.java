package com.project.java.core.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public interface ISavedStateViewModel<V extends ViewModel> {
    V create (SavedStateHandle savedStateHandle);
}
