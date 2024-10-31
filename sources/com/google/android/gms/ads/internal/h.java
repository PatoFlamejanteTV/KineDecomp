package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class H implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzc f9995a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(zzc zzcVar) {
        this.f9995a = zzcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        CookieManager zzba = zzbv.g().zzba(this.f9995a.zzbls.f10251c);
        return zzba != null ? zzba.getCookie("googleads.g.doubleclick.net") : "";
    }
}
