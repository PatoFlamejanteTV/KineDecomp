package com.facebook.places.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class LocationPackageManager {
    private static final String TAG = "LocationPackageManager";

    /* loaded from: classes.dex */
    public interface Listener {
        void onLocationPackage(LocationPackage locationPackage);
    }

    public static void logException(String str, Throwable th) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e(TAG, str, th);
        }
    }

    public static FutureTask<LocationPackage> newBluetoothScanFuture(LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new e(locationPackageRequestParams));
    }

    public static FutureTask<LocationPackage> newLocationScanFuture(LocationScanner locationScanner, LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new d(locationScanner));
    }

    public static FutureTask<LocationPackage> newWifiScanFuture(LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new f(locationPackageRequestParams));
    }

    public static void requestLocationPackage(LocationPackageRequestParams locationPackageRequestParams, Listener listener) {
        FacebookSdk.getExecutor().execute(new c(locationPackageRequestParams, listener));
    }
}
