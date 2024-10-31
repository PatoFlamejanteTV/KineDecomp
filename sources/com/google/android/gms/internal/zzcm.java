package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public interface zzcm extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzcm {

        /* loaded from: classes.dex */
        private static class a implements zzcm {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1690a;

            a(IBinder iBinder) {
                this.f1690a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1690a;
            }

            @Override // com.google.android.gms.internal.zzcm
            public double getScale() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.f1690a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readDouble();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcm
            public Uri getUri() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.f1690a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcm
            public com.google.android.gms.dynamic.zzd zzdv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.f1690a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        }

        public static zzcm zzt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzcm)) ? new a(iBinder) : (zzcm) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    com.google.android.gms.dynamic.zzd zzdv = zzdv();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdv != null ? zzdv.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    Uri uri = getUri();
                    parcel2.writeNoException();
                    if (uri != null) {
                        parcel2.writeInt(1);
                        uri.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    double scale = getScale();
                    parcel2.writeNoException();
                    parcel2.writeDouble(scale);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    double getScale() throws RemoteException;

    Uri getUri() throws RemoteException;

    com.google.android.gms.dynamic.zzd zzdv() throws RemoteException;
}
