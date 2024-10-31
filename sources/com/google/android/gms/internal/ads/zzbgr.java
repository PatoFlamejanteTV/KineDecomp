package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzbgr extends FrameLayout implements zzbgg {
    private final zzbgg zzezc;
    private final zzbdq zzezd;

    public zzbgr(zzbgg zzbggVar) {
        super(zzbggVar.getContext());
        this.zzezc = zzbggVar;
        this.zzezd = new zzbdq(zzbggVar.zzadg(), this, this);
        addView(this.zzezc.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void destroy() {
        IObjectWrapper zzadp = zzadp();
        if (zzadp != null) {
            com.google.android.gms.ads.internal.zzbv.v().zzp(zzadp);
            zzayh.zzelc.postDelayed(new Kf(this), ((Integer) zzwu.zzpz().zzd(zzaan.zzcwz)).intValue());
            return;
        }
        this.zzezc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final View.OnClickListener getOnClickListener() {
        return this.zzezc.getOnClickListener();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final int getRequestedOrientation() {
        return this.zzezc.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhm
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebView getWebView() {
        return this.zzezc.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final boolean isDestroyed() {
        return this.zzezc.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void loadData(String str, String str2, String str3) {
        this.zzezc.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzezc.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void loadUrl(String str) {
        this.zzezc.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void onPause() {
        this.zzezd.onPause();
        this.zzezc.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void onResume() {
        this.zzezc.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgg
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzezc.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgg
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzezc.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void setRequestedOrientation(int i) {
        this.zzezc.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzezc.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzezc.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void stopLoading() {
        this.zzezc.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map<String, ?> map) {
        this.zzezc.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzezc.zzaa(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzbdq zzabt() {
        return this.zzezd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzbgw zzabu() {
        return this.zzezc.zzabu();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzaay zzabv() {
        return this.zzezc.zzabv();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhc
    public final Activity zzabw() {
        return this.zzezc.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final String zzabx() {
        return this.zzezc.zzabx();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzaaz zzaby() {
        return this.zzezc.zzaby();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhl
    public final zzbbi zzabz() {
        return this.zzezc.zzabz();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final int zzaca() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final int zzacb() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzacc() {
        this.zzezc.zzacc();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzade() {
        this.zzezc.zzade();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadf() {
        this.zzezc.zzadf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final Context zzadg() {
        return this.zzezc.zzadg();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final com.google.android.gms.ads.internal.overlay.zzd zzadh() {
        return this.zzezc.zzadh();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final com.google.android.gms.ads.internal.overlay.zzd zzadi() {
        return this.zzezc.zzadi();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhj
    public final zzbht zzadj() {
        return this.zzezc.zzadj();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final String zzadk() {
        return this.zzezc.zzadk();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final zzbhn zzadl() {
        return this.zzezc.zzadl();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebViewClient zzadm() {
        return this.zzezc.zzadm();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final boolean zzadn() {
        return this.zzezc.zzadn();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhk
    public final zzcu zzado() {
        return this.zzezc.zzado();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final IObjectWrapper zzadp() {
        return this.zzezc.zzadp();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhd
    public final boolean zzadq() {
        return this.zzezc.zzadq();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadr() {
        this.zzezd.onDestroy();
        this.zzezc.zzadr();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final boolean zzads() {
        return this.zzezc.zzads();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final boolean zzadt() {
        return this.zzezc.zzadt();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final boolean zzadu() {
        return this.zzezc.zzadu();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadv() {
        this.zzezc.zzadv();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadw() {
        this.zzezc.zzadw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final zzacb zzadx() {
        return this.zzezc.zzadx();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzady() {
        setBackgroundColor(0);
        this.zzezc.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadz() {
        TextView textView = new TextView(getContext());
        Resources resources = com.google.android.gms.ads.internal.zzbv.i().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzaf(boolean z) {
        this.zzezc.zzaf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzat(boolean z) {
        this.zzezc.zzat(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzav(boolean z) {
        this.zzezc.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzaw(boolean z) {
        this.zzezc.zzaw(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzax(boolean z) {
        this.zzezc.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzay(boolean z) {
        this.zzezc.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        this.zzezc.zzb(str, zzuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzbo(Context context) {
        this.zzezc.zzbo(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzc(String str, String str2, String str3) {
        this.zzezc.zzc(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        this.zzezc.zzcg(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzdh(int i) {
        this.zzezc.zzdh(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzbfk zzet(String str) {
        return this.zzezc.zzet(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzfb(String str) {
        this.zzezc.zzfb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final com.google.android.gms.ads.internal.zzv zzid() {
        return this.zzezc.zzid();
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzjf() {
        this.zzezc.zzjf();
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzjg() {
        this.zzezc.zzjg();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzvv() {
        this.zzezc.zzvv();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzvw() {
        this.zzezc.zzvw();
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        this.zzezc.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzezc.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        this.zzezc.zza(str, zzuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzezc.zzb(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> predicate) {
        this.zzezc.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(zzacb zzacbVar) {
        this.zzezc.zzb(zzacbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zza(boolean z, long j) {
        this.zzezc.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zzb(boolean z, int i) {
        this.zzezc.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzezc.zza(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(zzbht zzbhtVar) {
        this.zzezc.zza(zzbhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final void zza(String str, zzbfk zzbfkVar) {
        this.zzezc.zza(str, zzbfkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsfVar) {
        this.zzezc.zza(zzsfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final void zza(zzbgw zzbgwVar) {
        this.zzezc.zza(zzbgwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzezc.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str) {
        this.zzezc.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzezc.zza(z, i, str, str2);
    }
}
