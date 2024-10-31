package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class SettableFuture<V> extends AbstractFuture.h<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> f() {
        return new SettableFuture<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean a(@Nullable V v) {
        return super.a((SettableFuture<V>) v);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean a(Throwable th) {
        return super.a(th);
    }
}
