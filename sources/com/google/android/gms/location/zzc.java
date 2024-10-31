package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzc extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzc {

        /* loaded from: classes.dex */
        private static class a implements zzc {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1906a;

            a(IBinder iBinder) {
                this.f1906a = iBinder;
            }

            @Override // com.google.android.gms.location.zzc
            public void a(LocationAvailability locationAvailability) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (locationAvailability != null) {
                        obtain.writeInt(1);
                        locationAvailability.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1906a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.zzc
            public void a(LocationResult locationResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (locationResult != null) {
                        obtain.writeInt(1);
                        locationResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1906a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1906a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.ILocationCallback");
        }

        public static zzc a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new a(iBinder) : (zzc) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
                    a(parcel.readInt() != 0 ? LocationResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
                    a(parcel.readInt() != 0 ? LocationAvailability.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.ILocationCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(LocationAvailability locationAvailability) throws RemoteException;

    void a(LocationResult locationResult) throws RemoteException;
}
