package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzpo extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzpo {

        /* loaded from: classes.dex */
        private static class a implements zzpo {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1800a;

            a(IBinder iBinder) {
                this.f1800a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1800a;
            }

            @Override // com.google.android.gms.internal.zzpo
            public void onError(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    obtain.writeInt(i);
                    this.f1800a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpo
            public void zzq(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    obtain.writeByteArray(bArr);
                    this.f1800a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzpo zzdd(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpo)) ? new a(iBinder) : (zzpo) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    zzq(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    onError(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onError(int i) throws RemoteException;

    void zzq(byte[] bArr) throws RemoteException;
}
