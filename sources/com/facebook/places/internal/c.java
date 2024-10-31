package com.facebook.places.internal;

import com.facebook.FacebookSdk;
import com.facebook.places.internal.LocationPackageManager;
import java.util.concurrent.FutureTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationPackageManager.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationPackageRequestParams f9461a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LocationPackageManager.Listener f9462b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationPackageRequestParams locationPackageRequestParams, LocationPackageManager.Listener listener) {
        this.f9461a = locationPackageRequestParams;
        this.f9462b = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        FutureTask futureTask;
        FutureTask futureTask2;
        LocationPackage locationPackage = new LocationPackage();
        try {
            FutureTask futureTask3 = null;
            if (this.f9461a.isLocationScanEnabled()) {
                LocationScanner newLocationScanner = ScannerFactory.newLocationScanner(FacebookSdk.getApplicationContext(), this.f9461a);
                newLocationScanner.initAndCheckEligibility();
                futureTask = LocationPackageManager.newLocationScanFuture(newLocationScanner, this.f9461a);
                FacebookSdk.getExecutor().execute(futureTask);
            } else {
                futureTask = null;
            }
            if (this.f9461a.isWifiScanEnabled()) {
                futureTask2 = LocationPackageManager.newWifiScanFuture(this.f9461a);
                FacebookSdk.getExecutor().execute(futureTask2);
            } else {
                futureTask2 = null;
            }
            if (this.f9461a.isBluetoothScanEnabled()) {
                futureTask3 = LocationPackageManager.newBluetoothScanFuture(this.f9461a);
                FacebookSdk.getExecutor().execute(futureTask3);
            }
            if (futureTask3 != null) {
                try {
                    LocationPackage locationPackage2 = (LocationPackage) futureTask3.get();
                    locationPackage.ambientBluetoothLe = locationPackage2.ambientBluetoothLe;
                    locationPackage.isBluetoothScanningEnabled = locationPackage2.isBluetoothScanningEnabled;
                } catch (Exception e2) {
                    LocationPackageManager.logException("Exception scanning for bluetooth beacons", e2);
                }
            }
            if (futureTask2 != null) {
                try {
                    LocationPackage locationPackage3 = (LocationPackage) futureTask2.get();
                    locationPackage.isWifiScanningEnabled = locationPackage3.isWifiScanningEnabled;
                    locationPackage.connectedWifi = locationPackage3.connectedWifi;
                    locationPackage.ambientWifi = locationPackage3.ambientWifi;
                } catch (Exception e3) {
                    LocationPackageManager.logException("Exception scanning for wifi access points", e3);
                }
            }
            if (futureTask != null) {
                try {
                    LocationPackage locationPackage4 = (LocationPackage) futureTask.get();
                    locationPackage.locationError = locationPackage4.locationError;
                    locationPackage.location = locationPackage4.location;
                } catch (Exception e4) {
                    LocationPackageManager.logException("Exception getting location", e4);
                }
            }
        } catch (ScannerException e5) {
            LocationPackageManager.logException("Exception scanning for locations", e5);
            locationPackage.locationError = e5.type;
        } catch (Exception e6) {
            LocationPackageManager.logException("Exception requesting a location package", e6);
        }
        this.f9462b.onLocationPackage(locationPackage);
    }
}
