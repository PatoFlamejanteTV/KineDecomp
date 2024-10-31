package com.nextreaming.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ImageWorker.java */
/* loaded from: classes.dex */
final class f implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f4462a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f4462a.getAndIncrement());
    }
}
