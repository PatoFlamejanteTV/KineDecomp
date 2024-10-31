package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzd extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzd {

        /* loaded from: classes.dex */
        private static class a implements zzd {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1907a;

            a(IBinder iBinder) {
                this.f1907a = iBinder;
            }

            @Override // com.google.android.gms.location.zzd
            public void a(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1907a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1907a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.ILocationListener");
        }

        public static zzd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new a(iBinder) : (zzd) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.ILocationListener");
                    a(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.ILocationListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(Location location) throws RemoteException;
}
