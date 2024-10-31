package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzxx extends zzex implements zzxw {
    public zzxx() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzxw asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        if (queryLocalInterface instanceof zzxw) {
            return (zzxw) queryLocalInterface;
        }
        return new zzxy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzxl createBannerAdManager = createBannerAdManager(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzwf) zzey.zza(parcel, zzwf.CREATOR), parcel.readString(), zzalh.zzu(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, createBannerAdManager);
                return true;
            case 2:
                zzxl createInterstitialAdManager = createInterstitialAdManager(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzwf) zzey.zza(parcel, zzwf.CREATOR), parcel.readString(), zzalh.zzu(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, createInterstitialAdManager);
                return true;
            case 3:
                zzxg createAdLoaderBuilder = createAdLoaderBuilder(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString(), zzalh.zzu(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, createAdLoaderBuilder);
                return true;
            case 4:
                zzyc mobileAdsSettingsManager = getMobileAdsSettingsManager(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzey.zza(parcel2, mobileAdsSettingsManager);
                return true;
            case 5:
                zzadf createNativeAdViewDelegate = createNativeAdViewDelegate(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzey.zza(parcel2, createNativeAdViewDelegate);
                return true;
            case 6:
                zzauw createRewardedVideoAd = createRewardedVideoAd(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzalh.zzu(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, createRewardedVideoAd);
                return true;
            case 7:
                zzaoz createInAppPurchaseManager = createInAppPurchaseManager(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzey.zza(parcel2, createInAppPurchaseManager);
                return true;
            case 8:
                zzaop createAdOverlay = createAdOverlay(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzey.zza(parcel2, createAdOverlay);
                return true;
            case 9:
                zzyc mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, mobileAdsSettingsManagerWithClientJarVersion);
                return true;
            case 10:
                zzxl createSearchAdManager = createSearchAdManager(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzwf) zzey.zza(parcel, zzwf.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, createSearchAdManager);
                return true;
            case 11:
                zzadk createNativeAdViewHolderDelegate = createNativeAdViewHolderDelegate(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzey.zza(parcel2, createNativeAdViewHolderDelegate);
                return true;
            case 12:
                zzauw createRewardedVideoAdSku = createRewardedVideoAdSku(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzey.zza(parcel2, createRewardedVideoAdSku);
                return true;
            default:
                return false;
        }
    }
}
