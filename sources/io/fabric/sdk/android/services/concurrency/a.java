package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask.java */
/* loaded from: classes3.dex */
class a implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f26943a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f26943a.getAndIncrement());
    }
}
