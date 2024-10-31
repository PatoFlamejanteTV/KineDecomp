package com.google.android.gms.maps;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

/* loaded from: classes.dex */
public final class GoogleMap {

    /* renamed from: a, reason: collision with root package name */
    private final IGoogleMapDelegate f1909a;

    /* loaded from: classes.dex */
    public interface CancelableCallback {
    }

    /* loaded from: classes.dex */
    public interface InfoWindowAdapter {
    }

    /* loaded from: classes.dex */
    public interface OnCameraChangeListener {
    }

    /* loaded from: classes.dex */
    public interface OnIndoorStateChangeListener {
    }

    /* loaded from: classes.dex */
    public interface OnInfoWindowClickListener {
    }

    /* loaded from: classes.dex */
    public interface OnMapClickListener {
    }

    /* loaded from: classes.dex */
    public interface OnMapLoadedCallback {
    }

    /* loaded from: classes.dex */
    public interface OnMapLongClickListener {
    }

    /* loaded from: classes.dex */
    public interface OnMarkerClickListener {
    }

    /* loaded from: classes.dex */
    public interface OnMarkerDragListener {
    }

    /* loaded from: classes.dex */
    public interface OnMyLocationButtonClickListener {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnMyLocationChangeListener {
    }

    /* loaded from: classes.dex */
    public interface SnapshotReadyCallback {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f1909a = (IGoogleMapDelegate) zzx.a(iGoogleMapDelegate);
    }
}
