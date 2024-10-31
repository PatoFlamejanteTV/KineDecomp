package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {

    /* renamed from: a */
    private final transient ImmutableList<E> f2758a;

    public RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f2758a = immutableList;
        Preconditions.a(!immutableList.isEmpty());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return this.f2758a.iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f2758a.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        if (!cu.a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        Object next = it2.next();
        while (it.hasNext()) {
            try {
                int unsafeCompare = unsafeCompare(it.next(), next);
                if (unsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (unsafeCompare > 0) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return false;
    }

    private int a(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f2758a, obj, unsafeComparator());
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f2758a.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f2758a.toArray();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f2758a.toArray(tArr);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (cu.a(this.comparator, set)) {
            Iterator<E> it = set.iterator();
            try {
                UnmodifiableIterator<E> it2 = iterator();
                while (it2.hasNext()) {
                    E next = it2.next();
                    E next2 = it.next();
                    if (next2 == null || unsafeCompare(next, next2) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (ClassCastException e) {
                return false;
            } catch (NoSuchElementException e2) {
                return false;
            }
        }
        return containsAll(set);
    }

    @Override // java.util.SortedSet
    public E first() {
        return this.f2758a.get(0);
    }

    @Override // java.util.SortedSet
    public E last() {
        return this.f2758a.get(size() - 1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return getSubSet(0, headIndex(e, z));
    }

    public int headIndex(E e, boolean z) {
        return SortedLists.a(this.f2758a, Preconditions.a(e), comparator(), z ? SortedLists.KeyPresentBehavior.FIRST_AFTER : SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return tailSetImpl(e, z).headSetImpl(e2, z2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return getSubSet(tailIndex(e, z), size());
    }

    public int tailIndex(E e, boolean z) {
        return SortedLists.a(this.f2758a, Preconditions.a(e), comparator(), z ? SortedLists.KeyPresentBehavior.FIRST_PRESENT : SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    public ImmutableSortedSet<E> getSubSet(int i, int i2) {
        if (i != 0 || i2 != size()) {
            if (i < i2) {
                return new RegularImmutableSortedSet(this.f2758a.subList(i, i2), this.comparator);
            }
            return emptySet(this.comparator);
        }
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int a2 = SortedLists.a(this.f2758a, obj, unsafeComparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            if (a2 < 0) {
                a2 = -1;
            }
            return a2;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return new ImmutableSortedAsList(this, this.f2758a);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        return new RegularImmutableSortedSet(this.f2758a.reverse(), Ordering.from(this.comparator).reverse());
    }
}
