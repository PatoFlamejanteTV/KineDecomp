package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@zzgr
/* loaded from: classes.dex */
public class ej extends FrameLayout implements zziz {

    /* renamed from: a, reason: collision with root package name */
    private final zziz f1529a;
    private final zziy b;

    public ej(zziz zzizVar) {
        super(zzizVar.zzha());
        this.f1529a = zzizVar;
        this.b = new zziy(zzizVar.zzha(), this, this);
        zzja zzhe = this.f1529a.zzhe();
        if (zzhe != null) {
            zzhe.zze(this);
        }
        addView(this.f1529a.getView());
    }

    @Override // com.google.android.gms.internal.zziz
    public void clearCache(boolean z) {
        this.f1529a.clearCache(z);
    }

    @Override // com.google.android.gms.internal.zziz
    public void destroy() {
        this.f1529a.destroy();
    }

    @Override // com.google.android.gms.internal.zziz
    public String getRequestId() {
        return this.f1529a.getRequestId();
    }

    @Override // com.google.android.gms.internal.zziz
    public int getRequestedOrientation() {
        return this.f1529a.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.zziz
    public View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zziz
    public WebView getWebView() {
        return this.f1529a.getWebView();
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean isDestroyed() {
        return this.f1529a.isDestroyed();
    }

    @Override // com.google.android.gms.internal.zziz
    public void loadData(String str, String str2, String str3) {
        this.f1529a.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.zziz
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f1529a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.zziz
    public void loadUrl(String str) {
        this.f1529a.loadUrl(str);
    }

    @Override // android.view.View, com.google.android.gms.internal.zziz
    public void setBackgroundColor(int i) {
        this.f1529a.setBackgroundColor(i);
    }

    @Override // com.google.android.gms.internal.zziz
    public void setContext(Context context) {
        this.f1529a.setContext(context);
    }

    @Override // android.view.View, com.google.android.gms.internal.zziz
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1529a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.zziz
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f1529a.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.zziz
    public void setRequestedOrientation(int i) {
        this.f1529a.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.zziz
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f1529a.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.zziz
    public void setWebViewClient(WebViewClient webViewClient) {
        this.f1529a.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.zziz
    public void stopLoading() {
        this.f1529a.stopLoading();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzC(boolean z) {
        this.f1529a.zzC(z);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzD(boolean z) {
        this.f1529a.zzD(z);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzE(boolean z) {
        this.f1529a.zzE(z);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(Context context, AdSizeParcel adSizeParcel, zzcg zzcgVar) {
        this.f1529a.zza(context, adSizeParcel, zzcgVar);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(AdSizeParcel adSizeParcel) {
        this.f1529a.zza(adSizeParcel);
    }

    @Override // com.google.android.gms.internal.zzaw
    public void zza(zzaz zzazVar, boolean z) {
        this.f1529a.zza(zzazVar, z);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(String str, String str2) {
        this.f1529a.zza(str, str2);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(String str, JSONObject jSONObject) {
        this.f1529a.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzaI(String str) {
        this.f1529a.zzaI(str);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzaJ(String str) {
        this.f1529a.zzaJ(str);
    }

    @Override // com.google.android.gms.internal.zziz
    public AdSizeParcel zzaN() {
        return this.f1529a.zzaN();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f1529a.zzb(zzdVar);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzb(String str, Map<String, ?> map) {
        this.f1529a.zzb(str, map);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzb(String str, JSONObject jSONObject) {
        this.f1529a.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f1529a.zzc(zzdVar);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzeJ() {
        this.f1529a.zzeJ();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzgY() {
        this.f1529a.zzgY();
    }

    @Override // com.google.android.gms.internal.zziz
    public Activity zzgZ() {
        return this.f1529a.zzgZ();
    }

    @Override // com.google.android.gms.internal.zziz
    public Context zzha() {
        return this.f1529a.zzha();
    }

    @Override // com.google.android.gms.internal.zziz
    public com.google.android.gms.ads.internal.zzd zzhb() {
        return this.f1529a.zzhb();
    }

    @Override // com.google.android.gms.internal.zziz
    public com.google.android.gms.ads.internal.overlay.zzd zzhc() {
        return this.f1529a.zzhc();
    }

    @Override // com.google.android.gms.internal.zziz
    public com.google.android.gms.ads.internal.overlay.zzd zzhd() {
        return this.f1529a.zzhd();
    }

    @Override // com.google.android.gms.internal.zziz
    public zzja zzhe() {
        return this.f1529a.zzhe();
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean zzhf() {
        return this.f1529a.zzhf();
    }

    @Override // com.google.android.gms.internal.zziz
    public zzan zzhg() {
        return this.f1529a.zzhg();
    }

    @Override // com.google.android.gms.internal.zziz
    public VersionInfoParcel zzhh() {
        return this.f1529a.zzhh();
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean zzhi() {
        return this.f1529a.zzhi();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzhj() {
        this.b.onDestroy();
        this.f1529a.zzhj();
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean zzhk() {
        return this.f1529a.zzhk();
    }

    @Override // com.google.android.gms.internal.zziz
    public zziy zzhl() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.zziz
    public zzce zzhm() {
        return this.f1529a.zzhm();
    }

    @Override // com.google.android.gms.internal.zziz
    public zzcf zzhn() {
        return this.f1529a.zzhn();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzho() {
        this.f1529a.zzho();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzhp() {
        this.f1529a.zzhp();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzv(int i) {
        this.f1529a.zzv(i);
    }
}
