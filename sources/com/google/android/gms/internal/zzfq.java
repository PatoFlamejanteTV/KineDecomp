package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public class zzfq implements zzfo {
    private final Context mContext;
    final Set<WebView> zzCr = Collections.synchronizedSet(new HashSet());

    public zzfq(Context context) {
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzfo
    public void zza(String str, String str2, String str3) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Fetching assets for the given html");
        zzid.zzIE.post(new cj(this, str2, str3));
    }

    public WebView zzfh() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
