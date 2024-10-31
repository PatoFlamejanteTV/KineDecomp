package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.gmsg.zzf;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import javax.annotation.ParametersAreNonnullByDefault;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzbhu extends zzbie implements zzbhn {
    private zzawr zzbmx;
    private zzvt zzciw;
    private com.google.android.gms.ads.internal.gmsg.zzb zzder;
    private com.google.android.gms.ads.internal.gmsg.zzd zzdes;
    private com.google.android.gms.ads.internal.zzw zzdgb;
    private zzaoa zzdgc;
    private zzbgg zzdin;
    private boolean zzdzf;
    private com.google.android.gms.ads.internal.overlay.zzn zzexw;
    private zzbho zzexx;
    private zzbhp zzexy;
    private zzbhq zzexz;
    private boolean zzeyb;
    private ViewTreeObserver.OnGlobalLayoutListener zzeyc;
    private ViewTreeObserver.OnScrollChangedListener zzeyd;
    private boolean zzeye;
    private zzt zzeyf;
    private zzaoj zzeyg;
    private zzbhr zzeyh;
    private boolean zzeyi;
    private boolean zzeyj;
    private int zzeyk;
    private View.OnAttachStateChangeListener zzeyl;
    private volatile boolean zzfaw;
    private final Object mLock = new Object();
    private boolean zzeya = false;
    private final zzaig<zzbgg> zzfav = new zzaig<>();

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

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:            com.google.android.gms.ads.internal.zzbv.e();     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e8, code lost:            return com.google.android.gms.internal.ads.zzayh.zzd(r3);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.webkit.WebResourceResponse zze(com.google.android.gms.internal.ads.zzbif r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhu.zze(com.google.android.gms.internal.ads.zzbif):android.webkit.WebResourceResponse");
    }

    public final void destroy() {
        zzawr zzawrVar = this.zzbmx;
        if (zzawrVar != null) {
            zzawrVar.zzxs();
            this.zzbmx = null;
        }
        zzaef();
        this.zzfav.reset();
        this.zzfav.zzi(null);
        synchronized (this.mLock) {
            this.zzciw = null;
            this.zzexw = null;
            this.zzexx = null;
            this.zzexy = null;
            this.zzder = null;
            this.zzdes = null;
            this.zzeyf = null;
            this.zzexz = null;
            if (this.zzdgc != null) {
                this.zzdgc.zzx(true);
                this.zzdgc = null;
            }
        }
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
            this.zzeyl = new Tf(this, zzawrVar);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzbgg zzbggVar, boolean z) {
        zzaoj zzaojVar = new zzaoj(zzbggVar, zzbggVar.zzadg(), new zzzy(zzbggVar.getContext()));
        this.zzdin = zzbggVar;
        this.zzfaw = z;
        this.zzeyg = zzaojVar;
        this.zzdgc = null;
        this.zzfav.zzi(zzbggVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final boolean zzc(zzbif zzbifVar) {
        String valueOf = String.valueOf(zzbifVar.url);
        zzaxz.v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbifVar.uri;
        if (this.zzfav.zzf(uri)) {
            return true;
        }
        if (this.zzeya) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzvt zzvtVar = this.zzciw;
                if (zzvtVar != null) {
                    zzvtVar.onAdClicked();
                    zzawr zzawrVar = this.zzbmx;
                    if (zzawrVar != null) {
                        zzawrVar.zzdi(zzbifVar.url);
                    }
                    this.zzciw = null;
                }
                return false;
            }
        }
        if (!this.zzdin.getWebView().willNotDraw()) {
            try {
                zzcu zzado = this.zzdin.zzado();
                if (zzado != null && zzado.zzb(uri)) {
                    uri = zzado.zza(uri, this.zzdin.getContext(), this.zzdin.getView(), this.zzdin.zzabw());
                }
            } catch (zzcv unused) {
                String valueOf2 = String.valueOf(zzbifVar.url);
                zzbbd.zzeo(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            com.google.android.gms.ads.internal.zzw zzwVar = this.zzdgb;
            if (zzwVar != null && !zzwVar.b()) {
                this.zzdgb.a(zzbifVar.url);
            } else {
                zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        } else {
            String valueOf3 = String.valueOf(zzbifVar.url);
            zzbbd.zzeo(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final WebResourceResponse zzd(zzbif zzbifVar) {
        String str;
        WebResourceResponse zze;
        zztv zza;
        zzawr zzawrVar = this.zzbmx;
        if (zzawrVar != null) {
            zzawrVar.zza(zzbifVar.url, zzbifVar.zzab, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(zzbifVar.url).getName())) {
            zzvr();
            if (this.zzdin.zzadj().zzafb()) {
                str = (String) zzwu.zzpz().zzd(zzaan.zzcpt);
            } else if (this.zzdin.zzadq()) {
                str = (String) zzwu.zzpz().zzd(zzaan.zzcps);
            } else {
                str = (String) zzwu.zzpz().zzd(zzaan.zzcpr);
            }
            com.google.android.gms.ads.internal.zzbv.e();
            zze = zzayh.zze(this.zzdin.getContext(), this.zzdin.zzabz().zzdp, str);
        } else {
            zze = null;
        }
        if (zze != null) {
            return zze;
        }
        try {
            if (!zzawz.zzb(zzbifVar.url, this.zzdin.getContext(), this.zzdzf).equals(zzbifVar.url)) {
                return zze(zzbifVar);
            }
            zzty zzbb = zzty.zzbb(zzbifVar.url);
            if (zzbb != null && (zza = com.google.android.gms.ads.internal.zzbv.k().zza(zzbb)) != null && zza.zzoe()) {
                return new WebResourceResponse("", "", zza.zzof());
            }
            if (zzbax.isEnabled()) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcso)).booleanValue()) {
                    return zze(zzbifVar);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdWebViewClient.interceptRequest");
            return null;
        }
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
        return this.zzfaw;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzvr() {
        synchronized (this.mLock) {
            this.zzeya = false;
            this.zzfaw = true;
            zzbcg.zzepo.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.Rf

                /* renamed from: a, reason: collision with root package name */
                private final zzbhu f11810a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11810a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f11810a.zzaen();
                }
            });
        }
    }

    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        this.zzfav.zza(str, zzuVar);
    }

    public final void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> predicate) {
        this.zzfav.zza(str, predicate);
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

    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        this.zzfav.zzb(str, zzuVar);
    }

    public final void zzb(boolean z, int i) {
        zzvt zzvtVar = (!this.zzdin.zzadq() || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        com.google.android.gms.ads.internal.overlay.zzn zznVar = this.zzexw;
        zzt zztVar = this.zzeyf;
        zzbgg zzbggVar = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvtVar, zznVar, zztVar, zzbggVar, z, i, zzbggVar.zzabz()));
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zzb(zzbif zzbifVar) {
        this.zzfav.zzf(zzbifVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zza(zzbif zzbifVar) {
        this.zzeyi = true;
        zzbhp zzbhpVar = this.zzexy;
        if (zzbhpVar != null) {
            zzbhpVar.zzuc();
            this.zzexy = null;
        }
        zzaek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzawr zzawrVar, int i) {
        if (!zzawrVar.zzxq() || i <= 0) {
            return;
        }
        zzawrVar.zzs(view);
        if (zzawrVar.zzxq()) {
            zzayh.zzelc.postDelayed(new Sf(this, view, zzawrVar, i), 100L);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zzadq = this.zzdin.zzadq();
        zza(new AdOverlayInfoParcel(zzcVar, (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null, zzadq ? null : this.zzexw, this.zzeyf, this.zzdin.zzabz()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvtVar = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        Uf uf = zzadq ? null : new Uf(this.zzdin, this.zzexw);
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzder;
        com.google.android.gms.ads.internal.gmsg.zzd zzdVar = this.zzdes;
        zzt zztVar = this.zzeyf;
        zzbgg zzbggVar = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvtVar, uf, zzbVar, zzdVar, zztVar, zzbggVar, z, i, str, zzbggVar.zzabz()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvtVar = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        Uf uf = zzadq ? null : new Uf(this.zzdin, this.zzexw);
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzder;
        com.google.android.gms.ads.internal.gmsg.zzd zzdVar = this.zzdes;
        zzt zztVar = this.zzeyf;
        zzbgg zzbggVar = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvtVar, uf, zzbVar, zzdVar, zztVar, zzbggVar, z, i, str, str2, zzbggVar.zzabz()));
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
