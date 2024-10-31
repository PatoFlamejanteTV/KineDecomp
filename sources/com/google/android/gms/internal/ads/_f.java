package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
final class _f {

    /* renamed from: a */
    @VisibleForTesting
    private static Boolean f12036a;

    private _f() {
    }

    @TargetApi(19)
    private static boolean a(WebView webView) {
        boolean booleanValue;
        synchronized (_f.class) {
            if (f12036a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    f12036a = true;
                } catch (IllegalStateException unused) {
                    f12036a = false;
                }
            }
            booleanValue = f12036a.booleanValue();
        }
        return booleanValue;
    }

    @TargetApi(19)
    public static void a(WebView webView, String str) {
        if (PlatformVersion.f() && a(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
        }
    }
}
