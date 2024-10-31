package com.google.common.cache;

import com.facebook.internal.NativeProtocol;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f2603a = Logger.getLogger(LocalCache.class.getName());
    static final ListeningExecutorService b = MoreExecutors.a();
    static final q<Object, Object> v = new com.google.common.cache.d();
    static final Queue<? extends Object> w = new com.google.common.cache.e();
    final int c;
    final int d;
    final Segment<K, V>[] e;
    final int f;
    final Equivalence<Object> g;
    final Equivalence<Object> h;
    final Strength i;
    final Strength j;
    final long k;
    final Weigher<K, V> l;
    final long m;
    final long n;
    final long o;
    final Queue<RemovalNotification<K, V>> p;
    final RemovalListener<K, V> q;
    final Ticker r;
    final EntryFactory s;
    final AbstractCache.StatsCounter t;

    @Nullable
    final CacheLoader<? super K, V> u;
    Set<K> x;
    Collection<V> y;
    Set<Map.Entry<K, V>> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface i<K, V> {
        long getAccessTime();

        int getHash();

        @Nullable
        K getKey();

        @Nullable
        i<K, V> getNext();

        i<K, V> getNextInAccessQueue();

        i<K, V> getNextInWriteQueue();

        i<K, V> getPreviousInAccessQueue();

        i<K, V> getPreviousInWriteQueue();

        q<K, V> getValueReference();

        long getWriteTime();

        void setAccessTime(long j);

        void setNextInAccessQueue(i<K, V> iVar);

        void setNextInWriteQueue(i<K, V> iVar);

        void setPreviousInAccessQueue(i<K, V> iVar);

        void setPreviousInWriteQueue(i<K, V> iVar);

        void setValueReference(q<K, V> qVar);

        void setWriteTime(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface q<K, V> {
        int a();

        q<K, V> a(ReferenceQueue<V> referenceQueue, @Nullable V v, i<K, V> iVar);

        void a(@Nullable V v);

        @Nullable
        i<K, V> b();

        boolean c();

        boolean d();

        V e() throws ExecutionException;

        @Nullable
        V get();
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @Nullable CacheLoader<? super K, V> cacheLoader) {
        int i2 = 0;
        this.f = Math.min(cacheBuilder.e(), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.i = cacheBuilder.i();
        this.j = cacheBuilder.j();
        this.g = cacheBuilder.b();
        this.h = cacheBuilder.c();
        this.k = cacheBuilder.f();
        this.l = (Weigher<K, V>) cacheBuilder.g();
        this.m = cacheBuilder.l();
        this.n = cacheBuilder.k();
        this.o = cacheBuilder.m();
        this.q = (RemovalListener<K, V>) cacheBuilder.n();
        this.p = this.q == CacheBuilder.NullListener.INSTANCE ? q() : new ConcurrentLinkedQueue<>();
        this.r = cacheBuilder.a(j());
        this.s = EntryFactory.getFactory(this.i, l(), k());
        this.t = cacheBuilder.o().get();
        this.u = cacheLoader;
        int min = Math.min(cacheBuilder.d(), 1073741824);
        if (a() && !b()) {
            min = Math.min(min, (int) this.k);
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.f && (!a() || i3 * 20 <= this.k)) {
            i4++;
            i3 <<= 1;
        }
        this.d = 32 - i4;
        this.c = i3 - 1;
        this.e = c(i3);
        int i5 = min / i3;
        int i6 = 1;
        while (i6 < (i5 * i3 < min ? i5 + 1 : i5)) {
            i6 <<= 1;
        }
        if (a()) {
            long j2 = (this.k / i3) + 1;
            long j3 = this.k % i3;
            while (true) {
                long j4 = j2;
                if (i2 < this.e.length) {
                    j2 = ((long) i2) == j3 ? j4 - 1 : j4;
                    this.e[i2] = a(i6, j2, cacheBuilder.o().get());
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            while (i2 < this.e.length) {
                this.e[i2] = a(i6, -1L, cacheBuilder.o().get());
                i2++;
            }
        }
    }

    boolean a() {
        return this.k >= 0;
    }

    boolean b() {
        return this.l != CacheBuilder.OneWeigher.INSTANCE;
    }

    boolean c() {
        return this.n > 0;
    }

    boolean d() {
        return this.m > 0;
    }

    boolean e() {
        return this.o > 0;
    }

    boolean f() {
        return d() || a();
    }

    boolean g() {
        return c();
    }

    boolean h() {
        return c() || e();
    }

    boolean i() {
        return d();
    }

    boolean j() {
        return h() || i();
    }

    boolean k() {
        return g() || h();
    }

    boolean l() {
        return f() || i();
    }

    boolean m() {
        return this.i != Strength.STRONG;
    }

    boolean n() {
        return this.j != Strength.STRONG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> q<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v, int i) {
                return i == 1 ? new n(v) : new y(v, i);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> q<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v, int i) {
                return i == 1 ? new j(segment.valueReferenceQueue, v, iVar) : new x(segment.valueReferenceQueue, v, iVar, i);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> q<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v, int i) {
                return i == 1 ? new v(segment.valueReferenceQueue, v, iVar) : new z(segment.valueReferenceQueue, v, iVar, i);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> q<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v, int i);

        /* synthetic */ Strength(com.google.common.cache.d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new m(k, i, iVar);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new k(k, i, iVar);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyAccessEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new o(k, i, iVar);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyWriteEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new l(k, i, iVar);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyAccessEntry(iVar, copyEntry);
                copyWriteEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new u(segment.keyReferenceQueue, k, i, iVar);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new s(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyAccessEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new w(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyWriteEntry(iVar, copyEntry);
                return copyEntry;
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar) {
                return new t(segment.keyReferenceQueue, k, i, iVar);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> copyEntry = super.copyEntry(segment, iVar, iVar2);
                copyAccessEntry(iVar, copyEntry);
                copyWriteEntry(iVar, copyEntry);
                return copyEntry;
            }
        };

        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        abstract <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable i<K, V> iVar);

        /* synthetic */ EntryFactory(com.google.common.cache.d dVar) {
            this();
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(z2 ? (char) 2 : (char) 0) | (z ? (char) 1 : (char) 0) | (strength == Strength.WEAK ? (char) 4 : (char) 0)];
        }

        @GuardedBy
        <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
            return newEntry(segment, iVar.getKey(), iVar.getHash(), iVar2);
        }

        @GuardedBy
        <K, V> void copyAccessEntry(i<K, V> iVar, i<K, V> iVar2) {
            iVar2.setAccessTime(iVar.getAccessTime());
            LocalCache.a(iVar.getPreviousInAccessQueue(), iVar2);
            LocalCache.a(iVar2, iVar.getNextInAccessQueue());
            LocalCache.b((i) iVar);
        }

        @GuardedBy
        <K, V> void copyWriteEntry(i<K, V> iVar, i<K, V> iVar2) {
            iVar2.setWriteTime(iVar.getWriteTime());
            LocalCache.b(iVar.getPreviousInWriteQueue(), iVar2);
            LocalCache.b(iVar2, iVar.getNextInWriteQueue());
            LocalCache.c((i) iVar);
        }
    }

    static <K, V> q<K, V> o() {
        return (q<K, V>) v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum NullEntry implements i<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.LocalCache.i
        public q<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setValueReference(q<Object, Object> qVar) {
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.i
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.i
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<Object, Object> iVar) {
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<Object, Object> iVar) {
        }

        @Override // com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<Object, Object> iVar) {
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<Object, Object> iVar) {
        }
    }

    /* loaded from: classes2.dex */
    static abstract class a<K, V> implements i<K, V> {
        @Override // com.google.common.cache.LocalCache.i
        public q<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setValueReference(q<K, V> qVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }
    }

    static <K, V> i<K, V> p() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> q() {
        return (Queue<E>) w;
    }

    /* loaded from: classes2.dex */
    static class m<K, V> implements i<K, V> {
        final K g;
        final int h;
        final i<K, V> i;
        volatile q<K, V> j = LocalCache.o();

        m(K k, int i, @Nullable i<K, V> iVar) {
            this.g = k;
            this.h = i;
            this.i = iVar;
        }

        @Override // com.google.common.cache.LocalCache.i
        public K getKey() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public q<K, V> getValueReference() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setValueReference(q<K, V> qVar) {
            this.j = qVar;
        }

        @Override // com.google.common.cache.LocalCache.i
        public int getHash() {
            return this.h;
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNext() {
            return this.i;
        }
    }

    /* loaded from: classes2.dex */
    static final class k<K, V> extends m<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile long f2613a;

        @GuardedBy
        i<K, V> b;

        @GuardedBy
        i<K, V> c;

        k(K k, int i, @Nullable i<K, V> iVar) {
            super(k, i, iVar);
            this.f2613a = Long.MAX_VALUE;
            this.b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            return this.f2613a;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
            this.f2613a = j;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInAccessQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<K, V> iVar) {
            this.b = iVar;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<K, V> iVar) {
            this.c = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class o<K, V> extends m<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile long f2616a;

        @GuardedBy
        i<K, V> b;

        @GuardedBy
        i<K, V> c;

        o(K k, int i, @Nullable i<K, V> iVar) {
            super(k, i, iVar);
            this.f2616a = Long.MAX_VALUE;
            this.b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            return this.f2616a;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
            this.f2616a = j;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInWriteQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<K, V> iVar) {
            this.b = iVar;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInWriteQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<K, V> iVar) {
            this.c = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class l<K, V> extends m<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile long f2614a;

        @GuardedBy
        i<K, V> b;

        @GuardedBy
        i<K, V> c;
        volatile long d;

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        l(K k, int i, @Nullable i<K, V> iVar) {
            super(k, i, iVar);
            this.f2614a = Long.MAX_VALUE;
            this.b = LocalCache.p();
            this.c = LocalCache.p();
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.p();
            this.f = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            return this.f2614a;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
            this.f2614a = j;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInAccessQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<K, V> iVar) {
            this.b = iVar;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<K, V> iVar) {
            this.c = iVar;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<K, V> iVar) {
            this.f = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static class u<K, V> extends WeakReference<K> implements i<K, V> {
        final int g;
        final i<K, V> h;
        volatile q<K, V> i;

        u(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(k, referenceQueue);
            this.i = LocalCache.o();
            this.g = i;
            this.h = iVar;
        }

        @Override // com.google.common.cache.LocalCache.i
        public K getKey() {
            return (K) get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public i<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        public i<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public i<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        public i<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.LocalCache.i
        public q<K, V> getValueReference() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.i
        public void setValueReference(q<K, V> qVar) {
            this.i = qVar;
        }

        @Override // com.google.common.cache.LocalCache.i
        public int getHash() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.i
        public i<K, V> getNext() {
            return this.h;
        }
    }

    /* loaded from: classes2.dex */
    static final class s<K, V> extends u<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile long f2619a;

        @GuardedBy
        i<K, V> b;

        @GuardedBy
        i<K, V> c;

        s(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.f2619a = Long.MAX_VALUE;
            this.b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            return this.f2619a;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
            this.f2619a = j;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInAccessQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<K, V> iVar) {
            this.b = iVar;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<K, V> iVar) {
            this.c = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class w<K, V> extends u<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile long f2622a;

        @GuardedBy
        i<K, V> b;

        @GuardedBy
        i<K, V> c;

        w(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.f2622a = Long.MAX_VALUE;
            this.b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            return this.f2622a;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
            this.f2622a = j;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInWriteQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<K, V> iVar) {
            this.b = iVar;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInWriteQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<K, V> iVar) {
            this.c = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static final class t<K, V> extends u<K, V> implements i<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile long f2620a;

        @GuardedBy
        i<K, V> b;

        @GuardedBy
        i<K, V> c;
        volatile long d;

        @GuardedBy
        i<K, V> e;

        @GuardedBy
        i<K, V> f;

        t(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.f2620a = Long.MAX_VALUE;
            this.b = LocalCache.p();
            this.c = LocalCache.p();
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.p();
            this.f = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public long getAccessTime() {
            return this.f2620a;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setAccessTime(long j) {
            this.f2620a = j;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInAccessQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setNextInAccessQueue(i<K, V> iVar) {
            this.b = iVar;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setPreviousInAccessQueue(i<K, V> iVar) {
            this.c = iVar;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setWriteTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setNextInWriteQueue(i<K, V> iVar) {
            this.e = iVar;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public i<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.u, com.google.common.cache.LocalCache.i
        public void setPreviousInWriteQueue(i<K, V> iVar) {
            this.f = iVar;
        }
    }

    /* loaded from: classes2.dex */
    static class v<K, V> extends WeakReference<V> implements q<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2621a;

        v(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            super(v, referenceQueue);
            this.f2621a = iVar;
        }

        @Override // com.google.common.cache.LocalCache.q
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.q
        public i<K, V> b() {
            return this.f2621a;
        }

        @Override // com.google.common.cache.LocalCache.q
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.q
        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new v(referenceQueue, v, iVar);
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.q
        public V e() {
            return get();
        }
    }

    /* loaded from: classes2.dex */
    static class j<K, V> extends SoftReference<V> implements q<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2612a;

        j(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            super(v, referenceQueue);
            this.f2612a = iVar;
        }

        @Override // com.google.common.cache.LocalCache.q
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.q
        public i<K, V> b() {
            return this.f2612a;
        }

        @Override // com.google.common.cache.LocalCache.q
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.q
        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new j(referenceQueue, v, iVar);
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.q
        public V e() {
            return get();
        }
    }

    /* loaded from: classes2.dex */
    static class n<K, V> implements q<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final V f2615a;

        n(V v) {
            this.f2615a = v;
        }

        @Override // com.google.common.cache.LocalCache.q
        public V get() {
            return this.f2615a;
        }

        @Override // com.google.common.cache.LocalCache.q
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.q
        public i<K, V> b() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.q
        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.q
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.q
        public void a(V v) {
        }
    }

    /* loaded from: classes2.dex */
    static final class z<K, V> extends v<K, V> {
        final int b;

        z(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar, int i) {
            super(referenceQueue, v, iVar);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.q
        public int a() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.LocalCache.q
        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new z(referenceQueue, v, iVar, this.b);
        }
    }

    /* loaded from: classes2.dex */
    static final class x<K, V> extends j<K, V> {
        final int b;

        x(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar, int i) {
            super(referenceQueue, v, iVar);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.j, com.google.common.cache.LocalCache.q
        public int a() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.j, com.google.common.cache.LocalCache.q
        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new x(referenceQueue, v, iVar, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class y<K, V> extends n<K, V> {
        final int b;

        y(V v, int i) {
            super(v);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.n, com.google.common.cache.LocalCache.q
        public int a() {
            return this.b;
        }
    }

    static int a(int i2) {
        int i3 = ((i2 << 15) ^ (-12931)) + i2;
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    int a(Object obj) {
        return a(this.g.hash(obj));
    }

    void a(q<K, V> qVar) {
        i<K, V> b2 = qVar.b();
        int hash = b2.getHash();
        b(hash).reclaimValue(b2.getKey(), hash, qVar);
    }

    void a(i<K, V> iVar) {
        int hash = iVar.getHash();
        b(hash).reclaimKey(iVar, hash);
    }

    Segment<K, V> b(int i2) {
        return this.e[(i2 >>> this.d) & this.c];
    }

    Segment<K, V> a(int i2, long j2, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i2, j2, statsCounter);
    }

    @Nullable
    V a(i<K, V> iVar, long j2) {
        V v2;
        if (iVar.getKey() == null || (v2 = iVar.getValueReference().get()) == null || b(iVar, j2)) {
            return null;
        }
        return v2;
    }

    boolean b(i<K, V> iVar, long j2) {
        if (!d() || j2 - iVar.getAccessTime() <= this.m) {
            return c() && j2 - iVar.getWriteTime() > this.n;
        }
        return true;
    }

    @GuardedBy
    static <K, V> void a(i<K, V> iVar, i<K, V> iVar2) {
        iVar.setNextInAccessQueue(iVar2);
        iVar2.setPreviousInAccessQueue(iVar);
    }

    @GuardedBy
    static <K, V> void b(i<K, V> iVar) {
        i<K, V> p2 = p();
        iVar.setNextInAccessQueue(p2);
        iVar.setPreviousInAccessQueue(p2);
    }

    @GuardedBy
    static <K, V> void b(i<K, V> iVar, i<K, V> iVar2) {
        iVar.setNextInWriteQueue(iVar2);
        iVar2.setPreviousInWriteQueue(iVar);
    }

    @GuardedBy
    static <K, V> void c(i<K, V> iVar) {
        i<K, V> p2 = p();
        iVar.setNextInWriteQueue(p2);
        iVar.setPreviousInWriteQueue(p2);
    }

    void r() {
        while (true) {
            RemovalNotification<K, V> poll = this.p.poll();
            if (poll != null) {
                try {
                    this.q.onRemoval(poll);
                } catch (Throwable th) {
                    f2603a.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    final Segment<K, V>[] c(int i2) {
        return new Segment[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Segment<K, V> extends ReentrantLock {

        @GuardedBy
        final Queue<i<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<i<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        volatile AtomicReferenceArray<i<K, V>> table;
        int threshold;

        @GuardedBy
        int totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;

        @GuardedBy
        final Queue<i<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache.StatsCounter statsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = statsCounter;
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.m() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.n() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.f() ? new ConcurrentLinkedQueue<>() : LocalCache.q();
            this.writeQueue = localCache.g() ? new aa<>() : LocalCache.q();
            this.accessQueue = localCache.f() ? new b<>() : LocalCache.q();
        }

        AtomicReferenceArray<i<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        void initTable(AtomicReferenceArray<i<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.b() && this.threshold == this.maxSegmentWeight) {
                this.threshold++;
            }
            this.table = atomicReferenceArray;
        }

        @GuardedBy
        i<K, V> newEntry(K k, int i, @Nullable i<K, V> iVar) {
            return this.map.s.newEntry(this, k, i, iVar);
        }

        @GuardedBy
        i<K, V> copyEntry(i<K, V> iVar, i<K, V> iVar2) {
            if (iVar.getKey() == null) {
                return null;
            }
            q<K, V> valueReference = iVar.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.d()) {
                return null;
            }
            i<K, V> copyEntry = this.map.s.copyEntry(this, iVar, iVar2);
            copyEntry.setValueReference(valueReference.a(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        @GuardedBy
        void setValue(i<K, V> iVar, K k, V v, long j) {
            q<K, V> valueReference = iVar.getValueReference();
            int weigh = this.map.l.weigh(k, v);
            Preconditions.b(weigh >= 0, "Weights must be non-negative");
            iVar.setValueReference(this.map.j.referenceValue(this, iVar, v, weigh));
            recordWrite(iVar, weigh, j);
            valueReference.a(v);
        }

        V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            V lockedGetOrLoad;
            i<K, V> entry;
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                        long a2 = this.map.r.a();
                        V liveValue = getLiveValue(entry, a2);
                        if (liveValue != null) {
                            recordRead(entry, a2);
                            this.statsCounter.a(1);
                            lockedGetOrLoad = scheduleRefresh(entry, k, i, liveValue, a2, cacheLoader);
                        } else {
                            q<K, V> valueReference = entry.getValueReference();
                            if (valueReference.c()) {
                                lockedGetOrLoad = waitForLoadingValue(entry, k, valueReference);
                            }
                        }
                        return lockedGetOrLoad;
                    }
                    lockedGetOrLoad = lockedGetOrLoad(k, i, cacheLoader);
                    return lockedGetOrLoad;
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e;
                }
            } finally {
                postReadCleanup();
            }
        }

        V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            q<K, V> qVar;
            boolean z;
            h<K, V> hVar;
            i<K, V> iVar;
            V loadSync;
            lock();
            try {
                long a2 = this.map.r.a();
                preWriteCleanup(a2);
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar2 = atomicReferenceArray.get(length);
                i<K, V> iVar3 = iVar2;
                while (true) {
                    if (iVar3 == null) {
                        qVar = null;
                        z = true;
                        break;
                    }
                    K key = iVar3.getKey();
                    if (iVar3.getHash() != i || key == null || !this.map.g.equivalent(k, key)) {
                        iVar3 = iVar3.getNext();
                    } else {
                        q<K, V> valueReference = iVar3.getValueReference();
                        if (valueReference.c()) {
                            z = false;
                            qVar = valueReference;
                        } else {
                            V v = valueReference.get();
                            if (v == null) {
                                enqueueNotification(key, i, valueReference, RemovalCause.COLLECTED);
                            } else if (this.map.b(iVar3, a2)) {
                                enqueueNotification(key, i, valueReference, RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(iVar3, a2);
                                this.statsCounter.a(1);
                                return v;
                            }
                            this.writeQueue.remove(iVar3);
                            this.accessQueue.remove(iVar3);
                            this.count = i2;
                            z = true;
                            qVar = valueReference;
                        }
                    }
                }
                if (!z) {
                    hVar = null;
                    iVar = iVar3;
                } else {
                    h<K, V> hVar2 = new h<>();
                    if (iVar3 == null) {
                        i<K, V> newEntry = newEntry(k, i, iVar2);
                        newEntry.setValueReference(hVar2);
                        atomicReferenceArray.set(length, newEntry);
                        iVar = newEntry;
                        hVar = hVar2;
                    } else {
                        iVar3.setValueReference(hVar2);
                        hVar = hVar2;
                        iVar = iVar3;
                    }
                }
                if (z) {
                    try {
                        synchronized (iVar) {
                            loadSync = loadSync(k, i, hVar, cacheLoader);
                        }
                        return loadSync;
                    } finally {
                        this.statsCounter.b(1);
                    }
                }
                return waitForLoadingValue(iVar, k, qVar);
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        V waitForLoadingValue(i<K, V> iVar, K k, q<K, V> qVar) throws ExecutionException {
            if (!qVar.c()) {
                throw new AssertionError();
            }
            Preconditions.b(!Thread.holdsLock(iVar), "Recursive load");
            try {
                V e = qVar.e();
                if (e == null) {
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                }
                recordRead(iVar, this.map.r.a());
                return e;
            } finally {
                this.statsCounter.b(1);
            }
        }

        V loadSync(K k, int i, h<K, V> hVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, hVar, hVar.a((h<K, V>) k, (CacheLoader<? super h<K, V>, V>) cacheLoader));
        }

        ListenableFuture<V> loadAsync(K k, int i, h<K, V> hVar, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> a2 = hVar.a((h<K, V>) k, (CacheLoader<? super h<K, V>, V>) cacheLoader);
            a2.a(new com.google.common.cache.i(this, k, i, hVar, a2), LocalCache.b);
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public V getAndRecordStats(K k, int i, h<K, V> hVar, ListenableFuture<V> listenableFuture) throws ExecutionException {
            try {
                V v = (V) Uninterruptibles.a(listenableFuture);
                if (v == null) {
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                }
                this.statsCounter.a(hVar.f());
                storeLoadedValue(k, i, hVar, v);
                if (v == null) {
                    this.statsCounter.b(hVar.f());
                    removeLoadingValue(k, i, hVar);
                }
                return v;
            } catch (Throwable th) {
                if (0 == 0) {
                    this.statsCounter.b(hVar.f());
                    removeLoadingValue(k, i, hVar);
                }
                throw th;
            }
        }

        V scheduleRefresh(i<K, V> iVar, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.e() || j - iVar.getWriteTime() <= this.map.o || (refresh = refresh(k, i, cacheLoader)) == null) ? v : refresh;
        }

        @Nullable
        V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader) {
            h<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (!loadAsync.isDone()) {
                return null;
            }
            try {
                return (V) Uninterruptibles.a(loadAsync);
            } catch (Throwable th) {
                return null;
            }
        }

        @Nullable
        h<K, V> insertLoadingValueReference(K k, int i) {
            lock();
            try {
                preWriteCleanup(this.map.r.a());
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(k, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        if (valueReference.c()) {
                            return null;
                        }
                        this.modCount++;
                        h<K, V> hVar = new h<>(valueReference);
                        iVar2.setValueReference(hVar);
                        return hVar;
                    }
                }
                this.modCount++;
                h<K, V> hVar2 = new h<>();
                i<K, V> newEntry = newEntry(k, i, iVar);
                newEntry.setValueReference(hVar2);
                atomicReferenceArray.set(length, newEntry);
                return hVar2;
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

        @GuardedBy
        void drainReferenceQueues() {
            if (this.map.m()) {
                drainKeyReferenceQueue();
            }
            if (this.map.n()) {
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
                    this.map.a((i) poll);
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
                    this.map.a((q) poll);
                    i = i2 + 1;
                } else {
                    return;
                }
            } while (i != 16);
        }

        void clearReferenceQueues() {
            if (this.map.m()) {
                clearKeyReferenceQueue();
            }
            if (this.map.n()) {
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

        void recordRead(i<K, V> iVar, long j) {
            if (this.map.i()) {
                iVar.setAccessTime(j);
            }
            this.recencyQueue.add(iVar);
        }

        @GuardedBy
        void recordLockedRead(i<K, V> iVar, long j) {
            if (this.map.i()) {
                iVar.setAccessTime(j);
            }
            this.accessQueue.add(iVar);
        }

        @GuardedBy
        void recordWrite(i<K, V> iVar, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.i()) {
                iVar.setAccessTime(j);
            }
            if (this.map.h()) {
                iVar.setWriteTime(j);
            }
            this.accessQueue.add(iVar);
            this.writeQueue.add(iVar);
        }

        @GuardedBy
        void drainRecencyQueue() {
            while (true) {
                i<K, V> poll = this.recencyQueue.poll();
                if (poll != null) {
                    if (this.accessQueue.contains(poll)) {
                        this.accessQueue.add(poll);
                    }
                } else {
                    return;
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

        @GuardedBy
        void expireEntries(long j) {
            i<K, V> peek;
            i<K, V> peek2;
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

        @GuardedBy
        void enqueueNotification(i<K, V> iVar, RemovalCause removalCause) {
            enqueueNotification(iVar.getKey(), iVar.getHash(), iVar.getValueReference(), removalCause);
        }

        @GuardedBy
        void enqueueNotification(@Nullable K k, int i, q<K, V> qVar, RemovalCause removalCause) {
            this.totalWeight -= qVar.a();
            if (removalCause.wasEvicted()) {
                this.statsCounter.a();
            }
            if (this.map.p != LocalCache.w) {
                this.map.p.offer(new RemovalNotification<>(k, qVar.get(), removalCause));
            }
        }

        @GuardedBy
        void evictEntries() {
            if (this.map.a()) {
                drainRecencyQueue();
                while (this.totalWeight > this.maxSegmentWeight) {
                    i<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        i<K, V> getNextEvictable() {
            for (i<K, V> iVar : this.accessQueue) {
                if (iVar.getValueReference().a() > 0) {
                    return iVar;
                }
            }
            throw new AssertionError();
        }

        i<K, V> getFirst(int i) {
            return this.table.get((r0.length() - 1) & i);
        }

        @Nullable
        i<K, V> getEntry(Object obj, int i) {
            for (i<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.g.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        @Nullable
        i<K, V> getLiveEntry(Object obj, int i, long j) {
            i<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.b(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        V getLiveValue(i<K, V> iVar, long j) {
            if (iVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = iVar.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.b(iVar, j)) {
                return v;
            }
            tryExpireEntries(j);
            return null;
        }

        @Nullable
        V get(Object obj, int i) {
            V v = null;
            try {
                if (this.count != 0) {
                    long a2 = this.map.r.a();
                    i<K, V> liveEntry = getLiveEntry(obj, i, a2);
                    if (liveEntry != null) {
                        V v2 = liveEntry.getValueReference().get();
                        if (v2 != null) {
                            recordRead(liveEntry, a2);
                            v = scheduleRefresh(liveEntry, liveEntry.getKey(), i, v2, a2, this.map.u);
                        } else {
                            tryDrainReferenceQueues();
                        }
                    }
                    return v;
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        boolean containsKey(Object obj, int i) {
            try {
                if (this.count != 0) {
                    i<K, V> liveEntry = getLiveEntry(obj, i, this.map.r.a());
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
                    long a2 = this.map.r.a();
                    AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (i<K, V> iVar = atomicReferenceArray.get(i); iVar != null; iVar = iVar.getNext()) {
                            V liveValue = getLiveValue(iVar, a2);
                            if (liveValue != null && this.map.h.equivalent(obj, liveValue)) {
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

        @Nullable
        V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long a2 = this.map.r.a();
                preWriteCleanup(a2);
                if (this.count + 1 > this.threshold) {
                    expand();
                    int i3 = this.count + 1;
                }
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(k, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            if (z) {
                                recordLockedRead(iVar2, a2);
                                return v2;
                            }
                            this.modCount++;
                            enqueueNotification(k, i, valueReference, RemovalCause.REPLACED);
                            setValue(iVar2, k, v, a2);
                            evictEntries();
                            return v2;
                        }
                        this.modCount++;
                        if (valueReference.d()) {
                            enqueueNotification(k, i, valueReference, RemovalCause.COLLECTED);
                            setValue(iVar2, k, v, a2);
                            i2 = this.count;
                        } else {
                            setValue(iVar2, k, v, a2);
                            i2 = this.count + 1;
                        }
                        this.count = i2;
                        evictEntries();
                        return null;
                    }
                }
                this.modCount++;
                i<K, V> newEntry = newEntry(k, i, iVar);
                setValue(newEntry, k, v, a2);
                atomicReferenceArray.set(length, newEntry);
                this.count++;
                evictEntries();
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
            if (length < 1073741824) {
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
                long a2 = this.map.r.a();
                preWriteCleanup(a2);
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(k, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        V v3 = valueReference.get();
                        if (v3 == null) {
                            if (valueReference.d()) {
                                int i2 = this.count - 1;
                                this.modCount++;
                                i<K, V> removeValueFromChain = removeValueFromChain(iVar, iVar2, key, i, valueReference, RemovalCause.COLLECTED);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, removeValueFromChain);
                                this.count = i3;
                            }
                            return false;
                        }
                        if (!this.map.h.equivalent(v, v3)) {
                            recordLockedRead(iVar2, a2);
                            return false;
                        }
                        this.modCount++;
                        enqueueNotification(k, i, valueReference, RemovalCause.REPLACED);
                        setValue(iVar2, k, v2, a2);
                        evictEntries();
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @Nullable
        V replace(K k, int i, V v) {
            lock();
            try {
                long a2 = this.map.r.a();
                preWriteCleanup(a2);
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(k, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            this.modCount++;
                            enqueueNotification(k, i, valueReference, RemovalCause.REPLACED);
                            setValue(iVar2, k, v, a2);
                            evictEntries();
                            return v2;
                        }
                        if (valueReference.d()) {
                            int i2 = this.count - 1;
                            this.modCount++;
                            i<K, V> removeValueFromChain = removeValueFromChain(iVar, iVar2, key, i, valueReference, RemovalCause.COLLECTED);
                            int i3 = this.count - 1;
                            atomicReferenceArray.set(length, removeValueFromChain);
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

        @Nullable
        V remove(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.r.a());
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(obj, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (!valueReference.d()) {
                                return null;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        i<K, V> removeValueFromChain = removeValueFromChain(iVar, iVar2, key, i, valueReference, removalCause);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
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

        boolean storeLoadedValue(K k, int i, h<K, V> hVar, V v) {
            lock();
            try {
                long a2 = this.map.r.a();
                preWriteCleanup(a2);
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
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(k, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        V v2 = valueReference.get();
                        if (hVar != valueReference && (v2 != null || valueReference == LocalCache.v)) {
                            enqueueNotification(k, i, new y(v, 0), RemovalCause.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (hVar.d()) {
                            enqueueNotification(k, i, hVar, v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i2--;
                        }
                        setValue(iVar2, k, v, a2);
                        this.count = i2;
                        evictEntries();
                        return true;
                    }
                }
                this.modCount++;
                i<K, V> newEntry = newEntry(k, i, iVar);
                setValue(newEntry, k, v, a2);
                atomicReferenceArray.set(length, newEntry);
                this.count = i2;
                evictEntries();
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean remove(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.r.a());
                int i2 = this.count - 1;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(obj, key)) {
                        q<K, V> valueReference = iVar2.getValueReference();
                        V v = valueReference.get();
                        if (this.map.h.equivalent(obj2, v)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (v != null || !valueReference.d()) {
                                return false;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        i<K, V> removeValueFromChain = removeValueFromChain(iVar, iVar2, key, i, valueReference, removalCause);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i3;
                        boolean z = removalCause == RemovalCause.EXPLICIT;
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
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (i<K, V> iVar = atomicReferenceArray.get(i); iVar != null; iVar = iVar.getNext()) {
                            if (iVar.getValueReference().d()) {
                                enqueueNotification(iVar, RemovalCause.EXPLICIT);
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

        @GuardedBy
        @Nullable
        i<K, V> removeValueFromChain(i<K, V> iVar, i<K, V> iVar2, @Nullable K k, int i, q<K, V> qVar, RemovalCause removalCause) {
            enqueueNotification(k, i, qVar, removalCause);
            this.writeQueue.remove(iVar2);
            this.accessQueue.remove(iVar2);
            if (!qVar.c()) {
                return removeEntryFromChain(iVar, iVar2);
            }
            qVar.a(null);
            return iVar;
        }

        @GuardedBy
        @Nullable
        i<K, V> removeEntryFromChain(i<K, V> iVar, i<K, V> iVar2) {
            int i;
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

        @GuardedBy
        void removeCollectedEntry(i<K, V> iVar) {
            enqueueNotification(iVar, RemovalCause.COLLECTED);
            this.writeQueue.remove(iVar);
            this.accessQueue.remove(iVar);
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
                        i<K, V> removeValueFromChain = removeValueFromChain(iVar2, iVar3, iVar3.getKey(), i, iVar3.getValueReference(), RemovalCause.COLLECTED);
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

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:            if (r2.getValueReference() != r12) goto L17;     */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:            r9.modCount++;        r0 = removeValueFromChain(r1, r2, r3, r11, r12, com.google.common.cache.RemovalCause.COLLECTED);        r1 = r9.count - 1;        r7.set(r8, r0);        r9.count = r1;     */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:            r0 = true;        unlock();        r1 = isHeldByCurrentThread();     */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:            unlock();     */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:            if (isHeldByCurrentThread() != false) goto L16;     */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:            postWriteCleanup();     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean reclaimValue(K r10, int r11, com.google.common.cache.LocalCache.q<K, V> r12) {
            /*
                r9 = this;
                r0 = 0
                r9.lock()
                int r1 = r9.count     // Catch: java.lang.Throwable -> L7c
                int r1 = r1 + (-1)
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.LocalCache$i<K, V>> r7 = r9.table     // Catch: java.lang.Throwable -> L7c
                int r1 = r7.length()     // Catch: java.lang.Throwable -> L7c
                int r1 = r1 + (-1)
                r8 = r11 & r1
                java.lang.Object r1 = r7.get(r8)     // Catch: java.lang.Throwable -> L7c
                com.google.common.cache.LocalCache$i r1 = (com.google.common.cache.LocalCache.i) r1     // Catch: java.lang.Throwable -> L7c
                r2 = r1
            L19:
                if (r2 == 0) goto L6f
                java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Throwable -> L7c
                int r4 = r2.getHash()     // Catch: java.lang.Throwable -> L7c
                if (r4 != r11) goto L6a
                if (r3 == 0) goto L6a
                com.google.common.cache.LocalCache<K, V> r4 = r9.map     // Catch: java.lang.Throwable -> L7c
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.g     // Catch: java.lang.Throwable -> L7c
                boolean r4 = r4.equivalent(r10, r3)     // Catch: java.lang.Throwable -> L7c
                if (r4 == 0) goto L6a
                com.google.common.cache.LocalCache$q r4 = r2.getValueReference()     // Catch: java.lang.Throwable -> L7c
                if (r4 != r12) goto L5d
                int r0 = r9.modCount     // Catch: java.lang.Throwable -> L7c
                int r0 = r0 + 1
                r9.modCount = r0     // Catch: java.lang.Throwable -> L7c
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L7c
                r0 = r9
                r4 = r11
                r5 = r12
                com.google.common.cache.LocalCache$i r0 = r0.removeValueFromChain(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L7c
                int r1 = r9.count     // Catch: java.lang.Throwable -> L7c
                int r1 = r1 + (-1)
                r7.set(r8, r0)     // Catch: java.lang.Throwable -> L7c
                r9.count = r1     // Catch: java.lang.Throwable -> L7c
                r0 = 1
                r9.unlock()
                boolean r1 = r9.isHeldByCurrentThread()
                if (r1 != 0) goto L5c
                r9.postWriteCleanup()
            L5c:
                return r0
            L5d:
                r9.unlock()
                boolean r1 = r9.isHeldByCurrentThread()
                if (r1 != 0) goto L5c
                r9.postWriteCleanup()
                goto L5c
            L6a:
                com.google.common.cache.LocalCache$i r2 = r2.getNext()     // Catch: java.lang.Throwable -> L7c
                goto L19
            L6f:
                r9.unlock()
                boolean r1 = r9.isHeldByCurrentThread()
                if (r1 != 0) goto L5c
                r9.postWriteCleanup()
                goto L5c
            L7c:
                r0 = move-exception
                r9.unlock()
                boolean r1 = r9.isHeldByCurrentThread()
                if (r1 != 0) goto L89
                r9.postWriteCleanup()
            L89:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.reclaimValue(java.lang.Object, int, com.google.common.cache.LocalCache$q):boolean");
        }

        boolean removeLoadingValue(K k, int i, h<K, V> hVar) {
            lock();
            try {
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    K key = iVar2.getKey();
                    if (iVar2.getHash() == i && key != null && this.map.g.equivalent(k, key)) {
                        if (iVar2.getValueReference() != hVar) {
                            return false;
                        }
                        if (hVar.d()) {
                            iVar2.setValueReference(hVar.g());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(iVar, iVar2));
                        }
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
        boolean removeEntry(i<K, V> iVar, int i, RemovalCause removalCause) {
            int i2 = this.count - 1;
            AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
            int length = i & (atomicReferenceArray.length() - 1);
            i<K, V> iVar2 = atomicReferenceArray.get(length);
            for (i<K, V> iVar3 = iVar2; iVar3 != null; iVar3 = iVar3.getNext()) {
                if (iVar3 == iVar) {
                    this.modCount++;
                    i<K, V> removeValueFromChain = removeValueFromChain(iVar2, iVar3, iVar3.getKey(), i, iVar3.getValueReference(), removalCause);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        @GuardedBy
        void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void cleanUp() {
            runLockedCleanup(this.map.r.a());
            runUnlockedCleanup();
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
            if (!isHeldByCurrentThread()) {
                this.map.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h<K, V> implements q<K, V> {

        /* renamed from: a, reason: collision with root package name */
        volatile q<K, V> f2611a;
        final SettableFuture<V> b;
        final Stopwatch c;

        public h() {
            this(LocalCache.o());
        }

        public h(q<K, V> qVar) {
            this.b = SettableFuture.b();
            this.c = new Stopwatch();
            this.f2611a = qVar;
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean c() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.q
        public boolean d() {
            return this.f2611a.d();
        }

        @Override // com.google.common.cache.LocalCache.q
        public int a() {
            return this.f2611a.a();
        }

        public boolean b(@Nullable V v) {
            return this.b.a((SettableFuture<V>) v);
        }

        public boolean a(Throwable th) {
            return a((SettableFuture<?>) this.b, th);
        }

        private static boolean a(SettableFuture<?> settableFuture, Throwable th) {
            try {
                return settableFuture.a(th);
            } catch (Error e) {
                return false;
            }
        }

        private ListenableFuture<V> b(Throwable th) {
            SettableFuture b = SettableFuture.b();
            a((SettableFuture<?>) b, th);
            return b;
        }

        @Override // com.google.common.cache.LocalCache.q
        public void a(@Nullable V v) {
            if (v != null) {
                b((h<K, V>) v);
            } else {
                this.f2611a = LocalCache.o();
            }
        }

        public ListenableFuture<V> a(K k, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> reload;
            this.c.a();
            V v = this.f2611a.get();
            try {
                if (v == null) {
                    V load = cacheLoader.load(k);
                    reload = b((h<K, V>) load) ? this.b : Futures.a(load);
                } else {
                    reload = cacheLoader.reload(k, v);
                    if (reload == null) {
                        reload = Futures.a(null);
                    }
                }
                return reload;
            } catch (Throwable th) {
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return a(th) ? this.b : b(th);
            }
        }

        public long f() {
            return this.c.a(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.q
        public V e() throws ExecutionException {
            return (V) Uninterruptibles.a(this.b);
        }

        @Override // com.google.common.cache.LocalCache.q
        public V get() {
            return this.f2611a.get();
        }

        public q<K, V> g() {
            return this.f2611a;
        }

        @Override // com.google.common.cache.LocalCache.q
        public i<K, V> b() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.q
        public q<K, V> a(ReferenceQueue<V> referenceQueue, @Nullable V v, i<K, V> iVar) {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    static final class aa<K, V> extends AbstractQueue<i<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2604a = new com.google.common.cache.j(this);

        aa() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(i<K, V> iVar) {
            LocalCache.b(iVar.getPreviousInWriteQueue(), iVar.getNextInWriteQueue());
            LocalCache.b(this.f2604a.getPreviousInWriteQueue(), iVar);
            LocalCache.b(iVar, this.f2604a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i<K, V> peek() {
            i<K, V> nextInWriteQueue = this.f2604a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f2604a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i<K, V> poll() {
            i<K, V> nextInWriteQueue = this.f2604a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f2604a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            i iVar = (i) obj;
            i<K, V> previousInWriteQueue = iVar.getPreviousInWriteQueue();
            i<K, V> nextInWriteQueue = iVar.getNextInWriteQueue();
            LocalCache.b(previousInWriteQueue, nextInWriteQueue);
            LocalCache.c(iVar);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((i) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f2604a.getNextInWriteQueue() == this.f2604a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (i<K, V> nextInWriteQueue = this.f2604a.getNextInWriteQueue(); nextInWriteQueue != this.f2604a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i<K, V> nextInWriteQueue = this.f2604a.getNextInWriteQueue();
            while (nextInWriteQueue != this.f2604a) {
                i<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                LocalCache.c((i) nextInWriteQueue);
                nextInWriteQueue = nextInWriteQueue2;
            }
            this.f2604a.setNextInWriteQueue(this.f2604a);
            this.f2604a.setPreviousInWriteQueue(this.f2604a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<i<K, V>> iterator() {
            return new com.google.common.cache.k(this, peek());
        }
    }

    /* loaded from: classes2.dex */
    static final class b<K, V> extends AbstractQueue<i<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final i<K, V> f2606a = new com.google.common.cache.f(this);

        b() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(i<K, V> iVar) {
            LocalCache.a(iVar.getPreviousInAccessQueue(), iVar.getNextInAccessQueue());
            LocalCache.a(this.f2606a.getPreviousInAccessQueue(), iVar);
            LocalCache.a(iVar, this.f2606a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i<K, V> peek() {
            i<K, V> nextInAccessQueue = this.f2606a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f2606a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i<K, V> poll() {
            i<K, V> nextInAccessQueue = this.f2606a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f2606a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            i iVar = (i) obj;
            i<K, V> previousInAccessQueue = iVar.getPreviousInAccessQueue();
            i<K, V> nextInAccessQueue = iVar.getNextInAccessQueue();
            LocalCache.a(previousInAccessQueue, nextInAccessQueue);
            LocalCache.b(iVar);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((i) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f2606a.getNextInAccessQueue() == this.f2606a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (i<K, V> nextInAccessQueue = this.f2606a.getNextInAccessQueue(); nextInAccessQueue != this.f2606a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i<K, V> nextInAccessQueue = this.f2606a.getNextInAccessQueue();
            while (nextInAccessQueue != this.f2606a) {
                i<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                LocalCache.b((i) nextInAccessQueue);
                nextInAccessQueue = nextInAccessQueue2;
            }
            this.f2606a.setNextInAccessQueue(this.f2606a);
            this.f2606a.setPreviousInAccessQueue(this.f2606a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<i<K, V>> iterator() {
            return new com.google.common.cache.g(this, peek());
        }
    }

    public void s() {
        for (Segment<K, V> segment : this.e) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.e;
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

    long t() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.e.length; i2++) {
            j2 += r1[i2].count;
        }
        return j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.a(t());
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int a2 = a(obj);
        return b(a2).get(obj, a2);
    }

    @Nullable
    public V b(Object obj) {
        int a2 = a(Preconditions.a(obj));
        V v2 = b(a2).get(obj, a2);
        if (v2 == null) {
            this.t.b(1);
        } else {
            this.t.a(1);
        }
        return v2;
    }

    V a(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int a2 = a(Preconditions.a(k2));
        return b(a2).get(k2, a2, cacheLoader);
    }

    V c(K k2) throws ExecutionException {
        return a((LocalCache<K, V>) k2, (CacheLoader<? super LocalCache<K, V>, V>) this.u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> a(Iterable<?> iterable) {
        int i2 = 0;
        LinkedHashMap b2 = Maps.b();
        int i3 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i2++;
            } else {
                b2.put(obj, v2);
                i3++;
            }
        }
        this.t.a(i3);
        this.t.b(i2);
        return ImmutableMap.copyOf((Map) b2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.cache.AbstractCache$StatsCounter] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.common.cache.AbstractCache$StatsCounter] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Set, java.util.LinkedHashSet] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.common.cache.LocalCache, com.google.common.cache.LocalCache<K, V>] */
    ImmutableMap<K, V> b(Iterable<? extends K> iterable) throws ExecutionException {
        Throwable th;
        int i2 = 0;
        ?? b2 = Maps.b();
        ?? b3 = Sets.b();
        int i3 = 0;
        for (K k2 : iterable) {
            Object obj = get(k2);
            if (!b2.containsKey(k2)) {
                b2.put(k2, obj);
                if (obj == null) {
                    i2++;
                    b3.add(k2);
                } else {
                    i3++;
                }
            }
        }
        try {
            if (b3.isEmpty()) {
                b3 = i2;
            } else {
                try {
                    try {
                        Map a2 = a(b3, this.u);
                        for (Object obj2 : b3) {
                            Object obj3 = a2.get(obj2);
                            if (obj3 == null) {
                                throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                            }
                            b2.put(obj2, obj3);
                        }
                        b3 = i2;
                    } catch (CacheLoader.UnsupportedLoadingOperationException e2) {
                        b3 = i2;
                        for (Object obj4 : b3) {
                            int i4 = (b3 == true ? 1 : 0) - 1;
                            b2.put(obj4, a(obj4, this.u));
                            b3 = i4;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.t.a(i3);
                    this.t.b(b3);
                    throw th;
                }
            }
            ImmutableMap<K, V> copyOf = ImmutableMap.copyOf((Map) b2);
            this.t.a(i3);
            this.t.b(b3);
            return copyOf;
        } catch (Throwable th3) {
            b3 = i2;
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map<K, V> a(java.util.Set<? extends K> r8, com.google.common.cache.CacheLoader<? super K, V> r9) throws java.util.concurrent.ExecutionException {
        /*
            r7 = this;
            r2 = 1
            r0 = 0
            com.google.common.base.Stopwatch r1 = new com.google.common.base.Stopwatch
            r1.<init>()
            com.google.common.base.Stopwatch r3 = r1.a()
            java.util.Map r4 = r9.loadAll(r8)     // Catch: com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> L35 java.lang.InterruptedException -> L46 java.lang.Throwable -> L54 java.lang.RuntimeException -> L58 java.lang.Exception -> L5f java.lang.Error -> L66
            if (r4 != 0) goto L6d
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.t
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r2 = r3.a(r1)
            r0.b(r2)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r0 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r2 = " returned null map from loadAll"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L35:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L37
        L37:
            r0 = move-exception
        L38:
            if (r2 != 0) goto L45
            com.google.common.cache.AbstractCache$StatsCounter r1 = r7.t
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r2 = r3.a(r2)
            r1.b(r2)
        L45:
            throw r0
        L46:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L54
            r2.interrupt()     // Catch: java.lang.Throwable -> L54
            java.util.concurrent.ExecutionException r2 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L54
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L54
            throw r2     // Catch: java.lang.Throwable -> L54
        L54:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L38
        L58:
            r1 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r2 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> L54
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L54
            throw r2     // Catch: java.lang.Throwable -> L54
        L5f:
            r1 = move-exception
            java.util.concurrent.ExecutionException r2 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L54
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L54
            throw r2     // Catch: java.lang.Throwable -> L54
        L66:
            r1 = move-exception
            com.google.common.util.concurrent.ExecutionError r2 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> L54
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L54
            throw r2     // Catch: java.lang.Throwable -> L54
        L6d:
            r3.b()
            java.util.Set r1 = r4.entrySet()
            java.util.Iterator r5 = r1.iterator()
            r1 = r0
        L79:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L99
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r6 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            if (r6 == 0) goto L91
            if (r0 != 0) goto L94
        L91:
            r0 = r2
        L92:
            r1 = r0
            goto L79
        L94:
            r7.put(r6, r0)
            r0 = r1
            goto L92
        L99:
            if (r1 == 0) goto Lbf
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.t
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r2 = r3.a(r1)
            r0.b(r2)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r0 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r2 = " returned null keys or values from loadAll"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Lbf:
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.t
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r2 = r3.a(r1)
            r0.a(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.a(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    void d(K k2) {
        int a2 = a(Preconditions.a(k2));
        b(a2).refresh(k2, a2, this.u);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int a2 = a(obj);
        return b(a2).containsKey(obj, a2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:            if (r8 != r12) goto L27;     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsValue(@javax.annotation.Nullable java.lang.Object r21) {
        /*
            r20 = this;
            if (r21 != 0) goto L4
            r4 = 0
        L3:
            return r4
        L4:
            r0 = r20
            com.google.common.base.Ticker r4 = r0.r
            long r14 = r4.a()
            r0 = r20
            com.google.common.cache.LocalCache$Segment<K, V>[] r11 = r0.e
            r8 = -1
            r4 = 0
            r10 = r4
            r12 = r8
        L15:
            r4 = 3
            if (r10 >= r4) goto L6d
            r6 = 0
            int r0 = r11.length
            r16 = r0
            r4 = 0
            r8 = r6
            r6 = r4
        L20:
            r0 = r16
            if (r6 >= r0) goto L69
            r7 = r11[r6]
            int r4 = r7.count
            java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.LocalCache$i<K, V>> r0 = r7.table
            r17 = r0
            r4 = 0
            r5 = r4
        L2e:
            int r4 = r17.length()
            if (r5 >= r4) goto L61
            r0 = r17
            java.lang.Object r4 = r0.get(r5)
            com.google.common.cache.LocalCache$i r4 = (com.google.common.cache.LocalCache.i) r4
        L3c:
            if (r4 == 0) goto L5d
            java.lang.Object r18 = r7.getLiveValue(r4, r14)
            if (r18 == 0) goto L58
            r0 = r20
            com.google.common.base.Equivalence<java.lang.Object> r0 = r0.h
            r19 = r0
            r0 = r19
            r1 = r21
            r2 = r18
            boolean r18 = r0.equivalent(r1, r2)
            if (r18 == 0) goto L58
            r4 = 1
            goto L3
        L58:
            com.google.common.cache.LocalCache$i r4 = r4.getNext()
            goto L3c
        L5d:
            int r4 = r5 + 1
            r5 = r4
            goto L2e
        L61:
            int r4 = r7.modCount
            long r4 = (long) r4
            long r8 = r8 + r4
            int r4 = r6 + 1
            r6 = r4
            goto L20
        L69:
            int r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r4 != 0) goto L6f
        L6d:
            r4 = 0
            goto L3
        L6f:
            int r4 = r10 + 1
            r10 = r4
            r12 = r8
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.containsValue(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int a2 = a(k2);
        return b(a2).put(k2, a2, v2, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int a2 = a(k2);
        return b(a2).put(k2, a2, v2, true);
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
        int a2 = a(obj);
        return b(a2).remove(obj, a2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int a2 = a(obj);
        return b(a2).remove(obj, a2, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @Nullable V v2, V v3) {
        Preconditions.a(k2);
        Preconditions.a(v3);
        if (v2 == null) {
            return false;
        }
        int a2 = a(k2);
        return b(a2).replace(k2, a2, v2, v3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int a2 = a(k2);
        return b(a2).replace(k2, a2, v2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.e) {
            segment.clear();
        }
    }

    void c(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.x;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.x = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.y;
        if (collection != null) {
            return collection;
        }
        r rVar = new r();
        this.y = rVar;
        return rVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.z;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.z = dVar;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class e {
        int b;
        int c = -1;
        Segment<K, V> d;
        AtomicReferenceArray<i<K, V>> e;
        i<K, V> f;
        LocalCache<K, V>.ab g;
        LocalCache<K, V>.ab h;

        e() {
            this.b = LocalCache.this.e.length - 1;
            b();
        }

        final void b() {
            this.g = null;
            if (!c() && !d()) {
                while (this.b >= 0) {
                    Segment<K, V>[] segmentArr = LocalCache.this.e;
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
                long a2 = LocalCache.this.r.a();
                K key = iVar.getKey();
                Object a3 = LocalCache.this.a(iVar, a2);
                if (a3 != null) {
                    this.g = new ab(key, a3);
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

        LocalCache<K, V>.ab e() {
            if (this.g == null) {
                throw new NoSuchElementException();
            }
            this.h = this.g;
            b();
            return this.h;
        }

        public void remove() {
            Preconditions.b(this.h != null);
            LocalCache.this.remove(this.h.getKey());
            this.h = null;
        }
    }

    /* loaded from: classes2.dex */
    final class f extends LocalCache<K, V>.e implements Iterator<K> {
        f() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return e().getKey();
        }
    }

    /* loaded from: classes2.dex */
    final class p extends LocalCache<K, V>.e implements Iterator<V> {
        p() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return e().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ab implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2605a;
        V b;

        ab(K k, V v) {
            this.f2605a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2605a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f2605a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2605a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes2.dex */
    final class c extends LocalCache<K, V>.e implements Iterator<Map.Entry<K, V>> {
        c() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return e();
        }
    }

    /* loaded from: classes2.dex */
    final class g extends AbstractSet<K> {
        g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }
    }

    /* loaded from: classes2.dex */
    final class r extends AbstractCollection<V> {
        r() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            LocalCache.this.clear();
        }
    }

    /* loaded from: classes2.dex */
    final class d extends AbstractSet<Map.Entry<K, V>> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.h.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
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
            this(localCache.i, localCache.j, localCache.g, localCache.h, localCache.n, localCache.m, localCache.k, localCache.l, localCache.f, localCache.q, localCache.r, localCache.u);
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
            this.ticker = (ticker == Ticker.b() || ticker == CacheBuilder.d) ? null : ticker;
            this.loader = cacheLoader;
        }

        CacheBuilder<Object, Object> recreateCacheBuilder() {
            CacheBuilder<Object, Object> a2 = CacheBuilder.a().a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).b(this.valueEquivalence).a(this.concurrencyLevel);
            a2.e = false;
            a2.a(this.removalListener);
            if (this.expireAfterWriteNanos > 0) {
                a2.a(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
            }
            if (this.expireAfterAccessNanos > 0) {
                a2.b(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
            }
            if (this.weigher != CacheBuilder.OneWeigher.INSTANCE) {
                a2.a(this.weigher);
                if (this.maxWeight != -1) {
                    a2.b(this.maxWeight);
                }
            } else if (this.maxWeight != -1) {
                a2.a(this.maxWeight);
            }
            if (this.ticker != null) {
                a2.a(this.ticker);
            }
            return a2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().p();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.delegate;
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

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* synthetic */ LocalManualCache(LocalCache localCache, com.google.common.cache.d dVar) {
            this(localCache);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        @Override // com.google.common.cache.Cache
        @Nullable
        public V getIfPresent(Object obj) {
            return this.localCache.b(obj);
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            Preconditions.a(callable);
            return this.localCache.a((LocalCache<K, V>) k, (CacheLoader<? super LocalCache<K, V>, V>) new com.google.common.cache.h(this, callable));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.a(iterable);
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
        public void invalidate(Object obj) {
            Preconditions.a(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.c(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.t();
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.a(this.localCache.t);
            for (Segment<K, V> segment : this.localCache.e) {
                simpleStatsCounter.a(segment.statsCounter);
            }
            return simpleStatsCounter.b();
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.s();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) Preconditions.a(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.localCache.c((LocalCache<K, V>) k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.b((Iterable) iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.localCache.d(k);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }
}
