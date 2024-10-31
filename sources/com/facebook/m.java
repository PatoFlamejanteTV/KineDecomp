package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
class m implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f9425a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "FacebookSdk #" + this.f9425a.incrementAndGet());
    }
}
