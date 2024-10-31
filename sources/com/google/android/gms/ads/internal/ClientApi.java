package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzact;
import com.google.android.gms.internal.ads.zzadf;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzaoz;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzauw;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzxx;
import com.google.android.gms.internal.ads.zzyc;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@RetainForClient
@Keep
@DynamiteApi
@zzark
@ParametersAreNonnullByDefault
@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class ClientApi extends zzxx {
    @Override // com.google.android.gms.internal.ads.zzxw
    public zzxg createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzalg zzalgVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzbv.e();
        return new zzak(context, str, zzalgVar, new zzbbi(14300000, i, true, zzayh.zzav(context)), zzv.a(context));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzaop createAdOverlay(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.a(iObjectWrapper);
        AdOverlayInfoParcel a2 = AdOverlayInfoParcel.a(activity.getIntent());
        if (a2 == null) {
            return new zzr(activity);
        }
        int i = a2.k;
        if (i == 1) {
            return new zzq(activity);
        }
        if (i == 2) {
            return new com.google.android.gms.ads.internal.overlay.zzx(activity);
        }
        if (i == 3) {
            return new zzy(activity);
        }
        if (i != 4) {
            return new zzr(activity);
        }
        return new zzs(activity, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzxl createBannerAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, zzalg zzalgVar, int i) throws RemoteException {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzbv.e();
        return new zzx(context, zzwfVar, str, zzalgVar, new zzbbi(14300000, i, true, zzayh.zzav(context)), zzv.a(context));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzaoz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:            if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcsa)).booleanValue() != false) goto L11;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0034, code lost:            if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcrz)).booleanValue() == false) goto L6;     */
    @Override // com.google.android.gms.internal.ads.zzxw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.ads.zzxl createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r8, com.google.android.gms.internal.ads.zzwf r9, java.lang.String r10, com.google.android.gms.internal.ads.zzalg r11, int r12) throws android.os.RemoteException {
        /*
            r7 = this;
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.a(r8)
            r1 = r8
            android.content.Context r1 = (android.content.Context) r1
            com.google.android.gms.internal.ads.zzaan.initialize(r1)
            com.google.android.gms.internal.ads.zzbbi r5 = new com.google.android.gms.internal.ads.zzbbi
            com.google.android.gms.ads.internal.zzbv.e()
            boolean r8 = com.google.android.gms.internal.ads.zzayh.zzav(r1)
            r0 = 1
            r2 = 14300000(0xda3360, float:2.0038568E-38)
            r5.<init>(r2, r12, r0, r8)
            java.lang.String r8 = r9.zzckk
            java.lang.String r12 = "reward_mb"
            boolean r8 = r12.equals(r8)
            if (r8 != 0) goto L36
            com.google.android.gms.internal.ads.zzaac<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzaan.zzcrz
            com.google.android.gms.internal.ads.zzaak r2 = com.google.android.gms.internal.ads.zzwu.zzpz()
            java.lang.Object r12 = r2.zzd(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L4c
        L36:
            if (r8 == 0) goto L4b
            com.google.android.gms.internal.ads.zzaac<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.zzaan.zzcsa
            com.google.android.gms.internal.ads.zzaak r12 = com.google.android.gms.internal.ads.zzwu.zzpz()
            java.lang.Object r8 = r12.zzd(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L4b
            goto L4c
        L4b:
            r0 = 0
        L4c:
            if (r0 == 0) goto L5d
            com.google.android.gms.internal.ads.zzahr r8 = new com.google.android.gms.internal.ads.zzahr
            com.google.android.gms.ads.internal.zzv r9 = com.google.android.gms.ads.internal.zzv.a(r1)
            r0 = r8
            r2 = r10
            r3 = r11
            r4 = r5
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return r8
        L5d:
            com.google.android.gms.ads.internal.zzal r8 = new com.google.android.gms.ads.internal.zzal
            com.google.android.gms.ads.internal.zzv r6 = com.google.android.gms.ads.internal.zzv.a(r1)
            r0 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzwf, java.lang.String, com.google.android.gms.internal.ads.zzalg, int):com.google.android.gms.internal.ads.zzxl");
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzadf createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzacr((FrameLayout) ObjectWrapper.a(iObjectWrapper), (FrameLayout) ObjectWrapper.a(iObjectWrapper2));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzadk createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzact((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzauw createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzalg zzalgVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzbv.e();
        return new zzaun(context, zzv.a(context), zzalgVar, new zzbbi(14300000, i, true, zzayh.zzav(context)));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzauw createRewardedVideoAdSku(IObjectWrapper iObjectWrapper, int i) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzxl createSearchAdManager(IObjectWrapper iObjectWrapper, zzwf zzwfVar, String str, int i) throws RemoteException {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzbv.e();
        return new zzbp(context, zzwfVar, str, new zzbbi(14300000, i, true, zzayh.zzav(context)));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzyc getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzyc getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzbv.e();
        return zzay.a(context, new zzbbi(14300000, i, true, zzayh.zzav(context)));
    }
}
