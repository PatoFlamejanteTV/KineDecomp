package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: SortedMultisets.java */
@GwtCompatible
/* loaded from: classes2.dex */
final class cv {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SortedMultisets.java */
    /* loaded from: classes2.dex */
    public static abstract class b<E> extends Multisets.b<E> implements SortedSet<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.b
        /* renamed from: b */
        public abstract SortedMultiset<E> a();

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e, E e2) {
            return a().subMultiset(e, BoundType.CLOSED, e2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e) {
            return a().headMultiset(e, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e) {
            return a().tailMultiset(e, BoundType.CLOSED).elementSet();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) cv.b(a().firstEntry());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) cv.b(a().lastEntry());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E b(Multiset.Entry<E> entry) {
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return entry.getElement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SortedMultisets.java */
    /* loaded from: classes2.dex */
    public static abstract class a<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

        /* renamed from: a, reason: collision with root package name */
        private transient Comparator<? super E> f2850a;
        private transient SortedSet<E> b;
        private transient Set<Multiset.Entry<E>> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract SortedMultiset<E> a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator<Multiset.Entry<E>> b();

        @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.ct
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.f2850a;
            if (comparator == null) {
                Ordering reverse = Ordering.from(a().comparator()).reverse();
                this.f2850a = reverse;
                return reverse;
            }
            return comparator;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public SortedSet<E> elementSet() {
            SortedSet<E> sortedSet = this.b;
            if (sortedSet == null) {
                cw cwVar = new cw(this);
                this.b = cwVar;
                return cwVar;
            }
            return sortedSet;
        }

        @Override // com.google.common.collect.SortedMultiset
        public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
            return a().tailMultiset(e, boundType).descendingMultiset();
        }

        @Override // com.google.common.collect.SortedMultiset
        public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
            return a().subMultiset(e2, boundType2, e, boundType).descendingMultiset();
        }

        @Override // com.google.common.collect.SortedMultiset
        public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
            return a().headMultiset(e, boundType).descendingMultiset();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: c */
        public Multiset<E> delegate() {
            return a();
        }

        @Override // com.google.common.collect.SortedMultiset
        public SortedMultiset<E> descendingMultiset() {
            return a();
        }

        @Override // com.google.common.collect.SortedMultiset
        public Multiset.Entry<E> firstEntry() {
            return a().lastEntry();
        }

        @Override // com.google.common.collect.SortedMultiset
        public Multiset.Entry<E> lastEntry() {
            return a().firstEntry();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.c;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> g = g();
            this.c = g;
            return g;
        }

        Set<Multiset.Entry<E>> g() {
            return new cx(this);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.a((Multiset) this);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return entrySet().toString();
        }
    }
}
