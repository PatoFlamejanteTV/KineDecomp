package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrustedListenableFutureTask.java */
@GwtCompatible
/* loaded from: classes2.dex */
public class z<V> extends AbstractFuture.h<V> implements RunnableFuture<V> {

    /* renamed from: h */
    private z<V>.a f16226h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TrustedListenableFutureTask.java */
    /* loaded from: classes2.dex */
    public final class a extends r {

        /* renamed from: e */
        private final Callable<V> f16227e;

        a(Callable<V> callable) {
            Preconditions.a(callable);
            this.f16227e = callable;
        }

        @Override // com.google.common.util.concurrent.r
        void c() {
            if (z.this.isDone()) {
                return;
            }
            try {
                z.this.a((z) this.f16227e.call());
            } catch (Throwable th) {
                z.this.a(th);
            }
        }

        @Override // com.google.common.util.concurrent.r
        boolean d() {
            return z.this.e();
        }

        public String toString() {
            return this.f16227e.toString();
        }
    }

    z(Callable<V> callable) {
        this.f16226h = new a(callable);
    }

    public static <V> z<V> a(Callable<V> callable) {
        return new z<>(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void c() {
        z<V>.a aVar;
        super.c();
        if (e() && (aVar = this.f16226h) != null) {
            aVar.b();
        }
        this.f16226h = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        z<V>.a aVar = this.f16226h;
        if (aVar != null) {
            aVar.run();
        }
    }

    public String toString() {
        return super.toString() + " (delegate = " + this.f16226h + ")";
    }

    public static <V> z<V> a(Runnable runnable, @Nullable V v) {
        return new z<>(Executors.callable(runnable, v));
    }
}
