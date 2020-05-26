package com.project.java.core.utils.netconnection;

import androidx.lifecycle.LiveData;

public interface IConnectionStateMonitor {
    void setupConnectionStateMonitor();
    ConnectionStateMonitor getObserver();
    LiveData<Boolean> getApiBelowLiveData();
}
