package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class IndoorBuilding {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.model.internal.zzd f1979a;

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.f1979a.a(((IndoorBuilding) obj).f1979a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1979a.e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
