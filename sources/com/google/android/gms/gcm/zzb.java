package com.google.android.gms.gcm;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzb extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzb {
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.gcm.INetworkTaskCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i) throws RemoteException;
}
