package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzagc extends zzex implements zzagb {
    public zzagc() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzagd zzageVar;
        if (i == 3) {
            zzyp videoController = getVideoController();
            parcel2.writeNoException();
            zzey.zza(parcel2, videoController);
            return true;
        }
        if (i == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        }
        if (i != 5) {
            return false;
        }
        IObjectWrapper a2 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzageVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
            if (queryLocalInterface instanceof zzagd) {
                zzageVar = (zzagd) queryLocalInterface;
            } else {
                zzageVar = new zzage(readStrongBinder);
            }
        }
        zza(a2, zzageVar);
        parcel2.writeNoException();
        return true;
    }
}
