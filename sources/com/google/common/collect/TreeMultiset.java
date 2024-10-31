package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.cs;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public final class TreeMultiset<E> extends m<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private final transient b<a<E>> f2782a;
    private final transient GeneralRange<E> b;
    private final transient a<E> c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.SortedMultiset, com.google.common.collect.ct
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.l, java.util.Collection
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.l, java.util.Collection
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.m
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.m
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.m, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E> TreeMultiset<E> create(@Nullable Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.a((Collection) create, (Iterable) iterable);
        return create;
    }

    TreeMultiset(b<a<E>> bVar, GeneralRange<E> generalRange, a<E> aVar) {
        super(generalRange.comparator());
        this.f2782a = bVar;
        this.b = generalRange;
        this.c = aVar;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.b = GeneralRange.all(comparator);
        this.c = new a<>(null, 1);
        a(this.c, this.c);
        this.f2782a = new b<>(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(a<?> aVar) {
                return ((a) aVar).b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@Nullable a<?> aVar) {
                if (aVar == null) {
                    return 0L;
                }
                return ((a) aVar).d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(a<?> aVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@Nullable a<?> aVar) {
                if (aVar == null) {
                    return 0L;
                }
                return ((a) aVar).c;
            }
        };

        abstract int nodeAggregate(a<?> aVar);

        abstract long treeAggregate(@Nullable a<?> aVar);

        /* synthetic */ Aggregate(Cdo cdo) {
            this();
        }
    }

    private long a(Aggregate aggregate) {
        a<E> a2 = this.f2782a.a();
        long treeAggregate = aggregate.treeAggregate(a2);
        if (this.b.hasLowerBound()) {
            treeAggregate -= a(aggregate, a2);
        }
        if (this.b.hasUpperBound()) {
            return treeAggregate - b(aggregate, a2);
        }
        return treeAggregate;
    }

    private long a(Aggregate aggregate, @Nullable a<E> aVar) {
        if (aVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.b.getLowerEndpoint(), ((a) aVar).f2784a);
        if (compare >= 0) {
            if (compare == 0) {
                switch (this.b.getLowerBoundType()) {
                    case OPEN:
                        return aggregate.nodeAggregate(aVar) + aggregate.treeAggregate(((a) aVar).f);
                    case CLOSED:
                        return aggregate.treeAggregate(((a) aVar).f);
                    default:
                        throw new AssertionError();
                }
            }
            return aggregate.treeAggregate(((a) aVar).f) + aggregate.nodeAggregate(aVar) + a(aggregate, ((a) aVar).g);
        }
        return a(aggregate, ((a) aVar).f);
    }

    private long b(Aggregate aggregate, @Nullable a<E> aVar) {
        if (aVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.b.getUpperEndpoint(), ((a) aVar).f2784a);
        if (compare <= 0) {
            if (compare == 0) {
                switch (this.b.getUpperBoundType()) {
                    case OPEN:
                        return aggregate.nodeAggregate(aVar) + aggregate.treeAggregate(((a) aVar).g);
                    case CLOSED:
                        return aggregate.treeAggregate(((a) aVar).g);
                    default:
                        throw new AssertionError();
                }
            }
            return aggregate.treeAggregate(((a) aVar).g) + aggregate.nodeAggregate(aVar) + b(aggregate, ((a) aVar).f);
        }
        return b(aggregate, ((a) aVar).g);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Ints.a(a(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.l
    int distinctElements() {
        return Ints.a(a(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        try {
            a<E> a2 = this.f2782a.a();
            if (!this.b.contains(obj) || a2 == null) {
                return 0;
            }
            return a2.a((Comparator<? super Comparator<? super E>>) comparator(), (Comparator<? super E>) obj);
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int add(@Nullable E e, int i) {
        Preconditions.a(i >= 0, "occurrences must be >= 0 but was %s", Integer.valueOf(i));
        if (i == 0) {
            return count(e);
        }
        Preconditions.a(this.b.contains(e));
        a<E> a2 = this.f2782a.a();
        if (a2 == null) {
            comparator().compare(e, e);
            a<E> aVar = new a<>(e, i);
            a(this.c, aVar, this.c);
            this.f2782a.a(a2, aVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.f2782a.a(a2, a2.a(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int remove(@Nullable Object obj, int i) {
        Preconditions.a(i >= 0, "occurrences must be >= 0 but was %s", Integer.valueOf(i));
        if (i == 0) {
            return count(obj);
        }
        a<E> a2 = this.f2782a.a();
        int[] iArr = new int[1];
        try {
            if (!this.b.contains(obj) || a2 == null) {
                return 0;
            }
            this.f2782a.a(a2, a2.b(comparator(), obj, i, iArr));
            return iArr[0];
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int setCount(@Nullable E e, int i) {
        Preconditions.a(i >= 0);
        if (!this.b.contains(e)) {
            Preconditions.a(i == 0);
            return 0;
        }
        a<E> a2 = this.f2782a.a();
        if (a2 == null) {
            if (i <= 0) {
                return 0;
            }
            add(e, i);
            return 0;
        }
        int[] iArr = new int[1];
        this.f2782a.a(a2, a2.c(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public boolean setCount(@Nullable E e, int i, int i2) {
        Preconditions.a(i2 >= 0);
        Preconditions.a(i >= 0);
        Preconditions.a(this.b.contains(e));
        a<E> a2 = this.f2782a.a();
        if (a2 == null) {
            if (i != 0) {
                return false;
            }
            if (i2 <= 0) {
                return true;
            }
            add(e, i2);
            return true;
        }
        int[] iArr = new int[1];
        this.f2782a.a(a2, a2.a(comparator(), e, i, i2, iArr));
        return iArr[0] == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> a(a<E> aVar) {
        return new Cdo(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public a<E> a() {
        a<E> aVar;
        if (this.f2782a.a() == null) {
            return null;
        }
        if (this.b.hasLowerBound()) {
            E lowerEndpoint = this.b.getLowerEndpoint();
            aVar = this.f2782a.a().b((Comparator<? super Comparator>) comparator(), (Comparator) lowerEndpoint);
            if (aVar == null) {
                return null;
            }
            if (this.b.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, aVar.getElement()) == 0) {
                aVar = ((a) aVar).i;
            }
        } else {
            aVar = ((a) this.c).i;
        }
        if (aVar == this.c || !this.b.contains(aVar.getElement())) {
            aVar = null;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public a<E> b() {
        a<E> aVar;
        if (this.f2782a.a() == null) {
            return null;
        }
        if (this.b.hasUpperBound()) {
            E upperEndpoint = this.b.getUpperEndpoint();
            aVar = this.f2782a.a().c(comparator(), upperEndpoint);
            if (aVar == null) {
                return null;
            }
            if (this.b.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, aVar.getElement()) == 0) {
                aVar = ((a) aVar).h;
            }
        } else {
            aVar = ((a) this.c).h;
        }
        if (aVar == this.c || !this.b.contains(aVar.getElement())) {
            aVar = null;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.l
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new dp(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.m
    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new dq(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@Nullable E e, BoundType boundType) {
        return new TreeMultiset(this.f2782a, this.b.intersect(GeneralRange.upTo(comparator(), e, boundType)), this.c);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@Nullable E e, BoundType boundType) {
        return new TreeMultiset(this.f2782a, this.b.intersect(GeneralRange.downTo(comparator(), e, boundType)), this.c);
    }

    static int distinctElements(@Nullable a<?> aVar) {
        if (aVar == null) {
            return 0;
        }
        return ((a) aVar).c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private T f2785a;

        private b() {
        }

        /* synthetic */ b(Cdo cdo) {
            this();
        }

        @Nullable
        public T a() {
            return this.f2785a;
        }

        public void a(@Nullable T t, T t2) {
            if (this.f2785a != t) {
                throw new ConcurrentModificationException();
            }
            this.f2785a = t2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a<E> extends Multisets.a<E> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final E f2784a;
        private int b;
        private int c;
        private long d;
        private int e;
        private a<E> f;
        private a<E> g;
        private a<E> h;
        private a<E> i;

        a(@Nullable E e, int i) {
            Preconditions.a(i > 0);
            this.f2784a = e;
            this.b = i;
            this.d = i;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int a(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare < 0) {
                if (this.f == null) {
                    return 0;
                }
                return this.f.a((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e);
            }
            if (compare > 0) {
                if (this.g != null) {
                    return this.g.a((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e);
                }
                return 0;
            }
            return this.b;
        }

        private a<E> a(E e, int i) {
            this.g = new a<>(e, i);
            TreeMultiset.a(this, this.g, this.i);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += i;
            return this;
        }

        private a<E> b(E e, int i) {
            this.f = new a<>(e, i);
            TreeMultiset.a(this.h, this.f, this);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> a(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare < 0) {
                a<E> aVar = this.f;
                if (aVar == null) {
                    iArr[0] = 0;
                    return b((a<E>) e, i);
                }
                int i2 = aVar.e;
                this.f = aVar.a(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += i;
                return this.f.e != i2 ? e() : this;
            }
            if (compare > 0) {
                a<E> aVar2 = this.g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    return a((a<E>) e, i);
                }
                int i3 = aVar2.e;
                this.g = aVar2.a(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += i;
                return this.g.e != i3 ? e() : this;
            }
            iArr[0] = this.b;
            Preconditions.a(((long) this.b) + ((long) i) <= 2147483647L);
            this.b += i;
            this.d += i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> b(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare < 0) {
                a<E> aVar = this.f;
                if (aVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = aVar.b(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.c--;
                        this.d -= iArr[0];
                    } else {
                        this.d -= i;
                    }
                }
                return iArr[0] != 0 ? e() : this;
            }
            if (compare > 0) {
                a<E> aVar2 = this.g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.g = aVar2.b(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.c--;
                        this.d -= iArr[0];
                    } else {
                        this.d -= i;
                    }
                }
                return e();
            }
            iArr[0] = this.b;
            if (i >= this.b) {
                return a();
            }
            this.b -= i;
            this.d -= i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> c(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare < 0) {
                a<E> aVar = this.f;
                if (aVar == null) {
                    iArr[0] = 0;
                    return i > 0 ? b((a<E>) e, i) : this;
                }
                this.f = aVar.c(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += i - iArr[0];
                return e();
            }
            if (compare > 0) {
                a<E> aVar2 = this.g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    return i > 0 ? a((a<E>) e, i) : this;
                }
                this.g = aVar2.c(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += i - iArr[0];
                return e();
            }
            iArr[0] = this.b;
            if (i == 0) {
                return a();
            }
            this.d += i - this.b;
            this.b = i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> a(Comparator<? super E> comparator, @Nullable E e, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare < 0) {
                a<E> aVar = this.f;
                if (aVar == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        return b((a<E>) e, i2);
                    }
                    return this;
                }
                this.f = aVar.a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += i2 - iArr[0];
                }
                return e();
            }
            if (compare > 0) {
                a<E> aVar2 = this.g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        return a((a<E>) e, i2);
                    }
                    return this;
                }
                this.g = aVar2.a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += i2 - iArr[0];
                }
                return e();
            }
            iArr[0] = this.b;
            if (i == this.b) {
                if (i2 == 0) {
                    return a();
                }
                this.d += i2 - this.b;
                this.b = i2;
                return this;
            }
            return this;
        }

        private a<E> a() {
            int i = this.b;
            this.b = 0;
            TreeMultiset.a(this.h, this.i);
            if (this.f == null) {
                return this.g;
            }
            if (this.g == null) {
                return this.f;
            }
            if (this.f.e >= this.g.e) {
                a<E> aVar = this.h;
                aVar.f = this.f.j(aVar);
                aVar.g = this.g;
                aVar.c = this.c - 1;
                aVar.d = this.d - i;
                return aVar.e();
            }
            a<E> aVar2 = this.i;
            aVar2.g = this.g.i(aVar2);
            aVar2.f = this.f;
            aVar2.c = this.c - 1;
            aVar2.d = this.d - i;
            return aVar2.e();
        }

        private a<E> i(a<E> aVar) {
            if (this.f == null) {
                return this.g;
            }
            this.f = this.f.i(aVar);
            this.c--;
            this.d -= aVar.b;
            return e();
        }

        private a<E> j(a<E> aVar) {
            if (this.g == null) {
                return this.f;
            }
            this.g = this.g.j(aVar);
            this.c--;
            this.d -= aVar.b;
            return e();
        }

        private void b() {
            this.c = TreeMultiset.distinctElements(this.f) + 1 + TreeMultiset.distinctElements(this.g);
            this.d = this.b + k(this.f) + k(this.g);
        }

        private void c() {
            this.e = Math.max(l(this.f), l(this.g)) + 1;
        }

        private void d() {
            b();
            c();
        }

        private a<E> e() {
            switch (f()) {
                case -2:
                    if (this.g.f() > 0) {
                        this.g = this.g.h();
                    }
                    return g();
                case 2:
                    if (this.f.f() < 0) {
                        this.f = this.f.g();
                    }
                    return h();
                default:
                    c();
                    return this;
            }
        }

        private int f() {
            return l(this.f) - l(this.g);
        }

        private a<E> g() {
            Preconditions.b(this.g != null);
            a<E> aVar = this.g;
            this.g = aVar.f;
            aVar.f = this;
            aVar.d = this.d;
            aVar.c = this.c;
            d();
            aVar.c();
            return aVar;
        }

        private a<E> h() {
            Preconditions.b(this.f != null);
            a<E> aVar = this.f;
            this.f = aVar.g;
            aVar.g = this;
            aVar.d = this.d;
            aVar.c = this.c;
            d();
            aVar.c();
            return aVar;
        }

        private static long k(@Nullable a<?> aVar) {
            if (aVar == null) {
                return 0L;
            }
            return ((a) aVar).d;
        }

        private static int l(@Nullable a<?> aVar) {
            if (aVar == null) {
                return 0;
            }
            return ((a) aVar).e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public a<E> b(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare < 0) {
                if (this.f != null) {
                    return (a) Objects.b(this.f.b((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e), this);
                }
                return this;
            }
            if (compare != 0) {
                return this.g == null ? null : this.g.b((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public a<E> c(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.f2784a);
            if (compare > 0) {
                if (this.g != null) {
                    return (a) Objects.b(this.g.c(comparator, e), this);
                }
                return this;
            }
            if (compare != 0) {
                return this.f == null ? null : this.f.c(comparator, e);
            }
            return this;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public E getElement() {
            return this.f2784a;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            return this.b;
        }

        @Override // com.google.common.collect.Multisets.a
        public String toString() {
            return Multisets.a(getElement(), getCount()).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(a<T> aVar, a<T> aVar2) {
        ((a) aVar).i = aVar2;
        ((a) aVar2).h = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(a<T> aVar, a<T> aVar2, a<T> aVar3) {
        a(aVar, aVar2);
        a(aVar2, aVar3);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        cs.a(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        cs.a(m.class, "comparator").a((cs.a) this, (Object) comparator);
        cs.a(TreeMultiset.class, "range").a((cs.a) this, (Object) GeneralRange.all(comparator));
        cs.a(TreeMultiset.class, "rootReference").a((cs.a) this, (Object) new b(null));
        a aVar = new a(null, 1);
        cs.a(TreeMultiset.class, "header").a((cs.a) this, (Object) aVar);
        a(aVar, aVar);
        cs.a(this, objectInputStream);
    }
}
