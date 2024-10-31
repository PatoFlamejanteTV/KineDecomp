package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import java.util.List;

/* loaded from: classes.dex */
public interface zzen extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzen {

        /* loaded from: classes.dex */
        private static class a implements zzen {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1707a;

            a(IBinder iBinder) {
                this.f1707a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1707a;
            }

            @Override // com.google.android.gms.internal.zzen
            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public boolean isInitialized() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void showVideo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(AdRequestParcel adRequestParcel, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f1707a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzaVar != null ? zzaVar.asBinder() : null);
                    obtain.writeString(str2);
                    this.f1707a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzeoVar != null ? zzeoVar.asBinder() : null);
                    this.f1707a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzeoVar != null ? zzeoVar.asBinder() : null);
                    this.f1707a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzeoVar != null ? zzeoVar.asBinder() : null);
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    this.f1707a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzeoVar != null ? zzeoVar.asBinder() : null);
                    this.f1707a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzeoVar != null ? zzeoVar.asBinder() : null);
                    this.f1707a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public zzeq zzdV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzeq.zza.zzI(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public zzer zzdW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzer.zza.zzJ(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public Bundle zzdX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public Bundle zzdY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzen
            public Bundle zzdZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1707a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static zzen zzF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzen)) ? new a(iBinder) : (zzen) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzeo.zza.zzG(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    com.google.android.gms.dynamic.zzd view = getView();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(view != null ? view.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzeo.zza.zzG(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), zzeo.zza.zzG(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), zzeo.zza.zzG(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    resume();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zza.AbstractBinderC0029zza.zzae(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showVideo();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean isInitialized = isInitialized();
                    parcel2.writeNoException();
                    parcel2.writeInt(isInitialized ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), zzeo.zza.zzG(parcel.readStrongBinder()), parcel.readInt() != 0 ? NativeAdOptionsParcel.CREATOR.createFromParcel(parcel) : null, parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zzeq zzdV = zzdV();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdV != null ? zzdV.asBinder() : null);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zzer zzdW = zzdW();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdW != null ? zzdW.asBinder() : null);
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    Bundle zzdX = zzdX();
                    parcel2.writeNoException();
                    if (zzdX == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    zzdX.writeToParcel(parcel2, 1);
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    Bundle zzdY = zzdY();
                    parcel2.writeNoException();
                    if (zzdY == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    zzdY.writeToParcel(parcel2, 1);
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    Bundle zzdZ = zzdZ();
                    parcel2.writeNoException();
                    if (zzdZ == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    zzdZ.writeToParcel(parcel2, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void destroy() throws RemoteException;

    com.google.android.gms.dynamic.zzd getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(AdRequestParcel adRequestParcel, String str) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzeo zzeoVar) throws RemoteException;

    void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzeo zzeoVar) throws RemoteException;

    zzeq zzdV() throws RemoteException;

    zzer zzdW() throws RemoteException;

    Bundle zzdX() throws RemoteException;

    Bundle zzdY() throws RemoteException;

    Bundle zzdZ() throws RemoteException;
}
