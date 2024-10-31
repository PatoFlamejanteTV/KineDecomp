package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.cs;
import com.google.common.collect.l;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
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

/* loaded from: classes2.dex */
public final class ConcurrentHashMultiset<E> extends l<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private final transient ConcurrentMap<E, AtomicInteger> f2668a;
    private transient ConcurrentHashMultiset<E>.a b;

    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final cs.a<ConcurrentHashMultiset> f2669a = cs.a(ConcurrentHashMultiset.class, "countMap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.l, java.util.Collection
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.l, java.util.Collection
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.a((Collection) create, (Iterable) iterable);
        return create;
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(GenericMapMaker<? super E, ? super Number> genericMapMaker) {
        return new ConcurrentHashMultiset<>(genericMapMaker.b());
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.a(concurrentMap.isEmpty());
        this.f2668a = concurrentMap;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        AtomicInteger a2 = a(obj);
        if (a2 == null) {
            return 0;
        }
        return a2.get();
    }

    private AtomicInteger a(Object obj) {
        try {
            return this.f2668a.get(obj);
        } catch (ClassCastException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public int size() {
        long j = 0;
        while (true) {
            long j2 = j;
            if (this.f2668a.values().iterator().hasNext()) {
                j = r4.next().get() + j2;
            } else {
                return Ints.a(j2);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return a().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) a().toArray(tArr);
    }

    private List<E> a() {
        ArrayList c = Lists.c(size());
        for (Multiset.Entry<E> entry : entrySet()) {
            E element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                c.add(element);
            }
        }
        return c;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int add(E e, int i) {
        AtomicInteger a2;
        int i2;
        AtomicInteger atomicInteger;
        Preconditions.a(e);
        if (i == 0) {
            return count(e);
        }
        Preconditions.a(i > 0, "Invalid occurrences: %s", Integer.valueOf(i));
        do {
            a2 = a(e);
            if (a2 == null && (a2 = this.f2668a.putIfAbsent(e, new AtomicInteger(i))) == null) {
                return 0;
            }
            do {
                i2 = a2.get();
                if (i2 != 0) {
                    try {
                    } catch (ArithmeticException e2) {
                        throw new IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                } else {
                    atomicInteger = new AtomicInteger(i);
                    if (this.f2668a.putIfAbsent(e, atomicInteger) == null) {
                        return 0;
                    }
                }
            } while (!a2.compareAndSet(i2, IntMath.a(i2, i)));
            return i2;
        } while (!this.f2668a.replace(e, a2, atomicInteger));
        return 0;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int remove(@Nullable Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        Preconditions.a(i > 0, "Invalid occurrences: %s", Integer.valueOf(i));
        AtomicInteger a2 = a(obj);
        if (a2 == null) {
            return 0;
        }
        do {
            i2 = a2.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!a2.compareAndSet(i2, max));
        if (max == 0) {
            this.f2668a.remove(obj, a2);
        }
        return i2;
    }

    public boolean removeExactly(@Nullable Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        Preconditions.a(i > 0, "Invalid occurrences: %s", Integer.valueOf(i));
        AtomicInteger a2 = a(obj);
        if (a2 == null) {
            return false;
        }
        do {
            i2 = a2.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!a2.compareAndSet(i2, i3));
        if (i3 != 0) {
            return true;
        }
        this.f2668a.remove(obj, a2);
        return true;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int setCount(E e, int i) {
        AtomicInteger a2;
        int i2;
        AtomicInteger atomicInteger;
        Preconditions.a(e);
        Multisets.a(i, "count");
        do {
            a2 = a(e);
            if (a2 != null || (i != 0 && (a2 = this.f2668a.putIfAbsent(e, new AtomicInteger(i))) != null)) {
                do {
                    i2 = a2.get();
                    if (i2 == 0) {
                        if (i != 0) {
                            atomicInteger = new AtomicInteger(i);
                            if (this.f2668a.putIfAbsent(e, atomicInteger) == null) {
                                break;
                            }
                        } else {
                            return 0;
                        }
                    }
                } while (!a2.compareAndSet(i2, i));
                if (i == 0) {
                    this.f2668a.remove(e, a2);
                }
                return i2;
            }
            return 0;
        } while (!this.f2668a.replace(e, a2, atomicInteger));
        return 0;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public boolean setCount(E e, int i, int i2) {
        Preconditions.a(e);
        Multisets.a(i, "oldCount");
        Multisets.a(i2, "newCount");
        AtomicInteger a2 = a(e);
        if (a2 == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || this.f2668a.putIfAbsent(e, new AtomicInteger(i2)) == null;
        }
        int i3 = a2.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    this.f2668a.remove(e, a2);
                    return true;
                }
                AtomicInteger atomicInteger = new AtomicInteger(i2);
                return this.f2668a.putIfAbsent(e, atomicInteger) == null || this.f2668a.replace(e, a2, atomicInteger);
            }
            if (a2.compareAndSet(i3, i2)) {
                if (i2 != 0) {
                    return true;
                }
                this.f2668a.remove(e, a2);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.l
    Set<E> createElementSet() {
        return new x(this, this.f2668a.keySet());
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        ConcurrentHashMultiset<E>.a aVar = this.b;
        if (aVar == null) {
            ConcurrentHashMultiset<E>.a aVar2 = new a(this, null);
            this.b = aVar2;
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.common.collect.l
    int distinctElements() {
        return this.f2668a.size();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f2668a.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.l
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new z(this, new y(this));
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f2668a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends l.b {
        private a() {
            super();
        }

        /* synthetic */ a(ConcurrentHashMultiset concurrentHashMultiset, x xVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.l.b, com.google.common.collect.Multisets.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return c().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c().toArray(tArr);
        }

        private List<Multiset.Entry<E>> c() {
            ArrayList c = Lists.c(size());
            Iterators.a(c, iterator());
            return c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            Object element = entry.getElement();
            int count = entry.getCount();
            if (count != 0) {
                return a().setCount(element, count, 0);
            }
            return false;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f2668a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        b.f2669a.a((cs.a<ConcurrentHashMultiset>) this, objectInputStream.readObject());
    }
}
