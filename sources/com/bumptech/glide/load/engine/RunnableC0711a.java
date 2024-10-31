package com.bumptech.glide.load.engine;

import android.os.Process;

/* compiled from: ActiveResources.java */
/* renamed from: com.bumptech.glide.load.engine.a */
/* loaded from: classes.dex */
class RunnableC0711a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f8791a;

    /* renamed from: b */
    final /* synthetic */ ThreadFactoryC0712b f8792b;

    public RunnableC0711a(ThreadFactoryC0712b threadFactoryC0712b, Runnable runnable) {
        this.f8792b = threadFactoryC0712b;
        this.f8791a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.f8791a.run();
    }
}
