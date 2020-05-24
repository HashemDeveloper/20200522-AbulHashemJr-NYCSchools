package com.project.java.schooldetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.project.java.core.viewmodel.ViewModelFactory;
import com.project.java.models.SATScores;
import com.project.java.schooldetails.databinding.FragmentSchoolDetailsLayoutBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;
import utils.ViewState;

public class SchoolDetailsPage extends Fragment {
    private FragmentSchoolDetailsLayoutBinding binding;
    @Inject
    public SchoolDetailPageViewModel.Factory viewModelFactory;
    private NavController navController;
    private SchoolDetailPageViewModel schoolDetailPageViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school_details_layout, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.schoolDetailPageViewModel = new ViewModelProvider(requireActivity(),
                new ViewModelFactory<SchoolDetailPageViewModel>(this.viewModelFactory, requireActivity(), savedInstanceState))
                .get(SchoolDetailPageViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        String id = "";
        if (getArguments() != null) {
            id = getArguments().getString("school_id");
        }
        this.schoolDetailPageViewModel.fetchSATScores(id);
        this.schoolDetailPageViewModel.getViewStatusLiveData().observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public void onChanged(Object o) {
                if (o instanceof ViewState) {
                    switch (((ViewState) o).getStatusType()) {
                        case LOADING: {
                            Timber.e("Loading");
                            break;
                        }
                        case SUCCESS: {
                            if (((ViewState) o).getData() != null) {
                                List<SATScores> satScores = (List<SATScores>) ((ViewState) o).getData();
                                if (satScores != null && !satScores.isEmpty()) {
                                    Timber.e(satScores.get(0).getSchoolName());
                                }
                            }
                            break;
                        }
                        case ERROR: {
                            break;
                        }
                    }
                }
            }
        });
    }
}
