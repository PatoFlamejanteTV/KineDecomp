package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.C1541rb;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.NavigableSet;

@Beta
/* loaded from: classes2.dex */
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    /* loaded from: classes2.dex */
    protected abstract class StandardDescendingMultiset extends H<E> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ForwardingSortedMultiset f15386d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.H
        public SortedMultiset<E> d() {
            return this.f15386d;
        }
    }

    /* loaded from: classes2.dex */
    protected class StandardElementSet extends C1541rb.b<E> {
    }

    protected ForwardingSortedMultiset() {
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.InterfaceC1530nb
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedMultiset<E> delegate();

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return delegate().headMultiset(e2, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        return delegate().subMultiset(e2, boundType, e3, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return delegate().tailMultiset(e2, boundType);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
