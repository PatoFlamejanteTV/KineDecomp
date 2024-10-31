package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: a */
    private final transient ImmutableSortedMultiset<E> f2673a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f2673a = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        return this.f2673a.count(obj);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return this.f2673a.lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return this.f2673a.firstEntry();
    }

    @Override // java.util.Collection
    public int size() {
        return this.f2673a.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.f2673a.elementSet().descendingSet();
    }

    /* renamed from: com.google.common.collect.DescendingImmutableSortedMultiset$1 */
    /* loaded from: classes2.dex */
    class AnonymousClass1 extends ImmutableMultiset.EntrySet {
        final /* synthetic */ ImmutableSet val$forwardEntrySet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImmutableSet immutableSet) {
            super();
            r2 = immutableSet;
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return r2.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Multiset.Entry<E>> createAsList() {
            return r2.asList().reverse();
        }
    }

    @Override // com.google.common.collect.ImmutableMultiset
    ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return new ImmutableMultiset.EntrySet() { // from class: com.google.common.collect.DescendingImmutableSortedMultiset.1
            final /* synthetic */ ImmutableSet val$forwardEntrySet;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ImmutableSet immutableSet) {
                super();
                r2 = immutableSet;
            }

            @Override // java.util.Collection, java.util.Set
            public int size() {
                return r2.size();
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
                return asList().iterator();
            }

            @Override // com.google.common.collect.ImmutableCollection
            ImmutableList<Multiset.Entry<E>> createAsList() {
                return r2.asList().reverse();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f2673a;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.f2673a.tailMultiset((ImmutableSortedMultiset<E>) e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.f2673a.headMultiset((ImmutableSortedMultiset<E>) e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f2673a.isPartialView();
    }
}
