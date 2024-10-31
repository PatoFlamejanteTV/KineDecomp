package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.internal.zzf;

/* loaded from: classes.dex */
public interface zzd extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzd {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements zzd {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1950a;

            a(IBinder iBinder) {
                this.f1950a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.zzd
            public com.google.android.gms.dynamic.zzd a(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1950a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1950a;
            }

            @Override // com.google.android.gms.maps.internal.zzd
            public com.google.android.gms.dynamic.zzd b(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1950a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static zzd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
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
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    com.google.android.gms.dynamic.zzd a2 = a(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2 != null ? a2.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    com.google.android.gms.dynamic.zzd b = b(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(b != null ? b.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    com.google.android.gms.dynamic.zzd a(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException;

    com.google.android.gms.dynamic.zzd b(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException;
}
