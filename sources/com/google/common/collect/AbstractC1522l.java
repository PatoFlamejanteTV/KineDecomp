package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultiset.java */
@GwtCompatible
/* renamed from: com.google.common.collect.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1522l<E> extends AbstractCollection<E> implements Multiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private transient Set<E> f15818a;

    /* renamed from: b, reason: collision with root package name */
    private transient Set<Multiset.Entry<E>> f15819b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMultiset.java */
    /* renamed from: com.google.common.collect.l$a */
    /* loaded from: classes2.dex */
    public class a extends Multisets.b<E> {
        a() {
        }

        @Override // com.google.common.collect.Multisets.b
        Multiset<E> a() {
            return AbstractC1522l.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMultiset.java */
    /* renamed from: com.google.common.collect.l$b */
    /* loaded from: classes2.dex */
    public class b extends Multisets.c<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // com.google.common.collect.Multisets.c
        Multiset<E> a() {
            return AbstractC1522l.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return AbstractC1522l.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC1522l.this.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean add(@Nullable E e2) {
        add(e2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return Multisets.a((Multiset) this, (Collection) collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterators.b(entryIterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@Nullable Object obj) {
        return count(obj) > 0;
    }

    public int count(@Nullable Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.a(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    Set<E> createElementSet() {
        return new a();
    }

    Set<Multiset.Entry<E>> createEntrySet() {
        return new b();
    }

    abstract int distinctElements();

    public Set<E> elementSet() {
        Set<E> set = this.f15818a;
        if (set != null) {
            return set;
        }
        Set<E> createElementSet = createElementSet();
        this.f15818a = createElementSet;
        return createElementSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> entryIterator();

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.f15819b;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.f15819b = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@Nullable Object obj) {
        return Multisets.a(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.a((Multiset) this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean remove(@Nullable Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    @CanIgnoreReturnValue
    public int setCount(@Nullable E e2, int i) {
        return Multisets.a(this, e2, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Multisets.b((Multiset<?>) this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public int add(@Nullable E e2, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int remove(@Nullable Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@Nullable E e2, int i, int i2) {
        return Multisets.a(this, e2, i, i2);
    }
}
