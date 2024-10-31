package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ReadRawResult;

/* loaded from: classes.dex */
public interface zzof extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzof {

        /* loaded from: classes.dex */
        private static class a implements zzof {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1782a;

            a(IBinder iBinder) {
                this.f1782a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1782a;
            }

            @Override // com.google.android.gms.internal.zzof
            public void zza(ReadRawResult readRawResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IReadRawCallback");
                    if (readRawResult != null) {
                        obtain.writeInt(1);
                        readRawResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1782a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzof zzbF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IReadRawCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzof)) ? new a(iBinder) : (zzof) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IReadRawCallback");
                    zza(parcel.readInt() != 0 ? ReadRawResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IReadRawCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(ReadRawResult readRawResult) throws RemoteException;
}
