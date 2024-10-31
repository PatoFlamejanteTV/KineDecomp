package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzxw extends IInterface {
    zzxg createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzalg zzalgVar, int i) throws RemoteException;

    zzaop createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzxl createBannerAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, zzalg zzalgVar, int i) throws RemoteException;

    zzaoz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzxl createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, zzalg zzalgVar, int i) throws RemoteException;

    zzadf createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    zzadk createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzauw createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzalg zzalgVar, int i) throws RemoteException;

    zzauw createRewardedVideoAdSku(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    zzxl createSearchAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, int i) throws RemoteException;

    zzyc getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzyc getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException;
}
