package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface zzi extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class zza extends Binder implements zzi {

        /* loaded from: classes2.dex */
        private static class a implements zzi {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1193a;

            a(IBinder iBinder) {
                this.f1193a = iBinder;
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzi
            public void a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1193a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1193a;
            }
        }

        public static zzi a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new a(iBinder) : (zzi) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    a(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(Status status) throws RemoteException;
}
