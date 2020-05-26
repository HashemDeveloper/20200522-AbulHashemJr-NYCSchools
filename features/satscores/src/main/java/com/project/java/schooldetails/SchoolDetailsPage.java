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
import com.project.java.schooldetails.databinding.FragmentSatScoreLayoutBindingImpl;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import utils.ViewState;

public class SchoolDetailsPage extends Fragment {
    public FragmentSatScoreLayoutBindingImpl binding;
    @Inject
    public SchoolDetailPageViewModel.Factory viewModelFactory;
    private NavController navController;
    private SchoolDetailPageViewModel schoolDetailPageViewModel;
    private String schoolName;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sat_score_layout, container, false);
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
            this.schoolName = getArguments().getString("school_name");
        }
        this.schoolDetailPageViewModel.fetchSATScores(id);
        this.schoolDetailPageViewModel.getViewStatusLiveData().observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public void onChanged(Object o) {
                if (o instanceof ViewState) {
                    switch (((ViewState) o).getStatusType()) {
                        case LOADING: {
                            displayProgressBar(true);
                            break;
                        }
                        case SUCCESS: {
                            displayProgressBar(false);
                            if (((ViewState) o).getData() != null) {
                                List<SATScores> satScores = (List<SATScores>) ((ViewState) o).getData();
                                setupSatScoreView(satScores);
                            }
                            break;
                        }
                        case ERROR: {
                            displayProgressBar(false);
                            setupSatScoreView(null);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void displayProgressBar(boolean isVisible) {
        this.binding.fragmentSatScoreProgressBarId.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    private void setupSatScoreView(List<SATScores> satScores) {
        String schoolName = (satScores != null && !satScores.isEmpty() && satScores.get(0).getSchoolName() != null) ? satScores.get(0).getSchoolName() : this.schoolName;
        String mathScore = (satScores != null && !satScores.isEmpty() && satScores.get(0).getSatMathAvgScore() != null) ? satScores.get(0).getSatMathAvgScore() : "NULL";
        String readingScore = (satScores != null && !satScores.isEmpty() && satScores.get(0).getSatCriticalReadingAvgScore() != null) ? satScores.get(0).getSatCriticalReadingAvgScore() : "NULL";
        String writing = (satScores != null && !satScores.isEmpty() && satScores.get(0).getSatWritingAvgScore() != null) ? satScores.get(0).getSatWritingAvgScore() : "NULL";
        String totalTestTakers = (satScores != null && !satScores.isEmpty() && satScores.get(0).getNumOfSatTestTakers() != null) ? satScores.get(0).getNumOfSatTestTakers() : "NULL";
        this.binding.fragmentSatScorePageSchoolNameTitleViewId.setText(schoolName);
        this.binding.fragmentSatScoreMathResultViewId.setText(mathScore);
        this.binding.fragmentSatScoreReadingViewId.setText(readingScore);
        this.binding.fragmentSatScoreWritingViewId.setText(writing);
        this.binding.fragmentSatScoreTotalStudentViewId.setText(totalTestTakers);
    }
}
