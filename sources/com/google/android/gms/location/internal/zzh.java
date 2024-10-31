package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzh extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzh {

        /* loaded from: classes.dex */
        private static class a implements zzh {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1859a;

            a(IBinder iBinder) {
                this.f1859a = iBinder;
            }

            @Override // com.google.android.gms.location.internal.zzh
            public void a(int i, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1859a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzh
            public void a(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.f1859a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1859a;
            }

            @Override // com.google.android.gms.location.internal.zzh
            public void b(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.f1859a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
        }

        public static zzh a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzh)) ? new a(iBinder) : (zzh) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    a(parcel.readInt(), parcel.createStringArray());
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    b(parcel.readInt(), parcel.createStringArray());
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    a(parcel.readInt(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, PendingIntent pendingIntent) throws RemoteException;

    void a(int i, String[] strArr) throws RemoteException;

    void b(int i, String[] strArr) throws RemoteException;
}
