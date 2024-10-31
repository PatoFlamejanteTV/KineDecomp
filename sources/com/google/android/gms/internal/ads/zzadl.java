package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzadl extends zzex implements zzadk {
    public zzadl() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzadk zzl(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        if (queryLocalInterface instanceof zzadk) {
            return (zzadk) queryLocalInterface;
        }
        return new zzadm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
        } else if (i == 2) {
            unregisterNativeAd();
        } else {
            if (i != 3) {
                return false;
            }
            zzc(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
