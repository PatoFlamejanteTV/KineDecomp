package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* compiled from: AbstractSortedMultiset.java */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class m<E> extends l<E> implements SortedMultiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private transient SortedMultiset<E> f2883a;
    final Comparator<? super E> comparator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    m() {
        this(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Comparator<? super E> comparator) {
        this.comparator = (Comparator) Preconditions.a(comparator);
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public SortedSet<E> elementSet() {
        return (SortedSet) super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.l
    public SortedSet<E> createElementSet() {
        return new n(this);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
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

    public SortedMultiset<E> subMultiset(@Nullable E e, BoundType boundType, @Nullable E e2, BoundType boundType2) {
        Preconditions.a(boundType);
        Preconditions.a(boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<E> descendingIterator() {
        return Multisets.a((Multiset) descendingMultiset());
    }

    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.f2883a;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset<E> createDescendingMultiset = createDescendingMultiset();
        this.f2883a = createDescendingMultiset;
        return createDescendingMultiset;
    }

    SortedMultiset<E> createDescendingMultiset() {
        return new o(this);
    }
}
