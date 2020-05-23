package com.project.java.core.viewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;

@SuppressWarnings("unchecked")
public class ViewModelFactory<V extends ViewModel> extends AbstractSavedStateViewModelFactory {
    private ISavedStateViewModel<V> iSavedStateViewModel;
    private SavedStateRegistryOwner owner;
    private Bundle defaultArg;

    public ViewModelFactory(ISavedStateViewModel savedStateViewModel, SavedStateRegistryOwner owner, Bundle defaltArg) {
        super(owner, defaltArg);
        this.iSavedStateViewModel = savedStateViewModel;
        this.owner = owner;
        this.defaultArg = defaltArg;
    }

    @NonNull
    @Override
    protected <T extends ViewModel> T create(@NonNull String key, @NonNull Class<T> modelClass, @NonNull SavedStateHandle handle) {
        return (T) this.iSavedStateViewModel.create(handle);
    }
}
