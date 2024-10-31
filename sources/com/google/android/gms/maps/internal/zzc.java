package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.internal.zza;

/* loaded from: classes.dex */
public interface zzc extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzc {

        /* loaded from: classes.dex */
        private static class a implements zzc {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1949a;

            a(IBinder iBinder) {
                this.f1949a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public ICameraUpdateFactoryDelegate a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.f1949a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return ICameraUpdateFactoryDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public IMapViewDelegate a(com.google.android.gms.dynamic.zzd zzdVar, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1949a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return IMapViewDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public IStreetViewPanoramaViewDelegate a(com.google.android.gms.dynamic.zzd zzdVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1949a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return IStreetViewPanoramaViewDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public void a(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1949a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public void a(com.google.android.gms.dynamic.zzd zzdVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f1949a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1949a;
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public IMapFragmentDelegate b(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1949a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return IMapFragmentDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public com.google.android.gms.maps.model.internal.zza b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.f1949a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return zza.AbstractBinderC0041zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.zzc
            public IStreetViewPanoramaFragmentDelegate c(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1949a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return IStreetViewPanoramaFragmentDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new a(iBinder) : (zzc) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    a(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate b = b(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(b != null ? b.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a2 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2 != null ? a2.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3 != null ? a3.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    com.google.android.gms.maps.model.internal.zza b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(b2 != null ? b2.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a4 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a4 != null ? a4.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate c = c(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(c != null ? c.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    ICameraUpdateFactoryDelegate a() throws RemoteException;

    IMapViewDelegate a(com.google.android.gms.dynamic.zzd zzdVar, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate a(com.google.android.gms.dynamic.zzd zzdVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void a(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    void a(com.google.android.gms.dynamic.zzd zzdVar, int i) throws RemoteException;

    IMapFragmentDelegate b(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    com.google.android.gms.maps.model.internal.zza b() throws RemoteException;

    IStreetViewPanoramaFragmentDelegate c(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;
}
