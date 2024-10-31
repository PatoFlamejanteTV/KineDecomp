package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class Futures {

    /* renamed from: a, reason: collision with root package name */
    private static final AsyncFunction<ListenableFuture<Object>, Object> f2964a = new i();
    private static final Ordering<Constructor<?>> b = Ordering.natural().onResultOf(new j()).reverse();

    private Futures() {
    }

    public static <V> ListenableFuture<V> a(@Nullable V v) {
        SettableFuture b2 = SettableFuture.b();
        b2.a((SettableFuture) v);
        return b2;
    }
}
