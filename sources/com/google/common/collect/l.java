package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultiset.java */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class l<E> extends AbstractCollection<E> implements Multiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private transient Set<E> f2880a;
    private transient Set<Multiset.Entry<E>> b;

    abstract int distinctElements();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> entryIterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Multisets.b((Multiset<?>) this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@Nullable Object obj) {
        return count(obj) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.a((Multiset) this);
    }

    public int count(@Nullable Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.a(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean add(@Nullable E e) {
        add(e, 1);
        return true;
    }

    public int add(@Nullable E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean remove(@Nullable Object obj) {
        return remove(obj, 1) > 0;
    }

    public int remove(@Nullable Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public int setCount(@Nullable E e, int i) {
        return Multisets.a(this, e, i);
    }

    public boolean setCount(@Nullable E e, int i, int i2) {
        return Multisets.a(this, e, i, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return Multisets.a((Multiset) this, (Collection) collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterators.d(entryIterator());
    }

    public Set<E> elementSet() {
        Set<E> set = this.f2880a;
        if (set == null) {
            Set<E> createElementSet = createElementSet();
            this.f2880a = createElementSet;
            return createElementSet;
        }
        return set;
    }

    Set<E> createElementSet() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMultiset.java */
    /* loaded from: classes2.dex */
    public class a extends Multisets.b<E> {
        a() {
        }

        @Override // com.google.common.collect.Multisets.b
        Multiset<E> a() {
            return l.this;
        }
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.b;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.b = createEntrySet;
        return createEntrySet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMultiset.java */
    /* loaded from: classes2.dex */
    public class b extends Multisets.c<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // com.google.common.collect.Multisets.c
        Multiset<E> a() {
            return l.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return l.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return l.this.distinctElements();
        }
    }

    Set<Multiset.Entry<E>> createEntrySet() {
        return new b();
    }

    @Override // java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return Multisets.a(this, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }
}
