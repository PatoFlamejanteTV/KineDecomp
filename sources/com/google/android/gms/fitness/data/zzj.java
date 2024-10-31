package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzj extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzj {

        /* loaded from: classes.dex */
        private static class a implements zzj {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1236a;

            a(IBinder iBinder) {
                this.f1236a = iBinder;
            }

            @Override // com.google.android.gms.fitness.data.zzj
            public void a(DataPoint dataPoint) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.data.IDataSourceListener");
                    if (dataPoint != null) {
                        obtain.writeInt(1);
                        dataPoint.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1236a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1236a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.data.IDataSourceListener");
        }

        public static zzj a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzj)) ? new a(iBinder) : (zzj) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
                    a(parcel.readInt() != 0 ? DataPoint.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DataPoint dataPoint) throws RemoteException;
}
