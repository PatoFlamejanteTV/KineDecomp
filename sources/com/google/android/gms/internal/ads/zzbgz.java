package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbhm;

@zzark
@TargetApi(17)
/* loaded from: classes2.dex */
public final class zzbgz<WebViewT extends zzbhc & zzbhk & zzbhm> {
    private final zzbhb zzfaq;
    private final WebViewT zzfar;

    private zzbgz(WebViewT webviewt, zzbhb zzbhbVar) {
        this.zzfaq = zzbhbVar;
        this.zzfar = webviewt;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.Qf, com.google.android.gms.internal.ads.zzbhb] */
    public static zzbgz<zzbgg> zzk(final zzbgg zzbggVar) {
        return new zzbgz<>(zzbggVar, new Object(zzbggVar) { // from class: com.google.android.gms.internal.ads.Qf

            /* renamed from: a, reason: collision with root package name */
            private final zzbgg f11787a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11787a = zzbggVar;
            }
        });
    }
}
