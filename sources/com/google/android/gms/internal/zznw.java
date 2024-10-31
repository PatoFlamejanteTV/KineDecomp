package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

/* loaded from: classes.dex */
public interface zznw extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zznw {

        /* loaded from: classes.dex */
        private static class a implements zznw {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1773a;

            a(IBinder iBinder) {
                this.f1773a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1773a;
            }

            @Override // com.google.android.gms.internal.zznw
            public void zza(DataTypeResult dataTypeResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    if (dataTypeResult != null) {
                        obtain.writeInt(1);
                        dataTypeResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1773a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataTypeCallback");
        }

        public static zznw zzbw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznw)) ? new a(iBinder) : (zznw) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    zza(parcel.readInt() != 0 ? DataTypeResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataTypeResult dataTypeResult) throws RemoteException;
}
