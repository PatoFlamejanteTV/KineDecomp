package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmediateFuture.java */
/* loaded from: classes2.dex */
public abstract class p<V> implements ListenableFuture<V> {

    /* renamed from: a */
    private static final Logger f16206a = Logger.getLogger(p.class.getName());

    /* compiled from: ImmediateFuture.java */
    /* loaded from: classes2.dex */
    public static final class a<V> extends AbstractFuture.h<V> {
        public a(Throwable th) {
            a(th);
        }
    }

    /* compiled from: ImmediateFuture.java */
    /* loaded from: classes2.dex */
    public static class b<V> extends p<V> {

        /* renamed from: b */
        static final b<Object> f16207b = new b<>(null);

        /* renamed from: c */
        @Nullable
        private final V f16208c;

        public b(@Nullable V v) {
            this.f16208c = v;
        }

        @Override // com.google.common.util.concurrent.p, java.util.concurrent.Future
        public V get() {
            return this.f16208c;
        }
    }

    p() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void a(Runnable runnable, Executor executor) {
        Preconditions.a(runnable, "Runnable was null.");
        Preconditions.a(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f16206a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.a(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
