package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class IndoorLevel {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zze f1980a;

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.f1980a.a(((IndoorLevel) obj).f1980a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1980a.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
