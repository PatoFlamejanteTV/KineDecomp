package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzbig extends Yf implements zzbij {
    private boolean zzdas;
    private final zzbie zzfbf;
    private boolean zzfbg;

    public zzbig(Context context, zzbie zzbieVar) {
        super(context);
        com.google.android.gms.ads.internal.zzbv.i().zzyn();
        this.zzfbf = zzbieVar;
        super.setWebViewClient(zzbieVar);
    }

    private final synchronized void zzyo() {
        if (!this.zzfbg) {
            this.zzfbg = true;
            com.google.android.gms.ads.internal.zzbv.i().zzyo();
        }
    }

    @Override // com.google.android.gms.internal.ads.Yf, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.zzdas) {
            return;
        }
        this.zzdas = true;
        this.zzfbf.zza(this);
        zzba(false);
        zzaxz.v("Initiating WebView self destruct sequence in 3...");
        zzaxz.v("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdWebViewImpl.loadUrlUnsafe");
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzba(true);
                }
                zzyo();
            }
        } finally {
            super.finalize();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzdas;
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.Yf, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzbbd.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgg
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final synchronized void zza(zzbif zzbifVar) {
        zzaxz.v("Blank page loaded, 1...");
        zzadr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzadr() {
        zzaxz.v("Destroying WebView!");
        zzyo();
        zzbcg.zzepo.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.Zf

            /* renamed from: a, reason: collision with root package name */
            private final zzbig f12009a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12009a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12009a.zzaff();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaff() {
        super.destroy();
    }

    protected void zzba(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.Yf, com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public /* bridge */ /* synthetic */ void zzcg(String str) {
        super.zzcg(str);
    }
}
