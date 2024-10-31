package com.google.android.gms.internal.gtm;

import android.os.Handler;

/* loaded from: classes2.dex */
public final class H implements zzbw {

    /* renamed from: a */
    private final /* synthetic */ Runnable f13154a;

    /* renamed from: b */
    private final /* synthetic */ zzcq f13155b;

    public H(zzcq zzcqVar, Runnable runnable) {
        this.f13155b = zzcqVar;
        this.f13154a = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzbw
    public final void zza(Throwable th) {
        Handler handler;
        handler = this.f13155b.handler;
        handler.post(this.f13154a);
    }
}
