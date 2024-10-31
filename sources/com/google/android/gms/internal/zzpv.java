package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public interface zzpv extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzpv {

        /* loaded from: classes.dex */
        private static class a implements zzpv {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1811a;

            a(IBinder iBinder) {
                this.f1811a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1811a;
            }

            @Override // com.google.android.gms.internal.zzpv
            public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    this.f1811a.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void onDisconnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    this.f1811a.transact(1008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f1811a.transact(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void onEndpointLost(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    this.f1811a.transact(1003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1811a.transact(1007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zza(String str, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.f1811a.transact(1006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1811a.transact(1004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zzei(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    this.f1811a.transact(1005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zzis(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.f1811a.transact(1010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zzit(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.f1811a.transact(1011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zziu(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.f1811a.transact(1012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zziv(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.f1811a.transact(1013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zziw(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.f1811a.transact(1014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpv
            public void zzm(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1811a.transact(1009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        }

        public static zzpv zzdi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpv)) ? new a(iBinder) : (zzpv) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1001:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onConnectionRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE /* 1002 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointFound(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1003:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointLost(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1004:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? AppMetadata.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1005:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzei(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1006:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1007:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onMessageReceived(parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1008:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onDisconnected(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1009:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzm(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1010:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzis(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1011:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzit(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1012:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziu(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1013:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziv(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1014:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziw(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void onDisconnected(String str) throws RemoteException;

    void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException;

    void onEndpointLost(String str) throws RemoteException;

    void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException;

    void zza(String str, int i, byte[] bArr) throws RemoteException;

    void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException;

    void zzei(String str) throws RemoteException;

    void zzis(int i) throws RemoteException;

    void zzit(int i) throws RemoteException;

    void zziu(int i) throws RemoteException;

    void zziv(int i) throws RemoteException;

    void zziw(int i) throws RemoteException;

    void zzm(int i, String str) throws RemoteException;
}
