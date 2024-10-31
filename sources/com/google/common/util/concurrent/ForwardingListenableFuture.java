package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    /* renamed from: b */
    public abstract ListenableFuture<V> delegate();

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void a(Runnable runnable, Executor executor) {
        delegate().a(runnable, executor);
    }

    /* loaded from: classes2.dex */
    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {

        /* renamed from: a, reason: collision with root package name */
        private final ListenableFuture<V> f2963a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ListenableFuture<V> delegate() {
            return this.f2963a;
        }
    }
}
