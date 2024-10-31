package com.facebook.places.internal;

import com.facebook.places.internal.ScannerException;
import java.util.concurrent.Callable;

/* compiled from: LocationPackageManager.java */
/* loaded from: classes.dex */
public class d implements Callable<LocationPackage> {

    /* renamed from: a */
    final /* synthetic */ LocationScanner f9463a;

    public d(LocationScanner locationScanner) {
        this.f9463a = locationScanner;
    }

    @Override // java.util.concurrent.Callable
    public LocationPackage call() throws Exception {
        LocationPackage locationPackage = new LocationPackage();
        try {
            locationPackage.location = this.f9463a.getLocation();
        } catch (ScannerException e2) {
            locationPackage.locationError = e2.type;
            LocationPackageManager.logException("Exception while getting location", e2);
        } catch (Exception unused) {
            locationPackage.locationError = ScannerException.Type.UNKNOWN_ERROR;
        }
        return locationPackage;
    }
}
