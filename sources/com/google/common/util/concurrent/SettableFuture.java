package com.google.common.util.concurrent;

import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    public static <V> SettableFuture<V> b() {
        return new SettableFuture<>();
    }

    private SettableFuture() {
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean a(@Nullable V v) {
        return super.a((SettableFuture<V>) v);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean a(Throwable th) {
        return super.a(th);
    }
}
