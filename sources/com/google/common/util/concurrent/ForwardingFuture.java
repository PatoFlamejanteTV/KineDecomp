package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {

    /* loaded from: classes2.dex */
    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract Future<V> delegate();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return delegate().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return delegate().get(j, timeUnit);
    }
}
