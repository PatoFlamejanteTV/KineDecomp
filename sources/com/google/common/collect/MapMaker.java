package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.ComputingConcurrentHashMap;
import com.google.common.collect.MapMakerInternalMap;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public final class MapMaker extends GenericMapMaker<Object, Object> {
    boolean b;
    MapMakerInternalMap.Strength f;
    MapMakerInternalMap.Strength g;
    RemovalCause j;
    Equivalence<Object> k;
    Ticker l;
    int c = -1;
    int d = -1;
    int e = -1;
    long h = -1;
    long i = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum RemovalCause {
        EXPLICIT { // from class: com.google.common.collect.MapMaker.RemovalCause.1
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return false;
            }
        },
        REPLACED { // from class: com.google.common.collect.MapMaker.RemovalCause.2
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return false;
            }
        },
        COLLECTED { // from class: com.google.common.collect.MapMaker.RemovalCause.3
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        },
        EXPIRED { // from class: com.google.common.collect.MapMaker.RemovalCause.4
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        },
        SIZE { // from class: com.google.common.collect.MapMaker.RemovalCause.5
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        };

        abstract boolean wasEvicted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a<K, V> {
        void onRemoval(RemovalNotification<K, V> removalNotification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public MapMaker a(Equivalence<Object> equivalence) {
        Preconditions.b(this.k == null, "key equivalence was already set to %s", this.k);
        this.k = (Equivalence) Preconditions.a(equivalence);
        this.b = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) Objects.b(this.k, g().defaultEquivalence());
    }

    public MapMaker a(int i) {
        Preconditions.b(this.c == -1, "initial capacity was already set to %s", Integer.valueOf(this.c));
        Preconditions.a(i >= 0);
        this.c = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if (this.c == -1) {
            return 16;
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public MapMaker b(int i) {
        Preconditions.b(this.e == -1, "maximum size was already set to %s", Integer.valueOf(this.e));
        Preconditions.a(i >= 0, "maximum size must not be negative");
        this.e = i;
        this.b = true;
        if (this.e == 0) {
            this.j = RemovalCause.SIZE;
        }
        return this;
    }

    public MapMaker c(int i) {
        Preconditions.b(this.d == -1, "concurrency level was already set to %s", Integer.valueOf(this.d));
        Preconditions.a(i > 0);
        this.d = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        if (this.d == -1) {
            return 4;
        }
        return this.d;
    }

    @GwtIncompatible
    public MapMaker f() {
        return a(MapMakerInternalMap.Strength.WEAK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker a(MapMakerInternalMap.Strength strength) {
        Preconditions.b(this.f == null, "Key strength was already set to %s", this.f);
        this.f = (MapMakerInternalMap.Strength) Preconditions.a(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength g() {
        return (MapMakerInternalMap.Strength) Objects.b(this.f, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker b(MapMakerInternalMap.Strength strength) {
        Preconditions.b(this.g == null, "Value strength was already set to %s", this.g);
        this.g = (MapMakerInternalMap.Strength) Preconditions.a(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength h() {
        return (MapMakerInternalMap.Strength) Objects.b(this.g, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public MapMaker a(long j, TimeUnit timeUnit) {
        c(j, timeUnit);
        this.h = timeUnit.toNanos(j);
        if (j == 0 && this.j == null) {
            this.j = RemovalCause.EXPIRED;
        }
        this.b = true;
        return this;
    }

    private void c(long j, TimeUnit timeUnit) {
        Preconditions.b(this.h == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.h));
        Preconditions.b(this.i == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(this.i));
        Preconditions.a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        if (this.h == -1) {
            return 0L;
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    @Deprecated
    public MapMaker b(long j, TimeUnit timeUnit) {
        c(j, timeUnit);
        this.i = timeUnit.toNanos(j);
        if (j == 0 && this.j == null) {
            this.j = RemovalCause.EXPIRED;
        }
        this.b = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        if (this.i == -1) {
            return 0L;
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ticker k() {
        return (Ticker) Objects.b(this.l, Ticker.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    @Deprecated
    public <K, V> GenericMapMaker<K, V> a(a<K, V> aVar) {
        Preconditions.b(this.f2684a == null);
        this.f2684a = (a) Preconditions.a(aVar);
        this.b = true;
        return this;
    }

    @Override // com.google.common.collect.GenericMapMaker
    public <K, V> ConcurrentMap<K, V> b() {
        if (this.b) {
            return this.j == null ? new MapMakerInternalMap(this) : new NullConcurrentMap(this);
        }
        return new ConcurrentHashMap(d(), 0.75f, e());
    }

    @Deprecated
    public <K, V> ConcurrentMap<K, V> a(Function<? super K, ? extends V> function) {
        return this.j == null ? new ComputingConcurrentHashMap.ComputingMapAdapter(this, function) : new NullComputingConcurrentMap(this, function);
    }

    public String toString() {
        Objects.ToStringHelper a2 = Objects.a(this);
        if (this.c != -1) {
            a2.a("initialCapacity", this.c);
        }
        if (this.d != -1) {
            a2.a("concurrencyLevel", this.d);
        }
        if (this.e != -1) {
            a2.a("maximumSize", this.e);
        }
        if (this.h != -1) {
            a2.a("expireAfterWrite", this.h + "ns");
        }
        if (this.i != -1) {
            a2.a("expireAfterAccess", this.i + "ns");
        }
        if (this.f != null) {
            a2.a("keyStrength", Ascii.a(this.f.toString()));
        }
        if (this.g != null) {
            a2.a("valueStrength", Ascii.a(this.g.toString()));
        }
        if (this.k != null) {
            a2.a((Object) "keyEquivalence");
        }
        if (this.f2684a != null) {
            a2.a((Object) "removalListener");
        }
        return a2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class RemovalNotification<K, V> extends ImmutableEntry<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause cause;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemovalNotification(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
            super(k, v);
            this.cause = removalCause;
        }

        public RemovalCause getCause() {
            return this.cause;
        }

        public boolean wasEvicted() {
            return this.cause.wasEvicted();
        }
    }

    /* loaded from: classes2.dex */
    static class NullConcurrentMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause removalCause;
        private final a<K, V> removalListener;

        NullConcurrentMap(MapMaker mapMaker) {
            this.removalListener = mapMaker.a();
            this.removalCause = mapMaker.j;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@Nullable Object obj) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object obj) {
            return null;
        }

        void notifyRemoval(K k, V v) {
            this.removalListener.onRemoval(new RemovalNotification<>(k, v, this.removalCause));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Preconditions.a(k);
            Preconditions.a(v);
            notifyRemoval(k, v);
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K k, V v) {
            return put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@Nullable Object obj) {
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
            return false;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K k, V v) {
            Preconditions.a(k);
            Preconditions.a(v);
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K k, @Nullable V v, V v2) {
            Preconditions.a(k);
            Preconditions.a(v2);
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }
    }

    /* loaded from: classes2.dex */
    static final class NullComputingConcurrentMap<K, V> extends NullConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        final Function<? super K, ? extends V> computingFunction;

        NullComputingConcurrentMap(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            super(mapMaker);
            this.computingFunction = (Function) Preconditions.a(function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMaker.NullConcurrentMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V a2 = a(obj);
            Preconditions.a(a2, this.computingFunction + " returned null for key " + obj + ".");
            notifyRemoval(obj, a2);
            return a2;
        }

        private V a(K k) {
            Preconditions.a(k);
            try {
                return this.computingFunction.apply(k);
            } catch (ComputationException e) {
                throw e;
            } catch (Throwable th) {
                throw new ComputationException(th);
            }
        }
    }
}
