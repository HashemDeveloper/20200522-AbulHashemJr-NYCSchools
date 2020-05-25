package com.project.java.schoollist.widgets;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.material.textview.MaterialTextView;
import com.project.java.core.base.BaseBottomSheet;
import com.project.java.schoollist.R;

import utils.NavigationType;

public class BottomSheetDialog extends BaseBottomSheet {
    private MutableLiveData<NavigationType> clickLiveData = new MutableLiveData<>();

    @Override
    public int getItemLayout() {
        return R.layout.fragment_bottom_sheet_dialog;
    }

    @Override
    protected int provideTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MaterialTextView wazebt = view.findViewById(R.id.bottom_sheet_use_waze_opt_text_view_id);
        MaterialTextView googleBt = view.findViewById(R.id.bottom_sheet_use_google_opt_text_view_id);
        wazebt.setOnClickListener(onClick -> this.clickLiveData.postValue(NavigationType.WAZE));
        googleBt.setOnClickListener(onClick -> this.clickLiveData.postValue(NavigationType.GOOGLE));
        super.onViewCreated(view, savedInstanceState);
    }
    public LiveData<NavigationType> getClickLiveData() {
        return this.clickLiveData;
    }
}
