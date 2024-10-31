package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzk f1432a;
    final /* synthetic */ zzc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(zzc zzcVar, zzk zzkVar) {
        this.b = zzcVar;
        this.f1432a = zzkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.b.zzi;
            blockingQueue.put(this.f1432a);
        } catch (InterruptedException e) {
        }
    }
}
