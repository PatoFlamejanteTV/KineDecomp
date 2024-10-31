package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.g;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

@GwtIncompatible
/* loaded from: classes2.dex */
public class MapMakerInternalMap<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final t<Object, Object, c> UNSET_WEAK_VALUE_REFERENCE = new Ea();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient h<K, V, E, S> entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    /* loaded from: classes2.dex */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).f();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* renamed from: com.google.common.collect.MapMakerInternalMap$Strength$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends Strength {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        }

        /* renamed from: com.google.common.collect.MapMakerInternalMap$Strength$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends Strength {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        }

        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(Ea ea) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l<K, V> castForTesting(g<K, V, ?> gVar) {
            return (l) gVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V, m<K, V>> getWeakValueReferenceForTesting(g<K, V, ?> gVar) {
            return castForTesting((g) gVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V, m<K, V>> newWeakValueReferenceForTesting(g<K, V, ?> gVar, V v) {
            return new u(this.queueForValues, v, castForTesting((g) gVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(g<K, V, ?> gVar, t<K, V, ? extends g<K, V, ?>> tVar) {
            m<K, V> castForTesting = castForTesting((g) gVar);
            t tVar2 = ((m) castForTesting).f15562d;
            ((m) castForTesting).f15562d = tVar;
            tVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K, V> castForTesting(g<K, V, ?> gVar) {
            return (m) gVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public q<K, V> castForTesting(g<K, V, ?> gVar) {
            return (q) gVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V, r<K, V>> getWeakValueReferenceForTesting(g<K, V, ?> gVar) {
            return castForTesting((g) gVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V, r<K, V>> newWeakValueReferenceForTesting(g<K, V, ?> gVar, V v) {
            return new u(this.queueForValues, v, castForTesting((g) gVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(g<K, V, ?> gVar, t<K, V, ? extends g<K, V, ?>> tVar) {
            r<K, V> castForTesting = castForTesting((g) gVar);
            t tVar2 = ((r) castForTesting).f15567c;
            ((r) castForTesting).f15567c = tVar;
            tVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K, V> castForTesting(g<K, V, ?> gVar) {
            return (r) gVar;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a<K, V, E extends g<K, V, E>> implements g<K, V, E> {

        /* renamed from: a */
        final K f15545a;

        /* renamed from: b */
        final int f15546b;

        /* renamed from: c */
        final E f15547c;

        a(K k, int i, @Nullable E e2) {
            this.f15545a = k;
            this.f15546b = i;
            this.f15547c = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public int getHash() {
            return this.f15546b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public K getKey() {
            return this.f15545a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public E getNext() {
            return this.f15547c;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b<K, V, E extends g<K, V, E>> extends WeakReference<K> implements g<K, V, E> {

        /* renamed from: a */
        final int f15548a;

        /* renamed from: b */
        final E f15549b;

        b(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable E e2) {
            super(k, referenceQueue);
            this.f15548a = i;
            this.f15549b = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public int getHash() {
            return this.f15548a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public E getNext() {
            return this.f15549b;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements g<Object, Object, c> {
        private c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public /* bridge */ /* synthetic */ c getNext() {
            getNext();
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public Object getValue() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public c getNext() {
            throw new AssertionError();
        }
    }

    /* loaded from: classes2.dex */
    final class d extends MapMakerInternalMap<K, V, E, S>.f<Map.Entry<K, V>> {
        d() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: classes2.dex */
    final class e extends k<Map.Entry<K, V>> {
        e() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
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
    }

    /* loaded from: classes2.dex */
    public abstract class f<T> implements Iterator<T> {

        /* renamed from: a */
        int f15551a;

        /* renamed from: b */
        int f15552b = -1;

        /* renamed from: c */
        Segment<K, V, E, S> f15553c;

        /* renamed from: d */
        AtomicReferenceArray<E> f15554d;

        /* renamed from: e */
        E f15555e;

        /* renamed from: f */
        MapMakerInternalMap<K, V, E, S>.v f15556f;

        /* renamed from: g */
        MapMakerInternalMap<K, V, E, S>.v f15557g;

        f() {
            this.f15551a = MapMakerInternalMap.this.segments.length - 1;
            b();
        }

        boolean a(E e2) {
            boolean z;
            try {
                Object key = e2.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e2);
                if (liveValue != null) {
                    this.f15556f = new v(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.f15553c.postReadCleanup();
            }
        }

        final void b() {
            this.f15556f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.f15551a;
                if (i < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f15551a = i - 1;
                this.f15553c = segmentArr[i];
                if (this.f15553c.count != 0) {
                    this.f15554d = this.f15553c.table;
                    this.f15552b = this.f15554d.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        MapMakerInternalMap<K, V, E, S>.v c() {
            MapMakerInternalMap<K, V, E, S>.v vVar = this.f15556f;
            if (vVar != null) {
                this.f15557g = vVar;
                b();
                return this.f15557g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            E e2 = this.f15555e;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.f15555e = (E) e2.getNext();
                E e3 = this.f15555e;
                if (e3 == null) {
                    return false;
                }
                if (a(e3)) {
                    return true;
                }
                e2 = this.f15555e;
            }
        }

        boolean e() {
            while (true) {
                int i = this.f15552b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f15554d;
                this.f15552b = i - 1;
                E e2 = atomicReferenceArray.get(i);
                this.f15555e = e2;
                if (e2 != null && (a(this.f15555e) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15556f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            C1555x.a(this.f15557g != null);
            MapMakerInternalMap.this.remove(this.f15557g.getKey());
            this.f15557g = null;
        }
    }

    /* loaded from: classes2.dex */
    public interface g<K, V, E extends g<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* loaded from: classes2.dex */
    public interface h<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        Strength a();

        E a(S s, E e2, @Nullable E e3);

        E a(S s, K k, int i, @Nullable E e2);

        void a(S s, E e2, V v);

        Strength b();
    }

    /* loaded from: classes2.dex */
    final class i extends MapMakerInternalMap<K, V, E, S>.f<K> {
        i() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes2.dex */
    final class j extends k<K> {
        j() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class k<E> extends AbstractSet<E> {
        private k() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        /* synthetic */ k(Ea ea) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) MapMakerInternalMap.a(this).toArray(eArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<K, V> extends a<K, V, l<K, V>> implements n<K, V, l<K, V>> {

        /* renamed from: d */
        @Nullable
        private volatile V f15560d;

        /* loaded from: classes2.dex */
        public static final class a<K, V> implements h<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a */
            private static final a<?, ?> f15561a = new a<>();

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f15561a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.STRONG;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ g a(Segment segment, Object obj, int i, g gVar) {
                return a((StrongKeyStrongValueSegment<StrongKeyStrongValueSegment<K, V>, V>) segment, (StrongKeyStrongValueSegment<K, V>) obj, i, (l<StrongKeyStrongValueSegment<K, V>, V>) gVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ void a(Segment segment, g gVar, Object obj) {
                a((StrongKeyStrongValueSegment<K, l<K, V>>) segment, (l<K, l<K, V>>) gVar, (l<K, V>) obj);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public StrongKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public l<K, V> a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, @Nullable l<K, V> lVar2) {
                return lVar.a((l) lVar2);
            }

            public void a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, V v) {
                lVar.a((l<K, V>) v);
            }

            public l<K, V> a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, @Nullable l<K, V> lVar) {
                return new l<>(k, i, lVar);
            }
        }

        l(K k, int i, @Nullable l<K, V> lVar) {
            super(k, i, lVar);
            this.f15560d = null;
        }

        void a(V v) {
            this.f15560d = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        @Nullable
        public V getValue() {
            return this.f15560d;
        }

        l<K, V> a(l<K, V> lVar) {
            l<K, V> lVar2 = new l<>(this.f15545a, this.f15546b, lVar);
            lVar2.f15560d = this.f15560d;
            return lVar2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<K, V> extends a<K, V, m<K, V>> implements s<K, V, m<K, V>> {

        /* renamed from: d */
        private volatile t<K, V, m<K, V>> f15562d;

        /* loaded from: classes2.dex */
        public static final class a<K, V> implements h<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a */
            private static final a<?, ?> f15563a = new a<>();

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f15563a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.STRONG;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ g a(Segment segment, Object obj, int i, g gVar) {
                return a((StrongKeyWeakValueSegment<StrongKeyWeakValueSegment<K, V>, V>) segment, (StrongKeyWeakValueSegment<K, V>) obj, i, (m<StrongKeyWeakValueSegment<K, V>, V>) gVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ void a(Segment segment, g gVar, Object obj) {
                a((StrongKeyWeakValueSegment<K, m<K, V>>) segment, (m<K, m<K, V>>) gVar, (m<K, V>) obj);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public StrongKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public m<K, V> a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, @Nullable m<K, V> mVar2) {
                if (Segment.isCollected(mVar)) {
                    return null;
                }
                return mVar.a(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, mVar2);
            }

            public void a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, V v) {
                mVar.a((m<K, V>) v, (ReferenceQueue<m<K, V>>) ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }

            public m<K, V> a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, @Nullable m<K, V> mVar) {
                return new m<>(k, i, mVar);
            }
        }

        m(K k, int i, @Nullable m<K, V> mVar) {
            super(k, i, mVar);
            this.f15562d = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public V getValue() {
            return this.f15562d.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.s
        public t<K, V, m<K, V>> getValueReference() {
            return this.f15562d;
        }

        void a(V v, ReferenceQueue<V> referenceQueue) {
            t<K, V, m<K, V>> tVar = this.f15562d;
            this.f15562d = new u(referenceQueue, v, this);
            tVar.clear();
        }

        m<K, V> a(ReferenceQueue<V> referenceQueue, m<K, V> mVar) {
            m<K, V> mVar2 = new m<>(this.f15545a, this.f15546b, mVar);
            mVar2.f15562d = this.f15562d.a(referenceQueue, mVar2);
            return mVar2;
        }
    }

    /* loaded from: classes2.dex */
    interface n<K, V, E extends g<K, V, E>> extends g<K, V, E> {
    }

    /* loaded from: classes2.dex */
    final class o extends MapMakerInternalMap<K, V, E, S>.f<V> {
        o() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: classes2.dex */
    final class p extends AbstractCollection<V> {
        p() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new o();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) MapMakerInternalMap.a(this).toArray(eArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class q<K, V> extends b<K, V, q<K, V>> implements n<K, V, q<K, V>> {

        /* renamed from: c */
        @Nullable
        private volatile V f15565c;

        /* loaded from: classes2.dex */
        public static final class a<K, V> implements h<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a */
            private static final a<?, ?> f15566a = new a<>();

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f15566a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.WEAK;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ g a(Segment segment, Object obj, int i, g gVar) {
                return a((WeakKeyStrongValueSegment<WeakKeyStrongValueSegment<K, V>, V>) segment, (WeakKeyStrongValueSegment<K, V>) obj, i, (q<WeakKeyStrongValueSegment<K, V>, V>) gVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ void a(Segment segment, g gVar, Object obj) {
                a((WeakKeyStrongValueSegment<K, q<K, V>>) segment, (q<K, q<K, V>>) gVar, (q<K, V>) obj);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public WeakKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public q<K, V> a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, @Nullable q<K, V> qVar2) {
                if (qVar.getKey() == null) {
                    return null;
                }
                return qVar.a(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, qVar2);
            }

            public void a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, V v) {
                qVar.a(v);
            }

            public q<K, V> a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, @Nullable q<K, V> qVar) {
                return new q<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k, i, qVar);
            }
        }

        q(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable q<K, V> qVar) {
            super(referenceQueue, k, i, qVar);
            this.f15565c = null;
        }

        void a(V v) {
            this.f15565c = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        @Nullable
        public V getValue() {
            return this.f15565c;
        }

        q<K, V> a(ReferenceQueue<K> referenceQueue, q<K, V> qVar) {
            q<K, V> qVar2 = new q<>(referenceQueue, getKey(), this.f15548a, qVar);
            qVar2.a(this.f15565c);
            return qVar2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class r<K, V> extends b<K, V, r<K, V>> implements s<K, V, r<K, V>> {

        /* renamed from: c */
        private volatile t<K, V, r<K, V>> f15567c;

        /* loaded from: classes2.dex */
        public static final class a<K, V> implements h<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a */
            private static final a<?, ?> f15568a = new a<>();

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f15568a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.WEAK;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ g a(Segment segment, Object obj, int i, g gVar) {
                return a((WeakKeyWeakValueSegment<WeakKeyWeakValueSegment<K, V>, V>) segment, (WeakKeyWeakValueSegment<K, V>) obj, i, (r<WeakKeyWeakValueSegment<K, V>, V>) gVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ void a(Segment segment, g gVar, Object obj) {
                a((WeakKeyWeakValueSegment<K, r<K, V>>) segment, (r<K, r<K, V>>) gVar, (r<K, V>) obj);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public WeakKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public r<K, V> a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, @Nullable r<K, V> rVar2) {
                if (rVar.getKey() == null || Segment.isCollected(rVar)) {
                    return null;
                }
                return rVar.a(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, rVar2);
            }

            public void a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, V v) {
                rVar.a((r<K, V>) v, (ReferenceQueue<r<K, V>>) ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }

            public r<K, V> a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, @Nullable r<K, V> rVar) {
                return new r<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k, i, rVar);
            }
        }

        r(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable r<K, V> rVar) {
            super(referenceQueue, k, i, rVar);
            this.f15567c = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public V getValue() {
            return this.f15567c.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.s
        public t<K, V, r<K, V>> getValueReference() {
            return this.f15567c;
        }

        r<K, V> a(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, r<K, V> rVar) {
            r<K, V> rVar2 = new r<>(referenceQueue, getKey(), this.f15548a, rVar);
            rVar2.f15567c = this.f15567c.a(referenceQueue2, rVar2);
            return rVar2;
        }

        void a(V v, ReferenceQueue<V> referenceQueue) {
            t<K, V, r<K, V>> tVar = this.f15567c;
            this.f15567c = new u(referenceQueue, v, this);
            tVar.clear();
        }
    }

    /* loaded from: classes2.dex */
    public interface s<K, V, E extends g<K, V, E>> extends g<K, V, E> {
        t<K, V, E> getValueReference();
    }

    /* loaded from: classes2.dex */
    public interface t<K, V, E extends g<K, V, E>> {
        E a();

        t<K, V, E> a(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        @Nullable
        V get();
    }

    /* loaded from: classes2.dex */
    public static final class u<K, V, E extends g<K, V, E>> extends WeakReference<V> implements t<K, V, E> {

        /* renamed from: a */
        final E f15569a;

        u(ReferenceQueue<V> referenceQueue, V v, E e2) {
            super(v, referenceQueue);
            this.f15569a = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public E a() {
            return this.f15569a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public t<K, V, E> a(ReferenceQueue<V> referenceQueue, E e2) {
            return new u(referenceQueue, get(), e2);
        }
    }

    /* loaded from: classes2.dex */
    public final class v extends AbstractC1513i<K, V> {

        /* renamed from: a */
        final K f15570a;

        /* renamed from: b */
        V f15571b;

        v(K k, V v) {
            this.f15570a = k;
            this.f15571b = v;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f15570a.equals(entry.getKey()) && this.f15571b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public K getKey() {
            return this.f15570a;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V getValue() {
            return this.f15571b;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public int hashCode() {
            return this.f15570a.hashCode() ^ this.f15571b.hashCode();
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.f15570a, v);
            this.f15571b = v;
            return v2;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, h<K, V, E, S> hVar) {
        this.concurrencyLevel = Math.min(mapMaker.a(), 65536);
        this.keyEquivalence = mapMaker.c();
        this.entryHelper = hVar;
        int min = Math.min(mapMaker.b(), MAXIMUM_CAPACITY);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.concurrencyLevel) {
            i5++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i5;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i6 = min / i4;
        while (i3 < (i4 * i6 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = createSegment(i3, -1);
            i2++;
        }
    }

    public static <E> ArrayList<E> a(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends g<K, V, ?>, ?> create(MapMaker mapMaker) {
        if (mapMaker.d() == Strength.STRONG && mapMaker.e() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, l.a.c());
        }
        if (mapMaker.d() == Strength.STRONG && mapMaker.e() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, m.a.c());
        }
        if (mapMaker.d() == Strength.WEAK && mapMaker.e() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, q.a.c());
        }
        if (mapMaker.d() == Strength.WEAK && mapMaker.e() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, r.a.c());
        }
        throw new AssertionError();
    }

    static int rehash(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    static <K, V, E extends g<K, V, E>> t<K, V, E> unsetWeakValueReference() {
        return (t<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (StrongKeyStrongValueSegment strongKeyStrongValueSegment : segmentArr) {
                int i3 = strongKeyStrongValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyStrongValueSegment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E e2 = atomicReferenceArray.get(i4); e2 != null; e2 = e2.getNext()) {
                        Object liveValue = strongKeyStrongValueSegment.getLiveValue(e2);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j3 += strongKeyStrongValueSegment.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    @VisibleForTesting
    E copyEntry(E e2, E e3) {
        return segmentFor(e2.getHash()).copyEntry(e2, e3);
    }

    Segment<K, V, E, S> createSegment(int i2, int i3) {
        return this.entryHelper.a(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.entrySet = eVar;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    E getEntry(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    V getLiveValue(E e2) {
        V v2;
        if (e2.getKey() == null || (v2 = (V) e2.getValue()) == null) {
            return null;
        }
        return v2;
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
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

    @VisibleForTesting
    boolean isLiveForTesting(g<K, V, ?> gVar) {
        return segmentFor(gVar.getHash()).getLiveValueForTesting(gVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        j jVar = new j();
        this.keySet = jVar;
        return jVar;
    }

    @VisibleForTesting
    Strength keyStrength() {
        return this.entryHelper.b();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v2, true);
    }

    void reclaimKey(E e2) {
        int hash = e2.getHash();
        segmentFor(hash).reclaimKey(e2, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reclaimValue(t<K, V, E> tVar) {
        E a2 = tVar.a();
        int hash = a2.getHash();
        segmentFor(hash).reclaimValue(a2.getKey(), hash, tVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @Nullable V v2, V v3) {
        Preconditions.a(k2);
        Preconditions.a(v3);
        if (v2 == null) {
            return false;
        }
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v2, v3);
    }

    Segment<K, V, E, S> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.segments.length; i2++) {
            j2 += r0[i2].count;
        }
        return Ints.b(j2);
    }

    @VisibleForTesting
    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.a().defaultEquivalence();
    }

    @VisibleForTesting
    Strength valueStrength() {
        return this.entryHelper.a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        p pVar = new p();
        this.values = pVar;
        return pVar;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.b(), this.entryHelper.a(), this.keyEquivalence, this.entryHelper.a().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().b(objectInputStream.readInt()).a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).a(this.concurrencyLevel);
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v2) {
        Preconditions.a(k2);
        Preconditions.a(v2);
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v2);
    }

    /* loaded from: classes2.dex */
    public static abstract class Segment<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        static <K, V, E extends g<K, V, E>> boolean isCollected(E e2) {
            return e2.getValue() == null;
        }

        abstract E castForTesting(g<K, V, ?> gVar);

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean clearValueForTesting(K k, int i, t<K, V, ? extends g<K, V, ?>> tVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((s) gVar2).getValueReference() != tVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(gVar, gVar2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z = true;
                    }
                }
                return z;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E e2 = atomicReferenceArray.get(i); e2 != null; e2 = e2.getNext()) {
                            Object liveValue = getLiveValue(e2);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
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

        E copyEntry(E e2, E e3) {
            return this.map.entryHelper.a((h<K, V, E, S>) self(), (g) e2, (g) e3);
        }

        E copyForTesting(g<K, V, ?> gVar, @Nullable g<K, V, ?> gVar2) {
            return this.map.entryHelper.a((h<K, V, E, S>) self(), (g) castForTesting(gVar), (g) castForTesting(gVar2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((g) poll);
                i++;
            } while (i != 16);
        }

        void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((t) poll);
                i++;
            } while (i != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= MapMakerInternalMap.MAXIMUM_CAPACITY) {
                return;
            }
            int i = this.count;
            SpscArrayQueue spscArrayQueue = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (spscArrayQueue.length() * 3) / 4;
            int length2 = spscArrayQueue.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E e2 = atomicReferenceArray.get(i2);
                if (e2 != null) {
                    g next = e2.getNext();
                    int hash = e2.getHash() & length2;
                    if (next == null) {
                        spscArrayQueue.set(hash, e2);
                    } else {
                        g gVar = e2;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                gVar = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        spscArrayQueue.set(hash, gVar);
                        while (e2 != gVar) {
                            int hash3 = e2.getHash() & length2;
                            g copyEntry = copyEntry(e2, (g) spscArrayQueue.get(hash3));
                            if (copyEntry != null) {
                                spscArrayQueue.set(hash3, copyEntry);
                            } else {
                                i--;
                            }
                            e2 = e2.getNext();
                        }
                    }
                }
            }
            this.table = spscArrayQueue;
            this.count = i;
        }

        V get(Object obj, int i) {
            try {
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        E getEntry(Object obj, int i) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i); first != null; first = (E) first.getNext()) {
                if (first.getHash() == i) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        E getFirst(int i) {
            return this.table.get(i & (r0.length() - 1));
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        E getLiveEntry(Object obj, int i) {
            return getEntry(obj, i);
        }

        @Nullable
        V getLiveValue(E e2) {
            if (e2.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e2.getValue();
            if (v != null) {
                return v;
            }
            tryDrainReferenceQueues();
            return null;
        }

        @Nullable
        V getLiveValueForTesting(g<K, V, ?> gVar) {
            return getLiveValue(castForTesting(gVar));
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        t<K, V, E> getWeakValueReferenceForTesting(g<K, V, ?> gVar) {
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            int i = this.threshold;
            if (i == this.maxSegmentSize) {
                this.threshold = i + 1;
            }
            this.table = atomicReferenceArray;
        }

        void maybeClearReferenceQueues() {
        }

        void maybeDrainReferenceQueues() {
        }

        AtomicReferenceArray<E> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        E newEntryForTesting(K k, int i, @Nullable g<K, V, ?> gVar) {
            return this.map.entryHelper.a(self(), k, i, castForTesting(gVar));
        }

        t<K, V, E> newWeakValueReferenceForTesting(g<K, V, ?> gVar, V v) {
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) gVar2.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(gVar2, v);
                            this.count = this.count;
                            return null;
                        }
                        if (z) {
                            return v2;
                        }
                        this.modCount++;
                        setValue(gVar2, v);
                        return v2;
                    }
                }
                this.modCount++;
                g a2 = this.map.entryHelper.a(self(), k, i, gVar);
                setValue(a2, v);
                atomicReferenceArray.set(length, a2);
                this.count = i2;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimKey(E e2, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    if (gVar2 == e2) {
                        this.modCount++;
                        g removeFromChain = removeFromChain(gVar, gVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimValue(K k, int i, t<K, V, E> tVar) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((s) gVar2).getValueReference() != tVar) {
                            return false;
                        }
                        this.modCount++;
                        g removeFromChain = removeFromChain(gVar, gVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count;
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) gVar2.getValue();
                        if (v == null && !isCollected(gVar2)) {
                            return null;
                        }
                        this.modCount++;
                        g removeFromChain = removeFromChain(gVar, gVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean removeEntryForTesting(E e2) {
            int hash = e2.getHash();
            int i = this.count;
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            g gVar = (g) atomicReferenceArray.get(length);
            for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                if (gVar2 == e2) {
                    this.modCount++;
                    g removeFromChain = removeFromChain(gVar, gVar2);
                    int i2 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i2;
                    return true;
                }
            }
            return false;
        }

        E removeFromChain(E e2, E e3) {
            int i = this.count;
            E e4 = (E) e3.getNext();
            while (e2 != e3) {
                E copyEntry = copyEntry(e2, e4);
                if (copyEntry != null) {
                    e4 = copyEntry;
                } else {
                    i--;
                }
                e2 = (E) e2.getNext();
            }
            this.count = i;
            return e4;
        }

        E removeFromChainForTesting(g<K, V, ?> gVar, g<K, V, ?> gVar2) {
            return removeFromChain(castForTesting(gVar), castForTesting(gVar2));
        }

        @CanIgnoreReturnValue
        boolean removeTableEntryForTesting(g<K, V, ?> gVar) {
            return removeEntryForTesting(castForTesting(gVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        Object value = gVar2.getValue();
                        if (value == null) {
                            if (isCollected(gVar2)) {
                                int i2 = this.count;
                                this.modCount++;
                                g removeFromChain = removeFromChain(gVar, gVar2);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i3;
                            }
                            return false;
                        }
                        if (!this.map.valueEquivalence().equivalent(v, value)) {
                            return false;
                        }
                        this.modCount++;
                        setValue(gVar2, v2);
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S self();

        void setTableEntryForTesting(int i, g<K, V, ?> gVar) {
            this.table.set(i, castForTesting(gVar));
        }

        void setValue(E e2, V v) {
            this.map.entryHelper.a((h<K, V, E, S>) self(), (S) e2, (E) v);
        }

        void setValueForTesting(g<K, V, ?> gVar, V v) {
            this.map.entryHelper.a((h<K, V, E, S>) self(), (S) castForTesting(gVar), (E) v);
        }

        void setWeakValueReferenceForTesting(g<K, V, ?> gVar, t<K, V, ? extends g<K, V, ?>> tVar) {
            throw new AssertionError();
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L50;     */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:            r5 = true;     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:            r8.modCount++;        r9 = removeFromChain(r3, r4);        r10 = r8.count - 1;        r0.set(r1, r9);        r8.count = r10;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:            return r5;     */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:            if (isCollected(r4) == false) goto L55;     */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:            return false;     */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L6b
                int r0 = r8.count     // Catch: java.lang.Throwable -> L6b
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$g<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L6b
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L6b
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L6b
                com.google.common.collect.MapMakerInternalMap$g r3 = (com.google.common.collect.MapMakerInternalMap.g) r3     // Catch: java.lang.Throwable -> L6b
                r4 = r3
            L18:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L6b
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L6b
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$g<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L6b
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L6b
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L6b
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L6b
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$g<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L6b
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L6b
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L6b
                if (r9 == 0) goto L43
                r5 = 1
                goto L49
            L43:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L6b
                if (r9 == 0) goto L5e
            L49:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L6b
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L6b
                com.google.common.collect.MapMakerInternalMap$g r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L6b
                int r10 = r8.count     // Catch: java.lang.Throwable -> L6b
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L6b
                r8.count = r10     // Catch: java.lang.Throwable -> L6b
                r8.unlock()
                return r5
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.MapMakerInternalMap$g r4 = r4.getNext()     // Catch: java.lang.Throwable -> L6b
                goto L18
            L67:
                r8.unlock()
                return r5
            L6b:
                r9 = move-exception
                r8.unlock()
                goto L71
            L70:
                throw r9
            L71:
                goto L70
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.getNext()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) gVar2.getValue();
                        if (v2 == null) {
                            if (isCollected(gVar2)) {
                                int i2 = this.count;
                                this.modCount++;
                                g removeFromChain = removeFromChain(gVar, gVar2);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i3;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(gVar2, v);
                        return v2;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
