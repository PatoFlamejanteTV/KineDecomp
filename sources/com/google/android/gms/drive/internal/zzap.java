package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface zzap extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class zza extends Binder implements zzap {
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    a(parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(boolean z) throws RemoteException;
}
