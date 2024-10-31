package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

/* loaded from: classes.dex */
public interface zznv extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zznv {

        /* loaded from: classes.dex */
        private static class a implements zznv {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1772a;

            a(IBinder iBinder) {
                this.f1772a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1772a;
            }

            @Override // com.google.android.gms.internal.zznv
            public void zza(DataSourcesResult dataSourcesResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    if (dataSourcesResult != null) {
                        obtain.writeInt(1);
                        dataSourcesResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1772a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
        }

        public static zznv zzbv(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznv)) ? new a(iBinder) : (zznv) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    zza(parcel.readInt() != 0 ? DataSourcesResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataSourcesResult dataSourcesResult) throws RemoteException;
}
