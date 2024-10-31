package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.SortedSet;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public interface SortedMultiset<E> extends Multiset<E>, ct<E> {
    @Override // com.google.common.collect.ct
    Comparator<? super E> comparator();

    SortedMultiset<E> descendingMultiset();

    @Override // com.google.common.collect.Multiset
    SortedSet<E> elementSet();

    Multiset.Entry<E> firstEntry();

    SortedMultiset<E> headMultiset(E e, BoundType boundType);

    Multiset.Entry<E> lastEntry();

    SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2);

    SortedMultiset<E> tailMultiset(E e, BoundType boundType);
}
