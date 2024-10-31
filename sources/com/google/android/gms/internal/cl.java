package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgc f1478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(zzgc zzgcVar) {
        this.f1478a = zzgcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f1478a.zzDi;
        if (atomicBoolean.get()) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Timed out waiting for WebView to finish loading.");
            this.f1478a.cancel();
        }
    }
}
