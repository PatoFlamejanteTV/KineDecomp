package com.google.common.collect;

import com.google.common.collect.C1541rb;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescendingMultiset.java */
/* loaded from: classes2.dex */
public abstract class H<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private transient Comparator<? super E> f15393a;

    /* renamed from: b, reason: collision with root package name */
    private transient NavigableSet<E> f15394b;

    /* renamed from: c, reason: collision with root package name */
    private transient Set<Multiset.Entry<E>> f15395c;

    Set<Multiset.Entry<E>> b() {
        return new G(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> c();

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.InterfaceC1530nb
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f15393a;
        if (comparator != null) {
            return comparator;
        }
        Ordering reverse = Ordering.from(d().comparator()).reverse();
        this.f15393a = reverse;
        return reverse;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SortedMultiset<E> d();

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        return d();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.f15395c;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> b2 = b();
        this.f15395c = b2;
        return b2;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return d().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return d().tailMultiset(e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return Multisets.a((Multiset) this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return d().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return d().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return d().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        return d().subMultiset(e3, boundType2, e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return d().headMultiset(e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.ForwardingObject
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f15394b;
        if (navigableSet != null) {
            return navigableSet;
        }
        C1541rb.b bVar = new C1541rb.b(this);
        this.f15394b = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Multiset<E> delegate() {
        return d();
    }
}
