package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.GenericMapMaker;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
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
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient EntryFactory entryFactory;
    transient Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final Strength keyStrength;
    final int maximumSize;
    final MapMaker.a<K, V> removalListener;
    final Queue<MapMaker.RemovalNotification<K, V>> removalNotificationQueue;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    transient Collection<V> values;

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2720a = Logger.getLogger(MapMakerInternalMap.class.getName());
    static final u<Object, Object> UNSET = new bl();
    static final Queue<? extends Object> DISCARDING_QUEUE = new bm();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface i<K, V> {
        long getExpirationTime();

        int getHash();

        K getKey();

        i<K, V> getNext();

        i<K, V> getNextEvictable();

        i<K, V> getNextExpirable();

        i<K, V> getPreviousEvictable();

        i<K, V> getPreviousExpirable();

        u<K, V> getValueReference();

        void setExpirationTime(long j);

        void setNextEvictable(i<K, V> iVar);

        void setNextExpirable(i<K, V> iVar);

        void setPreviousEvictable(i<K, V> iVar);

        void setPreviousExpirable(i<K, V> iVar);

        void setValueReference(u<K, V> uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface u<K, V> {
        i<K, V> a();

        u<K, V> a(ReferenceQueue<V> referenceQueue, @Nullable V v, i<K, V> iVar);

        void a(@Nullable u<K, V> uVar);

        boolean b();

        V c() throws ExecutionException;

        V get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap(MapMaker mapMaker) {
        int i2 = 1;
        int i3 = 0;
        this.concurrencyLevel = Math.min(mapMaker.e(), 65536);
        this.keyStrength = mapMaker.g();
        this.valueStrength = mapMaker.h();
        this.keyEquivalence = mapMaker.c();
        this.valueEquivalence = this.valueStrength.defaultEquivalence();
        this.maximumSize = mapMaker.e;
        this.expireAfterAccessNanos = mapMaker.j();
        this.expireAfterWriteNanos = mapMaker.i();
        this.entryFactory = EntryFactory.getFactory(this.keyStrength, expires(), evictsBySize());
        this.ticker = mapMaker.k();
        this.removalListener = mapMaker.a();
        this.removalNotificationQueue = this.removalListener == GenericMapMaker.NullListener.INSTANCE ? discardingQueue() : new ConcurrentLinkedQueue<>();
        int min = Math.min(mapMaker.d(), MAXIMUM_CAPACITY);
        min = evictsBySize() ? Math.min(min, this.maximumSize) : min;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.concurrencyLevel && (!evictsBySize() || i4 * 2 <= this.maximumSize)) {
            i5++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i5;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i6 = min / i4;
        while (i2 < (i6 * i4 < min ? i6 + 1 : i6)) {
            i2 <<= 1;
        }
        if (evictsBySize()) {
            int i7 = (this.maximumSize / i4) + 1;
            int i8 = this.maximumSize % i4;
            while (i3 < this.segments.length) {
                if (i3 == i8) {
                    i7--;
                }
                this.segments[i3] = createSegment(i2, i7);
                i3++;
            }
            return;
        }
        while (i3 < this.segments.length) {
            this.segments[i3] = createSegment(i2, -1);
            i3++;
        }
    }

    boolean evictsBySize() {
        return this.maximumSize != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean expires() {
        return expiresAfterWrite() || expiresAfterAccess();
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            <K, V> u<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v) {
                return new s(v);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            <K, V> u<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v) {
                return new n(segment.valueReferenceQueue, v, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.3
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            <K, V> u<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v) {
                return new aa(segment.valueReferenceQueue, v, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> u<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v);

        /* synthetic */ Strength(bl blVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.1
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new o(k, i, iVar);
            }
        },
        STRONG_EXPIRABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.2
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new q(k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        STRONG_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.3
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new p(k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyEvictableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        STRONG_EXPIRABLE_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.4
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new r(k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, copyEntry);
                copyEvictableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        SOFT { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.5
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new j(segment.keyReferenceQueue, k, i, iVar);
            }
        },
        SOFT_EXPIRABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.6
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new l(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        SOFT_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.7
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new k(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyEvictableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        SOFT_EXPIRABLE_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.8
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new m(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, copyEntry);
                copyEvictableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.9
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new w(segment.keyReferenceQueue, k, i, iVar);
            }
        },
        WEAK_EXPIRABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.10
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new y(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        WEAK_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.11
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new x(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyEvictableEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        WEAK_EXPIRABLE_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.12
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new z(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, copyEntry);
                copyEvictableEntry(iVar, copyEntry);
                return copyEntry;
            }
        };

        static final int EVICTABLE_MASK = 2;
        static final int EXPIRABLE_MASK = 1;
        static final EntryFactory[][] factories = {new EntryFactory[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE}, new EntryFactory[]{SOFT, SOFT_EXPIRABLE, SOFT_EVICTABLE, SOFT_EXPIRABLE_EVICTABLE}, new EntryFactory[]{WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE}};

        abstract <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar);

        /* synthetic */ EntryFactory(bl blVar) {
            this();
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[strength.ordinal()][(z2 ? (char) 2 : (char) 0) | (z ? (char) 1 : (char) 0)];
        }

        @GuardedBy
        <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
            return newEntry(segment, iVar.getKey(), iVar.getHash(), iVar2);
        }

        @GuardedBy
        <K, V> void copyExpirableEntry(i<K, V> iVar, i<K, V> iVar2) {
            iVar2.setExpirationTime(iVar.getExpirationTime());
            MapMakerInternalMap.connectExpirables(iVar.getPreviousExpirable(), iVar2);
            MapMakerInternalMap.connectExpirables(iVar2, iVar.getNextExpirable());
            MapMakerInternalMap.nullifyExpirable(iVar);
        }

        @GuardedBy
        <K, V> void copyEvictableEntry(i<K, V> iVar, i<K, V> iVar2) {
            MapMakerInternalMap.connectEvictables(iVar.getPreviousEvictable(), iVar2);
            MapMakerInternalMap.connectEvictables(iVar2, iVar.getNextEvictable());
            MapMakerInternalMap.nullifyEvictable(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> u<K, V> unset() {
        return (u<K, V>) UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum NullEntry implements i<Object, Object> {
        INSTANCE;

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public u<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(u<Object, Object> uVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return 0L;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getNextExpirable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getPreviousExpirable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getNextEvictable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getPreviousEvictable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<Object, Object> iVar) {
        }
    }

    /* loaded from: classes2.dex */
    static abstract class a<K, V> implements i<K, V> {
        @Override // com.google.common.collect.MapMakerInternalMap.i
        public u<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(u<K, V> uVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }
    }

    static <K, V> i<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    /* loaded from: classes2.dex */
    static class o<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2731a;
        final int b;
        final i<K, V> c;
        volatile u<K, V> d = MapMakerInternalMap.unset();

        o(K k, int i, @Nullable i<K, V> iVar) {
            this.f2731a = k;
            this.b = i;
            this.c = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return this.f2731a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public u<K, V> getValueReference() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(u<K, V> uVar) {
            u<K, V> uVar2 = this.d;
            this.d = uVar;
            uVar2.a(uVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            return this.c;
        }
    }

    /* loaded from: classes2.dex */
    static final class q<K, V> extends o<K, V> implements i<K, V> {
        volatile long e;

        @GuardedBy
        i<K, V> f;

        @GuardedBy
        i<K, V> g;

        q(K k, int i, @Nullable i<K, V> iVar) {
            super(k, i, iVar);
            this.e = Long.MAX_VALUE;
            this.f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.f = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.g = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class p<K, V> extends o<K, V> implements i<K, V> {

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        p(K k, int i, @Nullable i<K, V> iVar) {
            super(k, i, iVar);
            this.e = MapMakerInternalMap.nullEntry();
            this.f = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.f = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class r<K, V> extends o<K, V> implements i<K, V> {
        volatile long e;

        @GuardedBy
        i<K, V> f;

        @GuardedBy
        i<K, V> g;

        @GuardedBy
        i<K, V> h;

        @GuardedBy
        i<K, V> i;

        r(K k, int i, @Nullable i<K, V> iVar) {
            super(k, i, iVar);
            this.e = Long.MAX_VALUE;
            this.f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
            this.h = MapMakerInternalMap.nullEntry();
            this.i = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.f = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.g = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.h;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.h = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.i;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.o, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.i = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static class j<K, V> extends SoftReference<K> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final int f2729a;
        final i<K, V> b;
        volatile u<K, V> c;

        j(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(k, referenceQueue);
            this.c = MapMakerInternalMap.unset();
            this.f2729a = i;
            this.b = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public u<K, V> getValueReference() {
            return this.c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(u<K, V> uVar) {
            u<K, V> uVar2 = this.c;
            this.c = uVar;
            uVar2.a(uVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.f2729a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    static final class l<K, V> extends j<K, V> implements i<K, V> {
        volatile long d;

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        l(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.d = Long.MAX_VALUE;
            this.e = MapMakerInternalMap.nullEntry();
            this.f = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.f = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class k<K, V> extends j<K, V> implements i<K, V> {

        @GuardedBy
        i<K, V> d;

        @GuardedBy
        i<K, V> e;

        k(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.d = MapMakerInternalMap.nullEntry();
            this.e = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.d = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.e = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class m<K, V> extends j<K, V> implements i<K, V> {
        volatile long d;

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        @GuardedBy
        i<K, V> g;

        @GuardedBy
        i<K, V> h;

        m(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.d = Long.MAX_VALUE;
            this.e = MapMakerInternalMap.nullEntry();
            this.f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
            this.h = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.f = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.g = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.h;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.j, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.h = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static class w<K, V> extends WeakReference<K> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final int f2735a;
        final i<K, V> b;
        volatile u<K, V> c;

        w(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(k, referenceQueue);
            this.c = MapMakerInternalMap.unset();
            this.f2735a = i;
            this.b = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return (K) get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public u<K, V> getValueReference() {
            return this.c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(u<K, V> uVar) {
            u<K, V> uVar2 = this.c;
            this.c = uVar;
            uVar2.a(uVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.f2735a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    static final class y<K, V> extends w<K, V> implements i<K, V> {
        volatile long d;

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        y(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.d = Long.MAX_VALUE;
            this.e = MapMakerInternalMap.nullEntry();
            this.f = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.f = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class x<K, V> extends w<K, V> implements i<K, V> {

        @GuardedBy
        i<K, V> d;

        @GuardedBy
        i<K, V> e;

        x(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.d = MapMakerInternalMap.nullEntry();
            this.e = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.d = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.e = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class z<K, V> extends w<K, V> implements i<K, V> {
        volatile long d;

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        @GuardedBy
        i<K, V> g;

        @GuardedBy
        i<K, V> h;

        z(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.d = Long.MAX_VALUE;
            this.e = MapMakerInternalMap.nullEntry();
            this.f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
            this.h = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.f = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.g = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.h;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.h = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class aa<K, V> extends WeakReference<V> implements u<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2721a;

        aa(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            super(v, referenceQueue);
            this.f2721a = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public i<K, V> a() {
            return this.f2721a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void a(u<K, V> uVar) {
            clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public u<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new aa(referenceQueue, v, iVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V c() {
            return get();
        }
    }

    /* loaded from: classes2.dex */
    static final class n<K, V> extends SoftReference<V> implements u<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2730a;

        n(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            super(v, referenceQueue);
            this.f2730a = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public i<K, V> a() {
            return this.f2730a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void a(u<K, V> uVar) {
            clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public u<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new n(referenceQueue, v, iVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V c() {
            return get();
        }
    }

    /* loaded from: classes2.dex */
    static final class s<K, V> implements u<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final V f2732a;

        s(V v) {
            this.f2732a = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V get() {
            return this.f2732a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public u<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V c() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void a(u<K, V> uVar) {
        }
    }

    static int rehash(int i2) {
        int i3 = ((i2 << 15) ^ (-12931)) + i2;
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    @VisibleForTesting
    @GuardedBy
    i<K, V> newEntry(K k2, int i2, @Nullable i<K, V> iVar) {
        return segmentFor(i2).newEntry(k2, i2, iVar);
    }

    @VisibleForTesting
    @GuardedBy
    i<K, V> copyEntry(i<K, V> iVar, i<K, V> iVar2) {
        return segmentFor(iVar.getHash()).copyEntry(iVar, iVar2);
    }

    @VisibleForTesting
    @GuardedBy
    u<K, V> newValueReference(i<K, V> iVar, V v2) {
        return this.valueStrength.referenceValue(segmentFor(iVar.getHash()), iVar, v2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    void reclaimValue(u<K, V> uVar) {
        i<K, V> a2 = uVar.a();
        int hash = a2.getHash();
        segmentFor(hash).reclaimValue(a2.getKey(), hash, uVar);
    }

    void reclaimKey(i<K, V> iVar) {
        int hash = iVar.getHash();
        segmentFor(hash).reclaimKey(iVar, hash);
    }

    @VisibleForTesting
    boolean isLive(i<K, V> iVar) {
        return segmentFor(iVar.getHash()).getLiveValue(iVar) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment<K, V> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    Segment<K, V> createSegment(int i2, int i3) {
        return new Segment<>(this, i2, i3);
    }

    V getLiveValue(i<K, V> iVar) {
        V v2;
        if (iVar.getKey() == null || (v2 = iVar.getValueReference().get()) == null) {
            return null;
        }
        if (expires() && isExpired(iVar)) {
            return null;
        }
        return v2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExpired(i<K, V> iVar) {
        return isExpired(iVar, this.ticker.a());
    }

    boolean isExpired(i<K, V> iVar, long j2) {
        return j2 - iVar.getExpirationTime() > 0;
    }

    @GuardedBy
    static <K, V> void connectExpirables(i<K, V> iVar, i<K, V> iVar2) {
        iVar.setNextExpirable(iVar2);
        iVar2.setPreviousExpirable(iVar);
    }

    @GuardedBy
    static <K, V> void nullifyExpirable(i<K, V> iVar) {
        i<K, V> nullEntry = nullEntry();
        iVar.setNextExpirable(nullEntry);
        iVar.setPreviousExpirable(nullEntry);
    }

    void processPendingNotifications() {
        while (true) {
            MapMaker.RemovalNotification<K, V> poll = this.removalNotificationQueue.poll();
            if (poll != null) {
                try {
                    this.removalListener.onRemoval(poll);
                } catch (Exception e2) {
                    f2720a.log(Level.WARNING, "Exception thrown by removal listener", (Throwable) e2);
                }
            } else {
                return;
            }
        }
    }

    @GuardedBy
    static <K, V> void connectEvictables(i<K, V> iVar, i<K, V> iVar2) {
        iVar.setNextEvictable(iVar2);
        iVar2.setPreviousEvictable(iVar);
    }

    @GuardedBy
    static <K, V> void nullifyEvictable(i<K, V> iVar) {
        i<K, V> nullEntry = nullEntry();
        iVar.setNextEvictable(nullEntry);
        iVar.setPreviousEvictable(nullEntry);
    }

    final Segment<K, V>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Segment<K, V> extends ReentrantLock {
        volatile int count;

        @GuardedBy
        final Queue<i<K, V>> evictionQueue;

        @GuardedBy
        final Queue<i<K, V>> expirationQueue;
        final ReferenceQueue<K> keyReferenceQueue;
        final MapMakerInternalMap<K, V> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<i<K, V>> recencyQueue;
        volatile AtomicReferenceArray<i<K, V>> table;
        int threshold;
        final ReferenceQueue<V> valueReferenceQueue;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Segment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
            this.keyReferenceQueue = mapMakerInternalMap.usesKeyReferences() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = mapMakerInternalMap.usesValueReferences() ? new ReferenceQueue<>() : null;
            this.recencyQueue = (mapMakerInternalMap.evictsBySize() || mapMakerInternalMap.expiresAfterAccess()) ? new ConcurrentLinkedQueue<>() : MapMakerInternalMap.discardingQueue();
            this.evictionQueue = mapMakerInternalMap.evictsBySize() ? new d<>() : MapMakerInternalMap.discardingQueue();
            this.expirationQueue = mapMakerInternalMap.expires() ? new e<>() : MapMakerInternalMap.discardingQueue();
        }

        AtomicReferenceArray<i<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        void initTable(AtomicReferenceArray<i<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (this.threshold == this.maxSegmentSize) {
                this.threshold++;
            }
            this.table = atomicReferenceArray;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @GuardedBy
        public i<K, V> newEntry(K k, int i, @Nullable i<K, V> iVar) {
            return this.map.entryFactory.newEntry(this, k, i, iVar);
        }

        @GuardedBy
        i<K, V> copyEntry(i<K, V> iVar, i<K, V> iVar2) {
            if (iVar.getKey() == null) {
                return null;
            }
            u<K, V> valueReference = iVar.getValueReference();
            V v = valueReference.get();
            if (v == null && !valueReference.b()) {
                return null;
            }
            i<K, V> copyEntry = this.map.entryFactory.copyEntry(this, iVar, iVar2);
            copyEntry.setValueReference(valueReference.a(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        @GuardedBy
        void setValue(i<K, V> iVar, V v) {
            iVar.setValueReference(this.map.valueStrength.referenceValue(this, iVar, v));
            recordWrite(iVar);
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

        @GuardedBy
        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        @GuardedBy
        void drainKeyReferenceQueue() {
            int i = 0;
            do {
                int i2 = i;
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((i) poll);
                    i = i2 + 1;
                } else {
                    return;
                }
            } while (i != 16);
        }

        @GuardedBy
        void drainValueReferenceQueue() {
            int i = 0;
            do {
                int i2 = i;
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((u) poll);
                    i = i2 + 1;
                } else {
                    return;
                }
            } while (i != 16);
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void recordRead(i<K, V> iVar) {
            if (this.map.expiresAfterAccess()) {
                recordExpirationTime(iVar, this.map.expireAfterAccessNanos);
            }
            this.recencyQueue.add(iVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @GuardedBy
        public void recordLockedRead(i<K, V> iVar) {
            this.evictionQueue.add(iVar);
            if (this.map.expiresAfterAccess()) {
                recordExpirationTime(iVar, this.map.expireAfterAccessNanos);
                this.expirationQueue.add(iVar);
            }
        }

        @GuardedBy
        void recordWrite(i<K, V> iVar) {
            drainRecencyQueue();
            this.evictionQueue.add(iVar);
            if (this.map.expires()) {
                recordExpirationTime(iVar, this.map.expiresAfterAccess() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos);
                this.expirationQueue.add(iVar);
            }
        }

        @GuardedBy
        void drainRecencyQueue() {
            while (true) {
                i<K, V> poll = this.recencyQueue.poll();
                if (poll != null) {
                    if (this.evictionQueue.contains(poll)) {
                        this.evictionQueue.add(poll);
                    }
                    if (this.map.expiresAfterAccess() && this.expirationQueue.contains(poll)) {
                        this.expirationQueue.add(poll);
                    }
                } else {
                    return;
                }
            }
        }

        void recordExpirationTime(i<K, V> iVar, long j) {
            iVar.setExpirationTime(this.map.ticker.a() + j);
        }

        void tryExpireEntries() {
            if (tryLock()) {
                try {
                    expireEntries();
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy
        void expireEntries() {
            i<K, V> peek;
            drainRecencyQueue();
            if (!this.expirationQueue.isEmpty()) {
                long a2 = this.map.ticker.a();
                do {
                    peek = this.expirationQueue.peek();
                    if (peek == null || !this.map.isExpired(peek, a2)) {
                        return;
                    }
                } while (removeEntry(peek, peek.getHash(), MapMaker.RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        }

        void enqueueNotification(i<K, V> iVar, MapMaker.RemovalCause removalCause) {
            enqueueNotification(iVar.getKey(), iVar.getHash(), iVar.getValueReference().get(), removalCause);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void enqueueNotification(@Nullable K k, int i, @Nullable V v, MapMaker.RemovalCause removalCause) {
            if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(new MapMaker.RemovalNotification<>(k, v, removalCause));
            }
        }

        @GuardedBy
        boolean evictEntries() {
            if (!this.map.evictsBySize() || this.count < this.maxSegmentSize) {
                return false;
            }
            drainRecencyQueue();
            i<K, V> remove = this.evictionQueue.remove();
            if (!removeEntry(remove, remove.getHash(), MapMaker.RemovalCause.SIZE)) {
                throw new AssertionError();
            }
            return true;
        }

        i<K, V> getFirst(int i) {
            return this.table.get((r0.length() - 1) & i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public i<K, V> getEntry(Object obj, int i) {
            if (this.count != 0) {
                for (i<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                    if (first.getHash() == i) {
                        K key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
            }
            return null;
        }

        i<K, V> getLiveEntry(Object obj, int i) {
            i<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.expires() || !this.map.isExpired(entry)) {
                return entry;
            }
            tryExpireEntries();
            return null;
        }

        V get(Object obj, int i) {
            try {
                i<K, V> liveEntry = getLiveEntry(obj, i);
                if (liveEntry != null) {
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry);
                    } else {
                        tryDrainReferenceQueues();
                    }
                    return v;
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        boolean containsKey(Object obj, int i) {
            try {
                if (this.count != 0) {
                    i<K, V> liveEntry = getLiveEntry(obj, i);
                    if (liveEntry != null) {
                        r0 = liveEntry.getValueReference().get() != null;
                    }
                }
                return r0;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (i<K, V> iVar = atomicReferenceArray.get(i); iVar != null; iVar = iVar.getNext()) {
                            V liveValue = getLiveValue(iVar);
                            if (liveValue != null && this.map.valueEquivalence.equivalent(obj, liveValue)) {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        u<K, V> valueReference = iVar2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            if (z) {
                                recordLockedRead(iVar2);
                                return v2;
                            }
                            this.modCount++;
                            enqueueNotification(k, i, v2, MapMaker.RemovalCause.REPLACED);
                            setValue(iVar2, v);
                            return v2;
                        }
                        this.modCount++;
                        setValue(iVar2, v);
                        if (!valueReference.b()) {
                            enqueueNotification(k, i, v2, MapMaker.RemovalCause.COLLECTED);
                            i2 = this.count;
                        } else if (evictEntries()) {
                            i2 = this.count + 1;
                        }
                        this.count = i2;
                        return null;
                    }
                }
                this.modCount++;
                i<K, V> newEntry = newEntry(k, i, iVar);
                setValue(newEntry, v);
                atomicReferenceArray.set(length, newEntry);
                this.count = evictEntries() ? this.count + 1 : i2;
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @GuardedBy
        void expand() {
            int i;
            int i2;
            i<K, V> iVar;
            AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < MapMakerInternalMap.MAXIMUM_CAPACITY) {
                int i3 = this.count;
                AtomicReferenceArray<i<K, V>> newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                int i4 = 0;
                while (i4 < length) {
                    i<K, V> iVar2 = atomicReferenceArray.get(i4);
                    if (iVar2 != null) {
                        i<K, V> next = iVar2.getNext();
                        int hash = iVar2.getHash() & length2;
                        if (next == null) {
                            newEntryArray.set(hash, iVar2);
                            i = i3;
                        } else {
                            i<K, V> iVar3 = iVar2;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    iVar = next;
                                } else {
                                    hash2 = hash;
                                    iVar = iVar3;
                                }
                                next = next.getNext();
                                iVar3 = iVar;
                                hash = hash2;
                            }
                            newEntryArray.set(hash, iVar3);
                            i<K, V> iVar4 = iVar2;
                            i = i3;
                            while (iVar4 != iVar3) {
                                int hash3 = iVar4.getHash() & length2;
                                i<K, V> copyEntry = copyEntry(iVar4, newEntryArray.get(hash3));
                                if (copyEntry != null) {
                                    newEntryArray.set(hash3, copyEntry);
                                    i2 = i;
                                } else {
                                    removeCollectedEntry(iVar4);
                                    i2 = i - 1;
                                }
                                iVar4 = iVar4.getNext();
                                i = i2;
                            }
                        }
                    } else {
                        i = i3;
                    }
                    i4++;
                    i3 = i;
                }
                this.table = newEntryArray;
                this.count = i3;
            }
        }

        boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        u<K, V> valueReference = iVar2.getValueReference();
                        V v3 = valueReference.get();
                        if (v3 != null) {
                            if (!this.map.valueEquivalence.equivalent(v, v3)) {
                                recordLockedRead(iVar2);
                                return false;
                            }
                            this.modCount++;
                            enqueueNotification(k, i, v3, MapMaker.RemovalCause.REPLACED);
                            setValue(iVar2, v2);
                            return true;
                        }
                        if (isCollected(valueReference)) {
                            int i2 = this.count - 1;
                            this.modCount++;
                            enqueueNotification(key, i, v3, MapMaker.RemovalCause.COLLECTED);
                            i<K, V> removeFromChain = removeFromChain(iVar, iVar2);
                            int i3 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i3;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        u<K, V> valueReference = iVar2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            this.modCount++;
                            enqueueNotification(k, i, v2, MapMaker.RemovalCause.REPLACED);
                            setValue(iVar2, v);
                            return v2;
                        }
                        if (isCollected(valueReference)) {
                            int i2 = this.count - 1;
                            this.modCount++;
                            enqueueNotification(key, i, v2, MapMaker.RemovalCause.COLLECTED);
                            i<K, V> removeFromChain = removeFromChain(iVar, iVar2);
                            int i3 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i3;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        V remove(Object obj, int i) {
            MapMaker.RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        u<K, V> valueReference = iVar2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = MapMaker.RemovalCause.EXPLICIT;
                        } else {
                            if (!isCollected(valueReference)) {
                                return null;
                            }
                            removalCause = MapMaker.RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        enqueueNotification(key, i, v, removalCause);
                        i<K, V> removeFromChain = removeFromChain(iVar, iVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean remove(Object obj, int i, Object obj2) {
            MapMaker.RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        u<K, V> valueReference = iVar2.getValueReference();
                        V v = valueReference.get();
                        if (this.map.valueEquivalence.equivalent(obj2, v)) {
                            removalCause = MapMaker.RemovalCause.EXPLICIT;
                        } else {
                            if (!isCollected(valueReference)) {
                                return false;
                            }
                            removalCause = MapMaker.RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        enqueueNotification(key, i, v, removalCause);
                        i<K, V> removeFromChain = removeFromChain(iVar, iVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
                        boolean z = removalCause == MapMaker.RemovalCause.EXPLICIT;
                        unlock();
                        postWriteCleanup();
                        return z;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                    if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                        for (int i = 0; i < atomicReferenceArray.length(); i++) {
                            for (i<K, V> iVar = atomicReferenceArray.get(i); iVar != null; iVar = iVar.getNext()) {
                                if (!iVar.getValueReference().b()) {
                                    enqueueNotification(iVar, MapMaker.RemovalCause.EXPLICIT);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.evictionQueue.clear();
                    this.expirationQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        @GuardedBy
        i<K, V> removeFromChain(i<K, V> iVar, i<K, V> iVar2) {
            int i;
            this.evictionQueue.remove(iVar2);
            this.expirationQueue.remove(iVar2);
            int i2 = this.count;
            i<K, V> next = iVar2.getNext();
            while (iVar != iVar2) {
                i<K, V> copyEntry = copyEntry(iVar, next);
                if (copyEntry != null) {
                    i = i2;
                } else {
                    removeCollectedEntry(iVar);
                    i<K, V> iVar3 = next;
                    i = i2 - 1;
                    copyEntry = iVar3;
                }
                iVar = iVar.getNext();
                i2 = i;
                next = copyEntry;
            }
            this.count = i2;
            return next;
        }

        void removeCollectedEntry(i<K, V> iVar) {
            enqueueNotification(iVar, MapMaker.RemovalCause.COLLECTED);
            this.evictionQueue.remove(iVar);
            this.expirationQueue.remove(iVar);
        }

        boolean reclaimKey(i<K, V> iVar, int i) {
            lock();
            try {
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar2 = atomicReferenceArray.get(length);
                for (i<K, V> iVar3 = iVar2; iVar3 != null; iVar3 = iVar3.getNext()) {
                    if (iVar3 == iVar) {
                        this.modCount++;
                        enqueueNotification(iVar3.getKey(), i, iVar3.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
                        i<K, V> removeFromChain = removeFromChain(iVar2, iVar3);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
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

        boolean reclaimValue(K k, int i, u<K, V> uVar) {
            lock();
            try {
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (iVar2.getValueReference() != uVar) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                        this.modCount++;
                        enqueueNotification(k, i, uVar.get(), MapMaker.RemovalCause.COLLECTED);
                        i<K, V> removeFromChain = removeFromChain(iVar, iVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean clearValue(K k, int i, u<K, V> uVar) {
            lock();
            try {
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (iVar2.getValueReference() != uVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @GuardedBy
        boolean removeEntry(i<K, V> iVar, int i, MapMaker.RemovalCause removalCause) {
            int i2 = this.count - 1;
            AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
            int length = i & (atomicReferenceArray.length() - 1);
            i<K, V> iVar2 = atomicReferenceArray.get(length);
            for (i<K, V> iVar3 = iVar2; iVar3 != null; iVar3 = iVar3.getNext()) {
                if (iVar3 == iVar) {
                    this.modCount++;
                    enqueueNotification(iVar3.getKey(), i, iVar3.getValueReference().get(), removalCause);
                    i<K, V> removeFromChain = removeFromChain(iVar2, iVar3);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        boolean isCollected(i<K, V> iVar) {
            if (iVar.getKey() == null) {
                return true;
            }
            return isCollected(iVar.getValueReference());
        }

        boolean isCollected(u<K, V> uVar) {
            return !uVar.b() && uVar.get() == null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public V getLiveValue(i<K, V> iVar) {
            if (iVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = iVar.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.expires() || !this.map.isExpired(iVar)) {
                return v;
            }
            tryExpireEntries();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @GuardedBy
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void runCleanup() {
            runLockedCleanup();
            runUnlockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.processPendingNotifications();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class d<K, V> extends AbstractQueue<i<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2725a = new bn(this);

        d() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(i<K, V> iVar) {
            MapMakerInternalMap.connectEvictables(iVar.getPreviousEvictable(), iVar.getNextEvictable());
            MapMakerInternalMap.connectEvictables(this.f2725a.getPreviousEvictable(), iVar);
            MapMakerInternalMap.connectEvictables(iVar, this.f2725a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i<K, V> peek() {
            i<K, V> nextEvictable = this.f2725a.getNextEvictable();
            if (nextEvictable == this.f2725a) {
                return null;
            }
            return nextEvictable;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i<K, V> poll() {
            i<K, V> nextEvictable = this.f2725a.getNextEvictable();
            if (nextEvictable == this.f2725a) {
                return null;
            }
            remove(nextEvictable);
            return nextEvictable;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            i iVar = (i) obj;
            i<K, V> previousEvictable = iVar.getPreviousEvictable();
            i<K, V> nextEvictable = iVar.getNextEvictable();
            MapMakerInternalMap.connectEvictables(previousEvictable, nextEvictable);
            MapMakerInternalMap.nullifyEvictable(iVar);
            return nextEvictable != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((i) obj).getNextEvictable() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f2725a.getNextEvictable() == this.f2725a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (i<K, V> nextEvictable = this.f2725a.getNextEvictable(); nextEvictable != this.f2725a; nextEvictable = nextEvictable.getNextEvictable()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i<K, V> nextEvictable = this.f2725a.getNextEvictable();
            while (nextEvictable != this.f2725a) {
                i<K, V> nextEvictable2 = nextEvictable.getNextEvictable();
                MapMakerInternalMap.nullifyEvictable(nextEvictable);
                nextEvictable = nextEvictable2;
            }
            this.f2725a.setNextEvictable(this.f2725a);
            this.f2725a.setPreviousEvictable(this.f2725a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<i<K, V>> iterator() {
            return new bo(this, peek());
        }
    }

    /* loaded from: classes2.dex */
    static final class e<K, V> extends AbstractQueue<i<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2726a = new bp(this);

        e() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(i<K, V> iVar) {
            MapMakerInternalMap.connectExpirables(iVar.getPreviousExpirable(), iVar.getNextExpirable());
            MapMakerInternalMap.connectExpirables(this.f2726a.getPreviousExpirable(), iVar);
            MapMakerInternalMap.connectExpirables(iVar, this.f2726a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i<K, V> peek() {
            i<K, V> nextExpirable = this.f2726a.getNextExpirable();
            if (nextExpirable == this.f2726a) {
                return null;
            }
            return nextExpirable;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i<K, V> poll() {
            i<K, V> nextExpirable = this.f2726a.getNextExpirable();
            if (nextExpirable == this.f2726a) {
                return null;
            }
            remove(nextExpirable);
            return nextExpirable;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            i iVar = (i) obj;
            i<K, V> previousExpirable = iVar.getPreviousExpirable();
            i<K, V> nextExpirable = iVar.getNextExpirable();
            MapMakerInternalMap.connectExpirables(previousExpirable, nextExpirable);
            MapMakerInternalMap.nullifyExpirable(iVar);
            return nextExpirable != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((i) obj).getNextExpirable() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f2726a.getNextExpirable() == this.f2726a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (i<K, V> nextExpirable = this.f2726a.getNextExpirable(); nextExpirable != this.f2726a; nextExpirable = nextExpirable.getNextExpirable()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i<K, V> nextExpirable = this.f2726a.getNextExpirable();
            while (nextExpirable != this.f2726a) {
                i<K, V> nextExpirable2 = nextExpirable.getNextExpirable();
                MapMakerInternalMap.nullifyExpirable(nextExpirable);
                nextExpirable = nextExpirable2;
            }
            this.f2726a.setNextExpirable(this.f2726a);
            this.f2726a.setPreviousExpirable(this.f2726a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<i<K, V>> iterator() {
            return new bq(this, peek());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += segmentArr[i2].modCount;
        }
        if (j2 != 0) {
            for (int i3 = 0; i3 < segmentArr.length; i3++) {
                if (segmentArr[i3].count != 0) {
                    return false;
                }
                j2 -= segmentArr[i3].modCount;
            }
            if (j2 != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.segments.length; i2++) {
            j2 += r1[i2].count;
        }
        return Ints.a(j2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    i<K, V> getEntry(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    i<K, V> getLiveEntry(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getLiveEntry(obj, hash);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:            r4 = r4 + r3.modCount;        r2 = r2 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:            return false;     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsValue(@javax.annotation.Nullable java.lang.Object r15) {
        /*
            r14 = this;
            if (r15 != 0) goto L4
            r0 = 0
        L3:
            return r0
        L4:
            com.google.common.collect.MapMakerInternalMap$Segment<K, V>[] r7 = r14.segments
            r4 = -1
            r0 = 0
            r6 = r0
            r8 = r4
        Lb:
            r0 = 3
            if (r6 >= r0) goto L51
            r2 = 0
            int r10 = r7.length
            r0 = 0
            r4 = r2
            r2 = r0
        L14:
            if (r2 >= r10) goto L4d
            r3 = r7[r2]
            int r0 = r3.count
            java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r11 = r3.table
            r0 = 0
            r1 = r0
        L1e:
            int r0 = r11.length()
            if (r1 >= r0) goto L45
            java.lang.Object r0 = r11.get(r1)
            com.google.common.collect.MapMakerInternalMap$i r0 = (com.google.common.collect.MapMakerInternalMap.i) r0
        L2a:
            if (r0 == 0) goto L41
            java.lang.Object r12 = r3.getLiveValue(r0)
            if (r12 == 0) goto L3c
            com.google.common.base.Equivalence<java.lang.Object> r13 = r14.valueEquivalence
            boolean r12 = r13.equivalent(r15, r12)
            if (r12 == 0) goto L3c
            r0 = 1
            goto L3
        L3c:
            com.google.common.collect.MapMakerInternalMap$i r0 = r0.getNext()
            goto L2a
        L41:
            int r0 = r1 + 1
            r1 = r0
            goto L1e
        L45:
            int r0 = r3.modCount
            long r0 = (long) r0
            long r4 = r4 + r0
            int r0 = r2 + 1
            r2 = r0
            goto L14
        L4d:
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 != 0) goto L53
        L51:
            r0 = 0
            goto L3
        L53:
            int r0 = r6 + 1
            r6 = r0
            r8 = r4
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.containsValue(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v2, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @Nullable V v2, V v3) {
        Preconditions.a(k2);
        Preconditions.a(v3);
        if (v2 == null) {
            return false;
        }
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v2, v3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        h hVar = new h();
        this.keySet = hVar;
        return hVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        v vVar = new v();
        this.values = vVar;
        return vVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class f {
        int b;
        int c = -1;
        Segment<K, V> d;
        AtomicReferenceArray<i<K, V>> e;
        i<K, V> f;
        MapMakerInternalMap<K, V>.ab g;
        MapMakerInternalMap<K, V>.ab h;

        f() {
            this.b = MapMakerInternalMap.this.segments.length - 1;
            b();
        }

        final void b() {
            this.g = null;
            if (!c() && !d()) {
                while (this.b >= 0) {
                    Segment<K, V>[] segmentArr = MapMakerInternalMap.this.segments;
                    int i = this.b;
                    this.b = i - 1;
                    this.d = segmentArr[i];
                    if (this.d.count != 0) {
                        this.e = this.d.table;
                        this.c = this.e.length() - 1;
                        if (d()) {
                            return;
                        }
                    }
                }
            }
        }

        boolean c() {
            if (this.f != null) {
                this.f = this.f.getNext();
                while (this.f != null) {
                    if (!a(this.f)) {
                        this.f = this.f.getNext();
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean d() {
            while (this.c >= 0) {
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.e;
                int i = this.c;
                this.c = i - 1;
                i<K, V> iVar = atomicReferenceArray.get(i);
                this.f = iVar;
                if (iVar != null && (a(this.f) || c())) {
                    return true;
                }
            }
            return false;
        }

        boolean a(i<K, V> iVar) {
            Segment<K, V> segment;
            try {
                K key = iVar.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(iVar);
                if (liveValue != null) {
                    this.g = new ab(key, liveValue);
                    return true;
                }
                return false;
            } finally {
                this.d.postReadCleanup();
            }
        }

        public boolean hasNext() {
            return this.g != null;
        }

        MapMakerInternalMap<K, V>.ab e() {
            if (this.g == null) {
                throw new NoSuchElementException();
            }
            this.h = this.g;
            b();
            return this.h;
        }

        public void remove() {
            Preconditions.b(this.h != null);
            MapMakerInternalMap.this.remove(this.h.getKey());
            this.h = null;
        }
    }

    /* loaded from: classes2.dex */
    final class g extends MapMakerInternalMap<K, V>.f implements Iterator<K> {
        g() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return e().getKey();
        }
    }

    /* loaded from: classes2.dex */
    final class t extends MapMakerInternalMap<K, V>.f implements Iterator<V> {
        t() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return e().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ab extends com.google.common.collect.f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2722a;
        V b;

        ab(K k, V v) {
            this.f2722a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public K getKey() {
            return this.f2722a;
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f2722a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public int hashCode() {
            return this.f2722a.hashCode() ^ this.b.hashCode();
        }

        @Override // com.google.common.collect.f, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.f2722a, v);
            this.b = v;
            return v2;
        }
    }

    /* loaded from: classes2.dex */
    final class b extends MapMakerInternalMap<K, V>.f implements Iterator<Map.Entry<K, V>> {
        b() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return e();
        }
    }

    /* loaded from: classes2.dex */
    final class h extends AbstractSet<K> {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    /* loaded from: classes2.dex */
    final class v extends AbstractCollection<V> {
        v() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new t();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    /* loaded from: classes2.dex */
    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    Object writeReplace() {
        return new SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final int maximumSize;
        final MapMaker.a<? super K, ? super V> removalListener;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, MapMaker.a<? super K, ? super V> aVar, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maximumSize = i;
            this.concurrencyLevel = i2;
            this.removalListener = aVar;
            this.delegate = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            MapMaker c = new MapMaker().a(objectInputStream.readInt()).a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).c(this.concurrencyLevel);
            c.a(this.removalListener);
            if (this.expireAfterWriteNanos > 0) {
                c.a(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
            }
            if (this.expireAfterAccessNanos > 0) {
                c.b(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
            }
            if (this.maximumSize != -1) {
                c.b(this.maximumSize);
            }
            return c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.delegate.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, MapMaker.a<? super K, ? super V> aVar, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, aVar, concurrentMap);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).b();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }
    }
}
