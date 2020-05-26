package com.project.java.core.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {
    private NavController navController;

    protected abstract int getLayout();
    protected abstract int theme();
    protected abstract int getNavLayout();
    protected abstract int getContainerId();
    protected abstract void setupConnectionStateMonitor();
    protected View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        setTheme(theme());
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        this.navController = Navigation.findNavController(this, getContainerId());
        this.navController.setGraph(getNavLayout());
        setupConnectionStateMonitor();
    }
}
