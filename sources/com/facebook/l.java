package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
final class l implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f304a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "FacebookSdk #" + this.f304a.incrementAndGet());
    }
}
