package com.facebook.places;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.places.PlaceManager;
import com.facebook.places.internal.LocationPackage;
import com.facebook.places.internal.LocationPackageManager;
import com.facebook.places.internal.ScannerException;
import com.facebook.places.model.CurrentPlaceRequestParams;

/* compiled from: PlaceManager.java */
/* loaded from: classes.dex */
class b implements LocationPackageManager.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlaceManager.OnRequestReadyCallback f9454a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CurrentPlaceRequestParams f9455b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PlaceManager.OnRequestReadyCallback onRequestReadyCallback, CurrentPlaceRequestParams currentPlaceRequestParams) {
        this.f9454a = onRequestReadyCallback;
        this.f9455b = currentPlaceRequestParams;
    }

    @Override // com.facebook.places.internal.LocationPackageManager.Listener
    public void onLocationPackage(LocationPackage locationPackage) {
        Bundle currentPlaceParameters;
        PlaceManager.LocationError locationError;
        ScannerException.Type type = locationPackage.locationError;
        if (type == null) {
            currentPlaceParameters = PlaceManager.getCurrentPlaceParameters(this.f9455b, locationPackage);
            this.f9454a.onRequestReady(new GraphRequest(AccessToken.getCurrentAccessToken(), "current_place/results", currentPlaceParameters, HttpMethod.GET));
        } else {
            PlaceManager.OnRequestReadyCallback onRequestReadyCallback = this.f9454a;
            locationError = PlaceManager.getLocationError(type);
            onRequestReadyCallback.onLocationError(locationError);
        }
    }
}
