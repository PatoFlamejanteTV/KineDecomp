package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.C1527mb;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class TreeMultiset<E> extends AbstractC1537q<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: d, reason: collision with root package name */
    private final transient b<a<E>> f15708d;

    /* renamed from: e, reason: collision with root package name */
    private final transient GeneralRange<E> f15709e;

    /* renamed from: f, reason: collision with root package name */
    private final transient a<E> f15710f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(a<?> aVar) {
                return ((a) aVar).f15712b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@Nullable a<?> aVar) {
                if (aVar == null) {
                    return 0L;
                }
                return ((a) aVar).f15714d;
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
                return ((a) aVar).f15713c;
            }
        };

        abstract int nodeAggregate(a<?> aVar);

        abstract long treeAggregate(@Nullable a<?> aVar);

        /* synthetic */ Aggregate(Fb fb) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a<E> extends Multisets.a<E> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final E f15711a;

        /* renamed from: b, reason: collision with root package name */
        private int f15712b;

        /* renamed from: c, reason: collision with root package name */
        private int f15713c;

        /* renamed from: d, reason: collision with root package name */
        private long f15714d;

        /* renamed from: e, reason: collision with root package name */
        private int f15715e;

        /* renamed from: f, reason: collision with root package name */
        private a<E> f15716f;

        /* renamed from: g, reason: collision with root package name */
        private a<E> f15717g;

        /* renamed from: h, reason: collision with root package name */
        private a<E> f15718h;
        private a<E> i;

        a(@Nullable E e2, int i) {
            Preconditions.a(i > 0);
            this.f15711a = e2;
            this.f15712b = i;
            this.f15714d = i;
            this.f15713c = 1;
            this.f15715e = 1;
            this.f15716f = null;
            this.f15717g = null;
        }

        private static int i(@Nullable a<?> aVar) {
            if (aVar == null) {
                return 0;
            }
            return ((a) aVar).f15715e;
        }

        private a<E> j(a<E> aVar) {
            a<E> aVar2 = this.f15717g;
            if (aVar2 == null) {
                return this.f15716f;
            }
            this.f15717g = aVar2.j(aVar);
            this.f15713c--;
            this.f15714d -= aVar.f15712b;
            return c();
        }

        private a<E> k(a<E> aVar) {
            a<E> aVar2 = this.f15716f;
            if (aVar2 == null) {
                return this.f15717g;
            }
            this.f15716f = aVar2.k(aVar);
            this.f15713c--;
            this.f15714d -= aVar.f15712b;
            return c();
        }

        private static long l(@Nullable a<?> aVar) {
            if (aVar == null) {
                return 0L;
            }
            return ((a) aVar).f15714d;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            return this.f15712b;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public E getElement() {
            return this.f15711a;
        }

        @Override // com.google.common.collect.Multisets.a, com.google.common.collect.Multiset.Entry
        public String toString() {
            return Multisets.a(getElement(), getCount()).toString();
        }

        private void d() {
            f();
            e();
        }

        private void e() {
            this.f15715e = Math.max(i(this.f15716f), i(this.f15717g)) + 1;
        }

        private void f() {
            this.f15713c = TreeMultiset.distinctElements(this.f15716f) + 1 + TreeMultiset.distinctElements(this.f15717g);
            this.f15714d = this.f15712b + l(this.f15716f) + l(this.f15717g);
        }

        private a<E> g() {
            Preconditions.b(this.f15717g != null);
            a<E> aVar = this.f15717g;
            this.f15717g = aVar.f15716f;
            aVar.f15716f = this;
            aVar.f15714d = this.f15714d;
            aVar.f15713c = this.f15713c;
            d();
            aVar.e();
            return aVar;
        }

        private a<E> h() {
            Preconditions.b(this.f15716f != null);
            a<E> aVar = this.f15716f;
            this.f15716f = aVar.f15717g;
            aVar.f15717g = this;
            aVar.f15714d = this.f15714d;
            aVar.f15713c = this.f15713c;
            d();
            aVar.e();
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> c(Comparator<? super E> comparator, @Nullable E e2, int i, int[] iArr) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare < 0) {
                a<E> aVar = this.f15716f;
                if (aVar == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        a((a<E>) e2, i);
                    }
                    return this;
                }
                this.f15716f = aVar.c(comparator, e2, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.f15713c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.f15713c++;
                }
                this.f15714d += i - iArr[0];
                return c();
            }
            if (compare > 0) {
                a<E> aVar2 = this.f15717g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        b((a<E>) e2, i);
                    }
                    return this;
                }
                this.f15717g = aVar2.c(comparator, e2, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.f15713c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.f15713c++;
                }
                this.f15714d += i - iArr[0];
                return c();
            }
            iArr[0] = this.f15712b;
            if (i == 0) {
                return b();
            }
            this.f15714d += i - r3;
            this.f15712b = i;
            return this;
        }

        private a<E> b(E e2, int i) {
            this.f15717g = new a<>(e2, i);
            TreeMultiset.a(this, this.f15717g, this.i);
            this.f15715e = Math.max(2, this.f15715e);
            this.f15713c++;
            this.f15714d += i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int a(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare < 0) {
                a<E> aVar = this.f15716f;
                if (aVar == null) {
                    return 0;
                }
                return aVar.a((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e2);
            }
            if (compare > 0) {
                a<E> aVar2 = this.f15717g;
                if (aVar2 == null) {
                    return 0;
                }
                return aVar2.a((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e2);
            }
            return this.f15712b;
        }

        private a<E> a(E e2, int i) {
            this.f15716f = new a<>(e2, i);
            TreeMultiset.a(this.f15718h, this.f15716f, this);
            this.f15715e = Math.max(2, this.f15715e);
            this.f15713c++;
            this.f15714d += i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> b(Comparator<? super E> comparator, @Nullable E e2, int i, int[] iArr) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare < 0) {
                a<E> aVar = this.f15716f;
                if (aVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f15716f = aVar.b(comparator, e2, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.f15713c--;
                        this.f15714d -= iArr[0];
                    } else {
                        this.f15714d -= i;
                    }
                }
                return iArr[0] == 0 ? this : c();
            }
            if (compare > 0) {
                a<E> aVar2 = this.f15717g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f15717g = aVar2.b(comparator, e2, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.f15713c--;
                        this.f15714d -= iArr[0];
                    } else {
                        this.f15714d -= i;
                    }
                }
                return c();
            }
            int i2 = this.f15712b;
            iArr[0] = i2;
            if (i >= i2) {
                return b();
            }
            this.f15712b = i2 - i;
            this.f15714d -= i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> a(Comparator<? super E> comparator, @Nullable E e2, int i, int[] iArr) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare < 0) {
                a<E> aVar = this.f15716f;
                if (aVar == null) {
                    iArr[0] = 0;
                    a((a<E>) e2, i);
                    return this;
                }
                int i2 = aVar.f15715e;
                this.f15716f = aVar.a(comparator, e2, i, iArr);
                if (iArr[0] == 0) {
                    this.f15713c++;
                }
                this.f15714d += i;
                return this.f15716f.f15715e == i2 ? this : c();
            }
            if (compare > 0) {
                a<E> aVar2 = this.f15717g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    b((a<E>) e2, i);
                    return this;
                }
                int i3 = aVar2.f15715e;
                this.f15717g = aVar2.a(comparator, e2, i, iArr);
                if (iArr[0] == 0) {
                    this.f15713c++;
                }
                this.f15714d += i;
                return this.f15717g.f15715e == i3 ? this : c();
            }
            int i4 = this.f15712b;
            iArr[0] = i4;
            long j = i;
            Preconditions.a(((long) i4) + j <= 2147483647L);
            this.f15712b += i;
            this.f15714d += j;
            return this;
        }

        private a<E> c() {
            int a2 = a();
            if (a2 == -2) {
                if (this.f15717g.a() > 0) {
                    this.f15717g = this.f15717g.h();
                }
                return g();
            }
            if (a2 != 2) {
                e();
                return this;
            }
            if (this.f15716f.a() < 0) {
                this.f15716f = this.f15716f.g();
            }
            return h();
        }

        private a<E> b() {
            int i = this.f15712b;
            this.f15712b = 0;
            TreeMultiset.a(this.f15718h, this.i);
            a<E> aVar = this.f15716f;
            if (aVar == null) {
                return this.f15717g;
            }
            a<E> aVar2 = this.f15717g;
            if (aVar2 == null) {
                return aVar;
            }
            if (aVar.f15715e >= aVar2.f15715e) {
                a<E> aVar3 = this.f15718h;
                aVar3.f15716f = aVar.j(aVar3);
                aVar3.f15717g = this.f15717g;
                aVar3.f15713c = this.f15713c - 1;
                aVar3.f15714d = this.f15714d - i;
                return aVar3.c();
            }
            a<E> aVar4 = this.i;
            aVar4.f15717g = aVar2.k(aVar4);
            aVar4.f15716f = this.f15716f;
            aVar4.f15713c = this.f15713c - 1;
            aVar4.f15714d = this.f15714d - i;
            return aVar4.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public a<E> c(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare > 0) {
                a<E> aVar = this.f15717g;
                return aVar == null ? this : (a) MoreObjects.a(aVar.c(comparator, e2), this);
            }
            if (compare == 0) {
                return this;
            }
            a<E> aVar2 = this.f15716f;
            if (aVar2 == null) {
                return null;
            }
            return aVar2.c(comparator, e2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<E> a(Comparator<? super E> comparator, @Nullable E e2, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare < 0) {
                a<E> aVar = this.f15716f;
                if (aVar == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        a((a<E>) e2, i2);
                    }
                    return this;
                }
                this.f15716f = aVar.a(comparator, e2, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f15713c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f15713c++;
                    }
                    this.f15714d += i2 - iArr[0];
                }
                return c();
            }
            if (compare > 0) {
                a<E> aVar2 = this.f15717g;
                if (aVar2 == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        b((a<E>) e2, i2);
                    }
                    return this;
                }
                this.f15717g = aVar2.a(comparator, e2, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f15713c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f15713c++;
                    }
                    this.f15714d += i2 - iArr[0];
                }
                return c();
            }
            int i3 = this.f15712b;
            iArr[0] = i3;
            if (i == i3) {
                if (i2 == 0) {
                    return b();
                }
                this.f15714d += i2 - i3;
                this.f15712b = i2;
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public a<E> b(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.f15711a);
            if (compare < 0) {
                a<E> aVar = this.f15716f;
                return aVar == null ? this : (a) MoreObjects.a(aVar.b((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e2), this);
            }
            if (compare == 0) {
                return this;
            }
            a<E> aVar2 = this.f15717g;
            if (aVar2 == null) {
                return null;
            }
            return aVar2.b((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e2);
        }

        private int a() {
            return i(this.f15716f) - i(this.f15717g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private T f15719a;

        private b() {
        }

        @Nullable
        public T a() {
            return this.f15719a;
        }

        /* synthetic */ b(Fb fb) {
            this();
        }

        public void a(@Nullable T t, T t2) {
            if (this.f15719a == t) {
                this.f15719a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    TreeMultiset(b<a<E>> bVar, GeneralRange<E> generalRange, a<E> aVar) {
        super(generalRange.comparator());
        this.f15708d = bVar;
        this.f15709e = generalRange;
        this.f15710f = aVar;
    }

    private long a(Aggregate aggregate) {
        a<E> a2 = this.f15708d.a();
        long treeAggregate = aggregate.treeAggregate(a2);
        if (this.f15709e.hasLowerBound()) {
            treeAggregate -= b(aggregate, a2);
        }
        return this.f15709e.hasUpperBound() ? treeAggregate - a(aggregate, a2) : treeAggregate;
    }

    private long b(Aggregate aggregate, @Nullable a<E> aVar) {
        long treeAggregate;
        long b2;
        if (aVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.f15709e.getLowerEndpoint(), ((a) aVar).f15711a);
        if (compare < 0) {
            return b(aggregate, ((a) aVar).f15716f);
        }
        if (compare != 0) {
            treeAggregate = aggregate.treeAggregate(((a) aVar).f15716f) + aggregate.nodeAggregate(aVar);
            b2 = b(aggregate, ((a) aVar).f15717g);
        } else {
            int i = Ib.f15415a[this.f15709e.getLowerBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(((a) aVar).f15716f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(aVar);
            b2 = aggregate.treeAggregate(((a) aVar).f15716f);
        }
        return treeAggregate + b2;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        C1527mb.a(AbstractC1537q.class, "comparator").a((C1527mb.a) this, (Object) comparator);
        C1527mb.a(TreeMultiset.class, "range").a((C1527mb.a) this, (Object) GeneralRange.all(comparator));
        C1527mb.a(TreeMultiset.class, "rootReference").a((C1527mb.a) this, (Object) new b(null));
        a aVar = new a(null, 1);
        C1527mb.a(TreeMultiset.class, "header").a((C1527mb.a) this, (Object) aVar);
        a(aVar, aVar);
        C1527mb.a(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        C1527mb.a(this, objectOutputStream);
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
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset, com.google.common.collect.InterfaceC1530nb
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        try {
            a<E> a2 = this.f15708d.a();
            if (this.f15709e.contains(obj) && a2 != null) {
                return a2.a((Comparator<? super Comparator<? super E>>) comparator(), (Comparator<? super E>) obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC1537q
    Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Hb(this);
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractC1522l
    int distinctElements() {
        return Ints.b(a(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC1522l
    Iterator<Multiset.Entry<E>> entryIterator() {
        return new Gb(this);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@Nullable E e2, BoundType boundType) {
        return new TreeMultiset(this.f15708d, this.f15709e.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.f15710f);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@Nullable E e2, int i) {
        C1555x.a(i, "count");
        if (!this.f15709e.contains(e2)) {
            Preconditions.a(i == 0);
            return 0;
        }
        a<E> a2 = this.f15708d.a();
        if (a2 == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.f15708d.a(a2, a2.c(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Ints.b(a(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1537q, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@Nullable E e2, BoundType boundType) {
        return new TreeMultiset(this.f15708d, this.f15709e.intersect(GeneralRange.downTo(comparator(), e2, boundType)), this.f15710f);
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> TreeMultiset<E> create(@Nullable Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    static int distinctElements(@Nullable a<?> aVar) {
        if (aVar == null) {
            return 0;
        }
        return ((a) aVar).f15713c;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@Nullable E e2, int i) {
        C1555x.a(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        Preconditions.a(this.f15709e.contains(e2));
        a<E> a2 = this.f15708d.a();
        if (a2 == null) {
            comparator().compare(e2, e2);
            a<E> aVar = new a<>(e2, i);
            a<E> aVar2 = this.f15710f;
            a(aVar2, aVar, aVar2);
            this.f15708d.a(a2, aVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.f15708d.a(a2, a2.a(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@Nullable Object obj, int i) {
        C1555x.a(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        a<E> a2 = this.f15708d.a();
        int[] iArr = new int[1];
        try {
            if (this.f15709e.contains(obj) && a2 != null) {
                this.f15708d.a(a2, a2.b(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.a((Collection) create, (Iterable) iterable);
        return create;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.f15709e = GeneralRange.all(comparator);
        this.f15710f = new a<>(null, 1);
        a<E> aVar = this.f15710f;
        a(aVar, aVar);
        this.f15708d = new b<>(null);
    }

    private long a(Aggregate aggregate, @Nullable a<E> aVar) {
        long treeAggregate;
        long a2;
        if (aVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.f15709e.getUpperEndpoint(), ((a) aVar).f15711a);
        if (compare > 0) {
            return a(aggregate, ((a) aVar).f15717g);
        }
        if (compare != 0) {
            treeAggregate = aggregate.treeAggregate(((a) aVar).f15717g) + aggregate.nodeAggregate(aVar);
            a2 = a(aggregate, ((a) aVar).f15716f);
        } else {
            int i = Ib.f15415a[this.f15709e.getUpperBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(((a) aVar).f15717g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(aVar);
            a2 = aggregate.treeAggregate(((a) aVar).f15717g);
        }
        return treeAggregate + a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public a<E> b() {
        a<E> aVar;
        if (this.f15708d.a() == null) {
            return null;
        }
        if (!this.f15709e.hasUpperBound()) {
            aVar = ((a) this.f15710f).f15718h;
        } else {
            E upperEndpoint = this.f15709e.getUpperEndpoint();
            a<E> c2 = this.f15708d.a().c(comparator(), upperEndpoint);
            if (c2 == null) {
                return null;
            }
            if (this.f15709e.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, c2.getElement()) == 0) {
                c2 = ((a) c2).f15718h;
            }
            aVar = c2;
        }
        if (aVar == this.f15710f || !this.f15709e.contains(aVar.getElement())) {
            return null;
        }
        return aVar;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@Nullable E e2, int i, int i2) {
        C1555x.a(i2, "newCount");
        C1555x.a(i, "oldCount");
        Preconditions.a(this.f15709e.contains(e2));
        a<E> a2 = this.f15708d.a();
        if (a2 != null) {
            int[] iArr = new int[1];
            this.f15708d.a(a2, a2.a(comparator(), e2, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e2, i2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> a(a<E> aVar) {
        return new Fb(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public a<E> a() {
        a<E> aVar;
        if (this.f15708d.a() == null) {
            return null;
        }
        if (!this.f15709e.hasLowerBound()) {
            aVar = ((a) this.f15710f).i;
        } else {
            E lowerEndpoint = this.f15709e.getLowerEndpoint();
            a<E> b2 = this.f15708d.a().b((Comparator<? super Comparator>) comparator(), (Comparator) lowerEndpoint);
            if (b2 == null) {
                return null;
            }
            if (this.f15709e.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, b2.getElement()) == 0) {
                b2 = ((a) b2).i;
            }
            aVar = b2;
        }
        if (aVar == this.f15710f || !this.f15709e.contains(aVar.getElement())) {
            return null;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(a<T> aVar, a<T> aVar2) {
        ((a) aVar).i = aVar2;
        ((a) aVar2).f15718h = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(a<T> aVar, a<T> aVar2, a<T> aVar3) {
        a(aVar, aVar2);
        a(aVar2, aVar3);
    }
}
