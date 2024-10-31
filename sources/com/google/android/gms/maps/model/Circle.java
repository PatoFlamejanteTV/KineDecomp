package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class Circle {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zzb f1975a;

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.f1975a.a(((Circle) obj).f1975a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1975a.j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
