package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.keyczar.Keyczar;

@zzgr
/* loaded from: classes.dex */
public class zzjg extends zzja {
    public zzjg(zziz zzizVar, boolean z) {
        super(zzizVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zziz)) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zziz zzizVar = (zziz) webView;
            zzizVar.zzhe().zzeG();
            String str2 = zzizVar.zzaN().e ? zzby.zzuP.get() : zzizVar.zzhi() ? zzby.zzuO.get() : zzby.zzuN.get();
            com.google.android.gms.ads.internal.util.client.zzb.d("shouldInterceptRequest(" + str2 + ")");
            return zzd(zzizVar.getContext(), this.zzoM.zzhh().b, str2);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzp.e().zzf(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = new zzih(context).zza(str2, hashMap).get(60L, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", Keyczar.DEFAULT_ENCODING, new ByteArrayInputStream(str3.getBytes(Keyczar.DEFAULT_ENCODING)));
    }
}
