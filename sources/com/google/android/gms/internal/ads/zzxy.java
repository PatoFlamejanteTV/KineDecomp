package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzxy extends zzew implements zzxw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzxg createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzalg zzalgVar, int i) throws RemoteException {
        zzxg zzxiVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzey.zza(obtainAndWriteInterfaceToken, zzalgVar);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzxg) {
                zzxiVar = (zzxg) queryLocalInterface;
            } else {
                zzxiVar = new zzxi(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzaop createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
        zzaop zzx = zzaoq.zzx(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzx;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzxl createBannerAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, zzalg zzalgVar, int i) throws RemoteException {
        zzxl zzxnVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzwfVar);
        obtainAndWriteInterfaceToken.writeString(str);
        zzey.zza(obtainAndWriteInterfaceToken, zzalgVar);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzaoz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        zzaoz zzz = zzapa.zzz(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzxl createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, zzalg zzalgVar, int i) throws RemoteException {
        zzxl zzxnVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzwfVar);
        obtainAndWriteInterfaceToken.writeString(str);
        zzey.zza(obtainAndWriteInterfaceToken, zzalgVar);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzadf createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
        zzadf zzk = zzadg.zzk(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzadk createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        zzadk zzl = zzadl.zzl(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzauw createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzalg zzalgVar, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzalgVar);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
        zzauw zzab = zzaux.zzab(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzab;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzauw createRewardedVideoAdSku(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken);
        zzauw zzab = zzaux.zzab(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzab;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzxl createSearchAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, int i) throws RemoteException {
        zzxl zzxnVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzwfVar);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzyc getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzyc zzyeVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzyeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyc) {
                zzyeVar = (zzyc) queryLocalInterface;
            } else {
                zzyeVar = new zzye(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzyeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final zzyc getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzyc zzyeVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzyeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyc) {
                zzyeVar = (zzyc) queryLocalInterface;
            } else {
                zzyeVar = new zzye(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzyeVar;
    }
}
