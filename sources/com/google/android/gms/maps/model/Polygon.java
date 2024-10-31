package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class Polygon {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zzg f1987a;

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.f1987a.a(((Polygon) obj).f1987a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1987a.k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
