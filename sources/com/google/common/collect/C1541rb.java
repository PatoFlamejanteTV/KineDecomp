package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* compiled from: SortedMultisets.java */
/* renamed from: com.google.common.collect.rb */
/* loaded from: classes2.dex */
final class C1541rb {

    /* compiled from: SortedMultisets.java */
    /* renamed from: com.google.common.collect.rb$a */
    /* loaded from: classes2.dex */
    public static class a<E> extends Multisets.b<E> implements SortedSet<E> {

        /* renamed from: a */
        @Weak
        private final SortedMultiset<E> f15835a;

        a(SortedMultiset<E> sortedMultiset) {
            this.f15835a = sortedMultiset;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) C1541rb.d(a().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e2) {
            return a().headMultiset(e2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) C1541rb.d(a().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e2, E e3) {
            return a().subMultiset(e2, BoundType.CLOSED, e3, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e2) {
            return a().tailMultiset(e2, BoundType.CLOSED).elementSet();
        }

        @Override // com.google.common.collect.Multisets.b
        public final SortedMultiset<E> a() {
            return this.f15835a;
        }
    }

    /* compiled from: SortedMultisets.java */
    @GwtIncompatible
    /* renamed from: com.google.common.collect.rb$b */
    /* loaded from: classes2.dex */
    static class b<E> extends a<E> implements NavigableSet<E> {
        public b(SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return (E) C1541rb.c(a().tailMultiset(e2, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(a().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return (E) C1541rb.c(a().headMultiset(e2, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            return new b(a().headMultiset(e2, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return (E) C1541rb.c(a().tailMultiset(e2, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return (E) C1541rb.c(a().headMultiset(e2, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) C1541rb.c(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) C1541rb.c(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            return new b(a().subMultiset(e2, BoundType.forBoolean(z), e3, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            return new b(a().tailMultiset(e2, BoundType.forBoolean(z)));
        }
    }

    public static <E> E c(@Nullable Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }

    public static <E> E d(Multiset.Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }
}
