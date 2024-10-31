package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

/* loaded from: classes.dex */
public final class Polyline {

    /* renamed from: a, reason: collision with root package name */
    private final IPolylineDelegate f1989a;

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f1989a.a(((Polyline) obj).f1989a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f1989a.i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
