package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcm;
import java.util.List;

/* loaded from: classes.dex */
public interface zzcq extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzcq {

        /* loaded from: classes.dex */
        private static class a implements zzcq {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1693a;

            a(IBinder iBinder) {
                this.f1693a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1693a;
            }

            @Override // com.google.android.gms.internal.zzcq
            public String getBody() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public String getCallToAction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public String getHeadline() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public List getImages() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public String getPrice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public double getStarRating() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readDouble();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public String getStore() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public zzcm zzdw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzcm.zza.zzt(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcq
            public com.google.android.gms.dynamic.zzd zzdx() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f1693a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public static zzcq zzw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzcq)) ? new a(iBinder) : (zzcq) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    com.google.android.gms.dynamic.zzd zzdx = zzdx();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdx != null ? zzdx.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String headline = getHeadline();
                    parcel2.writeNoException();
                    parcel2.writeString(headline);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    List images = getImages();
                    parcel2.writeNoException();
                    parcel2.writeList(images);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String body = getBody();
                    parcel2.writeNoException();
                    parcel2.writeString(body);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcm zzdw = zzdw();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdw != null ? zzdw.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String callToAction = getCallToAction();
                    parcel2.writeNoException();
                    parcel2.writeString(callToAction);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double starRating = getStarRating();
                    parcel2.writeNoException();
                    parcel2.writeDouble(starRating);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String store = getStore();
                    parcel2.writeNoException();
                    parcel2.writeString(store);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String price = getPrice();
                    parcel2.writeNoException();
                    parcel2.writeString(price);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    if (extras != null) {
                        parcel2.writeInt(1);
                        extras.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzcm zzdw() throws RemoteException;

    com.google.android.gms.dynamic.zzd zzdx() throws RemoteException;
}
