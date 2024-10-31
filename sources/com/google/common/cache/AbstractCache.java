package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    @Beta
    /* loaded from: classes2.dex */
    public interface StatsCounter {
        void a();

        void a(int i);

        void a(long j);

        CacheStats b();

        void b(int i);

        void b(long j);
    }

    @Beta
    /* loaded from: classes2.dex */
    public static final class SimpleStatsCounter implements StatsCounter {

        /* renamed from: a, reason: collision with root package name */
        private final LongAdder f2597a = new LongAdder();
        private final LongAdder b = new LongAdder();
        private final LongAdder c = new LongAdder();
        private final LongAdder d = new LongAdder();
        private final LongAdder e = new LongAdder();
        private final LongAdder f = new LongAdder();

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a(int i) {
            this.f2597a.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b(int i) {
            this.b.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a(long j) {
            this.c.increment();
            this.e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b(long j) {
            this.d.increment();
            this.e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a() {
            this.f.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats b() {
            return new CacheStats(this.f2597a.sum(), this.b.sum(), this.c.sum(), this.d.sum(), this.e.sum(), this.f.sum());
        }

        public void a(StatsCounter statsCounter) {
            CacheStats b = statsCounter.b();
            this.f2597a.add(b.a());
            this.b.add(b.b());
            this.c.add(b.c());
            this.d.add(b.d());
            this.e.add(b.e());
            this.f.add(b.f());
        }
    }
}
