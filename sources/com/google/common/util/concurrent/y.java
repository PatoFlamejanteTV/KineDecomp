package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadFactoryBuilder.java */
/* loaded from: classes2.dex */
public class y implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ ThreadFactory f16220a;

    /* renamed from: b */
    final /* synthetic */ String f16221b;

    /* renamed from: c */
    final /* synthetic */ AtomicLong f16222c;

    /* renamed from: d */
    final /* synthetic */ Boolean f16223d;

    /* renamed from: e */
    final /* synthetic */ Integer f16224e;

    /* renamed from: f */
    final /* synthetic */ Thread.UncaughtExceptionHandler f16225f;

    public y(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f16220a = threadFactory;
        this.f16221b = str;
        this.f16222c = atomicLong;
        this.f16223d = bool;
        this.f16224e = num;
        this.f16225f = uncaughtExceptionHandler;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String b2;
        Thread newThread = this.f16220a.newThread(runnable);
        String str = this.f16221b;
        if (str != null) {
            b2 = ThreadFactoryBuilder.b(str, Long.valueOf(this.f16222c.getAndIncrement()));
            newThread.setName(b2);
        }
        Boolean bool = this.f16223d;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.f16224e;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16225f;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }
}
