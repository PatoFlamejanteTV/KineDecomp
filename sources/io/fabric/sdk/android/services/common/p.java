package io.fabric.sdk.android.services.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils.java */
/* loaded from: classes3.dex */
public class p implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f26900a;

    /* renamed from: b */
    final /* synthetic */ AtomicLong f26901b;

    public p(String str, AtomicLong atomicLong) {
        this.f26900a = str;
        this.f26901b = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(new o(this, runnable));
        newThread.setName(this.f26900a + this.f26901b.getAndIncrement());
        return newThread;
    }
}
