package com.project.java.core.utils.netconnection;

import com.project.java.core.BuildConfig;

import java.io.IOException;

import timber.log.Timber;

public class PingNetwork {
    public static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e) {
            debug(e);

        } catch (InterruptedException e) {
            debug(e);
        }
        return false;
    }
    private static <T> void debug(T e) {
        if (BuildConfig.DEBUG) {
            if (e != null) {
                if (e instanceof IOException) {
                    if (((IOException) e).getLocalizedMessage() != null) {
                        Timber.d("IoException: %s", ((IOException) e).getLocalizedMessage());
                    }
                } else if (e instanceof InterruptedException) {
                    if (((InterruptedException) e).getLocalizedMessage() != null) {
                        Timber.d("IoException: %s", ((InterruptedException) e).getLocalizedMessage());
                    }
                }
            }
        }
    }
}
