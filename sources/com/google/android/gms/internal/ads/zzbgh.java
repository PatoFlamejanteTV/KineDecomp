package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zzf;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzuo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzbgh extends WebViewClient implements zzbhn {
    private static final String[] zzext = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzexu = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object mLock;
    protected zzawr zzbmx;
    private boolean zzbul;
    private zzvt zzciw;
    private com.google.android.gms.ads.internal.gmsg.zzb zzder;
    private com.google.android.gms.ads.internal.gmsg.zzd zzdes;
    private com.google.android.gms.ads.internal.zzw zzdgb;
    private zzaoa zzdgc;
    private zzbgg zzdin;
    private boolean zzdzf;
    private final zzum zzehw;
    private final HashMap<String, List<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>>> zzexv;
    private com.google.android.gms.ads.internal.overlay.zzn zzexw;
    private zzbho zzexx;
    private zzbhp zzexy;
    private zzbhq zzexz;
    private boolean zzeya;
    private boolean zzeyb;
    private ViewTreeObserver.OnGlobalLayoutListener zzeyc;
    private ViewTreeObserver.OnScrollChangedListener zzeyd;
    private boolean zzeye;
    private zzt zzeyf;
    private final zzaoj zzeyg;
    private zzbhr zzeyh;
    private boolean zzeyi;
    private boolean zzeyj;
    private int zzeyk;
    private View.OnAttachStateChangeListener zzeyl;

    public zzbgh(zzbgg zzbggVar, zzum zzumVar, boolean z) {
        this(zzbggVar, zzumVar, z, new zzaoj(zzbggVar, zzbggVar.zzadg(), new zzzy(zzbggVar.getContext())), null);
    }

    private final void zzaef() {
        if (this.zzeyl == null) {
            return;
        }
        this.zzdin.getView().removeOnAttachStateChangeListener(this.zzeyl);
    }

    private final void zzaek() {
        if (this.zzexx != null && ((this.zzeyi && this.zzeyk <= 0) || this.zzeyj)) {
            this.zzexx.zzp(!this.zzeyj);
            this.zzexx = null;
        }
        this.zzdin.zzadw();
    }

    private final void zzd(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcsx)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    com.google.android.gms.ads.internal.zzbv.e().zza(context, this.zzdin.zzabz().zzdp, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            com.google.android.gms.ads.internal.zzbv.e().zza(context, this.zzdin.zzabz().zzdp, "gmob-apps", bundle, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00dd, code lost:            com.google.android.gms.ads.internal.zzbv.e();     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e4, code lost:            return com.google.android.gms.internal.ads.zzayh.zzd(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.webkit.WebResourceResponse zze(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgh.zze(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzaxz.v(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.mLock) {
            if (this.zzdin.isDestroyed()) {
                zzaxz.v("Blank page loaded, 1...");
                this.zzdin.zzadr();
                return;
            }
            this.zzeyi = true;
            zzbhp zzbhpVar = this.zzexy;
            if (zzbhpVar != null) {
                zzbhpVar.zzuc();
                this.zzexy = null;
            }
            zzaek();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf;
        if (i < 0) {
            int i2 = (-i) - 1;
            String[] strArr = zzext;
            if (i2 < strArr.length) {
                valueOf = strArr[i2];
                zzd(this.zzdin.getContext(), "http_err", valueOf, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        valueOf = String.valueOf(i);
        zzd(this.zzdin.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String valueOf;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0) {
                String[] strArr = zzexu;
                if (primaryError < strArr.length) {
                    valueOf = strArr[primaryError];
                    zzd(this.zzdin.getContext(), "ssl_err", valueOf, com.google.android.gms.ads.internal.zzbv.g().zza(sslError));
                }
            }
            valueOf = String.valueOf(primaryError);
            zzd(this.zzdin.getContext(), "ssl_err", valueOf, com.google.android.gms.ads.internal.zzbv.g().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        zzum zzumVar = this.zzehw;
        if (zzumVar != null) {
            zzumVar.zza(zzuo.zza.zzb.ANDROID_WEBVIEW_CRASH);
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        webView.destroy();
        return true;
    }

    public final void reset() {
        zzawr zzawrVar = this.zzbmx;
        if (zzawrVar != null) {
            zzawrVar.zzxs();
            this.zzbmx = null;
        }
        zzaef();
        synchronized (this.mLock) {
            this.zzexv.clear();
            this.zzciw = null;
            this.zzexw = null;
            this.zzexx = null;
            this.zzexy = null;
            this.zzder = null;
            this.zzdes = null;
            this.zzeya = false;
            this.zzbul = false;
            this.zzeyb = false;
            this.zzeye = false;
            this.zzeyf = null;
            this.zzexz = null;
            if (this.zzdgc != null) {
                this.zzdgc.zzx(true);
                this.zzdgc = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzaxz.v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        } else {
            if (this.zzeya && webView == this.zzdin.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzvt zzvtVar = this.zzciw;
                    if (zzvtVar != null) {
                        zzvtVar.onAdClicked();
                        zzawr zzawrVar = this.zzbmx;
                        if (zzawrVar != null) {
                            zzawrVar.zzdi(str);
                        }
                        this.zzciw = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzdin.getWebView().willNotDraw()) {
                try {
                    zzcu zzado = this.zzdin.zzado();
                    if (zzado != null && zzado.zzb(parse)) {
                        parse = zzado.zza(parse, this.zzdin.getContext(), this.zzdin.getView(), this.zzdin.zzabw());
                    }
                } catch (zzcv unused) {
                    String valueOf2 = String.valueOf(str);
                    zzbbd.zzeo(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zzw zzwVar = this.zzdgb;
                if (zzwVar != null && !zzwVar.b()) {
                    this.zzdgb.a(str);
                } else {
                    zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzbbd.zzeo(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(int i, int i2, boolean z) {
        this.zzeyg.zzj(i, i2);
        zzaoa zzaoaVar = this.zzdgc;
        if (zzaoaVar != null) {
            zzaoaVar.zza(i, i2, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final com.google.android.gms.ads.internal.zzw zzaea() {
        return this.zzdgb;
    }

    public final boolean zzaeb() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzeyb;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaec() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.mLock) {
            onGlobalLayoutListener = this.zzeyc;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzaed() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.mLock) {
            onScrollChangedListener = this.zzeyd;
        }
        return onScrollChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final boolean zzaee() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzeye;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaeg() {
        zzawr zzawrVar = this.zzbmx;
        if (zzawrVar != null) {
            WebView webView = this.zzdin.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzawrVar, 10);
                return;
            }
            zzaef();
            this.zzeyl = new Ff(this, zzawrVar);
            this.zzdin.getView().addOnAttachStateChangeListener(this.zzeyl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaeh() {
        synchronized (this.mLock) {
            this.zzeye = true;
        }
        this.zzeyk++;
        zzaek();
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaei() {
        this.zzeyk--;
        zzaek();
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaej() {
        this.zzeyj = true;
        zzaek();
    }

    public final zzbhr zzael() {
        return this.zzeyh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final zzawr zzaem() {
        return this.zzbmx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaen() {
        this.zzdin.zzadv();
        com.google.android.gms.ads.internal.overlay.zzd zzadh = this.zzdin.zzadh();
        if (zzadh != null) {
            zzadh.C();
        }
        zzbhq zzbhqVar = this.zzexz;
        if (zzbhqVar != null) {
            zzbhqVar.zzjx();
            this.zzexz = null;
        }
    }

    public final void zzat(boolean z) {
        this.zzeya = z;
    }

    public final void zzay(boolean z) {
        this.zzdzf = z;
    }

    public final void zzb(boolean z, int i) {
        zzvt zzvtVar = (!this.zzdin.zzadq() || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        com.google.android.gms.ads.internal.overlay.zzn zznVar = this.zzexw;
        zzt zztVar = this.zzeyf;
        zzbgg zzbggVar = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvtVar, zznVar, zztVar, zzbggVar, z, i, zzbggVar.zzabz()));
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzi(int i, int i2) {
        zzaoa zzaoaVar = this.zzdgc;
        if (zzaoaVar != null) {
            zzaoaVar.zzi(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final boolean zzmu() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbul;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzvr() {
        synchronized (this.mLock) {
            this.zzeya = false;
            this.zzbul = true;
            zzbcg.zzepo.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.Df

                /* renamed from: a, reason: collision with root package name */
                private final zzbgh f11460a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11460a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f11460a.zzaen();
                }
            });
        }
    }

    private final void zzi(Uri uri) {
        String path = uri.getPath();
        List<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> list = this.zzexv.get(path);
        if (list != null) {
            com.google.android.gms.ads.internal.zzbv.e();
            Map<String, String> zzg = zzayh.zzg(uri);
            if (zzbbd.isLoggable(2)) {
                String valueOf = String.valueOf(path);
                zzaxz.v(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
                for (String str : zzg.keySet()) {
                    String str2 = zzg.get(str);
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length());
                    sb.append("  ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    zzaxz.v(sb.toString());
                }
            }
            Iterator<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> it = list.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzdin, zzg);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb2.append("No GMSG handler found for GMSG: ");
        sb2.append(valueOf2);
        zzaxz.v(sb2.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzvt zzvtVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, com.google.android.gms.ads.internal.overlay.zzn zznVar, com.google.android.gms.ads.internal.gmsg.zzd zzdVar, zzt zztVar, boolean z, com.google.android.gms.ads.internal.gmsg.zzy zzyVar, com.google.android.gms.ads.internal.zzw zzwVar, zzaol zzaolVar, zzawr zzawrVar) {
        if (zzwVar == null) {
            zzwVar = new com.google.android.gms.ads.internal.zzw(this.zzdin.getContext(), zzawrVar, null);
        }
        this.zzdgc = new zzaoa(this.zzdin, zzaolVar);
        this.zzbmx = zzawrVar;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrk)).booleanValue()) {
            zza("/adMetadata", new com.google.android.gms.ads.internal.gmsg.zza(zzbVar));
        }
        zza("/appEvent", new com.google.android.gms.ads.internal.gmsg.zzc(zzdVar));
        zza("/backButton", zzf.j);
        zza("/refresh", zzf.k);
        zza("/canOpenURLs", zzf.f10072a);
        zza("/canOpenIntents", zzf.f10073b);
        zza("/click", zzf.f10074c);
        zza("/close", zzf.f10075d);
        zza("/customClose", zzf.f10076e);
        zza("/instrument", zzf.n);
        zza("/delayPageLoaded", zzf.p);
        zza("/delayPageClosed", zzf.q);
        zza("/getLocationInfo", zzf.r);
        zza("/httpTrack", zzf.f10077f);
        zza("/log", zzf.f10078g);
        zza("/mraid", new com.google.android.gms.ads.internal.gmsg.zzab(zzwVar, this.zzdgc, zzaolVar));
        zza("/mraidLoaded", this.zzeyg);
        zza("/open", new com.google.android.gms.ads.internal.gmsg.zzac(zzwVar, this.zzdgc));
        zza("/precache", new zzbfq());
        zza("/touch", zzf.i);
        zza("/video", zzf.l);
        zza("/videoMeta", zzf.m);
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.zzdin.getContext())) {
            zza("/logScionEvent", new com.google.android.gms.ads.internal.gmsg.zzaa(this.zzdin.getContext()));
        }
        if (zzyVar != null) {
            zza("/setInterstitialProperties", new com.google.android.gms.ads.internal.gmsg.zzx(zzyVar));
        }
        this.zzciw = zzvtVar;
        this.zzexw = zznVar;
        this.zzder = zzbVar;
        this.zzdes = zzdVar;
        this.zzeyf = zztVar;
        this.zzdgb = zzwVar;
        this.zzeya = z;
    }

    @VisibleForTesting
    private zzbgh(zzbgg zzbggVar, zzum zzumVar, boolean z, zzaoj zzaojVar, zzaoa zzaoaVar) {
        this.zzexv = new HashMap<>();
        this.mLock = new Object();
        this.zzeya = false;
        this.zzehw = zzumVar;
        this.zzdin = zzbggVar;
        this.zzbul = z;
        this.zzeyg = zzaojVar;
        this.zzdgc = null;
    }

    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        synchronized (this.mLock) {
            List<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> list = this.zzexv.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzuVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zztv zza;
        try {
            String zzb = zzawz.zzb(str, this.zzdin.getContext(), this.zzdzf);
            if (!zzb.equals(str)) {
                return zze(zzb, map);
            }
            zzty zzbb = zzty.zzbb(str);
            if (zzbb != null && (zza = com.google.android.gms.ads.internal.zzbv.k().zza(zzbb)) != null && zza.zzoe()) {
                return new WebResourceResponse("", "", zza.zzof());
            }
            if (zzbax.isEnabled()) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcso)).booleanValue()) {
                    return zze(str, map);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzawr zzawrVar, int i) {
        if (!zzawrVar.zzxq() || i <= 0) {
            return;
        }
        zzawrVar.zzs(view);
        if (zzawrVar.zzxq()) {
            zzayh.zzelc.postDelayed(new Ef(this, view, zzawrVar, i), 100L);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zzadq = this.zzdin.zzadq();
        zza(new AdOverlayInfoParcel(zzcVar, (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null, zzadq ? null : this.zzexw, this.zzeyf, this.zzdin.zzabz()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvtVar = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        Gf gf = zzadq ? null : new Gf(this.zzdin, this.zzexw);
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzder;
        com.google.android.gms.ads.internal.gmsg.zzd zzdVar = this.zzdes;
        zzt zztVar = this.zzeyf;
        zzbgg zzbggVar = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvtVar, gf, zzbVar, zzdVar, zztVar, zzbggVar, z, i, str, zzbggVar.zzabz()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvtVar = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        Gf gf = zzadq ? null : new Gf(this.zzdin, this.zzexw);
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzder;
        com.google.android.gms.ads.internal.gmsg.zzd zzdVar = this.zzdes;
        zzt zztVar = this.zzeyf;
        zzbgg zzbggVar = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvtVar, gf, zzbVar, zzdVar, zztVar, zzbggVar, z, i, str, str2, zzbggVar.zzabz()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzaoa zzaoaVar = this.zzdgc;
        boolean zzvm = zzaoaVar != null ? zzaoaVar.zzvm() : false;
        com.google.android.gms.ads.internal.zzbv.c();
        com.google.android.gms.ads.internal.overlay.zzl.a(this.zzdin.getContext(), adOverlayInfoParcel, zzvm ? false : true);
        if (this.zzbmx != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && (zzcVar = adOverlayInfoParcel.f10098a) != null) {
                str = zzcVar.f10119b;
            }
            this.zzbmx.zzdi(str);
        }
    }

    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        synchronized (this.mLock) {
            List<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> list = this.zzexv.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzexv.put(str, list);
            }
            list.add(zzuVar);
        }
    }

    public final void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> predicate) {
        synchronized (this.mLock) {
            List<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> list = this.zzexv.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar : list) {
                if (predicate.apply(zzuVar)) {
                    arrayList.add(zzuVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbho zzbhoVar) {
        this.zzexx = zzbhoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbhp zzbhpVar) {
        this.zzexy = zzbhpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbhq zzbhqVar) {
        this.zzexz = zzbhqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbhr zzbhrVar) {
        this.zzeyh = zzbhrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.mLock) {
            this.zzeyb = true;
            this.zzdin.zzadv();
            this.zzeyc = onGlobalLayoutListener;
            this.zzeyd = onScrollChangedListener;
        }
    }
}
