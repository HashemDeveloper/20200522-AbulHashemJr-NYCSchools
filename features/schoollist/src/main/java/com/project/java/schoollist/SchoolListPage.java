package com.project.java.schoollist;

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

import com.project.java.core.viewmodel.ViewModelFactory;
import com.project.java.models.SchoolDirectory;
import com.project.java.schoollist.databinding.FragmentSchoolListPageBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;
import utils.ViewState;

public class SchoolListPage extends Fragment {
    private FragmentSchoolListPageBinding binding;
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
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school_list_page, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.schoolListPageViewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory<SchoolListPageViewModel>(this.viewModelFactory, requireActivity(), savedInstanceState))
        .get(SchoolListPageViewModel.class);
        this.schoolListPageViewModel.retrieveList();
        this.schoolListPageViewModel.getSchoolList().observe(getViewLifecycleOwner(), schoolListObserver());
        super.onViewCreated(view, savedInstanceState);
    }

    private Observer<Object> schoolListObserver() {
        return o -> {
            if (o instanceof ViewState) {
                switch (((ViewState) o).getStatusType()) {
                    case LOADING: {
                        Timber.e("Loading");
                        break;
                    }
                    case SUCCESS: {
                        List<SchoolDirectory> list = (List<SchoolDirectory>) ((ViewState) o).getData();
                        Timber.e(list.get(0).getSchoolName());
                        break;
                    }
                    case ERROR: {
                        Timber.e("Error%s", ((ViewState) o).getErrorMessage());
                        break;
                    }
                }
            }
        };
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.schoolListPageViewModel.getSchoolList().removeObserver(this.schoolListObserver());
    }
}
