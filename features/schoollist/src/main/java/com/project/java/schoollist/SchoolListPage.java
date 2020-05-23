package com.project.java.schoollist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.java.core.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SchoolListPage extends Fragment {
    @Inject
    public SchoolListPageViewModel.Factory viewModelFactory;
    private SchoolListPageViewModel schoolListPageViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.schoolListPageViewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory<SchoolListPageViewModel>(this.viewModelFactory, requireActivity(), savedInstanceState))
        .get(SchoolListPageViewModel.class);
        super.onViewCreated(view, savedInstanceState);
    }
}
