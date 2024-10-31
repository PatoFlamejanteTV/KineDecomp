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
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
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
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
final class Lf extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbgg {
    private zzacb A;
    private int B;
    private int C;
    private zzaay D;
    private zzaay E;
    private zzaay F;
    private zzaaz G;
    private WeakReference<View.OnClickListener> H;
    private com.google.android.gms.ads.internal.overlay.zzd I;
    private boolean J;
    private zzbas K;
    private int L;
    private int M;
    private int N;
    private int O;
    private Map<String, zzbfk> P;
    private final WindowManager Q;
    private final zzum R;

    /* renamed from: a, reason: collision with root package name */
    private final zzbhs f11658a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcu f11659b;

    /* renamed from: c, reason: collision with root package name */
    private final zzbbi f11660c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzbo f11661d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzv f11662e;

    /* renamed from: f, reason: collision with root package name */
    private final DisplayMetrics f11663f;

    /* renamed from: g, reason: collision with root package name */
    private final float f11664g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11665h;
    private boolean i;
    private zzbgh j;
    private com.google.android.gms.ads.internal.overlay.zzd k;
    private IObjectWrapper l;
    private zzbht m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private Boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private String w;
    private zzbgw x;
    private boolean y;
    private boolean z;

    @VisibleForTesting
    private Lf(zzbhs zzbhsVar, zzbht zzbhtVar, String str, boolean z, boolean z2, zzcu zzcuVar, zzbbi zzbbiVar, zzaba zzabaVar, com.google.android.gms.ads.internal.zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar, zzum zzumVar) {
        super(zzbhsVar);
        this.f11665h = false;
        this.i = false;
        this.u = true;
        this.v = false;
        this.w = "";
        this.L = -1;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.f11658a = zzbhsVar;
        this.m = zzbhtVar;
        this.n = str;
        this.q = z;
        this.t = -1;
        this.f11659b = zzcuVar;
        this.f11660c = zzbbiVar;
        this.f11661d = zzboVar;
        this.f11662e = zzvVar;
        this.Q = (WindowManager) getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzbv.e();
        this.f11663f = zzayh.zza(this.Q);
        this.f11664g = this.f11663f.density;
        this.R = zzumVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzbbd.zzb("Unable to enable Javascript.", e2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        com.google.android.gms.ads.internal.zzbv.e().zza(zzbhsVar, zzbbiVar.zzdp, settings);
        com.google.android.gms.ads.internal.zzbv.g().zza(getContext(), settings);
        setDownloadListener(this);
        d();
        if (PlatformVersion.d()) {
            addJavascriptInterface(zzbgz.zzk(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.K = new zzbas(this.f11658a.zzabw(), this, this, null);
        h();
        this.G = new zzaaz(new zzaba(true, "make_wv", this.n));
        this.G.zzrf().zzc(zzabaVar);
        this.E = zzaat.zzb(this.G.zzrf());
        this.G.zza("native:view_create", this.E);
        this.F = null;
        this.D = null;
        com.google.android.gms.ads.internal.zzbv.g().zzaz(zzbhsVar);
        com.google.android.gms.ads.internal.zzbv.i().zzyn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Lf a(Context context, zzbht zzbhtVar, String str, boolean z, boolean z2, zzcu zzcuVar, zzbbi zzbbiVar, zzaba zzabaVar, com.google.android.gms.ads.internal.zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar, zzum zzumVar) {
        return new Lf(new zzbhs(context), zzbhtVar, str, z, z2, zzcuVar, zzbbiVar, zzabaVar, zzboVar, zzvVar, zzumVar);
    }

    private final synchronized void b(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdWebViewImpl.loadUrlUnsafe");
            zzbbd.zzc("Could not call loadUrl. ", e2);
        }
    }

    private final void c(String str) {
        if (PlatformVersion.f()) {
            if (i() == null) {
                b();
            }
            if (i().booleanValue()) {
                a(str, (ValueCallback<String>) null);
                return;
            } else {
                String valueOf = String.valueOf(str);
                a(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
                return;
            }
        }
        String valueOf2 = String.valueOf(str);
        a(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    private final synchronized void d() {
        if (!this.q && !this.m.zzafb()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzbbd.zzdn("Disabling hardware acceleration on an AdView.");
                e();
                return;
            } else {
                zzbbd.zzdn("Enabling hardware acceleration on an AdView.");
                f();
                return;
            }
        }
        zzbbd.zzdn("Enabling hardware acceleration on an overlay.");
        f();
    }

    private final synchronized void e() {
        if (!this.r) {
            com.google.android.gms.ads.internal.zzbv.g().zzaa(this);
        }
        this.r = true;
    }

    private final synchronized void f() {
        if (this.r) {
            com.google.android.gms.ads.internal.zzbv.g().zzz(this);
        }
        this.r = false;
    }

    private final synchronized void g() {
        if (this.P != null) {
            Iterator<zzbfk> it = this.P.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.P = null;
    }

    private final void h() {
        zzaba zzrf;
        zzaaz zzaazVar = this.G;
        if (zzaazVar == null || (zzrf = zzaazVar.zzrf()) == null || com.google.android.gms.ads.internal.zzbv.i().zzyh() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzbv.i().zzyh().zza(zzrf);
    }

    @VisibleForTesting
    private final synchronized Boolean i() {
        return this.s;
    }

    private final synchronized void j() {
        if (!this.J) {
            this.J = true;
            com.google.android.gms.ads.internal.zzbv.i().zzyo();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final synchronized void destroy() {
        h();
        this.K.zzaan();
        if (this.k != null) {
            this.k.A();
            this.k.onDestroy();
            this.k = null;
        }
        this.l = null;
        this.j.reset();
        if (this.p) {
            return;
        }
        com.google.android.gms.ads.internal.zzbv.C();
        zzbfj.zzc(this);
        g();
        this.p = true;
        zzaxz.v("Initiating WebView self destruct sequence in 3...");
        zzaxz.v("Loading blank page in WebView, 2...");
        b("about:blank");
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzbbd.zzeq("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.p) {
                    this.j.reset();
                    com.google.android.gms.ads.internal.zzbv.C();
                    zzbfj.zzc(this);
                    g();
                    j();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final View.OnClickListener getOnClickListener() {
        return this.H.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized int getRequestedOrientation() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhm
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean isDestroyed() {
        return this.p;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
                com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdWebViewImpl.loadUrl");
                zzbbd.zzc("Could not call loadUrl. ", e2);
                return;
            }
        }
        zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.K.onAttachedToWindow();
        }
        boolean z = this.y;
        if (this.j != null && this.j.zzaeb()) {
            if (!this.z) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.j.zzaec();
                if (zzaec != null) {
                    com.google.android.gms.ads.internal.zzbv.D();
                    zzbct.zza(this, zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.j.zzaed();
                if (zzaed != null) {
                    com.google.android.gms.ads.internal.zzbv.D();
                    zzbct.zza(this, zzaed);
                }
                this.z = true;
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
                this.K.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.z && this.j != null && this.j.zzaeb() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.j.zzaec();
                if (zzaec != null) {
                    com.google.android.gms.ads.internal.zzbv.g().zza(getViewTreeObserver(), zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.j.zzaed();
                if (zzaed != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzaed);
                }
                this.z = false;
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

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        zzbgh zzbghVar = this.j;
        if (zzbghVar == null || zzbghVar.zzael() == null) {
            return;
        }
        this.j.zzael().zzjw();
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d7 A[Catch: all -> 0x01ff, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ce, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0151, B:93:0x016c, B:95:0x01c1, B:96:0x01c5, B:98:0x01cc, B:103:0x01d7, B:105:0x01dd, B:106:0x01e0, B:108:0x01e4, B:109:0x01ed, B:115:0x01fa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141 A[Catch: all -> 0x01ff, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ce, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0151, B:93:0x016c, B:95:0x01c1, B:96:0x01c5, B:98:0x01cc, B:103:0x01d7, B:105:0x01dd, B:106:0x01e0, B:108:0x01e4, B:109:0x01ed, B:115:0x01fa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016c A[Catch: all -> 0x01ff, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ce, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0151, B:93:0x016c, B:95:0x01c1, B:96:0x01c5, B:98:0x01cc, B:103:0x01d7, B:105:0x01dd, B:106:0x01e0, B:108:0x01e4, B:109:0x01ed, B:115:0x01fa), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Lf.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e2) {
            zzbbd.zzb("Could not pause webview.", e2);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e2) {
            zzbbd.zzb("Could not resume webview.", e2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j.zzaeb()) {
            synchronized (this) {
                if (this.A != null) {
                    this.A.zzc(motionEvent);
                }
            }
        } else {
            zzcu zzcuVar = this.f11659b;
            if (zzcuVar != null) {
                zzcuVar.zza(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgg
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.H = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void setRequestedOrientation(int i) {
        this.t = i;
        if (this.k != null) {
            this.k.setRequestedOrientation(this.t);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbgh) {
            this.j = (zzbgh) webViewClient;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e2) {
            zzbbd.zzb("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, com.google.android.gms.ads.internal.zzbv.e().zzn(map));
        } catch (JSONException unused) {
            zzbbd.zzeo("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaa(IObjectWrapper iObjectWrapper) {
        this.l = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzbdq zzabt() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized zzbgw zzabu() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzaay zzabv() {
        return this.E;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhc
    public final Activity zzabw() {
        return this.f11658a.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized String zzabx() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzaaz zzaby() {
        return this.G;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhl
    public final zzbbi zzabz() {
        return this.f11660c;
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
        c();
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f11660c.zzdp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadf() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzbv.j().zzkk()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzbv.j().zzkj()));
        hashMap.put("device_volume", String.valueOf(zzaza.zzbb(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final Context zzadg() {
        return this.f11658a.zzadg();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzadh() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzadi() {
        return this.I;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhj
    public final synchronized zzbht zzadj() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized String zzadk() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final /* synthetic */ zzbhn zzadl() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebViewClient zzadm() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadn() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhk
    public final zzcu zzado() {
        return this.f11659b;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized IObjectWrapper zzadp() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhd
    public final synchronized boolean zzadq() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzadr() {
        zzaxz.v("Destroying WebView!");
        j();
        zzayh.zzelc.post(new Nf(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzads() {
        return this.u;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadt() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadu() {
        return this.B > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadv() {
        this.K.zzaam();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadw() {
        if (this.F == null) {
            this.F = zzaat.zzb(this.G.zzrf());
            this.G.zza("native:view_load", this.F);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized zzacb zzadx() {
        return this.A;
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
        if (this.k != null) {
            this.k.a(this.j.zzmu(), z);
        } else {
            this.o = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzat(boolean z) {
        this.j.zzat(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzav(boolean z) {
        boolean z2 = z != this.q;
        this.q = z;
        d();
        if (z2) {
            new zzaok(this).zzdc(z ? "expanded" : "default");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaw(boolean z) {
        this.u = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzax(boolean z) {
        this.B += z ? 1 : -1;
        if (this.B <= 0 && this.k != null) {
            this.k.G();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzay(boolean z) {
        this.j.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        c(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzbo(Context context) {
        this.f11658a.setBaseContext(context);
        this.K.zzj(this.f11658a.zzabw());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzc(String str, String str2, String str3) {
        if (!isDestroyed()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcre)).booleanValue()) {
                str2 = zzbhi.zzc(str2, zzbhi.zzaex());
            }
            super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", str3);
            return;
        }
        zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        c(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzdh(int i) {
        if (i == 0) {
            zzaat.zza(this.G.zzrf(), this.E, "aebb2");
        }
        c();
        if (this.G.zzrf() != null) {
            this.G.zzrf().zzg("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f11660c.zzdp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized zzbfk zzet(String str) {
        if (this.P == null) {
            return null;
        }
        return this.P.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzfb(String str) {
        if (str == null) {
            str = "";
        }
        try {
            this.w = str;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final com.google.android.gms.ads.internal.zzv zzid() {
        return this.f11662e;
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final synchronized void zzjf() {
        this.v = true;
        if (this.f11661d != null) {
            this.f11661d.zzjf();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final synchronized void zzjg() {
        this.v = false;
        if (this.f11661d != null) {
            this.f11661d.zzjg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzvv() {
        if (this.D == null) {
            zzaat.zza(this.G.zzrf(), this.E, "aes2");
            this.D = zzaat.zzb(this.G.zzrf());
            this.G.zza("native:view_show", this.D);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f11660c.zzdp);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzvw() {
        com.google.android.gms.ads.internal.overlay.zzd zzadh = zzadh();
        if (zzadh != null) {
            zzadh.F();
        }
    }

    private final boolean a() {
        int i;
        int i2;
        if (!this.j.zzmu() && !this.j.zzaeb()) {
            return false;
        }
        zzwu.zzpv();
        DisplayMetrics displayMetrics = this.f11663f;
        int zzb = zzbat.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwu.zzpv();
        DisplayMetrics displayMetrics2 = this.f11663f;
        int zzb2 = zzbat.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzabw = this.f11658a.zzabw();
        if (zzabw == null || zzabw.getWindow() == null) {
            i = zzb;
            i2 = zzb2;
        } else {
            com.google.android.gms.ads.internal.zzbv.e();
            int[] zzg = zzayh.zzg(zzabw);
            zzwu.zzpv();
            int zzb3 = zzbat.zzb(this.f11663f, zzg[0]);
            zzwu.zzpv();
            i2 = zzbat.zzb(this.f11663f, zzg[1]);
            i = zzb3;
        }
        if (this.M == zzb && this.L == zzb2 && this.N == i && this.O == i2) {
            return false;
        }
        boolean z = (this.M == zzb && this.L == zzb2) ? false : true;
        this.M = zzb;
        this.L = zzb2;
        this.N = i;
        this.O = i2;
        new zzaok(this).zza(zzb, zzb2, i, i2, this.f11663f.density, this.Q.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzbbd.zzdn(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        c(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.I = zzdVar;
    }

    private final synchronized void b() {
        this.s = com.google.android.gms.ads.internal.zzbv.i().zzyi();
        if (this.s == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                a((Boolean) true);
            } catch (IllegalStateException unused) {
                a((Boolean) false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzb(zzacb zzacbVar) {
        this.A = zzacbVar;
    }

    private final void c() {
        zzaat.zza(this.G.zzrf(), this.E, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zzb(boolean z, int i) {
        this.j.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        zzbgh zzbghVar = this.j;
        if (zzbghVar != null) {
            zzbghVar.zzb(str, zzuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(GraphResponse.SUCCESS_KEY, z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.k = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zza(zzbht zzbhtVar) {
        this.m = zzbhtVar;
        requestLayout();
    }

    private final synchronized void a(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zza(String str, zzbfk zzbfkVar) {
        if (this.P == null) {
            this.P = new HashMap();
        }
        this.P.put(str, zzbfkVar);
    }

    @TargetApi(19)
    private final synchronized void a(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zza(zzbgw zzbgwVar) {
        if (this.x != null) {
            zzbbd.e("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.x = zzbgwVar;
        }
    }

    @VisibleForTesting
    private final void a(Boolean bool) {
        synchronized (this) {
            this.s = bool;
        }
        com.google.android.gms.ads.internal.zzbv.i().zza(bool);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.j.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str) {
        this.j.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str, String str2) {
        this.j.zza(z, i, str, str2);
    }

    private final void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zza("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsfVar) {
        synchronized (this) {
            this.y = zzsfVar.zzuc;
        }
        a(zzsfVar.zzuc);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg> zzuVar) {
        zzbgh zzbghVar = this.j;
        if (zzbghVar != null) {
            zzbghVar.zza(str, zzuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super zzbgg>> predicate) {
        zzbgh zzbghVar = this.j;
        if (zzbghVar != null) {
            zzbghVar.zza(str, predicate);
        }
    }
}
