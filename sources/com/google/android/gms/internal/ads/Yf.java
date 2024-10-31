package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class Yf extends WebView {
    public Yf(Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        com.google.android.gms.ads.internal.zzbv.g().zza(getContext(), settings);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzbbd.zzb("Unable to enable Javascript.", e2);
        }
        setLayerType(1, null);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            zzaxz.v("Ignore addJavascriptInterface due to low Android version.");
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "CoreWebView.loadUrl");
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public void zzcg(String str) {
        _f.a(this, str);
    }
}
