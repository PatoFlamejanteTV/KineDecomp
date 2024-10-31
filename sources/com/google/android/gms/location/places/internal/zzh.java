package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

/* loaded from: classes.dex */
public interface zzh extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzh {

        /* loaded from: classes.dex */
        private static class a implements zzh {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1891a;

            a(IBinder iBinder) {
                this.f1891a = iBinder;
            }

            @Override // com.google.android.gms.location.places.internal.zzh
            public void a(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    if (placePhotoMetadataResult != null) {
                        obtain.writeInt(1);
                        placePhotoMetadataResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1891a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.places.internal.zzh
            public void a(PlacePhotoResult placePhotoResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    if (placePhotoResult != null) {
                        obtain.writeInt(1);
                        placePhotoResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1891a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1891a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.places.internal.IPhotosCallbacks");
        }

        public static zzh a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzh)) ? new a(iBinder) : (zzh) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    a(parcel.readInt() != 0 ? PlacePhotoResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    a(parcel.readInt() != 0 ? PlacePhotoMetadataResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException;

    void a(PlacePhotoResult placePhotoResult) throws RemoteException;
}
