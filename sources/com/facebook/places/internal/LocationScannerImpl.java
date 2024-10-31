package com.facebook.places.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import com.facebook.internal.Validate;
import com.facebook.places.internal.ScannerException;
import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class LocationScannerImpl implements LocationScanner, LocationListener {
    private static final float MIN_DISTANCE_BETWEEN_UPDATES = 0.0f;
    private static final long MIN_TIME_BETWEEN_UPDATES = 100;
    private Context context;
    private List<String> enabledProviders;
    private Location freshLocation;
    private LocationManager locationManager;
    private LocationPackageRequestParams params;
    private final Object scanLock = new Object();

    public LocationScannerImpl(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        this.context = context;
        this.params = locationPackageRequestParams;
        this.locationManager = (LocationManager) context.getSystemService(PlaceFields.LOCATION);
    }

    private Location getFreshLocation() throws ScannerException {
        this.freshLocation = null;
        HandlerThread handlerThread = new HandlerThread("LocationScanner");
        try {
            handlerThread.start();
            Iterator<String> it = this.enabledProviders.iterator();
            while (it.hasNext()) {
                this.locationManager.requestLocationUpdates(it.next(), MIN_TIME_BETWEEN_UPDATES, MIN_DISTANCE_BETWEEN_UPDATES, this, handlerThread.getLooper());
            }
            try {
                synchronized (this.scanLock) {
                    this.scanLock.wait(this.params.getLocationRequestTimeoutMs());
                }
            } catch (Exception unused) {
            }
            this.locationManager.removeUpdates(this);
            handlerThread.quit();
            Location location = this.freshLocation;
            if (location != null) {
                return location;
            }
            throw new ScannerException(ScannerException.Type.TIMEOUT);
        } catch (Throwable th) {
            this.locationManager.removeUpdates(this);
            handlerThread.quit();
            throw th;
        }
    }

    private Location getLastLocation(String str) {
        Location lastKnownLocation = this.locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null) {
            return null;
        }
        if (System.currentTimeMillis() - lastKnownLocation.getTime() < this.params.getLastLocationMaxAgeMs()) {
            return lastKnownLocation;
        }
        return null;
    }

    @Override // com.facebook.places.internal.LocationScanner
    public Location getLocation() throws ScannerException {
        Iterator<String> it = this.enabledProviders.iterator();
        while (it.hasNext()) {
            Location lastLocation = getLastLocation(it.next());
            if (lastLocation != null) {
                return lastLocation;
            }
        }
        return getFreshLocation();
    }

    @Override // com.facebook.places.internal.LocationScanner
    public void initAndCheckEligibility() throws ScannerException {
        if (Validate.hasLocationPermission(this.context)) {
            this.enabledProviders = new ArrayList(this.params.getLocationProviders().length);
            for (String str : this.params.getLocationProviders()) {
                if (this.locationManager.isProviderEnabled(str)) {
                    this.enabledProviders.add(str);
                }
            }
            if (this.enabledProviders.isEmpty()) {
                throw new ScannerException(ScannerException.Type.DISABLED);
            }
            return;
        }
        throw new ScannerException(ScannerException.Type.PERMISSION_DENIED);
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (this.freshLocation != null || location.getAccuracy() >= this.params.getLocationMaxAccuracyMeters()) {
            return;
        }
        synchronized (this.scanLock) {
            this.freshLocation = location;
            this.scanLock.notify();
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
