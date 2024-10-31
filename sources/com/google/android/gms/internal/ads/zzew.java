package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzew implements IInterface {
    private final IBinder zzvd;
    private final String zzve;

    public zzew(IBinder iBinder, String str) {
        this.zzvd = iBinder;
        this.zzve = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzvd;
    }

    public final Parcel obtainAndWriteInterfaceToken() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzve);
        return obtain;
    }

    public final Parcel transactAndReadException(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzvd.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    public final void zza(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzvd.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zzvd.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
