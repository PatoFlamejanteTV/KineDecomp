package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzgr
/* loaded from: classes.dex */
public class zzja extends WebViewClient {
    private static final String[] zzJU = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzJV = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzfi zzAl;
    private zza zzDn;
    private final HashMap<String, List<zzdk>> zzJW;
    private com.google.android.gms.ads.internal.overlay.zzg zzJX;
    private zzb zzJY;
    private boolean zzJZ;
    private boolean zzKa;
    private com.google.android.gms.ads.internal.overlay.zzn zzKb;
    private final zzfg zzKc;
    private boolean zzKd;
    private boolean zzKe;
    private boolean zzKf;
    private boolean zzKg;
    private int zzKh;
    protected zziz zzoM;
    private final Object zzpd;
    private boolean zzqW;
    private com.google.android.gms.ads.internal.client.zza zzsy;
    private zzdo zzxO;
    private com.google.android.gms.ads.internal.zze zzxQ;
    private zzfc zzxR;
    private zzdm zzxT;
    private zzdg zzxn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.google.android.gms.ads.internal.overlay.zzg {

        /* renamed from: a */
        private zziz f1728a;
        private com.google.android.gms.ads.internal.overlay.zzg b;

        public a(zziz zzizVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar) {
            this.f1728a = zzizVar;
            this.b = zzgVar;
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void zzaV() {
            this.b.zzaV();
            this.f1728a.zzgY();
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void zzaW() {
            this.b.zzaW();
            this.f1728a.zzeJ();
        }
    }

    /* loaded from: classes.dex */
    public class b implements zzdk {
        private b() {
        }

        /* synthetic */ b(zzja zzjaVar, ei eiVar) {
            this();
        }

        @Override // com.google.android.gms.internal.zzdk
        public void zza(zziz zzizVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzja.this.zzht();
            } else if (map.keySet().contains("stop")) {
                zzja.this.zzhu();
            } else if (map.keySet().contains("cancel")) {
                zzja.this.zzhv();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zza {
        void zza(zziz zzizVar, boolean z);
    }

    /* loaded from: classes.dex */
    public interface zzb {
        void zzbf();
    }

    public zzja(zziz zzizVar, boolean z) {
        this(zzizVar, z, new zzfg(zzizVar, zzizVar.zzha(), new zzbq(zzizVar.getContext())), null);
    }

    zzja(zziz zzizVar, boolean z, zzfg zzfgVar, zzfc zzfcVar) {
        this.zzJW = new HashMap<>();
        this.zzpd = new Object();
        this.zzJZ = false;
        this.zzoM = zzizVar;
        this.zzqW = z;
        this.zzKc = zzfgVar;
        this.zzxR = zzfcVar;
    }

    private void zza(Context context, String str, String str2, String str3) {
        if (zzby.zzvp.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzaK(str3));
            com.google.android.gms.ads.internal.zzp.e().zza(context, this.zzoM.zzhh().b, "gmob-apps", bundle, true);
        }
    }

    private String zzaK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private static boolean zzg(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    public void zzht() {
        synchronized (this.zzpd) {
            this.zzKa = true;
        }
        this.zzKh++;
        zzhw();
    }

    public void zzhu() {
        this.zzKh--;
        zzhw();
    }

    public void zzhv() {
        this.zzKg = true;
        zzhw();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.d("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzpd) {
            if (this.zzKe && "about:blank".equals(str)) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Blank page loaded, 1...");
                this.zzoM.zzhj();
            } else {
                this.zzKf = true;
                zzhw();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zza(this.zzoM.getContext(), "http_err", (i >= 0 || (-i) + (-1) >= zzJU.length) ? String.valueOf(i) : zzJU[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            zza(this.zzoM.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzJV.length) ? String.valueOf(primaryError) : zzJV[primaryError], com.google.android.gms.ads.internal.zzp.g().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        synchronized (this.zzpd) {
            this.zzJW.clear();
            this.zzsy = null;
            this.zzJX = null;
            this.zzDn = null;
            this.zzxn = null;
            this.zzJZ = false;
            this.zzqW = false;
            this.zzKa = false;
            this.zzxT = null;
            this.zzKb = null;
            this.zzJY = null;
            if (this.zzxR != null) {
                this.zzxR.zzn(true);
                this.zzxR = null;
            }
            this.zzKd = false;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        com.google.android.gms.ads.internal.util.client.zzb.d("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else {
            if (this.zzJZ && webView == this.zzoM.getWebView() && zzg(parse)) {
                if (!this.zzKd) {
                    this.zzKd = true;
                    if (this.zzsy != null && zzby.zzvd.get().booleanValue()) {
                        this.zzsy.onAdClicked();
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (this.zzoM.getWebView().willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("AdWebView unable to handle URL: " + str);
            } else {
                try {
                    zzan zzhg = this.zzoM.zzhg();
                    if (zzhg != null && zzhg.zzb(parse)) {
                        parse = zzhg.zza(parse, this.zzoM.getContext());
                    }
                    uri = parse;
                } catch (zzao e) {
                    com.google.android.gms.ads.internal.util.client.zzb.e("Unable to append parameter to URL: " + str);
                    uri = parse;
                }
                if (this.zzxQ == null || this.zzxQ.b()) {
                    zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.zzxQ.a(str);
                }
            }
        }
        return true;
    }

    public void zzF(boolean z) {
        this.zzJZ = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzKc.zze(i, i2);
        if (this.zzxR != null) {
            this.zzxR.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        boolean zzhi = this.zzoM.zzhi();
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, (!zzhi || this.zzoM.zzaN().e) ? this.zzsy : null, zzhi ? null : this.zzJX, this.zzKb, this.zzoM.zzhh()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.zzp.c().a(this.zzoM.getContext(), adOverlayInfoParcel, this.zzxR != null ? this.zzxR.zzef() : false ? false : true);
    }

    public void zza(zza zzaVar) {
        this.zzDn = zzaVar;
    }

    public void zza(zzb zzbVar) {
        this.zzJY = zzbVar;
    }

    public final void zza(String str, zzdk zzdkVar) {
        synchronized (this.zzpd) {
            List<zzdk> list = this.zzJW.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzJW.put(str, list);
            }
            list.add(zzdkVar);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzoM.zzhi() || this.zzoM.zzaN().e) ? this.zzsy : null, this.zzJX, this.zzKb, this.zzoM, z, i, this.zzoM.zzhh()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzhi = this.zzoM.zzhi();
        zza(new AdOverlayInfoParcel((!zzhi || this.zzoM.zzaN().e) ? this.zzsy : null, zzhi ? null : new a(this.zzoM, this.zzJX), this.zzxn, this.zzKb, this.zzoM, z, i, str, this.zzoM.zzhh(), this.zzxT));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzhi = this.zzoM.zzhi();
        zza(new AdOverlayInfoParcel((!zzhi || this.zzoM.zzaN().e) ? this.zzsy : null, zzhi ? null : new a(this.zzoM, this.zzJX), this.zzxn, this.zzKb, this.zzoM, z, i, str, str2, this.zzoM.zzhh(), this.zzxT));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar, zzdg zzdgVar, com.google.android.gms.ads.internal.overlay.zzn zznVar, boolean z, zzdm zzdmVar, zzdo zzdoVar, com.google.android.gms.ads.internal.zze zzeVar, zzfi zzfiVar) {
        if (zzeVar == null) {
            zzeVar = new com.google.android.gms.ads.internal.zze(false);
        }
        this.zzxR = new zzfc(this.zzoM, zzfiVar);
        zza("/appEvent", new zzdf(zzdgVar));
        zza("/backButton", zzdj.zzxx);
        zza("/canOpenURLs", zzdj.zzxp);
        zza("/canOpenIntents", zzdj.zzxq);
        zza("/click", zzdj.zzxr);
        zza("/close", zzdj.zzxs);
        zza("/customClose", zzdj.zzxt);
        zza("/instrument", zzdj.zzxA);
        zza("/delayPageLoaded", new b(this, null));
        zza("/httpTrack", zzdj.zzxu);
        zza("/log", zzdj.zzxv);
        zza("/mraid", new zzdq(zzeVar, this.zzxR));
        zza("/mraidLoaded", this.zzKc);
        zza("/open", new zzdr(zzdmVar, zzeVar, this.zzxR));
        zza("/precache", zzdj.zzxz);
        zza("/touch", zzdj.zzxw);
        zza("/video", zzdj.zzxy);
        if (zzdoVar != null) {
            zza("/setInterstitialProperties", new zzdn(zzdoVar));
        }
        this.zzsy = zzaVar;
        this.zzJX = zzgVar;
        this.zzxn = zzdgVar;
        this.zzxT = zzdmVar;
        this.zzKb = zznVar;
        this.zzxQ = zzeVar;
        this.zzAl = zzfiVar;
        this.zzxO = zzdoVar;
        zzF(z);
        this.zzKd = false;
    }

    public final void zzb(String str, zzdk zzdkVar) {
        synchronized (this.zzpd) {
            List<zzdk> list = this.zzJW.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzdkVar);
        }
    }

    public boolean zzbY() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzqW;
        }
        return z;
    }

    public void zzd(int i, int i2) {
        if (this.zzxR != null) {
            this.zzxR.zzd(i, i2);
        }
    }

    public void zze(zziz zzizVar) {
        this.zzoM = zzizVar;
    }

    public final void zzeG() {
        synchronized (this.zzpd) {
            this.zzJZ = false;
            this.zzqW = true;
            zzid.runOnUiThread(new ei(this));
        }
    }

    public void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzdk> list = this.zzJW.get(path);
        if (list == null) {
            com.google.android.gms.ads.internal.util.client.zzb.d("No GMSG handler found for GMSG: " + uri);
            return;
        }
        Map<String, String> zze = com.google.android.gms.ads.internal.zzp.e().zze(uri);
        if (com.google.android.gms.ads.internal.util.client.zzb.a(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Received GMSG: " + path);
            for (String str : zze.keySet()) {
                com.google.android.gms.ads.internal.util.client.zzb.d("  " + str + ": " + zze.get(str));
            }
        }
        Iterator<zzdk> it = list.iterator();
        while (it.hasNext()) {
            it.next().zza(this.zzoM, zze);
        }
    }

    public com.google.android.gms.ads.internal.zze zzhq() {
        return this.zzxQ;
    }

    public boolean zzhr() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzKa;
        }
        return z;
    }

    public void zzhs() {
        synchronized (this.zzpd) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Loading blank page in WebView, 2...");
            this.zzKe = true;
            this.zzoM.zzaI("about:blank");
        }
    }

    public final void zzhw() {
        if (this.zzDn != null && ((this.zzKf && this.zzKh <= 0) || this.zzKg)) {
            this.zzDn.zza(this.zzoM, !this.zzKg);
            this.zzDn = null;
        }
        this.zzoM.zzhp();
    }
}
