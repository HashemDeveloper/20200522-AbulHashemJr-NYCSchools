package com.project.java.schoollist.widgets;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.project.java.core.base.BaseBottomSheet;

public class BottomSheetDialog extends BaseBottomSheet {

    @Override
    public int getItemLayout() {
        return 0;
    }

    @Override
    protected int provideTheme() {
        return 0;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
