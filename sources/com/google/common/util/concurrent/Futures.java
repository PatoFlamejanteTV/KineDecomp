package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.p;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class Futures extends o {

    /* renamed from: a */
    private static final AsyncFunction<ListenableFuture<Object>, Object> f16177a = new n();

    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    /* loaded from: classes2.dex */
    public static final class FutureCombiner<V> {
    }

    private Futures() {
    }

    public static <V> ListenableFuture<V> a(@Nullable V v) {
        if (v == null) {
            return p.b.f16207b;
        }
        return new p.b(v);
    }

    public static <V> ListenableFuture<V> a(Throwable th) {
        Preconditions.a(th);
        return new p.a(th);
    }

    public static <I, O> ListenableFuture<O> a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        return l.a((ListenableFuture) listenableFuture, (Function) function);
    }

    @CanIgnoreReturnValue
    public static <V> V a(Future<V> future) throws ExecutionException {
        Preconditions.b(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.a(future);
    }
}
