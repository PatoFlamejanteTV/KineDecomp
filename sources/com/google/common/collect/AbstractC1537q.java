package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.C1541rb;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractSortedMultiset.java */
/* renamed from: com.google.common.collect.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1537q<E> extends AbstractC1522l<E> implements SortedMultiset<E> {

    /* renamed from: c, reason: collision with root package name */
    private transient SortedMultiset<E> f15830c;
    final Comparator<? super E> comparator;

    AbstractC1537q() {
        this(Ordering.natural());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    SortedMultiset<E> createDescendingMultiset() {
        return new C1534p(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<E> descendingIterator() {
        return Multisets.a((Multiset) descendingMultiset());
    }

    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.f15830c;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset<E> createDescendingMultiset = createDescendingMultiset();
        this.f15830c = createDescendingMultiset;
        return createDescendingMultiset;
    }

    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = entryIterator.next();
        Multiset.Entry<E> a2 = Multisets.a(next.getElement(), next.getCount());
        entryIterator.remove();
        return a2;
    }

    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = descendingEntryIterator.next();
        Multiset.Entry<E> a2 = Multisets.a(next.getElement(), next.getCount());
        descendingEntryIterator.remove();
        return a2;
    }

    public SortedMultiset<E> subMultiset(@Nullable E e2, BoundType boundType, @Nullable E e3, BoundType boundType2) {
        Preconditions.a(boundType);
        Preconditions.a(boundType2);
        return tailMultiset(e2, boundType).headMultiset(e3, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1537q(Comparator<? super E> comparator) {
        Preconditions.a(comparator);
        this.comparator = comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC1522l
    public NavigableSet<E> createElementSet() {
        return new C1541rb.b(this);
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
