package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@zzark
@TargetApi(11)
/* loaded from: classes2.dex */
public class zzbhf extends zzbgh {
    public zzbhf(zzbgg zzbggVar, zzum zzumVar, boolean z) {
        super(zzbggVar, zzumVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgg)) {
            zzbbd.zzeo("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgg zzbggVar = (zzbgg) webView;
        zzawr zzawrVar = this.zzbmx;
        if (zzawrVar != null) {
            zzawrVar.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbggVar.zzadl() != null) {
            zzbggVar.zzadl().zzvr();
        }
        if (zzbggVar.zzadj().zzafb()) {
            str2 = (String) zzwu.zzpz().zzd(zzaan.zzcpt);
        } else if (zzbggVar.zzadq()) {
            str2 = (String) zzwu.zzpz().zzd(zzaan.zzcps);
        } else {
            str2 = (String) zzwu.zzpz().zzd(zzaan.zzcpr);
        }
        com.google.android.gms.ads.internal.zzbv.e();
        return zzayh.zze(zzbggVar.getContext(), zzbggVar.zzabz().zzdp, str2);
    }
}
