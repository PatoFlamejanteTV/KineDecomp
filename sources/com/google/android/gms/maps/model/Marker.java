package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class Marker {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zzf f1984a;

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.f1984a.a(((Marker) obj).f1984a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1984a.k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
