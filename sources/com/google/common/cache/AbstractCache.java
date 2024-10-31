package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /* loaded from: classes2.dex */
    public static final class SimpleStatsCounter implements StatsCounter {

        /* renamed from: a */
        private final m f15150a = LongAddables.a();

        /* renamed from: b */
        private final m f15151b = LongAddables.a();

        /* renamed from: c */
        private final m f15152c = LongAddables.a();

        /* renamed from: d */
        private final m f15153d = LongAddables.a();

        /* renamed from: e */
        private final m f15154e = LongAddables.a();

        /* renamed from: f */
        private final m f15155f = LongAddables.a();

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a(int i) {
            this.f15150a.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b(int i) {
            this.f15151b.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a(long j) {
            this.f15153d.increment();
            this.f15154e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b(long j) {
            this.f15152c.increment();
            this.f15154e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a() {
            this.f15155f.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats b() {
            return new CacheStats(this.f15150a.sum(), this.f15151b.sum(), this.f15152c.sum(), this.f15153d.sum(), this.f15154e.sum(), this.f15155f.sum());
        }

        public void a(StatsCounter statsCounter) {
            CacheStats b2 = statsCounter.b();
            this.f15150a.add(b2.b());
            this.f15151b.add(b2.e());
            this.f15152c.add(b2.d());
            this.f15153d.add(b2.c());
            this.f15154e.add(b2.f());
            this.f15155f.add(b2.a());
        }
    }

    /* loaded from: classes2.dex */
    public interface StatsCounter {
        void a();

        void a(int i);

        void a(long j);

        CacheStats b();

        void b(int i);

        void b(long j);
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }

    @Override // com.google.common.cache.Cache
    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        V ifPresent;
        LinkedHashMap d2 = Maps.d();
        for (Object obj : iterable) {
            if (!d2.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                d2.put(obj, ifPresent);
            }
        }
        return ImmutableMap.copyOf((Map) d2);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // com.google.common.cache.Cache
    public void put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
