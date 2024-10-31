package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Gd implements Callable<Boolean> {

    /* renamed from: a */
    private final /* synthetic */ Context f11544a;

    /* renamed from: b */
    private final /* synthetic */ WebSettings f11545b;

    public Gd(zzays zzaysVar, Context context, WebSettings webSettings) {
        this.f11544a = context;
        this.f11545b = webSettings;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        if (this.f11544a.getCacheDir() != null) {
            this.f11545b.setAppCachePath(this.f11544a.getCacheDir().getAbsolutePath());
            this.f11545b.setAppCacheMaxSize(0L);
            this.f11545b.setAppCacheEnabled(true);
        }
        this.f11545b.setDatabasePath(this.f11544a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.f11545b.setDatabaseEnabled(true);
        this.f11545b.setDomStorageEnabled(true);
        this.f11545b.setDisplayZoomControls(false);
        this.f11545b.setBuiltInZoomControls(true);
        this.f11545b.setSupportZoom(true);
        this.f11545b.setAllowContentAccess(false);
        return true;
    }
}
