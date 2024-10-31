package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public interface LoadingCache<K, V> extends Function<K, V>, Cache<K, V> {
    @Override // com.google.common.base.Function
    V apply(K k);

    V get(K k) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k);

    void refresh(K k);
}
