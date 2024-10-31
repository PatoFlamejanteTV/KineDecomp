package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: d, reason: collision with root package name */
    private final transient RegularImmutableSortedSet<E> f15661d;

    /* renamed from: e, reason: collision with root package name */
    private final transient long[] f15662e;

    /* renamed from: f, reason: collision with root package name */
    private final transient int f15663f;

    /* renamed from: g, reason: collision with root package name */
    private final transient int f15664g;

    /* renamed from: c, reason: collision with root package name */
    private static final long[] f15660c = {0};
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.f15661d = ImmutableSortedSet.emptySet(comparator);
        this.f15662e = f15660c;
        this.f15663f = 0;
        this.f15664g = 0;
    }

    private int a(int i) {
        long[] jArr = this.f15662e;
        int i2 = this.f15663f;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        int indexOf = this.f15661d.indexOf(obj);
        if (indexOf >= 0) {
            return a(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int i) {
        return Multisets.a(this.f15661d.asList().get(i), a(i));
    }

    ImmutableSortedMultiset<E> getSubMultiset(int i, int i2) {
        Preconditions.a(i, i2, this.f15664g);
        if (i == i2) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i == 0 && i2 == this.f15664g) ? this : new RegularImmutableSortedMultiset(this.f15661d.getSubSet(i, i2), this.f15662e, this.f15663f + i, i2 - i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f15663f > 0 || this.f15664g < this.f15662e.length - 1;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f15664g - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long[] jArr = this.f15662e;
        int i = this.f15663f;
        return Ints.b(jArr[this.f15664g + i] - jArr[i]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.f15661d;
        Preconditions.a(boundType);
        return getSubMultiset(0, regularImmutableSortedSet.headIndex(e2, boundType == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.f15661d;
        Preconditions.a(boundType);
        return getSubMultiset(regularImmutableSortedSet.tailIndex(e2, boundType == BoundType.CLOSED), this.f15664g);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.f15661d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i, int i2) {
        this.f15661d = regularImmutableSortedSet;
        this.f15662e = jArr;
        this.f15663f = i;
        this.f15664g = i2;
    }
}
