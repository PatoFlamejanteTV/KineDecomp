package com.facebook.places.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationPackageManager.java */
/* loaded from: classes.dex */
public class f implements Callable<LocationPackage> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationPackageRequestParams f9465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocationPackageRequestParams locationPackageRequestParams) {
        this.f9465a = locationPackageRequestParams;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public LocationPackage call() throws Exception {
        LocationPackage locationPackage = new LocationPackage();
        try {
            WifiScanner newWifiScanner = ScannerFactory.newWifiScanner(FacebookSdk.getApplicationContext(), this.f9465a);
            newWifiScanner.initAndCheckEligibility();
            locationPackage.connectedWifi = newWifiScanner.getConnectedWifi();
            locationPackage.isWifiScanningEnabled = newWifiScanner.isWifiScanningEnabled();
            if (locationPackage.isWifiScanningEnabled) {
                locationPackage.ambientWifi = newWifiScanner.getWifiScans();
            }
        } catch (Exception e2) {
            LocationPackageManager.logException("Exception scanning for wifi access points", e2);
            locationPackage.isWifiScanningEnabled = false;
        }
        return locationPackage;
    }
}
