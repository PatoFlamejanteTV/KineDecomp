package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

@zzark
@TargetApi(11)
/* loaded from: classes2.dex */
public final class zzbhe extends zzbhf {
    public zzbhe(zzbgg zzbggVar, zzum zzumVar, boolean z) {
        super(zzbggVar, zzumVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgh, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
