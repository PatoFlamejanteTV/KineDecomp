package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

/* loaded from: classes.dex */
public interface zzv extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzv {

        /* loaded from: classes.dex */
        private static class a implements zzv {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1968a;

            a(IBinder iBinder) {
                this.f1968a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.zzv
            public void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    obtain.writeStrongBinder(iStreetViewPanoramaDelegate != null ? iStreetViewPanoramaDelegate.asBinder() : null);
                    this.f1968a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1968a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        }

        public static zzv a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzv)) ? new a(iBinder) : (zzv) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    a(IStreetViewPanoramaDelegate.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException;
}
