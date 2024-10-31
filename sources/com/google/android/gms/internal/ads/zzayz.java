package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
/* loaded from: classes2.dex */
public final class zzayz extends zzayy {
    @Override // com.google.android.gms.internal.ads.zzays, com.google.android.gms.internal.ads.zzayp
    public final zzbgh zza(zzbgg zzbggVar, zzum zzumVar, boolean z) {
        return new zzbhg(zzbggVar, zzumVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzayu, com.google.android.gms.internal.ads.zzayp
    public final int zzaab() {
        return R.style.Theme.Material.Dialog.Alert;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final CookieManager zzba(Context context) {
        if (zzayp.zzaaa()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbbd.zzb("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
