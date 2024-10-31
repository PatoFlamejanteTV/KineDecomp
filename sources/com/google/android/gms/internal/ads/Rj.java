package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class Rj implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzr f11814a;

    /* renamed from: b */
    private final /* synthetic */ zzd f11815b;

    public Rj(zzd zzdVar, zzr zzrVar) {
        this.f11815b = zzdVar;
        this.f11814a = zzrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f11815b.zzi;
            blockingQueue.put(this.f11814a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
