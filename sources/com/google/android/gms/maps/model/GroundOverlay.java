package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class GroundOverlay {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zzc f1977a;

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.f1977a.a(((GroundOverlay) obj).f1977a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1977a.k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
