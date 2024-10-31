package com.facebook.places;

import com.facebook.places.PlaceManager;
import com.facebook.places.internal.LocationPackage;
import com.facebook.places.internal.LocationPackageManager;
import com.facebook.places.internal.ScannerException;
import com.facebook.places.model.PlaceSearchRequestParams;

/* compiled from: PlaceManager.java */
/* loaded from: classes.dex */
class a implements LocationPackageManager.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlaceSearchRequestParams f9452a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PlaceManager.OnRequestReadyCallback f9453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PlaceSearchRequestParams placeSearchRequestParams, PlaceManager.OnRequestReadyCallback onRequestReadyCallback) {
        this.f9452a = placeSearchRequestParams;
        this.f9453b = onRequestReadyCallback;
    }

    @Override // com.facebook.places.internal.LocationPackageManager.Listener
    public void onLocationPackage(LocationPackage locationPackage) {
        PlaceManager.LocationError locationError;
        ScannerException.Type type = locationPackage.locationError;
        if (type == null) {
            this.f9453b.onRequestReady(PlaceManager.newPlaceSearchRequestForLocation(this.f9452a, locationPackage.location));
        } else {
            PlaceManager.OnRequestReadyCallback onRequestReadyCallback = this.f9453b;
            locationError = PlaceManager.getLocationError(type);
            onRequestReadyCallback.onLocationError(locationError);
        }
    }
}
