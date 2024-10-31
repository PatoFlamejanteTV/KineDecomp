package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f15182a = Logger.getLogger(LocalCache.class.getName());

    /* renamed from: b, reason: collision with root package name */
    static final r<Object, Object> f15183b = new com.google.common.cache.d();

    /* renamed from: c, reason: collision with root package name */
    static final Queue<? extends Object> f15184c = new com.google.common.cache.e();

    /* renamed from: d, reason: collision with root package name */
    final int f15185d;

    /* renamed from: e, reason: collision with root package name */
    final int f15186e;

    /* renamed from: f, reason: collision with root package name */
    final Segment<K, V>[] f15187f;

    /* renamed from: g, reason: collision with root package name */
    final int f15188g;

    /* renamed from: h, reason: collision with root package name */
    final Equivalence<Object> f15189h;
    final Equivalence<Object> i;
    final Strength j;
    final Strength k;
    final long l;
    final Weigher<K, V> m;
    final long n;
    final long o;
    final long p;
    final Queue<RemovalNotification<K, V>> q;
    final RemovalListener<K, V> r;
    final Ticker s;
    final EntryFactory t;
    final AbstractCache.StatsCounter u;

    @Nullable
    final CacheLoader<? super K, V> v;
    Set<K> w;
    Collection<V> x;
    Set<Map.Entry<K, V>> y;

    /* loaded from: classes2.dex */
    static final class A<K, V> extends w<K, V> {

        /* renamed from: b, reason: collision with root package name */
        final int f15190b;

        A(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar, int i) {
            super(referenceQueue, v, jVar);
            this.f15190b = i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            return new A(referenceQueue, v, jVar, this.f15190b);
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.r
        public int b() {
            return this.f15190b;
        }
    }

    /* loaded from: classes2.dex */
    static final class B<K, V> extends AbstractQueue<j<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final j<K, V> f15191a = new com.google.common.cache.k(this);

        B() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(j<K, V> jVar) {
            LocalCache.b(jVar.getPreviousInWriteQueue(), jVar.getNextInWriteQueue());
            LocalCache.b(this.f15191a.getPreviousInWriteQueue(), jVar);
            LocalCache.b(jVar, this.f15191a);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            j<K, V> nextInWriteQueue = this.f15191a.getNextInWriteQueue();
            while (true) {
                j<K, V> jVar = this.f15191a;
                if (nextInWriteQueue != jVar) {
                    j<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.b((j) nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    jVar.setNextInWriteQueue(jVar);
                    j<K, V> jVar2 = this.f15191a;
                    jVar2.setPreviousInWriteQueue(jVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((j) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f15191a.getNextInWriteQueue() == this.f15191a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<j<K, V>> iterator() {
            return new com.google.common.cache.l(this, peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            j jVar = (j) obj;
            j<K, V> previousInWriteQueue = jVar.getPreviousInWriteQueue();
            j<K, V> nextInWriteQueue = jVar.getNextInWriteQueue();
            LocalCache.b(previousInWriteQueue, nextInWriteQueue);
            LocalCache.b(jVar);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (j<K, V> nextInWriteQueue = this.f15191a.getNextInWriteQueue(); nextInWriteQueue != this.f15191a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.Queue
        public j<K, V> peek() {
            j<K, V> nextInWriteQueue = this.f15191a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f15191a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        public j<K, V> poll() {
            j<K, V> nextInWriteQueue = this.f15191a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f15191a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class C implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f15192a;

        /* renamed from: b, reason: collision with root package name */
        V f15193b;

        C(K k, V v) {
            this.f15192a = k;
            this.f15193b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f15192a.equals(entry.getKey()) && this.f15193b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f15192a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f15193b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f15192a.hashCode() ^ this.f15193b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.f15192a, v);
            this.f15193b = v;
            return v2;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new n(k, i, jVar);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
                j<K, V> copyEntry = super.copyEntry(segment, jVar, jVar2);
                copyAccessEntry(jVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new l(k, i, jVar);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
                j<K, V> copyEntry = super.copyEntry(segment, jVar, jVar2);
                copyWriteEntry(jVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new p(k, i, jVar);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
                j<K, V> copyEntry = super.copyEntry(segment, jVar, jVar2);
                copyAccessEntry(jVar, copyEntry);
                copyWriteEntry(jVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new m(k, i, jVar);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new v(segment.keyReferenceQueue, k, i, jVar);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
                j<K, V> copyEntry = super.copyEntry(segment, jVar, jVar2);
                copyAccessEntry(jVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new t(segment.keyReferenceQueue, k, i, jVar);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
                j<K, V> copyEntry = super.copyEntry(segment, jVar, jVar2);
                copyWriteEntry(jVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new x(segment.keyReferenceQueue, k, i, jVar);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
                j<K, V> copyEntry = super.copyEntry(segment, jVar, jVar2);
                copyAccessEntry(jVar, copyEntry);
                copyWriteEntry(jVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar) {
                return new u(segment.keyReferenceQueue, k, i, jVar);
            }
        };

        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        <K, V> void copyAccessEntry(j<K, V> jVar, j<K, V> jVar2) {
            jVar2.setAccessTime(jVar.getAccessTime());
            LocalCache.a(jVar.getPreviousInAccessQueue(), jVar2);
            LocalCache.a(jVar2, jVar.getNextInAccessQueue());
            LocalCache.a((j) jVar);
        }

        <K, V> j<K, V> copyEntry(Segment<K, V> segment, j<K, V> jVar, j<K, V> jVar2) {
            return newEntry(segment, jVar.getKey(), jVar.getHash(), jVar2);
        }

        <K, V> void copyWriteEntry(j<K, V> jVar, j<K, V> jVar2) {
            jVar2.setWriteTime(jVar.getWriteTime());
            LocalCache.b(jVar.getPreviousInWriteQueue(), jVar2);
            LocalCache.b(jVar2, jVar.getNextInWriteQueue());
            LocalCache.b((j) jVar);
        }

        abstract <K, V> j<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable j<K, V> jVar);

        /* synthetic */ EntryFactory(com.google.common.cache.d dVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        transient LoadingCache<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (LoadingCache<K, V>) recreateCacheBuilder().a(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, cacheLoader), null);
            Preconditions.a(cacheLoader);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.localCache.b((LocalCache<K, V>) k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.a((Iterable) iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e2) {
                throw new UncheckedExecutionException(e2.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.localCache.d(k);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* synthetic */ LocalManualCache(LocalCache localCache, com.google.common.cache.d dVar) {
            this(localCache);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.a();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            Preconditions.a(callable);
            return this.localCache.a((LocalCache<K, V>) k, (CacheLoader<? super LocalCache<K, V>, V>) new com.google.common.cache.i(this, callable));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.b(iterable);
        }

        @Override // com.google.common.cache.Cache
        @Nullable
        public V getIfPresent(Object obj) {
            return this.localCache.a(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.a(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.c(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.g();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.a(this.localCache.u);
            for (Segment<K, V> segment : this.localCache.f15187f) {
                simpleStatsCounter.a(segment.statsCounter);
            }
            return simpleStatsCounter.b();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    /* loaded from: classes2.dex */
    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.j, localCache.k, localCache.f15189h, localCache.i, localCache.o, localCache.n, localCache.l, localCache.m, localCache.f15188g, localCache.r, localCache.s, localCache.v);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.o().a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).b(this.valueEquivalence).a(this.concurrencyLevel).a(this.removalListener);
            cacheBuilder.f15161f = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.b(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.a(j2, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.weigher;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.a(weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.b(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.a(j4);
                }
            }
            Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilder.a(ticker);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher, int i, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher;
            this.concurrencyLevel = i;
            this.removalListener = removalListener;
            this.ticker = (ticker == Ticker.b() || ticker == CacheBuilder.f15159d) ? null : ticker;
            this.loader = cacheLoader;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum NullEntry implements j<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.LocalCache.j
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.LocalCache.j
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.j
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.j
        public r<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.j
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setNextInAccessQueue(j<Object, Object> jVar) {
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setNextInWriteQueue(j<Object, Object> jVar) {
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setPreviousInAccessQueue(j<Object, Object> jVar) {
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setPreviousInWriteQueue(j<Object, Object> jVar) {
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setValueReference(r<Object, Object> rVar) {
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setWriteTime(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> r<K, V> referenceValue(Segment<K, V> segment, j<K, V> jVar, V v, int i) {
                return i == 1 ? new o(v) : new z(v, i);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> r<K, V> referenceValue(Segment<K, V> segment, j<K, V> jVar, V v, int i) {
                return i == 1 ? new k(segment.valueReferenceQueue, v, jVar) : new y(segment.valueReferenceQueue, v, jVar, i);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> r<K, V> referenceValue(Segment<K, V> segment, j<K, V> jVar, V v, int i) {
                return i == 1 ? new w(segment.valueReferenceQueue, v, jVar) : new A(segment.valueReferenceQueue, v, jVar, i);
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> r<K, V> referenceValue(Segment<K, V> segment, j<K, V> jVar, V v, int i);

        /* synthetic */ Strength(com.google.common.cache.d dVar) {
            this();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache$a, reason: case insensitive filesystem */
    /* loaded from: classes2.dex */
    abstract class AbstractC1486a<T> extends AbstractSet<T> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        final ConcurrentMap<?, ?> f15195a;

        AbstractC1486a(ConcurrentMap<?, ?> concurrentMap) {
            this.f15195a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f15195a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f15195a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f15195a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.b((Collection) this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.b((Collection) this).toArray(eArr);
        }
    }

    /* renamed from: com.google.common.cache.LocalCache$b, reason: case insensitive filesystem */
    /* loaded from: classes2.dex */
    static abstract class AbstractC1487b<K, V> implements j<K, V> {
        @Override // com.google.common.cache.LocalCache.j
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public r<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setNextInAccessQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setNextInWriteQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setPreviousInAccessQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setPreviousInWriteQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setValueReference(r<K, V> rVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache$c, reason: case insensitive filesystem */
    /* loaded from: classes2.dex */
    static final class C1488c<K, V> extends AbstractQueue<j<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final j<K, V> f15197a = new com.google.common.cache.f(this);

        C1488c() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(j<K, V> jVar) {
            LocalCache.a(jVar.getPreviousInAccessQueue(), jVar.getNextInAccessQueue());
            LocalCache.a(this.f15197a.getPreviousInAccessQueue(), jVar);
            LocalCache.a(jVar, this.f15197a);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            j<K, V> nextInAccessQueue = this.f15197a.getNextInAccessQueue();
            while (true) {
                j<K, V> jVar = this.f15197a;
                if (nextInAccessQueue != jVar) {
                    j<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.a((j) nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    jVar.setNextInAccessQueue(jVar);
                    j<K, V> jVar2 = this.f15197a;
                    jVar2.setPreviousInAccessQueue(jVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((j) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f15197a.getNextInAccessQueue() == this.f15197a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<j<K, V>> iterator() {
            return new com.google.common.cache.g(this, peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            j jVar = (j) obj;
            j<K, V> previousInAccessQueue = jVar.getPreviousInAccessQueue();
            j<K, V> nextInAccessQueue = jVar.getNextInAccessQueue();
            LocalCache.a(previousInAccessQueue, nextInAccessQueue);
            LocalCache.a(jVar);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (j<K, V> nextInAccessQueue = this.f15197a.getNextInAccessQueue(); nextInAccessQueue != this.f15197a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.Queue
        public j<K, V> peek() {
            j<K, V> nextInAccessQueue = this.f15197a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f15197a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        public j<K, V> poll() {
            j<K, V> nextInAccessQueue = this.f15197a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f15197a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }
    }

    /* loaded from: classes2.dex */
    final class d extends LocalCache<K, V>.f<Map.Entry<K, V>> {
        d() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: classes2.dex */
    final class e extends LocalCache<K, V>.AbstractC1486a<Map.Entry<K, V>> {
        e(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.i.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class f<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        int f15199a;

        /* renamed from: b, reason: collision with root package name */
        int f15200b = -1;

        /* renamed from: c, reason: collision with root package name */
        Segment<K, V> f15201c;

        /* renamed from: d, reason: collision with root package name */
        AtomicReferenceArray<j<K, V>> f15202d;

        /* renamed from: e, reason: collision with root package name */
        j<K, V> f15203e;

        /* renamed from: f, reason: collision with root package name */
        LocalCache<K, V>.C f15204f;

        /* renamed from: g, reason: collision with root package name */
        LocalCache<K, V>.C f15205g;

        f() {
            this.f15199a = LocalCache.this.f15187f.length - 1;
            b();
        }

        boolean a(j<K, V> jVar) {
            boolean z;
            try {
                long a2 = LocalCache.this.s.a();
                K key = jVar.getKey();
                Object a3 = LocalCache.this.a(jVar, a2);
                if (a3 != null) {
                    this.f15204f = new C(key, a3);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.f15201c.postReadCleanup();
            }
        }

        final void b() {
            this.f15204f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.f15199a;
                if (i < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.f15187f;
                this.f15199a = i - 1;
                this.f15201c = segmentArr[i];
                if (this.f15201c.count != 0) {
                    this.f15202d = this.f15201c.table;
                    this.f15200b = this.f15202d.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        LocalCache<K, V>.C c() {
            LocalCache<K, V>.C c2 = this.f15204f;
            if (c2 != null) {
                this.f15205g = c2;
                b();
                return this.f15205g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            j<K, V> jVar = this.f15203e;
            if (jVar == null) {
                return false;
            }
            while (true) {
                this.f15203e = jVar.getNext();
                j<K, V> jVar2 = this.f15203e;
                if (jVar2 == null) {
                    return false;
                }
                if (a(jVar2)) {
                    return true;
                }
                jVar = this.f15203e;
            }
        }

        boolean e() {
            while (true) {
                int i = this.f15200b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.f15202d;
                this.f15200b = i - 1;
                j<K, V> jVar = atomicReferenceArray.get(i);
                this.f15203e = jVar;
                if (jVar != null && (a(this.f15203e) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15204f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b(this.f15205g != null);
            LocalCache.this.remove(this.f15205g.getKey());
            this.f15205g = null;
        }
    }

    /* loaded from: classes2.dex */
    final class g extends LocalCache<K, V>.f<K> {
        g() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes2.dex */
    final class h extends LocalCache<K, V>.AbstractC1486a<K> {
        h(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f15195a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f15195a.remove(obj) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i<K, V> implements r<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile r<K, V> f15208a;

        /* renamed from: b, reason: collision with root package name */
        final SettableFuture<V> f15209b;

        /* renamed from: c, reason: collision with root package name */
        final Stopwatch f15210c;

        public i() {
            this(LocalCache.n());
        }

        @Override // com.google.common.cache.LocalCache.r
        public j<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, @Nullable V v, j<K, V> jVar) {
            return this;
        }

        public boolean a(Throwable th) {
            return this.f15209b.a(th);
        }

        @Override // com.google.common.cache.LocalCache.r
        public int b() {
            return this.f15208a.b();
        }

        @Override // com.google.common.cache.LocalCache.r
        public V c() throws ExecutionException {
            return (V) Uninterruptibles.a(this.f15209b);
        }

        public long d() {
            return this.f15210c.a(TimeUnit.NANOSECONDS);
        }

        public r<K, V> e() {
            return this.f15208a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V get() {
            return this.f15208a.get();
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isActive() {
            return this.f15208a.isActive();
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isLoading() {
            return true;
        }

        public i(r<K, V> rVar) {
            this.f15209b = SettableFuture.f();
            this.f15210c = Stopwatch.b();
            this.f15208a = rVar;
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(@Nullable V v) {
            if (v != null) {
                b((i<K, V>) v);
            } else {
                this.f15208a = LocalCache.n();
            }
        }

        public boolean b(@Nullable V v) {
            return this.f15209b.a((SettableFuture<V>) v);
        }

        private ListenableFuture<V> b(Throwable th) {
            return Futures.a(th);
        }

        public ListenableFuture<V> a(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f15210c.d();
                V v = this.f15208a.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return b((i<K, V>) load) ? this.f15209b : Futures.a(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k, v);
                if (reload == null) {
                    return Futures.a((Object) null);
                }
                return Futures.a(reload, new com.google.common.cache.h(this));
            } catch (Throwable th) {
                ListenableFuture<V> b2 = a(th) ? this.f15209b : b(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return b2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface j<K, V> {
        long getAccessTime();

        int getHash();

        @Nullable
        K getKey();

        @Nullable
        j<K, V> getNext();

        j<K, V> getNextInAccessQueue();

        j<K, V> getNextInWriteQueue();

        j<K, V> getPreviousInAccessQueue();

        j<K, V> getPreviousInWriteQueue();

        r<K, V> getValueReference();

        long getWriteTime();

        void setAccessTime(long j);

        void setNextInAccessQueue(j<K, V> jVar);

        void setNextInWriteQueue(j<K, V> jVar);

        void setPreviousInAccessQueue(j<K, V> jVar);

        void setPreviousInWriteQueue(j<K, V> jVar);

        void setValueReference(r<K, V> rVar);

        void setWriteTime(long j);
    }

    /* loaded from: classes2.dex */
    static class k<K, V> extends SoftReference<V> implements r<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final j<K, V> f15211a;

        k(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            super(v, referenceQueue);
            this.f15211a = jVar;
        }

        @Override // com.google.common.cache.LocalCache.r
        public j<K, V> a() {
            return this.f15211a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.r
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            return new k(referenceQueue, v, jVar);
        }
    }

    /* loaded from: classes2.dex */
    static final class l<K, V> extends n<K, V> {

        /* renamed from: e, reason: collision with root package name */
        volatile long f15212e;

        /* renamed from: f, reason: collision with root package name */
        j<K, V> f15213f;

        /* renamed from: g, reason: collision with root package name */
        j<K, V> f15214g;

        l(K k, int i, @Nullable j<K, V> jVar) {
            super(k, i, jVar);
            this.f15212e = Long.MAX_VALUE;
            this.f15213f = LocalCache.h();
            this.f15214g = LocalCache.h();
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public long getAccessTime() {
            return this.f15212e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInAccessQueue() {
            return this.f15213f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInAccessQueue() {
            return this.f15214g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setAccessTime(long j) {
            this.f15212e = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setNextInAccessQueue(j<K, V> jVar) {
            this.f15213f = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setPreviousInAccessQueue(j<K, V> jVar) {
            this.f15214g = jVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class m<K, V> extends n<K, V> {

        /* renamed from: e, reason: collision with root package name */
        volatile long f15215e;

        /* renamed from: f, reason: collision with root package name */
        j<K, V> f15216f;

        /* renamed from: g, reason: collision with root package name */
        j<K, V> f15217g;

        /* renamed from: h, reason: collision with root package name */
        volatile long f15218h;
        j<K, V> i;
        j<K, V> j;

        m(K k, int i, @Nullable j<K, V> jVar) {
            super(k, i, jVar);
            this.f15215e = Long.MAX_VALUE;
            this.f15216f = LocalCache.h();
            this.f15217g = LocalCache.h();
            this.f15218h = Long.MAX_VALUE;
            this.i = LocalCache.h();
            this.j = LocalCache.h();
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public long getAccessTime() {
            return this.f15215e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInAccessQueue() {
            return this.f15216f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInAccessQueue() {
            return this.f15217g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInWriteQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public long getWriteTime() {
            return this.f15218h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setAccessTime(long j) {
            this.f15215e = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setNextInAccessQueue(j<K, V> jVar) {
            this.f15216f = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setNextInWriteQueue(j<K, V> jVar) {
            this.i = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setPreviousInAccessQueue(j<K, V> jVar) {
            this.f15217g = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setPreviousInWriteQueue(j<K, V> jVar) {
            this.j = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setWriteTime(long j) {
            this.f15218h = j;
        }
    }

    /* loaded from: classes2.dex */
    static class n<K, V> extends AbstractC1487b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f15219a;

        /* renamed from: b, reason: collision with root package name */
        final int f15220b;

        /* renamed from: c, reason: collision with root package name */
        final j<K, V> f15221c;

        /* renamed from: d, reason: collision with root package name */
        volatile r<K, V> f15222d = LocalCache.n();

        n(K k, int i, @Nullable j<K, V> jVar) {
            this.f15219a = k;
            this.f15220b = i;
            this.f15221c = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public int getHash() {
            return this.f15220b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public K getKey() {
            return this.f15219a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getNext() {
            return this.f15221c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public r<K, V> getValueReference() {
            return this.f15222d;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setValueReference(r<K, V> rVar) {
            this.f15222d = rVar;
        }
    }

    /* loaded from: classes2.dex */
    static class o<K, V> implements r<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final V f15223a;

        o(V v) {
            this.f15223a = v;
        }

        @Override // com.google.common.cache.LocalCache.r
        public j<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.r
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.r
        public V get() {
            return this.f15223a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isLoading() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class p<K, V> extends n<K, V> {

        /* renamed from: e, reason: collision with root package name */
        volatile long f15224e;

        /* renamed from: f, reason: collision with root package name */
        j<K, V> f15225f;

        /* renamed from: g, reason: collision with root package name */
        j<K, V> f15226g;

        p(K k, int i, @Nullable j<K, V> jVar) {
            super(k, i, jVar);
            this.f15224e = Long.MAX_VALUE;
            this.f15225f = LocalCache.h();
            this.f15226g = LocalCache.h();
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInWriteQueue() {
            return this.f15225f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInWriteQueue() {
            return this.f15226g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public long getWriteTime() {
            return this.f15224e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setNextInWriteQueue(j<K, V> jVar) {
            this.f15225f = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setPreviousInWriteQueue(j<K, V> jVar) {
            this.f15226g = jVar;
        }

        @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
        public void setWriteTime(long j) {
            this.f15224e = j;
        }
    }

    /* loaded from: classes2.dex */
    final class q extends LocalCache<K, V>.f<V> {
        q() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface r<K, V> {
        @Nullable
        j<K, V> a();

        r<K, V> a(ReferenceQueue<V> referenceQueue, @Nullable V v, j<K, V> jVar);

        void a(@Nullable V v);

        int b();

        V c() throws ExecutionException;

        @Nullable
        V get();

        boolean isActive();

        boolean isLoading();
    }

    /* loaded from: classes2.dex */
    final class s extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        private final ConcurrentMap<?, ?> f15227a;

        s(ConcurrentMap<?, ?> concurrentMap) {
            this.f15227a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f15227a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f15227a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f15227a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new q();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f15227a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.b((Collection) this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.b((Collection) this).toArray(eArr);
        }
    }

    /* loaded from: classes2.dex */
    static final class t<K, V> extends v<K, V> {

        /* renamed from: d, reason: collision with root package name */
        volatile long f15229d;

        /* renamed from: e, reason: collision with root package name */
        j<K, V> f15230e;

        /* renamed from: f, reason: collision with root package name */
        j<K, V> f15231f;

        t(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable j<K, V> jVar) {
            super(referenceQueue, k, i, jVar);
            this.f15229d = Long.MAX_VALUE;
            this.f15230e = LocalCache.h();
            this.f15231f = LocalCache.h();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public long getAccessTime() {
            return this.f15229d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInAccessQueue() {
            return this.f15230e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInAccessQueue() {
            return this.f15231f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setAccessTime(long j) {
            this.f15229d = j;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setNextInAccessQueue(j<K, V> jVar) {
            this.f15230e = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setPreviousInAccessQueue(j<K, V> jVar) {
            this.f15231f = jVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class u<K, V> extends v<K, V> {

        /* renamed from: d, reason: collision with root package name */
        volatile long f15232d;

        /* renamed from: e, reason: collision with root package name */
        j<K, V> f15233e;

        /* renamed from: f, reason: collision with root package name */
        j<K, V> f15234f;

        /* renamed from: g, reason: collision with root package name */
        volatile long f15235g;

        /* renamed from: h, reason: collision with root package name */
        j<K, V> f15236h;
        j<K, V> i;

        u(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable j<K, V> jVar) {
            super(referenceQueue, k, i, jVar);
            this.f15232d = Long.MAX_VALUE;
            this.f15233e = LocalCache.h();
            this.f15234f = LocalCache.h();
            this.f15235g = Long.MAX_VALUE;
            this.f15236h = LocalCache.h();
            this.i = LocalCache.h();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public long getAccessTime() {
            return this.f15232d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInAccessQueue() {
            return this.f15233e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInWriteQueue() {
            return this.f15236h;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInAccessQueue() {
            return this.f15234f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public long getWriteTime() {
            return this.f15235g;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setAccessTime(long j) {
            this.f15232d = j;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setNextInAccessQueue(j<K, V> jVar) {
            this.f15233e = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setNextInWriteQueue(j<K, V> jVar) {
            this.f15236h = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setPreviousInAccessQueue(j<K, V> jVar) {
            this.f15234f = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setPreviousInWriteQueue(j<K, V> jVar) {
            this.i = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setWriteTime(long j) {
            this.f15235g = j;
        }
    }

    /* loaded from: classes2.dex */
    static class v<K, V> extends WeakReference<K> implements j<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final int f15237a;

        /* renamed from: b, reason: collision with root package name */
        final j<K, V> f15238b;

        /* renamed from: c, reason: collision with root package name */
        volatile r<K, V> f15239c;

        v(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable j<K, V> jVar) {
            super(k, referenceQueue);
            this.f15239c = LocalCache.n();
            this.f15237a = i;
            this.f15238b = jVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public int getHash() {
            return this.f15237a;
        }

        @Override // com.google.common.cache.LocalCache.j
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.j
        public j<K, V> getNext() {
            return this.f15238b;
        }

        public j<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public j<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public j<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public j<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public r<K, V> getValueReference() {
            return this.f15239c;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(j<K, V> jVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.j
        public void setValueReference(r<K, V> rVar) {
            this.f15239c = rVar;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes2.dex */
    static class w<K, V> extends WeakReference<V> implements r<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final j<K, V> f15240a;

        w(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            super(v, referenceQueue);
            this.f15240a = jVar;
        }

        @Override // com.google.common.cache.LocalCache.r
        public j<K, V> a() {
            return this.f15240a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V v) {
        }

        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean isLoading() {
            return false;
        }

        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            return new w(referenceQueue, v, jVar);
        }
    }

    /* loaded from: classes2.dex */
    static final class x<K, V> extends v<K, V> {

        /* renamed from: d, reason: collision with root package name */
        volatile long f15241d;

        /* renamed from: e, reason: collision with root package name */
        j<K, V> f15242e;

        /* renamed from: f, reason: collision with root package name */
        j<K, V> f15243f;

        x(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable j<K, V> jVar) {
            super(referenceQueue, k, i, jVar);
            this.f15241d = Long.MAX_VALUE;
            this.f15242e = LocalCache.h();
            this.f15243f = LocalCache.h();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getNextInWriteQueue() {
            return this.f15242e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public j<K, V> getPreviousInWriteQueue() {
            return this.f15243f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public long getWriteTime() {
            return this.f15241d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setNextInWriteQueue(j<K, V> jVar) {
            this.f15242e = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setPreviousInWriteQueue(j<K, V> jVar) {
            this.f15243f = jVar;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.j
        public void setWriteTime(long j) {
            this.f15241d = j;
        }
    }

    /* loaded from: classes2.dex */
    static final class y<K, V> extends k<K, V> {

        /* renamed from: b, reason: collision with root package name */
        final int f15244b;

        y(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar, int i) {
            super(referenceQueue, v, jVar);
            this.f15244b = i;
        }

        @Override // com.google.common.cache.LocalCache.k, com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, j<K, V> jVar) {
            return new y(referenceQueue, v, jVar, this.f15244b);
        }

        @Override // com.google.common.cache.LocalCache.k, com.google.common.cache.LocalCache.r
        public int b() {
            return this.f15244b;
        }
    }

    /* loaded from: classes2.dex */
    static final class z<K, V> extends o<K, V> {

        /* renamed from: b, reason: collision with root package name */
        final int f15245b;

        z(V v, int i) {
            super(v);
            this.f15245b = i;
        }

        @Override // com.google.common.cache.LocalCache.o, com.google.common.cache.LocalCache.r
        public int b() {
            return this.f15245b;
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @Nullable CacheLoader<? super K, V> cacheLoader) {
        this.f15188g = Math.min(cacheBuilder.b(), 65536);
        this.j = cacheBuilder.g();
        this.k = cacheBuilder.m();
        this.f15189h = cacheBuilder.f();
        this.i = cacheBuilder.l();
        this.l = cacheBuilder.h();
        this.m = (Weigher<K, V>) cacheBuilder.n();
        this.n = cacheBuilder.c();
        this.o = cacheBuilder.d();
        this.p = cacheBuilder.i();
        this.r = (RemovalListener<K, V>) cacheBuilder.j();
        this.q = this.r == CacheBuilder.NullListener.INSTANCE ? c() : new ConcurrentLinkedQueue<>();
        this.s = cacheBuilder.a(k());
        this.t = EntryFactory.getFactory(this.j, o(), s());
        this.u = cacheBuilder.k().get();
        this.v = cacheLoader;
        int min = Math.min(cacheBuilder.e(), 1073741824);
        if (d() && !b()) {
            min = Math.min(min, (int) this.l);
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.f15188g && (!d() || i4 * 20 <= this.l)) {
            i5++;
            i4 <<= 1;
        }
        this.f15186e = 32 - i5;
        this.f15185d = i4 - 1;
        this.f15187f = a(i4);
        int i6 = min / i4;
        while (i3 < (i6 * i4 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (d()) {
            long j2 = this.l;
            long j3 = i4;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (i2 < this.f15187f.length) {
                if (i2 == j5) {
                    j4--;
                }
                this.f15187f[i2] = a(i3, j4, cacheBuilder.k().get());
                i2++;
            }
            return;
        }
        while (true) {
            Segment<K, V>[] segmentArr = this.f15187f;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = a(i3, -1L, cacheBuilder.k().get());
            i2++;
        }
    }

    static int b(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    static <E> Queue<E> c() {
        return (Queue<E>) f15184c;
    }

    static <K, V> j<K, V> h() {
        return NullEntry.INSTANCE;
    }

    static <K, V> r<K, V> n() {
        return (r<K, V>) f15183b;
    }

    boolean b() {
        return this.m != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f15187f) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int c2 = c(obj);
        return c(c2).containsKey(obj, c2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        long j2;
        if (obj == null) {
            return false;
        }
        long a2 = this.s.a();
        Segment<K, V>[] segmentArr = this.f15187f;
        long j3 = -1;
        int i2 = 0;
        while (i2 < 3) {
            int length = segmentArr.length;
            long j4 = 0;
            int i3 = 0;
            while (i3 < length) {
                Segment<K, V> segment = segmentArr[i3];
                int i4 = segment.count;
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = segment.table;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    j<K, V> jVar = atomicReferenceArray.get(i5);
                    while (jVar != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(jVar, a2);
                        if (liveValue != null) {
                            j2 = a2;
                            if (this.i.equivalent(obj, liveValue)) {
                                return true;
                            }
                        } else {
                            j2 = a2;
                        }
                        jVar = jVar.getNext();
                        segmentArr = segmentArr2;
                        a2 = j2;
                    }
                }
                j4 += segment.modCount;
                i3++;
                a2 = a2;
            }
            long j5 = a2;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j4 == j3) {
                return false;
            }
            i2++;
            j3 = j4;
            segmentArr = segmentArr3;
            a2 = j5;
        }
        return false;
    }

    boolean d() {
        return this.l >= 0;
    }

    boolean e() {
        return this.n > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.y;
        if (set != null) {
            return set;
        }
        e eVar = new e(this);
        this.y = eVar;
        return eVar;
    }

    boolean f() {
        return this.o > 0;
    }

    long g() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.f15187f.length; i2++) {
            j2 += Math.max(0, r0[i2].count);
        }
        return j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int c2 = c(obj);
        return c(c2).get(obj, c2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @Nullable
    public V getOrDefault(@Nullable Object obj, @Nullable V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    void i() {
        while (true) {
            RemovalNotification<K, V> poll = this.q.poll();
            if (poll == null) {
                return;
            }
            try {
                this.r.onRemoval(poll);
            } catch (Throwable th) {
                f15182a.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f15187f;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += segmentArr[i2].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].count != 0) {
                return false;
            }
            j2 -= segmentArr[i3].modCount;
        }
        return j2 == 0;
    }

    boolean j() {
        return e();
    }

    boolean k() {
        return l() || j();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.w;
        if (set != null) {
            return set;
        }
        h hVar = new h(this);
        this.w = hVar;
        return hVar;
    }

    boolean l() {
        return f() || m();
    }

    boolean m() {
        return this.p > 0;
    }

    boolean o() {
        return p() || j();
    }

    boolean p() {
        return e() || d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int c2 = c(k2);
        return c(c2).put(k2, c2, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int c2 = c(k2);
        return c(c2).put(k2, c2, v2, true);
    }

    boolean q() {
        return this.j != Strength.STRONG;
    }

    boolean r() {
        return this.k != Strength.STRONG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int c2 = c(obj);
        return c(c2).remove(obj, c2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @Nullable V v2, V v3) {
        Preconditions.a(k2);
        Preconditions.a(v3);
        if (v2 == null) {
            return false;
        }
        int c2 = c(k2);
        return c(c2).replace(k2, c2, v2, v3);
    }

    boolean s() {
        return t() || l();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.b(g());
    }

    boolean t() {
        return f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.x;
        if (collection != null) {
            return collection;
        }
        s sVar = new s(this);
        this.x = sVar;
        return sVar;
    }

    void a(r<K, V> rVar) {
        j<K, V> a2 = rVar.a();
        int hash = a2.getHash();
        c(hash).reclaimValue(a2.getKey(), hash, rVar);
    }

    boolean b(j<K, V> jVar, long j2) {
        Preconditions.a(jVar);
        if (!e() || j2 - jVar.getAccessTime() < this.n) {
            return f() && j2 - jVar.getWriteTime() >= this.o;
        }
        return true;
    }

    int c(@Nullable Object obj) {
        return b(this.f15189h.hash(obj));
    }

    void d(K k2) {
        Preconditions.a(k2);
        int c2 = c(k2);
        c(c2).refresh(k2, c2, this.v, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int c2 = c(obj);
        return c(c2).remove(obj, c2, obj2);
    }

    void c(j<K, V> jVar) {
        int hash = jVar.getHash();
        c(hash).reclaimKey(jVar, hash);
    }

    static <K, V> void b(j<K, V> jVar, j<K, V> jVar2) {
        jVar.setNextInWriteQueue(jVar2);
        jVar2.setPreviousInWriteQueue(jVar);
    }

    Segment<K, V> a(int i2, long j2, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i2, j2, statsCounter);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int c2 = c(k2);
        return c(c2).replace(k2, c2, v2);
    }

    @Nullable
    V a(j<K, V> jVar, long j2) {
        V v2;
        if (jVar.getKey() == null || (v2 = jVar.getValueReference().get()) == null || b(jVar, j2)) {
            return null;
        }
        return v2;
    }

    Segment<K, V> c(int i2) {
        return this.f15187f[(i2 >>> this.f15186e) & this.f15185d];
    }

    static <K, V> void b(j<K, V> jVar) {
        j<K, V> h2 = h();
        jVar.setNextInWriteQueue(h2);
        jVar.setPreviousInWriteQueue(h2);
    }

    void c(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    static <K, V> void a(j<K, V> jVar, j<K, V> jVar2) {
        jVar.setNextInAccessQueue(jVar2);
        jVar2.setPreviousInAccessQueue(jVar);
    }

    V b(K k2) throws ExecutionException {
        return a((LocalCache<K, V>) k2, (CacheLoader<? super LocalCache<K, V>, V>) this.v);
    }

    static <K, V> void a(j<K, V> jVar) {
        j<K, V> h2 = h();
        jVar.setNextInAccessQueue(h2);
        jVar.setPreviousInAccessQueue(h2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> b(Iterable<?> iterable) {
        LinkedHashMap d2 = Maps.d();
        int i2 = 0;
        int i3 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i3++;
            } else {
                d2.put(obj, v2);
                i2++;
            }
        }
        this.u.a(i2);
        this.u.b(i3);
        return ImmutableMap.copyOf((Map) d2);
    }

    final Segment<K, V>[] a(int i2) {
        return new Segment[i2];
    }

    public void a() {
        for (Segment<K, V> segment : this.f15187f) {
            segment.cleanUp();
        }
    }

    @Nullable
    public V a(Object obj) {
        Preconditions.a(obj);
        int c2 = c(obj);
        V v2 = c(c2).get(obj, c2);
        if (v2 == null) {
            this.u.b(1);
        } else {
            this.u.a(1);
        }
        return v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> b(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    V a(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        Preconditions.a(k2);
        int c2 = c(k2);
        return c(c2).get(k2, c2, cacheLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Segment<K, V> extends ReentrantLock {
        final Queue<j<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<j<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        volatile AtomicReferenceArray<j<K, V>> table;
        int threshold;
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<j<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache.StatsCounter statsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            Preconditions.a(statsCounter);
            this.statsCounter = statsCounter;
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.q() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.r() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.p() ? new ConcurrentLinkedQueue<>() : LocalCache.c();
            this.writeQueue = localCache.t() ? new B<>() : LocalCache.c();
            this.accessQueue = localCache.p() ? new C1488c<>() : LocalCache.c();
        }

        void cleanUp() {
            runLockedCleanup(this.map.s.a());
            runUnlockedCleanup();
        }

        void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.s.a());
                    AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (j<K, V> jVar = atomicReferenceArray.get(i); jVar != null; jVar = jVar.getNext()) {
                            if (jVar.getValueReference().isActive()) {
                                K key = jVar.getKey();
                                V v = jVar.getValueReference().get();
                                if (key != null && v != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, jVar.getHash(), v, jVar.getValueReference().b(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, jVar.getHash(), v, jVar.getValueReference().b(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        void clearReferenceQueues() {
            if (this.map.q()) {
                clearKeyReferenceQueue();
            }
            if (this.map.r()) {
                clearValueReferenceQueue();
            }
        }

        void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        boolean containsKey(Object obj, int i) {
            try {
                if (this.count == 0) {
                    return false;
                }
                j<K, V> liveEntry = getLiveEntry(obj, i, this.map.s.a());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a2 = this.map.s.a();
                    AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (j<K, V> jVar = atomicReferenceArray.get(i); jVar != null; jVar = jVar.getNext()) {
                            V liveValue = getLiveValue(jVar, a2);
                            if (liveValue != null && this.map.i.equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        j<K, V> copyEntry(j<K, V> jVar, j<K, V> jVar2) {
            if (jVar.getKey() == null) {
                return null;
            }
            r<K, V> valueReference = jVar.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            j<K, V> copyEntry = this.map.t.copyEntry(this, jVar, jVar2);
            copyEntry.setValueReference(valueReference.a(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.c((j) poll);
                i++;
            } while (i != 16);
        }

        void drainRecencyQueue() {
            while (true) {
                j<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        void drainReferenceQueues() {
            if (this.map.q()) {
                drainKeyReferenceQueue();
            }
            if (this.map.r()) {
                drainValueReferenceQueue();
            }
        }

        void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.a((r) poll);
                i++;
            } while (i != 16);
        }

        void enqueueNotification(@Nullable K k, int i, @Nullable V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.a();
            }
            if (this.map.q != LocalCache.f15184c) {
                this.map.q.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        void evictEntries(j<K, V> jVar) {
            if (this.map.d()) {
                drainRecencyQueue();
                if (jVar.getValueReference().b() > this.maxSegmentWeight && !removeEntry(jVar, jVar.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    j<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        void expand() {
            AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<j<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                j<K, V> jVar = atomicReferenceArray.get(i2);
                if (jVar != null) {
                    j<K, V> next = jVar.getNext();
                    int hash = jVar.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, jVar);
                    } else {
                        j<K, V> jVar2 = jVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                jVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, jVar2);
                        while (jVar != jVar2) {
                            int hash3 = jVar.getHash() & length2;
                            j<K, V> copyEntry = copyEntry(jVar, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(jVar);
                                i--;
                            }
                            jVar = jVar.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i;
        }

        void expireEntries(long j) {
            j<K, V> peek;
            j<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.b(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.b(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            j<K, V> entry;
            Preconditions.a(k);
            Preconditions.a(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                        long a2 = this.map.s.a();
                        V liveValue = getLiveValue(entry, a2);
                        if (liveValue != null) {
                            recordRead(entry, a2);
                            this.statsCounter.a(1);
                            return scheduleRefresh(entry, k, i, liveValue, a2, cacheLoader);
                        }
                        r<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            return waitForLoadingValue(entry, k, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k, i, cacheLoader);
                } catch (ExecutionException e2) {
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof Error)) {
                        if (cause instanceof RuntimeException) {
                            throw new UncheckedExecutionException(cause);
                        }
                        throw e2;
                    }
                    throw new ExecutionError((Error) cause);
                }
            } finally {
                postReadCleanup();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public V getAndRecordStats(K k, int i, i<K, V> iVar, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v;
            try {
                v = (V) Uninterruptibles.a(listenableFuture);
            } catch (Throwable th) {
                th = th;
                v = null;
            }
            try {
                if (v != null) {
                    this.statsCounter.b(iVar.d());
                    storeLoadedValue(k, i, iVar, v);
                    if (v == null) {
                        this.statsCounter.a(iVar.d());
                        removeLoadingValue(k, i, iVar);
                    }
                    return v;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
            } catch (Throwable th2) {
                th = th2;
                if (v == null) {
                    this.statsCounter.a(iVar.d());
                    removeLoadingValue(k, i, iVar);
                }
                throw th;
            }
        }

        @Nullable
        j<K, V> getEntry(Object obj, int i) {
            for (j<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f15189h.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        j<K, V> getFirst(int i) {
            return this.table.get(i & (r0.length() - 1));
        }

        @Nullable
        j<K, V> getLiveEntry(Object obj, int i, long j) {
            j<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.b(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        V getLiveValue(j<K, V> jVar, long j) {
            if (jVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = jVar.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.b(jVar, j)) {
                return v;
            }
            tryExpireEntries(j);
            return null;
        }

        j<K, V> getNextEvictable() {
            for (j<K, V> jVar : this.accessQueue) {
                if (jVar.getValueReference().b() > 0) {
                    return jVar;
                }
            }
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<j<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.b()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        @Nullable
        i<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long a2 = this.map.s.a();
                preWriteCleanup(a2);
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                j<K, V> jVar = (j) atomicReferenceArray.get(length);
                for (j jVar2 = jVar; jVar2 != null; jVar2 = jVar2.getNext()) {
                    Object key = jVar2.getKey();
                    if (jVar2.getHash() == i && key != null && this.map.f15189h.equivalent(k, key)) {
                        r<K, V> valueReference = jVar2.getValueReference();
                        if (!valueReference.isLoading() && (!z || a2 - jVar2.getWriteTime() >= this.map.p)) {
                            this.modCount++;
                            i<K, V> iVar = new i<>(valueReference);
                            jVar2.setValueReference(iVar);
                            return iVar;
                        }
                        return null;
                    }
                }
                this.modCount++;
                i<K, V> iVar2 = new i<>();
                j<K, V> newEntry = newEntry(k, i, jVar);
                newEntry.setValueReference(iVar2);
                atomicReferenceArray.set(length, newEntry);
                return iVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        ListenableFuture<V> loadAsync(K k, int i, i<K, V> iVar, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> a2 = iVar.a(k, cacheLoader);
            a2.a(new com.google.common.cache.j(this, k, i, iVar, a2), MoreExecutors.a());
            return a2;
        }

        V loadSync(K k, int i, i<K, V> iVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, iVar, iVar.a(k, cacheLoader));
        }

        V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            i<K, V> iVar;
            r<K, V> rVar;
            boolean z;
            V loadSync;
            lock();
            try {
                long a2 = this.map.s.a();
                preWriteCleanup(a2);
                int i2 = this.count - 1;
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                j<K, V> jVar = atomicReferenceArray.get(length);
                j<K, V> jVar2 = jVar;
                while (true) {
                    iVar = null;
                    if (jVar2 == null) {
                        rVar = null;
                        break;
                    }
                    K key = jVar2.getKey();
                    if (jVar2.getHash() == i && key != null && this.map.f15189h.equivalent(k, key)) {
                        r<K, V> valueReference = jVar2.getValueReference();
                        if (valueReference.isLoading()) {
                            z = false;
                            rVar = valueReference;
                        } else {
                            V v = valueReference.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference.b(), RemovalCause.COLLECTED);
                            } else if (this.map.b(jVar2, a2)) {
                                enqueueNotification(key, i, v, valueReference.b(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(jVar2, a2);
                                this.statsCounter.a(1);
                                return v;
                            }
                            this.writeQueue.remove(jVar2);
                            this.accessQueue.remove(jVar2);
                            this.count = i2;
                            rVar = valueReference;
                        }
                    } else {
                        jVar2 = jVar2.getNext();
                    }
                }
                z = true;
                if (z) {
                    iVar = new i<>();
                    if (jVar2 == null) {
                        jVar2 = newEntry(k, i, jVar);
                        jVar2.setValueReference(iVar);
                        atomicReferenceArray.set(length, jVar2);
                    } else {
                        jVar2.setValueReference(iVar);
                    }
                }
                if (z) {
                    try {
                        synchronized (jVar2) {
                            loadSync = loadSync(k, i, iVar, cacheLoader);
                        }
                        return loadSync;
                    } finally {
                        this.statsCounter.b(1);
                    }
                }
                return waitForLoadingValue(jVar2, k, rVar);
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        j<K, V> newEntry(K k, int i, @Nullable j<K, V> jVar) {
            EntryFactory entryFactory = this.map.t;
            Preconditions.a(k);
            return entryFactory.newEntry(this, k, i, jVar);
        }

        AtomicReferenceArray<j<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:            return null;     */
        @javax.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V put(K r15, int r16, V r17, boolean r18) {
            /*
                Method dump skipped, instructions count: 239
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        boolean reclaimKey(j<K, V> jVar, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                j<K, V> jVar2 = atomicReferenceArray.get(length);
                for (j<K, V> jVar3 = jVar2; jVar3 != null; jVar3 = jVar3.getNext()) {
                    if (jVar3 == jVar) {
                        this.modCount++;
                        j<K, V> removeValueFromChain = removeValueFromChain(jVar2, jVar3, jVar3.getKey(), i, jVar3.getValueReference().get(), jVar3.getValueReference(), RemovalCause.COLLECTED);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i3;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimValue(K k, int i, r<K, V> rVar) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                j<K, V> jVar = atomicReferenceArray.get(length);
                for (j<K, V> jVar2 = jVar; jVar2 != null; jVar2 = jVar2.getNext()) {
                    K key = jVar2.getKey();
                    if (jVar2.getHash() == i && key != null && this.map.f15189h.equivalent(k, key)) {
                        if (jVar2.getValueReference() == rVar) {
                            this.modCount++;
                            j<K, V> removeValueFromChain = removeValueFromChain(jVar, jVar2, key, i, rVar.get(), rVar, RemovalCause.COLLECTED);
                            int i3 = this.count - 1;
                            atomicReferenceArray.set(length, removeValueFromChain);
                            this.count = i3;
                            return true;
                        }
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        void recordLockedRead(j<K, V> jVar, long j) {
            if (this.map.j()) {
                jVar.setAccessTime(j);
            }
            this.accessQueue.add(jVar);
        }

        void recordRead(j<K, V> jVar, long j) {
            if (this.map.j()) {
                jVar.setAccessTime(j);
            }
            this.recencyQueue.add(jVar);
        }

        void recordWrite(j<K, V> jVar, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.j()) {
                jVar.setAccessTime(j);
            }
            if (this.map.l()) {
                jVar.setWriteTime(j);
            }
            this.accessQueue.add(jVar);
            this.writeQueue.add(jVar);
        }

        @Nullable
        V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            i<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) Uninterruptibles.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:            r9 = r5.getValueReference();        r12 = r9.get();     */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:            if (r12 == null) goto L15;     */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:            r2 = com.google.common.cache.RemovalCause.EXPLICIT;     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:            r10 = r2;     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:            r11.modCount++;        r13 = removeValueFromChain(r4, r5, r6, r13, r12, r9, r10);        r2 = r11.count - 1;        r0.set(r1, r13);        r11.count = r2;     */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:            return r12;     */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:            if (r9.isActive() == false) goto L21;     */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:            r2 = com.google.common.cache.RemovalCause.COLLECTED;     */
        @javax.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch: java.lang.Throwable -> L7a
                com.google.common.base.Ticker r0 = r0.s     // Catch: java.lang.Throwable -> L7a
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L7a
                r11.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L7a
                int r0 = r11.count     // Catch: java.lang.Throwable -> L7a
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.LocalCache$j<K, V>> r0 = r11.table     // Catch: java.lang.Throwable -> L7a
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L7a
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L7a
                r4 = r2
                com.google.common.cache.LocalCache$j r4 = (com.google.common.cache.LocalCache.j) r4     // Catch: java.lang.Throwable -> L7a
                r5 = r4
            L21:
                r2 = 0
                if (r5 == 0) goto L6e
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L7a
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L7a
                if (r3 != r13) goto L75
                if (r6 == 0) goto L75
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch: java.lang.Throwable -> L7a
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.f15189h     // Catch: java.lang.Throwable -> L7a
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L7a
                if (r3 == 0) goto L75
                com.google.common.cache.LocalCache$r r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L7a
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L7a
                if (r12 == 0) goto L48
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L7a
            L46:
                r10 = r2
                goto L51
            L48:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L7a
                if (r3 == 0) goto L6e
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L7a
                goto L46
            L51:
                int r2 = r11.modCount     // Catch: java.lang.Throwable -> L7a
                int r2 = r2 + 1
                r11.modCount = r2     // Catch: java.lang.Throwable -> L7a
                r3 = r11
                r7 = r13
                r8 = r12
                com.google.common.cache.LocalCache$j r13 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L7a
                int r2 = r11.count     // Catch: java.lang.Throwable -> L7a
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L7a
                r11.count = r2     // Catch: java.lang.Throwable -> L7a
                r11.unlock()
                r11.postWriteCleanup()
                return r12
            L6e:
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L75:
                com.google.common.cache.LocalCache$j r5 = r5.getNext()     // Catch: java.lang.Throwable -> L7a
                goto L21
            L7a:
                r12 = move-exception
                r11.unlock()
                r11.postWriteCleanup()
                goto L83
            L82:
                throw r12
            L83:
                goto L82
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        void removeCollectedEntry(j<K, V> jVar) {
            enqueueNotification(jVar.getKey(), jVar.getHash(), jVar.getValueReference().get(), jVar.getValueReference().b(), RemovalCause.COLLECTED);
            this.writeQueue.remove(jVar);
            this.accessQueue.remove(jVar);
        }

        @VisibleForTesting
        boolean removeEntry(j<K, V> jVar, int i, RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            j<K, V> jVar2 = atomicReferenceArray.get(length);
            for (j<K, V> jVar3 = jVar2; jVar3 != null; jVar3 = jVar3.getNext()) {
                if (jVar3 == jVar) {
                    this.modCount++;
                    j<K, V> removeValueFromChain = removeValueFromChain(jVar2, jVar3, jVar3.getKey(), i, jVar3.getValueReference().get(), jVar3.getValueReference(), removalCause);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        @Nullable
        j<K, V> removeEntryFromChain(j<K, V> jVar, j<K, V> jVar2) {
            int i = this.count;
            j<K, V> next = jVar2.getNext();
            while (jVar != jVar2) {
                j<K, V> copyEntry = copyEntry(jVar, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(jVar);
                    i--;
                }
                jVar = jVar.getNext();
            }
            this.count = i;
            return next;
        }

        boolean removeLoadingValue(K k, int i, i<K, V> iVar) {
            lock();
            try {
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                j<K, V> jVar = atomicReferenceArray.get(length);
                j<K, V> jVar2 = jVar;
                while (true) {
                    if (jVar2 == null) {
                        break;
                    }
                    K key = jVar2.getKey();
                    if (jVar2.getHash() == i && key != null && this.map.f15189h.equivalent(k, key)) {
                        if (jVar2.getValueReference() == iVar) {
                            if (iVar.isActive()) {
                                jVar2.setValueReference(iVar.e());
                            } else {
                                atomicReferenceArray.set(length, removeEntryFromChain(jVar, jVar2));
                            }
                            return true;
                        }
                    } else {
                        jVar2 = jVar2.getNext();
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @Nullable
        j<K, V> removeValueFromChain(j<K, V> jVar, j<K, V> jVar2, @Nullable K k, int i, V v, r<K, V> rVar, RemovalCause removalCause) {
            enqueueNotification(k, i, v, rVar.b(), removalCause);
            this.writeQueue.remove(jVar2);
            this.accessQueue.remove(jVar2);
            if (rVar.isLoading()) {
                rVar.a(null);
                return jVar;
            }
            return removeEntryFromChain(jVar, jVar2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:            return false;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean replace(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb7
                com.google.common.base.Ticker r1 = r1.s     // Catch: java.lang.Throwable -> Lb7
                long r7 = r1.a()     // Catch: java.lang.Throwable -> Lb7
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> Lb7
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.LocalCache$j<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> Lb7
                int r1 = r10.length()     // Catch: java.lang.Throwable -> Lb7
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch: java.lang.Throwable -> Lb7
                r2 = r1
                com.google.common.cache.LocalCache$j r2 = (com.google.common.cache.LocalCache.j) r2     // Catch: java.lang.Throwable -> Lb7
                r13 = r2
            L24:
                r14 = 0
                if (r13 == 0) goto L6b
                java.lang.Object r4 = r13.getKey()     // Catch: java.lang.Throwable -> Lb7
                int r1 = r13.getHash()     // Catch: java.lang.Throwable -> Lb7
                if (r1 != r0) goto Lad
                if (r4 == 0) goto Lad
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb7
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f15189h     // Catch: java.lang.Throwable -> Lb7
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch: java.lang.Throwable -> Lb7
                if (r1 == 0) goto Laf
                com.google.common.cache.LocalCache$r r16 = r13.getValueReference()     // Catch: java.lang.Throwable -> Lb7
                java.lang.Object r6 = r16.get()     // Catch: java.lang.Throwable -> Lb7
                if (r6 != 0) goto L72
                boolean r1 = r16.isActive()     // Catch: java.lang.Throwable -> Lb7
                if (r1 == 0) goto L6b
                int r1 = r9.count     // Catch: java.lang.Throwable -> Lb7
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb7
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb7
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> Lb7
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.LocalCache$j r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb7
                int r1 = r9.count     // Catch: java.lang.Throwable -> Lb7
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch: java.lang.Throwable -> Lb7
                r9.count = r1     // Catch: java.lang.Throwable -> Lb7
            L6b:
                r17.unlock()
                r17.postWriteCleanup()
                return r14
            L72:
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb7
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.i     // Catch: java.lang.Throwable -> Lb7
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> Lb7
                if (r1 == 0) goto La9
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb7
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb7
                int r5 = r16.b()     // Catch: java.lang.Throwable -> Lb7
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> Lb7
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb7
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb7
                r9.evictEntries(r13)     // Catch: java.lang.Throwable -> Lb7
                r17.unlock()
                r17.postWriteCleanup()
                return r11
            La9:
                r9.recordLockedRead(r13, r7)     // Catch: java.lang.Throwable -> Lb7
                goto L6b
            Lad:
                r15 = r18
            Laf:
                r3 = r20
                com.google.common.cache.LocalCache$j r13 = r13.getNext()     // Catch: java.lang.Throwable -> Lb7
                goto L24
            Lb7:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                goto Lc0
            Lbf:
                throw r0
            Lc0:
                goto Lbf
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.i();
        }

        V scheduleRefresh(j<K, V> jVar, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.m() || j - jVar.getWriteTime() <= this.map.p || jVar.getValueReference().isLoading() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        void setValue(j<K, V> jVar, K k, V v, long j) {
            r<K, V> valueReference = jVar.getValueReference();
            int weigh = this.map.m.weigh(k, v);
            Preconditions.b(weigh >= 0, "Weights must be non-negative");
            jVar.setValueReference(this.map.k.referenceValue(this, jVar, v, weigh));
            recordWrite(jVar, weigh, j);
            valueReference.a(v);
        }

        boolean storeLoadedValue(K k, int i, i<K, V> iVar, V v) {
            lock();
            try {
                long a2 = this.map.s.a();
                preWriteCleanup(a2);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<j<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                j<K, V> jVar = atomicReferenceArray.get(length);
                j<K, V> jVar2 = jVar;
                while (true) {
                    if (jVar2 != null) {
                        K key = jVar2.getKey();
                        if (jVar2.getHash() == i && key != null && this.map.f15189h.equivalent(k, key)) {
                            r<K, V> valueReference = jVar2.getValueReference();
                            V v2 = valueReference.get();
                            if (iVar != valueReference && (v2 != null || valueReference == LocalCache.f15183b)) {
                                enqueueNotification(k, i, v, 0, RemovalCause.REPLACED);
                                return false;
                            }
                            this.modCount++;
                            if (iVar.isActive()) {
                                enqueueNotification(k, i, v2, iVar.b(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i3--;
                            }
                            setValue(jVar2, k, v, a2);
                            this.count = i3;
                            evictEntries(jVar2);
                        } else {
                            jVar2 = jVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        j<K, V> newEntry = newEntry(k, i, jVar);
                        setValue(newEntry, k, v, a2);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i3;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        V waitForLoadingValue(j<K, V> jVar, K k, r<K, V> rVar) throws ExecutionException {
            if (rVar.isLoading()) {
                Preconditions.b(!Thread.holdsLock(jVar), "Recursive load of: %s", k);
                try {
                    V c2 = rVar.c();
                    if (c2 != null) {
                        recordRead(jVar, this.map.s.a());
                        return c2;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } finally {
                    this.statsCounter.b(1);
                }
            }
            throw new AssertionError();
        }

        @Nullable
        V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long a2 = this.map.s.a();
                    j<K, V> liveEntry = getLiveEntry(obj, i, a2);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, a2);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, a2, this.map.v);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:            r10 = r6.getValueReference();        r9 = r10.get();     */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:            if (r12.map.i.equivalent(r15, r9) == false) goto L14;     */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:            r13 = com.google.common.cache.RemovalCause.EXPLICIT;     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:            r12.modCount++;        r14 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r13);        r15 = r12.count - 1;        r0.set(r1, r14);        r12.count = r15;     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L21;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:            r2 = false;     */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:            return r2;     */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:            if (r9 != null) goto L24;     */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:            if (r10.isActive() == false) goto L24;     */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:            r13 = com.google.common.cache.RemovalCause.COLLECTED;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch: java.lang.Throwable -> L86
                com.google.common.base.Ticker r0 = r0.s     // Catch: java.lang.Throwable -> L86
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L86
                r12.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L86
                int r0 = r12.count     // Catch: java.lang.Throwable -> L86
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.LocalCache$j<K, V>> r0 = r12.table     // Catch: java.lang.Throwable -> L86
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L86
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L86
                r5 = r3
                com.google.common.cache.LocalCache$j r5 = (com.google.common.cache.LocalCache.j) r5     // Catch: java.lang.Throwable -> L86
                r6 = r5
            L21:
                r3 = 0
                if (r6 == 0) goto L7a
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L86
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L86
                if (r4 != r14) goto L81
                if (r7 == 0) goto L81
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch: java.lang.Throwable -> L86
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.f15189h     // Catch: java.lang.Throwable -> L86
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L86
                if (r4 == 0) goto L81
                com.google.common.cache.LocalCache$r r10 = r6.getValueReference()     // Catch: java.lang.Throwable -> L86
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L86
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch: java.lang.Throwable -> L86
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.i     // Catch: java.lang.Throwable -> L86
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L86
                if (r13 == 0) goto L4f
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L86
                goto L59
            L4f:
                if (r9 != 0) goto L7a
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L86
                if (r13 == 0) goto L7a
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L86
            L59:
                int r15 = r12.modCount     // Catch: java.lang.Throwable -> L86
                int r15 = r15 + r2
                r12.modCount = r15     // Catch: java.lang.Throwable -> L86
                r4 = r12
                r8 = r14
                r11 = r13
                com.google.common.cache.LocalCache$j r14 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L86
                int r15 = r12.count     // Catch: java.lang.Throwable -> L86
                int r15 = r15 - r2
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L86
                r12.count = r15     // Catch: java.lang.Throwable -> L86
                com.google.common.cache.RemovalCause r14 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L86
                if (r13 != r14) goto L72
                goto L73
            L72:
                r2 = 0
            L73:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L7a:
                r12.unlock()
                r12.postWriteCleanup()
                return r3
            L81:
                com.google.common.cache.LocalCache$j r6 = r6.getNext()     // Catch: java.lang.Throwable -> L86
                goto L21
            L86:
                r13 = move-exception
                r12.unlock()
                r12.postWriteCleanup()
                goto L8f
            L8e:
                throw r13
            L8f:
                goto L8e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:            return null;     */
        @javax.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V replace(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La9
                com.google.common.base.Ticker r1 = r1.s     // Catch: java.lang.Throwable -> La9
                long r7 = r1.a()     // Catch: java.lang.Throwable -> La9
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> La9
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.LocalCache$j<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> La9
                int r1 = r10.length()     // Catch: java.lang.Throwable -> La9
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> La9
                r2 = r1
                com.google.common.cache.LocalCache$j r2 = (com.google.common.cache.LocalCache.j) r2     // Catch: java.lang.Throwable -> La9
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6e
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> La9
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> La9
                if (r1 != r0) goto La1
                if (r4 == 0) goto La1
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La9
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f15189h     // Catch: java.lang.Throwable -> La9
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> La9
                if (r1 == 0) goto La3
                com.google.common.cache.LocalCache$r r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> La9
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> La9
                if (r16 != 0) goto L75
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> La9
                if (r1 == 0) goto L6e
                int r1 = r9.count     // Catch: java.lang.Throwable -> La9
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La9
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La9
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> La9
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.LocalCache$j r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La9
                int r1 = r9.count     // Catch: java.lang.Throwable -> La9
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> La9
                r9.count = r1     // Catch: java.lang.Throwable -> La9
            L6e:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L75:
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La9
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La9
                int r5 = r15.b()     // Catch: java.lang.Throwable -> La9
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> La9
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La9
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La9
                r9.evictEntries(r12)     // Catch: java.lang.Throwable -> La9
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            La1:
                r14 = r18
            La3:
                com.google.common.cache.LocalCache$j r12 = r12.getNext()     // Catch: java.lang.Throwable -> La9
                goto L24
            La9:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                goto Lb2
            Lb1:
                throw r0
            Lb2:
                goto Lb1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> a(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap d2 = Maps.d();
        LinkedHashSet b2 = Sets.b();
        int i2 = 0;
        int i3 = 0;
        for (K k2 : iterable) {
            Object obj = get(k2);
            if (!d2.containsKey(k2)) {
                d2.put(k2, obj);
                if (obj == null) {
                    i3++;
                    b2.add(k2);
                } else {
                    i2++;
                }
            }
        }
        try {
            if (!b2.isEmpty()) {
                try {
                    Map a2 = a((Set) b2, (CacheLoader) this.v);
                    for (Object obj2 : b2) {
                        Object obj3 = a2.get(obj2);
                        if (obj3 != null) {
                            d2.put(obj2, obj3);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : b2) {
                        i3--;
                        d2.put(obj4, a((LocalCache<K, V>) obj4, (CacheLoader<? super LocalCache<K, V>, V>) this.v));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) d2);
        } finally {
            this.u.a(i2);
            this.u.b(i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map<K, V> a(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            com.google.common.base.Preconditions.a(r8)
            com.google.common.base.Preconditions.a(r7)
            com.google.common.base.Stopwatch r0 = com.google.common.base.Stopwatch.a()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> L8e java.lang.Error -> L90 java.lang.Exception -> L97 java.lang.RuntimeException -> L9e java.lang.InterruptedException -> La5 com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lb3
            if (r7 == 0) goto L6c
            r0.e()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.u
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.a(r1)
            r8.b(r0)
            return r7
        L4a:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.u
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.a(r1)
            r7.a(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L6c:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.u
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.a(r1)
            r7.a(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L8e:
            r7 = move-exception
            goto Lb7
        L90:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L97:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L9e:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        La5:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8e
            r8.interrupt()     // Catch: java.lang.Throwable -> L8e
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        Lb3:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r7 = move-exception
            r2 = 1
        Lb7:
            if (r2 != 0) goto Lc4
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.u
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.a(r1)
            r8.a(r0)
        Lc4:
            goto Lc6
        Lc5:
            throw r7
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.a(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }
}
