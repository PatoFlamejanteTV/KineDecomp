package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class zzlk {
    private static final ExecutorService zzacD = Executors.newFixedThreadPool(2, new a());

    /* loaded from: classes.dex */
    private static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadFactory f1761a;
        private AtomicInteger b;

        private a() {
            this.f1761a = Executors.defaultThreadFactory();
            this.b = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f1761a.newThread(runnable);
            newThread.setName("GAC_Executor[" + this.b.getAndIncrement() + "]");
            return newThread;
        }
    }

    public static ExecutorService zzoj() {
        return zzacD;
    }
}
