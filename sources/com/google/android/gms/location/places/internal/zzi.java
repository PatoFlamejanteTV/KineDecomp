package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public interface zzi extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzi {

        /* loaded from: classes.dex */
        private static class a implements zzi {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1892a;

            a(IBinder iBinder) {
                this.f1892a = iBinder;
            }

            @Override // com.google.android.gms.location.places.internal.zzi
            public void a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1892a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.places.internal.zzi
            public void a(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1892a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1892a;
            }

            @Override // com.google.android.gms.location.places.internal.zzi
            public void b(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1892a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.places.internal.zzi
            public void c(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1892a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.places.internal.zzi
            public void d(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1892a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
        }

        public static zzi a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new a(iBinder) : (zzi) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    a(parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    b(parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    c(parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    a(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    d(parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(Status status) throws RemoteException;

    void a(DataHolder dataHolder) throws RemoteException;

    void b(DataHolder dataHolder) throws RemoteException;

    void c(DataHolder dataHolder) throws RemoteException;

    void d(DataHolder dataHolder) throws RemoteException;
}
