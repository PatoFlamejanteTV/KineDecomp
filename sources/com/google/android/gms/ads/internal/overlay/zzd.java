package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaok;
import com.google.android.gms.internal.ads.zzaoq;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzwu;
import java.util.Collections;

@zzark
/* loaded from: classes.dex */
public class zzd extends zzaoq implements zzw {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private static final int f10126a = Color.argb(0, 0, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    protected final Activity f10127b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    AdOverlayInfoParcel f10128c;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    zzbgg f10129d;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private zzi f10130e;

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private zzo f10131f;

    /* renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    private FrameLayout f10133h;

    @VisibleForTesting
    private WebChromeClient.CustomViewCallback i;

    @VisibleForTesting
    private c l;
    private Runnable p;
    private boolean q;
    private boolean r;

    /* renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    private boolean f10132g = false;

    @VisibleForTesting
    private boolean j = false;

    @VisibleForTesting
    private boolean k = false;

    @VisibleForTesting
    private boolean m = false;

    @VisibleForTesting
    int n = 0;
    private final Object o = new Object();
    private boolean s = false;
    private boolean t = false;
    private boolean u = true;

    public zzd(Activity activity) {
        this.f10127b = activity;
    }

    private final void H() {
        if (!this.f10127b.isFinishing() || this.s) {
            return;
        }
        this.s = true;
        zzbgg zzbggVar = this.f10129d;
        if (zzbggVar != null) {
            zzbggVar.zzdh(this.n);
            synchronized (this.o) {
                if (!this.q && this.f10129d.zzadu()) {
                    this.p = new b(this);
                    zzayh.zzelc.postDelayed(this.p, ((Long) zzwu.zzpz().zzd(zzaan.zzcrs)).longValue());
                    return;
                }
            }
        }
        D();
    }

    private final void f(boolean z) {
        int intValue = ((Integer) zzwu.zzpz().zzd(zzaan.zzcwo)).intValue();
        f fVar = new f();
        fVar.f10117e = 50;
        fVar.f10113a = z ? intValue : 0;
        fVar.f10114b = z ? 0 : intValue;
        fVar.f10115c = 0;
        fVar.f10116d = intValue;
        this.f10131f = new zzo(this.f10127b, fVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        a(z, this.f10128c.f10104g);
        this.l.addView(this.f10131f, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g(boolean r18) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.g(boolean):void");
    }

    private final void zzvv() {
        this.f10129d.zzvv();
    }

    public final void A() {
        this.n = 2;
        this.f10127b.finish();
    }

    public final void B() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.f10128c;
        if (adOverlayInfoParcel != null && this.f10132g) {
            setRequestedOrientation(adOverlayInfoParcel.j);
        }
        if (this.f10133h != null) {
            this.f10127b.setContentView(this.l);
            this.r = true;
            this.f10133h.removeAllViews();
            this.f10133h = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.i;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.i = null;
        }
        this.f10132g = false;
    }

    public final void C() {
        this.l.removeView(this.f10131f);
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void D() {
        zzbgg zzbggVar;
        zzn zznVar;
        if (this.t) {
            return;
        }
        this.t = true;
        zzbgg zzbggVar2 = this.f10129d;
        if (zzbggVar2 != null) {
            this.l.removeView(zzbggVar2.getView());
            zzi zziVar = this.f10130e;
            if (zziVar != null) {
                this.f10129d.zzbo(zziVar.f10137d);
                this.f10129d.zzav(false);
                ViewGroup viewGroup = this.f10130e.f10136c;
                View view = this.f10129d.getView();
                zzi zziVar2 = this.f10130e;
                viewGroup.addView(view, zziVar2.f10134a, zziVar2.f10135b);
                this.f10130e = null;
            } else if (this.f10127b.getApplicationContext() != null) {
                this.f10129d.zzbo(this.f10127b.getApplicationContext());
            }
            this.f10129d = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f10128c;
        if (adOverlayInfoParcel != null && (zznVar = adOverlayInfoParcel.f10100c) != null) {
            zznVar.zziv();
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.f10128c;
        if (adOverlayInfoParcel2 == null || (zzbggVar = adOverlayInfoParcel2.f10101d) == null) {
            return;
        }
        a(zzbggVar.zzadp(), this.f10128c.f10101d.getView());
    }

    public final void E() {
        if (this.m) {
            this.m = false;
            zzvv();
        }
    }

    public final void F() {
        this.l.f10109b = true;
    }

    public final void G() {
        synchronized (this.o) {
            this.q = true;
            if (this.p != null) {
                zzayh.zzelc.removeCallbacks(this.p);
                zzayh.zzelc.post(this.p);
            }
        }
    }

    public final void a(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzaq zzaqVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzaq zzaqVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcrt)).booleanValue() && (adOverlayInfoParcel2 = this.f10128c) != null && (zzaqVar2 = adOverlayInfoParcel2.o) != null && zzaqVar2.f10211h;
        boolean z5 = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcru)).booleanValue() && (adOverlayInfoParcel = this.f10128c) != null && (zzaqVar = adOverlayInfoParcel.o) != null && zzaqVar.i;
        if (z && z2 && z4 && !z5) {
            new zzaok(this.f10129d, "useCustomClose").zzda("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzo zzoVar = this.f10131f;
        if (zzoVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzoVar.a(z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onBackPressed() {
        this.n = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public void onCreate(Bundle bundle) {
        this.f10127b.requestWindowFeature(1);
        this.j = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.f10128c = AdOverlayInfoParcel.a(this.f10127b.getIntent());
            if (this.f10128c != null) {
                if (this.f10128c.m.zzeov > 7500000) {
                    this.n = 3;
                }
                if (this.f10127b.getIntent() != null) {
                    this.u = this.f10127b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.f10128c.o != null) {
                    this.k = this.f10128c.o.f10204a;
                } else {
                    this.k = false;
                }
                if (this.k && this.f10128c.o.f10209f != -1) {
                    new d(this, null).zzyz();
                }
                if (bundle == null) {
                    if (this.f10128c.f10100c != null && this.u) {
                        this.f10128c.f10100c.zziw();
                    }
                    if (this.f10128c.k != 1 && this.f10128c.f10099b != null) {
                        this.f10128c.f10099b.onAdClicked();
                    }
                }
                this.l = new c(this.f10127b, this.f10128c.n, this.f10128c.m.zzdp);
                this.l.setId(1000);
                int i = this.f10128c.k;
                if (i == 1) {
                    g(false);
                    return;
                }
                if (i == 2) {
                    this.f10130e = new zzi(this.f10128c.f10101d);
                    g(false);
                    return;
                } else {
                    if (i == 3) {
                        g(true);
                        return;
                    }
                    throw new zzg("Could not determine ad overlay type.");
                }
            }
            throw new zzg("Could not get info for ad overlay.");
        } catch (zzg e2) {
            zzbbd.zzeo(e2.getMessage());
            this.n = 3;
            this.f10127b.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onDestroy() {
        zzbgg zzbggVar = this.f10129d;
        if (zzbggVar != null) {
            this.l.removeView(zzbggVar.getView());
        }
        H();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onPause() {
        B();
        zzn zznVar = this.f10128c.f10100c;
        if (zznVar != null) {
            zznVar.onPause();
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue() && this.f10129d != null && (!this.f10127b.isFinishing() || this.f10130e == null)) {
            zzbv.g();
            zzayp.zzi(this.f10129d);
        }
        H();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onResume() {
        zzn zznVar = this.f10128c.f10100c;
        if (zznVar != null) {
            zznVar.onResume();
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue()) {
            return;
        }
        zzbgg zzbggVar = this.f10129d;
        if (zzbggVar != null && !zzbggVar.isDestroyed()) {
            zzbv.g();
            zzayp.zzj(this.f10129d);
        } else {
            zzbbd.zzeo("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.j);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onStart() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue()) {
            zzbgg zzbggVar = this.f10129d;
            if (zzbggVar != null && !zzbggVar.isDestroyed()) {
                zzbv.g();
                zzayp.zzj(this.f10129d);
            } else {
                zzbbd.zzeo("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onStop() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue() && this.f10129d != null && (!this.f10127b.isFinishing() || this.f10130e == null)) {
            zzbv.g();
            zzayp.zzi(this.f10129d);
        }
        H();
    }

    public final void setRequestedOrientation(int i) {
        if (this.f10127b.getApplicationInfo().targetSdkVersion >= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyg)).intValue()) {
            if (this.f10127b.getApplicationInfo().targetSdkVersion <= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyh)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyi)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyj)).intValue()) {
                        return;
                    }
                }
            }
        }
        this.f10127b.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void z() {
        this.n = 1;
        this.f10127b.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzay() {
        this.r = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzq(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwl)).booleanValue() && PlatformVersion.j()) {
            Configuration configuration = (Configuration) ObjectWrapper.a(iObjectWrapper);
            zzbv.e();
            if (zzayh.zza(this.f10127b, configuration)) {
                this.f10127b.getWindow().addFlags(1024);
                this.f10127b.getWindow().clearFlags(2048);
            } else {
                this.f10127b.getWindow().addFlags(2048);
                this.f10127b.getWindow().clearFlags(1024);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final boolean zzvq() {
        this.n = 0;
        zzbgg zzbggVar = this.f10129d;
        if (zzbggVar == null) {
            return true;
        }
        boolean zzads = zzbggVar.zzads();
        if (!zzads) {
            this.f10129d.zza("onbackblocked", Collections.emptyMap());
        }
        return zzads;
    }

    public final void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f10133h = new FrameLayout(this.f10127b);
        this.f10133h.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f10133h.addView(view, -1, -1);
        this.f10127b.setContentView(this.f10133h);
        this.r = true;
        this.i = customViewCallback;
        this.f10132g = true;
    }

    private static void a(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper == null || view == null) {
            return;
        }
        zzbv.v().zza(iObjectWrapper, view);
    }
}
