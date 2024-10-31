package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzm implements IInterface {
    private final IBinder zzqx;
    private final String zzqy;

    public zzm(IBinder iBinder, String str) {
        this.zzqx = iBinder;
        this.zzqy = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzqx;
    }

    public final Parcel obtainAndWriteInterfaceToken() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzqy);
        return obtain;
    }

    protected final Parcel transactAndReadException(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzqx.transact(i, parcel, obtain, 0);
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
            this.zzqx.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    protected final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zzqx.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
