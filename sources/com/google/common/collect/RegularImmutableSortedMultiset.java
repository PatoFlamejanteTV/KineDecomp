package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: a */
    private final transient RegularImmutableSortedSet<E> f2757a;
    private final transient int[] b;
    private final transient long[] c;
    private final transient int d;
    private final transient int e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, int[] iArr, long[] jArr, int i, int i2) {
        this.f2757a = regularImmutableSortedSet;
        this.b = iArr;
        this.c = jArr;
        this.d = i;
        this.e = i2;
    }

    public Multiset.Entry<E> a(int i) {
        return Multisets.a(this.f2757a.asList().get(i), this.b[this.d + i]);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return a(0);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return a(this.e - 1);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        int indexOf = this.f2757a.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.b[indexOf + this.d];
    }

    @Override // java.util.Collection
    public int size() {
        return Ints.a(this.c[this.d + this.e] - this.c[this.d]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.f2757a;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return getSubMultiset(0, this.f2757a.headIndex(e, Preconditions.a(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return getSubMultiset(this.f2757a.tailIndex(e, Preconditions.a(boundType) == BoundType.CLOSED), this.e);
    }

    ImmutableSortedMultiset<E> getSubMultiset(int i, int i2) {
        Preconditions.a(i, i2, this.e);
        if (i == i2) {
            return emptyMultiset(comparator());
        }
        return (i == 0 && i2 == this.e) ? this : new RegularImmutableSortedMultiset((RegularImmutableSortedSet) this.f2757a.getSubSet(i, i2), this.b, this.c, this.d + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    /* loaded from: classes2.dex */
    public final class EntrySet extends ImmutableMultiset.EntrySet {
        private EntrySet() {
            super();
        }

        /* synthetic */ EntrySet(RegularImmutableSortedMultiset regularImmutableSortedMultiset, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableSortedMultiset.this.e;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return asList().iterator();
        }

        /* renamed from: com.google.common.collect.RegularImmutableSortedMultiset$EntrySet$1 */
        /* loaded from: classes2.dex */
        class AnonymousClass1 extends ImmutableAsList<Multiset.Entry<E>> {
            AnonymousClass1() {
            }

            @Override // java.util.List
            public Multiset.Entry<E> get(int i) {
                return RegularImmutableSortedMultiset.this.a(i);
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                return EntrySet.this;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Multiset.Entry<E>> createAsList() {
            return new ImmutableAsList<Multiset.Entry<E>>() { // from class: com.google.common.collect.RegularImmutableSortedMultiset.EntrySet.1
                AnonymousClass1() {
                }

                @Override // java.util.List
                public Multiset.Entry<E> get(int i) {
                    return RegularImmutableSortedMultiset.this.a(i);
                }

                @Override // com.google.common.collect.ImmutableAsList
                ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.d > 0 || this.e < this.b.length;
    }
}
