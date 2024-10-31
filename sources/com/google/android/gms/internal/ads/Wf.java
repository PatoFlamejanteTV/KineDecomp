package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
final class Wf extends zzbig implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzaic, zzbgg {
    private WeakReference<View.OnClickListener> A;
    private com.google.android.gms.ads.internal.overlay.zzd B;
    private zzbas C;
    private final AtomicReference<IObjectWrapper> D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private Map<String, zzbfk> J;
    private final WindowManager K;

    /* renamed from: a, reason: collision with root package name */
    private final zzbhs f11922a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbhu f11923b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcu f11924c;

    /* renamed from: d, reason: collision with root package name */
    private final zzbbi f11925d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzbo f11926e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzv f11927f;

    /* renamed from: g, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzd f11928g;

    /* renamed from: h, reason: collision with root package name */
    private zzbht f11929h;
    private String i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private String p;
    private zzbgw q;
    private boolean r;
    private boolean s;
    private zzacb t;
    private int u;
    private int v;
    private zzaay w;
    private zzaay x;
    private zzaay y;
    private zzaaz z;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public Wf(zzbhs zzbhsVar, zzbhu zzbhuVar, zzbht zzbhtVar, String str, boolean z, boolean z2, zzcu zzcuVar, zzbbi zzbbiVar, zzaba zzabaVar, com.google.android.gms.ads.internal.zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        super(zzbhsVar, zzbhuVar);
        this.n = true;
        this.o = false;
        this.p = "";
        this.D = new AtomicReference<>();
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.f11922a = zzbhsVar;
        this.f11923b = zzbhuVar;
        this.f11929h = zzbhtVar;
        this.i = str;
        this.k = z;
        this.m = -1;
        this.f11924c = zzcuVar;
        this.f11925d = zzbbiVar;
        this.f11926e = zzboVar;
        this.f11927f = zzvVar;
        this.K = (WindowManager) getContext().getSystemService("window");
        this.C = new zzbas(this.f11922a.zzabw(), this, this, null);
        com.google.android.gms.ads.internal.zzbv.e().zza(zzbhsVar, zzbbiVar.zzdp, getSettings());
        setDownloadListener(this);
        this.I = zzbhsVar.getResources().getDisplayMetrics().density;
        c();
        if (PlatformVersion.d()) {
            addJavascriptInterface(zzbgz.zzk(this), "googleAdsJsInterface");
        }
        g();
        this.z = new zzaaz(new zzaba(true, "make_wv", this.i));
        this.z.zzrf().zzc(zzabaVar);
        this.x = zzaat.zzb(this.z.zzrf());
        this.z.zza("native:view_create", this.x);
        this.y = null;
        this.w = null;
        com.google.android.gms.ads.internal.zzbv.g().zzaz(zzbhsVar);
    }

    private final boolean a() {
        int i;
        int i2;
        if (!this.f11923b.zzmu() && !this.f11923b.zzaeb()) {
            return false;
        }
        com.google.android.gms.ads.internal.zzbv.e();
        DisplayMetrics zza = zzayh.zza(this.K);
        zzwu.zzpv();
        int zzb = zzbat.zzb(zza, zza.widthPixels);
        zzwu.zzpv();
        int zzb2 = zzbat.zzb(zza, zza.heightPixels);
        Activity zzabw = this.f11922a.zzabw();
        if (zzabw == null || zzabw.getWindow() == null) {
            i = zzb;
            i2 = zzb2;
        } else {
            com.google.android.gms.ads.internal.zzbv.e();
            int[] zzg = zzayh.zzg(zzabw);
            zzwu.zzpv();
            i = zzbat.zzb(zza, zzg[0]);
            zzwu.zzpv();
            i2 = zzbat.zzb(zza, zzg[1]);
        }
        if (this.F == zzb && this.E == zzb2 && this.G == i && this.H == i2) {
            return false;
        }
        boolean z = (this.F == zzb && this.E == zzb2) ? false : true;
        this.F = zzb;
        this.E = zzb2;
        this.G = i;
        this.H = i2;
        new zzaok(this).zza(zzb, zzb2, i, i2, zza.density, this.K.getDefaultDisplay().getRotation());
        return z;
    }

    private final void b() {
        zzaat.zza(this.z.zzrf(), this.x, "aeh2");
    }

    private final synchronized void c() {
        if (!this.k && !this.f11929h.zzafb()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzbbd.zzdn("Disabling hardware acceleration on an AdView.");
                d();
                return;
            } else {
                zzbbd.zzdn("Enabling hardware acceleration on an AdView.");
                e();
                return;
            }
        }
        zzbbd.zzdn("Enabling hardware acceleration on an overlay.");
        e();
    }

    private final synchronized void d() {
        if (!this.l) {
            com.google.android.gms.ads.internal.zzbv.g().zzaa(this);
        }
        this.l = true;
    }

    private final synchronized void e() {
        if (this.l) {
            com.google.android.gms.ads.internal.zzbv.g().zzz(this);
        }
        this.l = false;
    }

    private final synchronized void f() {
        if (this.J != null) {
            Iterator<zzbfk> it = this.J.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.J = null;
    }

    private final void g() {
        zzaba zzrf;
        zzaaz zzaazVar = this.z;
        if (zzaazVar == null || (zzrf = zzaazVar.zzrf()) == null || com.google.android.gms.ads.internal.zzbv.i().zzyh() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzbv.i().zzyh().zza(zzrf);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final View.OnClickListener getOnClickListener() {
        return this.A.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized int getRequestedOrientation() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhm
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebView getWebView() {
        return this;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.C.onAttachedToWindow();
        }
        boolean z = this.r;
        if (this.f11923b != null && this.f11923b.zzaeb()) {
            if (!this.s) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.f11923b.zzaec();
                if (zzaec != null) {
                    com.google.android.gms.ads.internal.zzbv.D();
                    zzbct.zza(this, zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.f11923b.zzaed();
                if (zzaed != null) {
                    com.google.android.gms.ads.internal.zzbv.D();
                    zzbct.zza(this, zzaed);
                }
                this.s = true;
            }
            a();
            z = true;
        }
        a(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.C.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.s && this.f11923b != null && this.f11923b.zzaeb() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.f11923b.zzaec();
                if (zzaec != null) {
                    com.google.android.gms.ads.internal.zzbv.g().zza(getViewTreeObserver(), zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.f11923b.zzaed();
                if (zzaed != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzaed);
                }
                this.s = false;
            }
        }
        a(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzbv.e();
            zzayh.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzbbd.zzdn(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbig, android.webkit.WebView, android.view.View
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        zzbhu zzbhuVar = this.f11923b;
        if (zzbhuVar == null || zzbhuVar.zzael() == null) {
            return;
        }
        this.f11923b.zzael().zzjw();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean a2 = a();
        com.google.android.gms.ads.internal.overlay.zzd zzadh = zzadh();
        if (zzadh == null || !a2) {
            return;
        }
        zzadh.E();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d0 A[Catch: all -> 0x01eb, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d7, B:60:0x00d3, B:61:0x00dc, B:64:0x00e1, B:66:0x00e9, B:69:0x0100, B:76:0x0126, B:78:0x012d, B:82:0x0137, B:84:0x0149, B:86:0x0159, B:94:0x0172, B:96:0x01c7, B:97:0x01cb, B:100:0x01d0, B:102:0x01d6, B:103:0x01d9, B:109:0x01e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0149 A[Catch: all -> 0x01eb, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d7, B:60:0x00d3, B:61:0x00dc, B:64:0x00e1, B:66:0x00e9, B:69:0x0100, B:76:0x0126, B:78:0x012d, B:82:0x0137, B:84:0x0149, B:86:0x0159, B:94:0x0172, B:96:0x01c7, B:97:0x01cb, B:100:0x01d0, B:102:0x01d6, B:103:0x01d9, B:109:0x01e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0172 A[Catch: all -> 0x01eb, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d7, B:60:0x00d3, B:61:0x00dc, B:64:0x00e1, B:66:0x00e9, B:69:0x0100, B:76:0x0126, B:78:0x012d, B:82:0x0137, B:84:0x0149, B:86:0x0159, B:94:0x0172, B:96:0x01c7, B:97:0x01cb, B:100:0x01d0, B:102:0x01d6, B:103:0x01d9, B:109:0x01e6), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Wf.onMeasure(int, int):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbig, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e2) {
            zzbbd.zzb("Could not pause webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbig, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e2) {
            zzbbd.zzb("Could not resume webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbig, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11923b.zzaeb()) {
            synchronized (this) {
                if (this.t != null) {
                    this.t.zzc(motionEvent);
                }
            }
        } else {
            zzcu zzcuVar = this.f11924c;
            if (zzcuVar != null) {
                zzcuVar.zza(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgg
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.A = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void setRequestedOrientation(int i) {
        this.m = i;
        if (this.f11928g != null) {
            this.f11928g.setRequestedOrientation(this.m);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbig, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e2) {
            zzbbd.zzb("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(GraphResponse.SUCCESS_KEY, z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("duration", Long.toString(j));
        zzaid.zza(this, "onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.D.set(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzbdq zzabt() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized zzbgw zzabu() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzaay zzabv() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhc
    public final Activity zzabw() {
        return this.f11922a.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized String zzabx() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzaaz zzaby() {
        return this.z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhl
    public final zzbbi zzabz() {
        return this.f11925d;
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
    public final synchronized void zzacc() {
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzade() {
        b();
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f11925d.zzdp);
        zzaid.zza(this, "onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadf() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzbv.j().zzkk()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzbv.j().zzkj()));
        hashMap.put("device_volume", String.valueOf(zzaza.zzbb(getContext())));
        zzaid.zza(this, "volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final Context zzadg() {
        return this.f11922a.zzadg();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzadh() {
        return this.f11928g;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzadi() {
        return this.B;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhj
    public final synchronized zzbht zzadj() {
        return this.f11929h;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized String zzadk() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final /* synthetic */ zzbhn zzadl() {
        return this.f11923b;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebViewClient zzadm() {
        return this.f11923b;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadn() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhk
    public final zzcu zzado() {
        return this.f11924c;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final IObjectWrapper zzadp() {
        return this.D.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhd
    public final synchronized boolean zzadq() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzbig, com.google.android.gms.internal.ads.zzbgg
    public final void zzadr() {
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzads() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadt() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadu() {
        return this.u > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadv() {
        this.C.zzaam();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadw() {
        if (this.y == null) {
            this.y = zzaat.zzb(this.z.zzrf());
            this.z.zza("native:view_load", this.y);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized zzacb zzadx() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzady() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadz() {
        zzaxz.v("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaf(boolean z) {
        if (this.f11928g != null) {
            this.f11928g.a(this.f11923b.zzmu(), z);
        } else {
            this.j = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzat(boolean z) {
        this.f11923b.zzat(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzav(boolean z) {
        boolean z2 = z != this.k;
        this.k = z;
        c();
        if (z2) {
            new zzaok(this).zzdc(z ? "expanded" : "default");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaw(boolean z) {
        this.n = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzax(boolean z) {
        this.u += z ? 1 : -1;
        if (this.u <= 0 && this.f11928g != null) {
            this.f11928g.G();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzay(boolean z) {
        this.f11923b.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.B = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbig
    protected final synchronized void zzba(boolean z) {
        if (!z) {
            g();
            this.C.zzaan();
            if (this.f11928g != null) {
                this.f11928g.A();
                this.f11928g.onDestroy();
                this.f11928g = null;
            }
        }
        this.D.set(null);
        this.f11923b.destroy();
        com.google.android.gms.ads.internal.zzbv.C();
        zzbfj.zzc(this);
        f();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzbo(Context context) {
        this.f11922a.setBaseContext(context);
        this.C.zzj(this.f11922a.zzabw());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzc(String str, String str2, String str3) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcre)).booleanValue()) {
            str2 = zzbhi.zzc(str2, zzbhi.zzaex());
        }
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbig, com.google.android.gms.internal.ads.Yf, com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final synchronized void zzcg(String str) {
        if (!isDestroyed()) {
            super.zzcg(str);
        } else {
            zzbbd.zzeo("The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzdh(int i) {
        if (i == 0) {
            zzaat.zza(this.z.zzrf(), this.x, "aebb2");
        }
        b();
        if (this.z.zzrf() != null) {
            this.z.zzrf().zzg("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f11925d.zzdp);
        zzaid.zza(this, "onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized zzbfk zzet(String str) {
        if (this.J == null) {
            return null;
        }
        return this.J.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzfb(String str) {
        if (str == null) {
            str = "";
        }
        try {
            this.p = str;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final com.google.android.gms.ads.internal.zzv zzid() {
        return this.f11927f;
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final synchronized void zzjf() {
        this.o = true;
        if (this.f11926e != null) {
            this.f11926e.zzjf();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final synchronized void zzjg() {
        this.o = false;
        if (this.f11926e != null) {
            this.f11926e.zzjg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzvv() {
        if (this.w == null) {
            zzaat.zza(this.z.zzrf(), this.x, "aes2");
            this.w = zzaat.zzb(this.z.zzrf());
            this.z.zza("native:view_show", this.w);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f11925d.zzdp);
        zzaid.zza(this, "onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzvw() {
        com.google.android.gms.ads.internal.overlay.zzd zzadh = zzadh();
        if (zzadh != null) {
            zzadh.F();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzb(zzacb zzacbVar) {
        this.t = zzacbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f11928g = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zzb(boolean z, int i) {
        this.f11923b.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        zzbhu zzbhuVar = this.f11923b;
        if (zzbhuVar != null) {
            zzbhuVar.zzb(str, zzuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zza(zzbht zzbhtVar) {
        this.f11929h = zzbhtVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zza(String str, zzbfk zzbfkVar) {
        if (this.J == null) {
            this.J = new HashMap();
        }
        this.J.put(str, zzbfkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zza(zzbgw zzbgwVar) {
        if (this.q != null) {
            zzbbd.e("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.q = zzbgwVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.f11923b.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str) {
        this.f11923b.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str, String str2) {
        this.f11923b.zza(z, i, str, str2);
    }

    private final void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzaid.zza(this, "onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsfVar) {
        synchronized (this) {
            this.r = zzsfVar.zzuc;
        }
        a(zzsfVar.zzuc);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        zzbhu zzbhuVar = this.f11923b;
        if (zzbhuVar != null) {
            zzbhuVar.zza(str, zzuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> predicate) {
        zzbhu zzbhuVar = this.f11923b;
        if (zzbhuVar != null) {
            zzbhuVar.zza(str, predicate);
        }
    }
}
