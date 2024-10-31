package com.google.android.gms.analytics.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzb f707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(zzb zzbVar) {
        this.f707a = zzbVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        o oVar;
        oVar = this.f707a.f737a;
        oVar.j();
        return null;
    }
}
