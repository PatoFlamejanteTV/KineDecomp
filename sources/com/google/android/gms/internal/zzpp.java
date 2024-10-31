package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface zzpp extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzpp {

        /* loaded from: classes.dex */
        private static class a implements zzpp {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1801a;

            a(IBinder iBinder) {
                this.f1801a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1801a;
            }

            @Override // com.google.android.gms.internal.zzpp
            public void zzaT(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1801a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzpp zzde(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpp)) ? new a(iBinder) : (zzpp) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapCallback");
                    zzaT(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzaT(Status status) throws RemoteException;
}
