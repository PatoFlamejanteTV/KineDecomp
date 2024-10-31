package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

/* loaded from: classes.dex */
public interface zzky extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzky {

        /* loaded from: classes.dex */
        private static class a implements zzky {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1747a;

            a(IBinder iBinder) {
                this.f1747a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1747a;
            }

            @Override // com.google.android.gms.internal.zzky
            public void onDisconnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    this.f1747a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzky
            public void onError(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    obtain.writeInt(i);
                    this.f1747a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzky
            public void zza(int i, int i2, Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1747a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzky
            public void zznn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    this.f1747a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
        }

        public static zzky zzaD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzky)) ? new a(iBinder) : (zzky) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    zza(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    onError(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    onDisconnected();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    zznn();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDisconnected() throws RemoteException;

    void onError(int i) throws RemoteException;

    void zza(int i, int i2, Surface surface) throws RemoteException;

    void zznn() throws RemoteException;
}
