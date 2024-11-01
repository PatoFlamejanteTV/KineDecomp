package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public interface zziz extends zzaw {
    void clearCache(boolean z);

    void destroy();

    Context getContext();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zzC(boolean z);

    void zzD(boolean z);

    void zzE(boolean z);

    void zza(Context context, AdSizeParcel adSizeParcel, zzcg zzcgVar);

    void zza(AdSizeParcel adSizeParcel);

    void zza(String str, String str2);

    void zza(String str, JSONObject jSONObject);

    void zzaI(String str);

    void zzaJ(String str);

    AdSizeParcel zzaN();

    void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzb(String str, Map<String, ?> map);

    void zzb(String str, JSONObject jSONObject);

    void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzeJ();

    void zzgY();

    Activity zzgZ();

    Context zzha();

    com.google.android.gms.ads.internal.zzd zzhb();

    com.google.android.gms.ads.internal.overlay.zzd zzhc();

    com.google.android.gms.ads.internal.overlay.zzd zzhd();

    zzja zzhe();

    boolean zzhf();

    zzan zzhg();

    VersionInfoParcel zzhh();

    boolean zzhi();

    void zzhj();

    boolean zzhk();

    zziy zzhl();

    zzce zzhm();

    zzcf zzhn();

    void zzho();

    void zzhp();

    void zzv(int i);
}
