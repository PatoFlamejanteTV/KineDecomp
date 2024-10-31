package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzpv;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public interface zzpw extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzpw {

        /* loaded from: classes.dex */
        private static class a implements zzpw {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1812a;

            a(IBinder iBinder) {
                this.f1812a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1812a;
            }

            @Override // com.google.android.gms.internal.zzpw
            public String zzAP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    this.f1812a.transact(1016, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzE(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.f1812a.transact(1014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzQ(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.f1812a.transact(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzR(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.f1812a.transact(1006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzS(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.f1812a.transact(1013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public String zzT(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.f1812a.transact(1015, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(zzpv zzpvVar, int i, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(zzpvVar != null ? zzpvVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.f1812a.transact(1005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(zzpv zzpvVar, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(zzpvVar != null ? zzpvVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1812a.transact(1009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(zzpv zzpvVar, String str, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(zzpvVar != null ? zzpvVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.f1812a.transact(1003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(zzpv zzpvVar, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(zzpvVar != null ? zzpvVar.asBinder() : null);
                    obtain.writeString(str);
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.f1812a.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(zzpv zzpvVar, String str, String str2, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(zzpvVar != null ? zzpvVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.f1812a.transact(1007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(zzpv zzpvVar, String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(zzpvVar != null ? zzpvVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.f1812a.transact(1008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zza(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.f1812a.transact(1010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.f1812a.transact(1011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzg(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1812a.transact(1004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpw
            public void zzh(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1812a.transact(1012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzpw zzdj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpw)) ? new a(iBinder) : (zzpw) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1001:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzpv.zza.zzdi(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? AppMetadata.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE /* 1002 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzQ(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1003:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzpv.zza.zzdi(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1004:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzg(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1005:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzpv.zza.zzdi(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1006:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzR(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1007:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzpv.zza.zzdi(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1008:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzpv.zza.zzdi(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1009:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzpv.zza.zzdi(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1010:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(parcel.createStringArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1011:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzb(parcel.createStringArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1012:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzh(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1013:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzS(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1014:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzE(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1015:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    String zzT = zzT(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(zzT);
                    return true;
                case 1016:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    String zzAP = zzAP();
                    parcel2.writeNoException();
                    parcel2.writeString(zzAP);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String zzAP() throws RemoteException;

    void zzE(long j) throws RemoteException;

    void zzQ(long j) throws RemoteException;

    void zzR(long j) throws RemoteException;

    void zzS(long j) throws RemoteException;

    String zzT(long j) throws RemoteException;

    void zza(zzpv zzpvVar, int i, long j, long j2) throws RemoteException;

    void zza(zzpv zzpvVar, String str, long j) throws RemoteException;

    void zza(zzpv zzpvVar, String str, long j, long j2) throws RemoteException;

    void zza(zzpv zzpvVar, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException;

    void zza(zzpv zzpvVar, String str, String str2, byte[] bArr, long j) throws RemoteException;

    void zza(zzpv zzpvVar, String str, byte[] bArr, long j) throws RemoteException;

    void zza(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzg(String str, long j) throws RemoteException;

    void zzh(String str, long j) throws RemoteException;
}
