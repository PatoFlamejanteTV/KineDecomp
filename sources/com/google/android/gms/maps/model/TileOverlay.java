package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class TileOverlay {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zzh f1997a;

    public boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.f1997a.a(((TileOverlay) obj).f1997a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1997a.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
