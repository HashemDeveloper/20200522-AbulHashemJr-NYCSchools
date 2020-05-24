package com.project.java.schoollist;

import android.net.Uri;
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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.java.core.utils.NavigationUtil;
import com.project.java.core.viewmodel.ViewModelFactory;
import com.project.java.schoollist.databinding.FragmentSchoolListPageBinding;
import com.project.java.schoollist.recycler.SchoolListAdapter;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;
import utils.ViewState;

public class SchoolListPage extends Fragment implements SchoolListAdapter.SchoolListItemClickListener {
    private SchoolListAdapter schoolListAdapter;
    private FragmentSchoolListPageBinding binding;
    private NavController navController;
    @Inject
    public SchoolListPageViewModel.Factory viewModelFactory;
    private SchoolListPageViewModel schoolListPageViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        this.schoolListPageViewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory<SchoolListPageViewModel>(this.viewModelFactory, requireActivity(), savedInstanceState))
                .get(SchoolListPageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school_list_page, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.navController = Navigation.findNavController(this.binding.getRoot());
        this.binding.fragmentSchoolListRecyclerViewId.setLayoutManager(new LinearLayoutManager(this.getContext()));
        String mapKey = getResources().getString(R.string.google_map_key);
        this.schoolListAdapter = new SchoolListAdapter(14, "600x600", mapKey, this);
        this.binding.fragmentSchoolListRecyclerViewId.setAdapter(this.schoolListAdapter);
        this.schoolListPageViewModel.getSchoolListData().observe(getViewLifecycleOwner(), schoolDirectories -> {
            this.schoolListAdapter.submitList(schoolDirectories);
        });
        this.schoolListPageViewModel.getStatusLiveData().observe(getViewLifecycleOwner(), schoolListObserver());
    }

    private Observer<Object> schoolListObserver() {
        return o -> {
            if (o instanceof ViewState) {
                switch (((ViewState) o).getStatusType()) {
                    case LOADING: {
                        displayProgressBar(true);
                        break;
                    }
                    case COMPLETE: {
                        displayProgressBar(false);
                        break;
                    }
                    case ERROR: {
                        displayProgressBar(false);
                        if (BuildConfig.DEBUG) {
                            Timber.e("Error%s", ((ViewState) o).getErrorMessage());
                        }
                        break;
                    }
                }
            }
        };
    }
    private void displayProgressBar(boolean isShow) {
        this.binding.fragmentSchoolListPageProgressBarId.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public <T> void onItemClicked(SchoolListAdapter.ItemClickType type, T data) {
        switch (type) {
            case WEBSITE: {
                String url = (String) data;
                Timber.e(url);
                break;
            }
            case SAT_SCORE:
            case NAVIGATE: {
                String id = "";
                String schoolName = "";
                if (data instanceof String[]) {
                    String[] dataArray = (String[]) data;
                    id = dataArray[0];
                    schoolName = dataArray[1];
                }
                NavigationUtil.navigateUriWithDefaultOptions(this.navController, Uri.parse("nycschools://schooldetailspage/" + id + "/" + schoolName), null);
                break;
            }
        }
    }
}