package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzla;

/* loaded from: classes.dex */
public interface zzkz extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzkz {

        /* loaded from: classes.dex */
        private static class a implements zzkz {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1748a;

            a(IBinder iBinder) {
                this.f1748a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1748a;
            }

            @Override // com.google.android.gms.internal.zzkz
            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.f1748a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzkz
            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.f1748a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzkz
            public void zza(zzky zzkyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    obtain.writeStrongBinder(zzkyVar != null ? zzkyVar.asBinder() : null);
                    this.f1748a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzkz
            public void zza(zzky zzkyVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    obtain.writeStrongBinder(zzkyVar != null ? zzkyVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f1748a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzkz
            public void zza(zzky zzkyVar, zzla zzlaVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    obtain.writeStrongBinder(zzkyVar != null ? zzkyVar.asBinder() : null);
                    obtain.writeStrongBinder(zzlaVar != null ? zzlaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1748a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzkz zzaE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkz)) ? new a(iBinder) : (zzkz) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    destroy();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    disconnect();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(zzky.zza.zzaD(parcel.readStrongBinder()), zzla.zza.zzaF(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(zzky.zza.zzaD(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(zzky.zza.zzaD(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void destroy() throws RemoteException;

    void disconnect() throws RemoteException;

    void zza(zzky zzkyVar) throws RemoteException;

    void zza(zzky zzkyVar, int i) throws RemoteException;

    void zza(zzky zzkyVar, zzla zzlaVar, String str, String str2) throws RemoteException;
}
