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
public interface zzeq extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzeq {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements zzeq {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1710a;

            a(IBinder iBinder) {
                this.f1710a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1710a;
            }

            @Override // com.google.android.gms.internal.zzeq
            public String getBody() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public String getCallToAction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public String getHeadline() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public List getImages() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public boolean getOverrideClickHandling() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public boolean getOverrideImpressionRecording() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public String getPrice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public double getStarRating() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readDouble();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public String getStore() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public void recordImpression() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public void zzc(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1710a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public void zzd(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1710a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzeq
            public zzcm zzdw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.f1710a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzcm.zza.zzt(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        }

        public static zzeq zzI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzeq)) ? new a(iBinder) : (zzeq) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    String headline = getHeadline();
                    parcel2.writeNoException();
                    parcel2.writeString(headline);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    List images = getImages();
                    parcel2.writeNoException();
                    parcel2.writeList(images);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    String body = getBody();
                    parcel2.writeNoException();
                    parcel2.writeString(body);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    zzcm zzdw = zzdw();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdw != null ? zzdw.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    String callToAction = getCallToAction();
                    parcel2.writeNoException();
                    parcel2.writeString(callToAction);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    double starRating = getStarRating();
                    parcel2.writeNoException();
                    parcel2.writeDouble(starRating);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    String store = getStore();
                    parcel2.writeNoException();
                    parcel2.writeString(store);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    String price = getPrice();
                    parcel2.writeNoException();
                    parcel2.writeString(price);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    recordImpression();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    zzc(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    zzd(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    boolean overrideImpressionRecording = getOverrideImpressionRecording();
                    parcel2.writeNoException();
                    parcel2.writeInt(overrideImpressionRecording ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    boolean overrideClickHandling = getOverrideClickHandling();
                    parcel2.writeNoException();
                    parcel2.writeInt(overrideClickHandling ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    if (extras == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    extras.writeToParcel(parcel2, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
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

    boolean getOverrideClickHandling() throws RemoteException;

    boolean getOverrideImpressionRecording() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzc(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    void zzd(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    zzcm zzdw() throws RemoteException;
}
