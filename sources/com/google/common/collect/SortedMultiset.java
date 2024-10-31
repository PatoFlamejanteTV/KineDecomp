package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* loaded from: classes2.dex */
public interface SortedMultiset<E> extends InterfaceC1539qb<E>, InterfaceC1530nb<E> {
    Comparator<? super E> comparator();

    SortedMultiset<E> descendingMultiset();

    @Override // com.google.common.collect.Multiset
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    Set<Multiset.Entry<E>> entrySet();

    Multiset.Entry<E> firstEntry();

    SortedMultiset<E> headMultiset(E e2, BoundType boundType);

    Multiset.Entry<E> lastEntry();

    Multiset.Entry<E> pollFirstEntry();

    Multiset.Entry<E> pollLastEntry();

    SortedMultiset<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2);

    SortedMultiset<E> tailMultiset(E e2, BoundType boundType);
}
