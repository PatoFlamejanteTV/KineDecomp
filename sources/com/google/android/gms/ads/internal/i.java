package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class I implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzc f9996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(zzc zzcVar) {
        this.f9996a = zzcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f9996a.zzbls.f10252d.zzab().zza(this.f9996a.zzbls.f10251c);
    }
}
