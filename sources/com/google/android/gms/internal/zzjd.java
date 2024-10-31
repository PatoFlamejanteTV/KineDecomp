package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
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
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@zzgr
/* loaded from: classes.dex */
public class zzjd extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zziz {
    private Map<String, zzdv> A;
    private final WindowManager B;

    /* renamed from: a, reason: collision with root package name */
    private final zza f1730a;
    private final Object b;
    private final zzan c;
    private final VersionInfoParcel d;
    private final com.google.android.gms.ads.internal.zzd e;
    private zzja f;
    private com.google.android.gms.ads.internal.overlay.zzd g;
    private AdSizeParcel h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Boolean m;
    private int n;
    private boolean o;
    private String p;
    private zzce q;
    private zzce r;
    private zzce s;
    private zzcf t;
    private com.google.android.gms.ads.internal.overlay.zzd u;
    private zzim v;
    private int w;
    private int x;
    private int y;
    private int z;

    @zzgr
    /* loaded from: classes.dex */
    public static class zza extends MutableContextWrapper {
        private Activity zzJn;
        private Context zzKC;
        private Context zzqZ;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return this.zzKC.getSystemService(str);
        }

        @Override // android.content.MutableContextWrapper
        public void setBaseContext(Context context) {
            this.zzqZ = context.getApplicationContext();
            this.zzJn = context instanceof Activity ? (Activity) context : null;
            this.zzKC = context;
            super.setBaseContext(this.zzqZ);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public void startActivity(Intent intent) {
            if (this.zzJn != null && !zzmx.isAtLeastL()) {
                this.zzJn.startActivity(intent);
            } else {
                intent.setFlags(268435456);
                this.zzqZ.startActivity(intent);
            }
        }

        public Activity zzgZ() {
            return this.zzJn;
        }

        public Context zzha() {
            return this.zzKC;
        }
    }

    protected zzjd(zza zzaVar, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel, zzcg zzcgVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        super(zzaVar);
        this.b = new Object();
        this.o = true;
        this.p = "";
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.f1730a = zzaVar;
        this.h = adSizeParcel;
        this.k = z;
        this.n = -1;
        this.c = zzanVar;
        this.d = versionInfoParcel;
        this.e = zzdVar;
        this.B = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        com.google.android.gms.ads.internal.zzp.e().zza(zzaVar, versionInfoParcel.b, settings);
        com.google.android.gms.ads.internal.zzp.g().zza(getContext(), settings);
        setDownloadListener(this);
        d();
        if (zzmx.zzqz()) {
            addJavascriptInterface(new zzje(this), "googleAdsJsInterface");
        }
        this.v = new zzim(this.f1730a.zzgZ(), this, null);
        a(zzcgVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjd a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel, zzcg zzcgVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        return new zzjd(new zza(context), adSizeParcel, z, z2, zzanVar, versionInfoParcel, zzcgVar, zzdVar);
    }

    private void a(zzcg zzcgVar) {
        h();
        this.t = new zzcf(new zzcg(true, "make_wv", this.h.b));
        this.t.zzdm().zzc(zzcgVar);
        this.r = zzcc.zzb(this.t.zzdm());
        this.t.zza("native:view_create", this.r);
        this.s = null;
        this.q = null;
    }

    private void c() {
        synchronized (this.b) {
            this.m = com.google.android.gms.ads.internal.zzp.h().zzgs();
            if (this.m == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    a((Boolean) true);
                } catch (IllegalStateException e) {
                    a((Boolean) false);
                }
            }
        }
    }

    private void d() {
        synchronized (this.b) {
            if (this.k || this.h.e) {
                if (Build.VERSION.SDK_INT < 14) {
                    com.google.android.gms.ads.internal.util.client.zzb.a("Disabling hardware acceleration on an overlay.");
                    e();
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.a("Enabling hardware acceleration on an overlay.");
                    f();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                com.google.android.gms.ads.internal.util.client.zzb.a("Disabling hardware acceleration on an AdView.");
                e();
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.a("Enabling hardware acceleration on an AdView.");
                f();
            }
        }
    }

    private void e() {
        synchronized (this.b) {
            if (!this.l) {
                com.google.android.gms.ads.internal.zzp.g().zzm(this);
            }
            this.l = true;
        }
    }

    private void f() {
        synchronized (this.b) {
            if (this.l) {
                com.google.android.gms.ads.internal.zzp.g().zzl(this);
            }
            this.l = false;
        }
    }

    private void g() {
        synchronized (this.b) {
            if (this.A != null) {
                Iterator<zzdv> it = this.A.values().iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
            }
        }
    }

    private void h() {
        zzcg zzdm;
        if (this.t == null || (zzdm = this.t.zzdm()) == null || com.google.android.gms.ads.internal.zzp.h().zzgo() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.h().zzgo().zza(zzdm);
    }

    void a(Boolean bool) {
        this.m = bool;
        com.google.android.gms.ads.internal.zzp.h().zzb(bool);
    }

    protected void a(String str) {
        synchronized (this.b) {
            if (isDestroyed()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void a(String str, ValueCallback<String> valueCallback) {
        synchronized (this.b) {
            if (isDestroyed()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public boolean a() {
        int i;
        int i2;
        if (!zzhe().zzbY()) {
            return false;
        }
        DisplayMetrics zza2 = com.google.android.gms.ads.internal.zzp.e().zza(this.B);
        int b = com.google.android.gms.ads.internal.client.zzl.a().b(zza2, zza2.widthPixels);
        int b2 = com.google.android.gms.ads.internal.client.zzl.a().b(zza2, zza2.heightPixels);
        Activity zzgZ = zzgZ();
        if (zzgZ == null || zzgZ.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            int[] zzg = com.google.android.gms.ads.internal.zzp.e().zzg(zzgZ);
            i2 = com.google.android.gms.ads.internal.client.zzl.a().b(zza2, zzg[0]);
            i = com.google.android.gms.ads.internal.client.zzl.a().b(zza2, zzg[1]);
        }
        if (this.x == b && this.w == b2 && this.y == i2 && this.z == i) {
            return false;
        }
        boolean z = (this.x == b && this.w == b2) ? false : true;
        this.x = b;
        this.w = b2;
        this.y = i2;
        this.z = i;
        new zzfh(this).zza(b, b2, i2, i, zza2.density, this.B.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean b() {
        Boolean bool;
        synchronized (this.b) {
            bool = this.m;
        }
        return bool;
    }

    protected void b(String str) {
        if (!zzmx.zzqB()) {
            a("javascript:" + str);
            return;
        }
        if (b() == null) {
            c();
        }
        if (b().booleanValue()) {
            a(str, null);
        } else {
            a("javascript:" + str);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zziz
    public void destroy() {
        synchronized (this.b) {
            h();
            this.v.zzgP();
            if (this.g != null) {
                this.g.a();
                this.g.onDestroy();
                this.g = null;
            }
            this.f.reset();
            if (this.j) {
                return;
            }
            com.google.android.gms.ads.internal.zzp.r().zza(this);
            g();
            this.j = true;
            com.google.android.gms.ads.internal.util.client.zzb.d("Initiating WebView self destruct sequence in 3...");
            this.f.zzhs();
        }
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.b) {
            if (!isDestroyed()) {
                super.evaluateJavascript(str, valueCallback);
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzb.e("The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public String getRequestId() {
        String str;
        synchronized (this.b) {
            str = this.p;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zziz
    public int getRequestedOrientation() {
        int i;
        synchronized (this.b) {
            i = this.n;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zziz
    public View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zziz
    public WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean isDestroyed() {
        boolean z;
        synchronized (this.b) {
            z = this.j;
        }
        return z;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zziz
    public void loadData(String str, String str2, String str3) {
        synchronized (this.b) {
            if (isDestroyed()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zziz
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.b) {
            if (isDestroyed()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zziz
    public void loadUrl(String str) {
        synchronized (this.b) {
            if (isDestroyed()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzb.e("Could not call loadUrl. " + th);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        synchronized (this.b) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.v.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        synchronized (this.b) {
            if (!isDestroyed()) {
                this.v.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzp.e().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean a2 = a();
        com.google.android.gms.ads.internal.overlay.zzd zzhc = zzhc();
        if (zzhc == null || !a2) {
            return;
        }
        zzhc.f();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        synchronized (this.b) {
            if (isDestroyed()) {
                setMeasuredDimension(0, 0);
                return;
            }
            if (isInEditMode() || this.k || this.h.i || this.h.j) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.h.e) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.B.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
            int i4 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size2 : Integer.MAX_VALUE;
            if (this.h.g > i3 || this.h.d > i4) {
                float f = this.f1730a.getResources().getDisplayMetrics().density;
                com.google.android.gms.ads.internal.util.client.zzb.e("Not enough space to show ad. Needs " + ((int) (this.h.g / f)) + "x" + ((int) (this.h.d / f)) + " dp, but only has " + ((int) (size / f)) + "x" + ((int) (size2 / f)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.h.g, this.h.d);
            }
        }
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            if (zzmx.zzqu()) {
                super.onPause();
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            if (zzmx.zzqu()) {
                super.onResume();
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c != null) {
            this.c.zza(motionEvent);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.zziz
    public void setContext(Context context) {
        this.f1730a.setBaseContext(context);
        this.v.zzk(this.f1730a.zzgZ());
    }

    @Override // com.google.android.gms.internal.zziz
    public void setRequestedOrientation(int i) {
        synchronized (this.b) {
            this.n = i;
            if (this.g != null) {
                this.g.a(this.n);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zziz
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzja) {
            this.f = (zzja) webViewClient;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zziz
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzC(boolean z) {
        synchronized (this.b) {
            this.k = z;
            d();
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzD(boolean z) {
        synchronized (this.b) {
            if (this.g != null) {
                this.g.a(this.f.zzbY(), z);
            } else {
                this.i = z;
            }
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzE(boolean z) {
        synchronized (this.b) {
            this.o = z;
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(Context context, AdSizeParcel adSizeParcel, zzcg zzcgVar) {
        synchronized (this.b) {
            this.v.zzgP();
            setContext(context);
            this.g = null;
            this.h = adSizeParcel;
            this.k = false;
            this.i = false;
            this.p = "";
            this.n = -1;
            com.google.android.gms.ads.internal.zzp.g().zzb(this);
            loadUrl("about:blank");
            this.f.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.o = true;
            a(zzcgVar);
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.b) {
            this.h = adSizeParcel;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.zzaw
    public void zza(zzaz zzazVar, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzb("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(String str, String str2) {
        b(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.zziz
    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zza(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzaI(String str) {
        synchronized (this.b) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not call loadUrl. " + th);
            }
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzaJ(String str) {
        synchronized (this.b) {
            if (str == null) {
                str = "";
            }
            this.p = str;
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public AdSizeParcel zzaN() {
        AdSizeParcel adSizeParcel;
        synchronized (this.b) {
            adSizeParcel = this.h;
        }
        return adSizeParcel;
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.b) {
            this.g = zzdVar;
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzb(String str, Map<String, ?> map) {
        try {
            zzb(str, com.google.android.gms.ads.internal.zzp.e().zzz(map));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        com.google.android.gms.ads.internal.util.client.zzb.d("Dispatching AFMA event: " + sb.toString());
        b(sb.toString());
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.b) {
            this.u = zzdVar;
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzeJ() {
        if (this.q != null) {
            zzcc.zza(this.t.zzdm(), this.s, "aes");
            this.q = zzcc.zzb(this.t.zzdm());
            this.t.zza("native:view_show", this.s);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.d.b);
        zzb("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzgY() {
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.d.b);
        zzb("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.zziz
    public Activity zzgZ() {
        return this.f1730a.zzgZ();
    }

    @Override // com.google.android.gms.internal.zziz
    public Context zzha() {
        return this.f1730a.zzha();
    }

    @Override // com.google.android.gms.internal.zziz
    public com.google.android.gms.ads.internal.zzd zzhb() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.zziz
    public com.google.android.gms.ads.internal.overlay.zzd zzhc() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.b) {
            zzdVar = this.g;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zziz
    public com.google.android.gms.ads.internal.overlay.zzd zzhd() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.b) {
            zzdVar = this.u;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zziz
    public zzja zzhe() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean zzhf() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.zziz
    public zzan zzhg() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.zziz
    public VersionInfoParcel zzhh() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean zzhi() {
        boolean z;
        synchronized (this.b) {
            z = this.k;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzhj() {
        synchronized (this.b) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Destroying WebView!");
            zzid.zzIE.post(new ek(this));
        }
    }

    @Override // com.google.android.gms.internal.zziz
    public boolean zzhk() {
        boolean z;
        synchronized (this.b) {
            z = this.o;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zziz
    public zziy zzhl() {
        return null;
    }

    @Override // com.google.android.gms.internal.zziz
    public zzce zzhm() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.zziz
    public zzcf zzhn() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzho() {
        this.v.zzgO();
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzhp() {
        if (this.s != null || "about:blank".equals(getUrl())) {
            return;
        }
        this.s = zzcc.zzb(this.t.zzdm());
        this.t.zza("native:view_load", this.s);
    }

    @Override // com.google.android.gms.internal.zziz
    public void zzv(int i) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.d.b);
        zzb("onhide", hashMap);
    }
}
