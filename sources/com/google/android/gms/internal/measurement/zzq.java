package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzq implements IInterface {
    private final IBinder zzqt;
    private final String zzqu;

    public zzq(IBinder iBinder, String str) {
        this.zzqt = iBinder;
        this.zzqu = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzqt;
    }

    public final Parcel obtainAndWriteInterfaceToken() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzqu);
        return obtain;
    }

    public final Parcel transactAndReadException(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzqt.transact(i, parcel, obtain, 0);
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
            this.zzqt.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    protected final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zzqt.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
