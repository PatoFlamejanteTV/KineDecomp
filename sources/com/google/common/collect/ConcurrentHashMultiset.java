package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.C1527mb;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class ConcurrentHashMultiset<E> extends AbstractC1522l<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: c */
    private final transient ConcurrentMap<E, AtomicInteger> f15358c;

    /* loaded from: classes2.dex */
    private class a extends AbstractC1522l<E>.b {
        private a() {
            super();
        }

        private List<Multiset.Entry<E>> b() {
            ArrayList c2 = Lists.c(size());
            Iterators.a(c2, iterator());
            return c2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return b().toArray();
        }

        /* synthetic */ a(ConcurrentHashMultiset concurrentHashMultiset, A a2) {
            this();
        }

        @Override // com.google.common.collect.AbstractC1522l.b, com.google.common.collect.Multisets.c
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) b().toArray(tArr);
        }
    }

    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a */
        static final C1527mb.a<ConcurrentHashMultiset> f15360a = C1527mb.a(ConcurrentHashMultiset.class, "countMap");
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.a(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.f15358c = concurrentMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> a() {
        ArrayList c2 = Lists.c(size());
        for (Multiset.Entry entry : entrySet()) {
            Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                c2.add(element);
            }
        }
        return c2;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        b.f15360a.a((C1527mb.a<ConcurrentHashMultiset>) this, objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f15358c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f15358c.clear();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.e(this.f15358c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.AbstractC1522l
    Set<E> createElementSet() {
        return new A(this, this.f15358c.keySet());
    }

    @Override // com.google.common.collect.AbstractC1522l
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new a(this, null);
    }

    @Override // com.google.common.collect.AbstractC1522l
    int distinctElements() {
        return this.f15358c.size();
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC1522l
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new C(this, new B(this));
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f15358c.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@Nullable Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        C1555x.b(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.e(this.f15358c, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.f15358c.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e2, int i) {
        AtomicInteger atomicInteger;
        int i2;
        AtomicInteger atomicInteger2;
        Preconditions.a(e2);
        C1555x.a(i, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.e(this.f15358c, e2);
            if (atomicInteger == null && (i == 0 || (atomicInteger = this.f15358c.putIfAbsent(e2, new AtomicInteger(i))) == null)) {
                return 0;
            }
            do {
                i2 = atomicInteger.get();
                if (i2 == 0) {
                    if (i != 0) {
                        atomicInteger2 = new AtomicInteger(i);
                        if (this.f15358c.putIfAbsent(e2, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i2, i));
            if (i == 0) {
                this.f15358c.remove(e2, atomicInteger);
            }
            return i2;
        } while (!this.f15358c.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public int size() {
        long j = 0;
        while (this.f15358c.values().iterator().hasNext()) {
            j += r0.next().get();
        }
        return Ints.b(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return a().toArray();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.a((Collection) create, (Iterable) iterable);
        return create;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e2, int i) {
        AtomicInteger atomicInteger;
        int i2;
        AtomicInteger atomicInteger2;
        Preconditions.a(e2);
        if (i == 0) {
            return count(e2);
        }
        C1555x.b(i, "occurences");
        do {
            atomicInteger = (AtomicInteger) Maps.e(this.f15358c, e2);
            if (atomicInteger == null && (atomicInteger = this.f15358c.putIfAbsent(e2, new AtomicInteger(i))) == null) {
                return 0;
            }
            do {
                i2 = atomicInteger.get();
                if (i2 != 0) {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                } else {
                    atomicInteger2 = new AtomicInteger(i);
                    if (this.f15358c.putIfAbsent(e2, atomicInteger2) == null) {
                        break;
                    }
                }
            } while (!atomicInteger.compareAndSet(i2, IntMath.a(i2, i)));
            return i2;
        } while (!this.f15358c.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@Nullable Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        C1555x.b(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.e(this.f15358c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.f15358c.remove(obj, atomicInteger);
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) a().toArray(tArr);
    }

    @Beta
    @Deprecated
    public static <E> ConcurrentHashMultiset<E> create(MapMaker mapMaker) {
        return create(mapMaker.f());
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e2, int i, int i2) {
        Preconditions.a(e2);
        C1555x.a(i, "oldCount");
        C1555x.a(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.e(this.f15358c, e2);
        if (atomicInteger == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || this.f15358c.putIfAbsent(e2, new AtomicInteger(i2)) == null;
        }
        int i3 = atomicInteger.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    this.f15358c.remove(e2, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                return this.f15358c.putIfAbsent(e2, atomicInteger2) == null || this.f15358c.replace(e2, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i3, i2)) {
                if (i2 == 0) {
                    this.f15358c.remove(e2, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
