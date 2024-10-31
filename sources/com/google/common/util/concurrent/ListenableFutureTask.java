package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutionList f2965a;

    public static <V> ListenableFutureTask<V> a(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    public static <V> ListenableFutureTask<V> a(Runnable runnable, @Nullable V v) {
        return new ListenableFutureTask<>(runnable, v);
    }

    private ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.f2965a = new ExecutionList();
    }

    private ListenableFutureTask(Runnable runnable, @Nullable V v) {
        super(runnable, v);
        this.f2965a = new ExecutionList();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void a(Runnable runnable, Executor executor) {
        this.f2965a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.f2965a.a();
    }
}
