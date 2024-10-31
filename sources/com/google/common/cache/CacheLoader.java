package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.Map;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {
    public abstract V load(K k) throws Exception;

    @GwtIncompatible
    public ListenableFuture<V> reload(K k, V v) throws Exception {
        return Futures.a(load(k));
    }

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @Beta
    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader(function);
    }

    /* loaded from: classes2.dex */
    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = (Function) Preconditions.a(function);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            return this.computingFunction.apply(k);
        }
    }

    @Beta
    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new SupplierToCacheLoader(supplier);
    }

    /* loaded from: classes2.dex */
    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.computingSupplier = (Supplier) Preconditions.a(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            return this.computingSupplier.get();
        }
    }

    /* loaded from: classes2.dex */
    static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }
}
