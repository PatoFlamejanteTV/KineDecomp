package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public interface zzbgg extends com.google.android.gms.ads.internal.zzbo, zzahu, zzais, zzbdz, zzbhc, zzbhd, zzbhh, zzbhk, zzbhl, zzbhm, zzsg {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhc
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    View.OnClickListener getOnClickListener();

    ViewParent getParent();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbdz
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zza(zzbgw zzbgwVar);

    void zza(zzbht zzbhtVar);

    void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar);

    void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> predicate);

    void zza(String str, zzbfk zzbfkVar);

    void zzaa(IObjectWrapper iObjectWrapper);

    zzbgw zzabu();

    Activity zzabw();

    zzaaz zzaby();

    zzbbi zzabz();

    void zzade();

    void zzadf();

    Context zzadg();

    com.google.android.gms.ads.internal.overlay.zzd zzadh();

    com.google.android.gms.ads.internal.overlay.zzd zzadi();

    zzbht zzadj();

    String zzadk();

    zzbhn zzadl();

    WebViewClient zzadm();

    boolean zzadn();

    zzcu zzado();

    IObjectWrapper zzadp();

    boolean zzadq();

    void zzadr();

    boolean zzads();

    boolean zzadt();

    boolean zzadu();

    void zzadv();

    void zzadw();

    zzacb zzadx();

    void zzady();

    void zzadz();

    void zzaf(boolean z);

    void zzav(boolean z);

    void zzaw(boolean z);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzb(zzacb zzacbVar);

    void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar);

    void zzbo(Context context);

    void zzc(String str, String str2, String str3);

    void zzdh(int i);

    void zzfb(String str);

    com.google.android.gms.ads.internal.zzv zzid();

    void zzvv();
}
