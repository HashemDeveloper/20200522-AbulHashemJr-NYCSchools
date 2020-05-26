package com.project.java.core.utils.netconnection;

import android.content.Intent;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class ConnectionSetting {
    private AppCompatActivity activity;
    private View view;
    private Snackbar snackbar;

    public ConnectionSetting(AppCompatActivity activity, View view) {
        this.activity = activity;
        this.view = view;
    }
    public void initWifiSetting(boolean isConnected, String message, String actionTitle, int bgColorId, int actionColorId) {
        this.snackbar = Snackbar.make(this.view, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
        this.snackbar.getView().setBackgroundColor(ContextCompat.getColor(this.activity, bgColorId));
        this.snackbar.setActionTextColor(ContextCompat.getColor(this.activity, actionColorId));
        this.snackbar.setAction(actionTitle, view -> {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.activity.startActivity(intent);
            this.snackbar.dismiss();
        });
        if (isConnected) {
            this.snackbar.dismiss();
        } else  {
            this.snackbar.show();
        }
    }

    public Snackbar getSnackbar() {
        return snackbar;
    }
}
