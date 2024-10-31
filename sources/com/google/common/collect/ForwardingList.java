package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract List<E> delegate();

    protected ForwardingList() {
    }

    @Override // java.util.List
    public void add(int i, E e) {
        delegate().add(i, e);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        return delegate().addAll(i, collection);
    }

    @Override // java.util.List
    public E get(int i) {
        return delegate().get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return delegate().listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        return delegate().remove(i);
    }

    @Override // java.util.List
    public E set(int i, E e) {
        return delegate().set(i, e);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return delegate().subList(i, i2);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }
}
