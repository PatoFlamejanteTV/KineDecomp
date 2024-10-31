package com.facebook.places.internal;

import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationPackageManager.java */
/* loaded from: classes.dex */
public class e implements Callable<LocationPackage> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationPackageRequestParams f9464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LocationPackageRequestParams locationPackageRequestParams) {
        this.f9464a = locationPackageRequestParams;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public LocationPackage call() throws Exception {
        LocationPackage locationPackage = new LocationPackage();
        try {
            BleScanner newBleScanner = ScannerFactory.newBleScanner(FacebookSdk.getApplicationContext(), this.f9464a);
            newBleScanner.initAndCheckEligibility();
            try {
                newBleScanner.startScanning();
                try {
                    Thread.sleep(this.f9464a.getBluetoothScanDurationMs());
                } catch (Exception unused) {
                }
                newBleScanner.stopScanning();
                int errorCode = newBleScanner.getErrorCode();
                if (errorCode == 0) {
                    locationPackage.ambientBluetoothLe = newBleScanner.getScanResults();
                    locationPackage.isBluetoothScanningEnabled = true;
                } else {
                    if (FacebookSdk.isDebugEnabled()) {
                        Utility.logd("LocationPackageManager", String.format(Locale.getDefault(), "Bluetooth LE scan failed with error: %d", Integer.valueOf(errorCode)));
                    }
                    locationPackage.isBluetoothScanningEnabled = false;
                }
            } catch (Throwable th) {
                newBleScanner.stopScanning();
                throw th;
            }
        } catch (Exception e2) {
            LocationPackageManager.logException("Exception scanning for bluetooth beacons", e2);
            locationPackage.isBluetoothScanningEnabled = false;
        }
        return locationPackage;
    }
}
