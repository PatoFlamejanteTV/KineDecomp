package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzf;

/* loaded from: classes.dex */
public interface zzn extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzn {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements zzn {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1960a;

            a(IBinder iBinder) {
                this.f1960a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.zzn
            public void a(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1960a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1960a;
            }

            @Override // com.google.android.gms.maps.internal.zzn
            public void b(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1960a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzn
            public void c(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1960a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }

        public static zzn a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzn)) ? new a(iBinder) : (zzn) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    a(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    b(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    c(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException;

    void b(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException;

    void c(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException;
}
