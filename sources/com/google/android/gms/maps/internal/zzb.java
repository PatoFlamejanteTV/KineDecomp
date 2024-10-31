package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzb extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzb {

        /* loaded from: classes.dex */
        private static class a implements zzb {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1948a;

            a(IBinder iBinder) {
                this.f1948a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.zzb
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICancelableCallback");
                    this.f1948a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1948a;
            }

            @Override // com.google.android.gms.maps.internal.zzb
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICancelableCallback");
                    this.f1948a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.ICancelableCallback");
        }

        public static zzb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICancelableCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new a(iBinder) : (zzb) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICancelableCallback");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICancelableCallback");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.ICancelableCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void b() throws RemoteException;
}
