package com.google.android.gms.cast.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;

/* loaded from: classes.dex */
public interface zzi extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzi {

        /* loaded from: classes.dex */
        private static class a implements zzi {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f855a;

            a(IBinder iBinder) {
                this.f855a = iBinder;
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.f855a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(double d, double d2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeInt(z ? 1 : 0);
                    this.f855a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.f855a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str, LaunchOptions launchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (launchOptions != null) {
                        obtain.writeInt(1);
                        launchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f855a.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f855a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.f855a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str, String str2, JoinOptions joinOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (joinOptions != null) {
                        obtain.writeInt(1);
                        joinOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f855a.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f855a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.f855a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void a(boolean z, double d, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeDouble(d);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f855a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f855a;
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.f855a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.f855a.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.f855a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.cast.internal.zzi
            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.f855a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzi a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new a(iBinder) : (zzi) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString(), parcel.readInt() != 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString(), parcel.readString());
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    b();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString());
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    c();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readDouble(), parcel.readDouble(), parcel.readInt() != 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readInt() != 0, parcel.readDouble(), parcel.readInt() != 0);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString(), parcel.readString(), parcel.readLong());
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    b(parcel.readString());
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    c(parcel.readString());
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString(), parcel.readInt() != 0 ? LaunchOptions.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? JoinOptions.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void a(double d, double d2, boolean z) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, LaunchOptions launchOptions) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, long j) throws RemoteException;

    void a(String str, String str2, JoinOptions joinOptions) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(String str, byte[] bArr, long j) throws RemoteException;

    void a(boolean z, double d, boolean z2) throws RemoteException;

    void b() throws RemoteException;

    void b(String str) throws RemoteException;

    void c() throws RemoteException;

    void c(String str) throws RemoteException;
}
