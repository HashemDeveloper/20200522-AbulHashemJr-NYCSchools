package com.project.java.schoollist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.java.core.utils.NavigationUtil;
import com.project.java.core.viewmodel.ViewModelFactory;
import com.project.java.schoollist.databinding.FragmentSchoolListPageBinding;
import com.project.java.schoollist.recycler.SchoolListAdapter;
import com.project.java.schoollist.widgets.BottomSheetDialog;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;
import utils.NavigationType;
import utils.ViewState;

public class SchoolListPage extends Fragment implements SchoolListAdapter.SchoolListItemClickListener, SchoolListPageViewModel.StatusListener {
    private static final String TAG = SchoolListPage.class.getCanonicalName();
    private SchoolListAdapter schoolListAdapter;
    private FragmentSchoolListPageBinding binding;
    private NavController navController;
    private BottomSheetDialog directionSheetDialog;
    @Inject
    public SchoolListPageViewModel.Factory viewModelFactory;
    private SchoolListPageViewModel schoolListPageViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        this.schoolListPageViewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory<SchoolListPageViewModel>(this.viewModelFactory, requireActivity(), savedInstanceState))
                .get(SchoolListPageViewModel.class);
        this.schoolListPageViewModel.setupStatusChangeListener(this);
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
        this.directionSheetDialog = new BottomSheetDialog();
    }


    @Override
    public void onStatusChanged(LiveData liveData) {
        liveData.observe(getViewLifecycleOwner(), schoolListObserver());
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
        if (this.directionSheetDialog != null && this.directionSheetDialog.getClickLiveData() != null) {
            this.directionSheetDialog.getClickLiveData().removeObserver(bottomSheetClickObserver("", ""));
        }
    }

    @Override
    public <T> void onItemClicked(SchoolListAdapter.ItemClickType type, T data) {
        switch (type) {
            case WEBSITE: {
                String d = (String) data;
                String url = "";
                if (d != null && !"".equals(d)) {
                    if (!d.startsWith("https://") && !d.startsWith("http://")) {
                        url = "http://" + d;
                    } else {
                        url = d;
                    }
                    Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browseIntent);
                }
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
            case DESTINATION: {
                String destination = (String) data;
                String wazeUrl = "";
                String googleUrl = "";
                try {
                    wazeUrl = NavigationType.WAZE.getUrlString() + URLEncoder.encode(destination, "UTF-8");
                    googleUrl = NavigationType.GOOGLE.getUrlString() + URLEncoder.encode(destination, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    if (BuildConfig.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (this.directionSheetDialog != null && getActivity() != null) {
                    this.directionSheetDialog.show(getActivity().getSupportFragmentManager(), this.directionSheetDialog.getTag());
                    this.directionSheetDialog.getClickLiveData().observe(getViewLifecycleOwner(), bottomSheetClickObserver(wazeUrl, googleUrl));
                }
            }
        }
    }

    private Observer<NavigationType> bottomSheetClickObserver(String wazeUrl, String googleUrl) {
        return navigationType -> {
            switch (navigationType) {
                case WAZE: {
                    try {
                       launchIntent((wazeUrl != null && !"".equals(wazeUrl) ? wazeUrl : ""));
                    } catch (Exception e) {
                        printDebug(e);
                        String storeUrl = "market://details?id=com.waze";
                        launchIntent(storeUrl);
                    }
                    break;
                }
                case GOOGLE: {
                    try {
                        launchIntent((googleUrl != null && !"".equals(googleUrl) ? googleUrl : ""));
                    } catch (Exception e) {
                        printDebug(e);
                        String storeUrl = "market://details?id=com.google.android.apps.maps";
                        launchIntent(storeUrl);
                    }
                    break;
                }
            }
        };
    }
    private void launchIntent(String url) {
        if (!"".equals(url)) {
            Intent wazeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            wazeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(wazeIntent);
            this.directionSheetDialog.dismiss();
        }
    }
    private void printDebug(Exception e) {
        if (BuildConfig.DEBUG) {
            if (e.getLocalizedMessage() != null) {
                Timber.e(TAG + "Exception: " + e.getLocalizedMessage());
            }
        }
    }
}