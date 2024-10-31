package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.internal.zzd;

/* loaded from: classes.dex */
public interface zze extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zze {

        /* loaded from: classes.dex */
        private static class a implements zze {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f812a;

            a(IBinder iBinder) {
                this.f812a = iBinder;
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zze
            public void a(zzd zzdVar, GoogleSignInConfig googleSignInConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (googleSignInConfig != null) {
                        obtain.writeInt(1);
                        googleSignInConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f812a.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zze
            public void a(zzd zzdVar, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f812a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f812a;
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zze
            public void b(zzd zzdVar, GoogleSignInConfig googleSignInConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (googleSignInConfig != null) {
                        obtain.writeInt(1);
                        googleSignInConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f812a.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zze
            public void b(zzd zzdVar, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f812a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zze
            public void c(zzd zzdVar, GoogleSignInConfig googleSignInConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (googleSignInConfig != null) {
                        obtain.writeInt(1);
                        googleSignInConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f812a.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new a(iBinder) : (zze) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? SignInConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    b(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? SignInConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 101:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? GoogleSignInConfig.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 102:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    b(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? GoogleSignInConfig.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 103:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    c(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? GoogleSignInConfig.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(zzd zzdVar, GoogleSignInConfig googleSignInConfig) throws RemoteException;

    void a(zzd zzdVar, SignInConfiguration signInConfiguration) throws RemoteException;

    void b(zzd zzdVar, GoogleSignInConfig googleSignInConfig) throws RemoteException;

    void b(zzd zzdVar, SignInConfiguration signInConfiguration) throws RemoteException;

    void c(zzd zzdVar, GoogleSignInConfig googleSignInConfig) throws RemoteException;
}
