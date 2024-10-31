package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Collection<E> delegate();

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        return delegate().add(e);
    }

    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    @Beta
    protected boolean standardContains(@Nullable Object obj) {
        return Iterators.a((Iterator<?>) iterator(), obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    public boolean standardContainsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Beta
    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    @Beta
    protected boolean standardRemove(@Nullable Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Objects.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.a((Iterator<?>) iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.b((Iterator<?>) iterator(), collection);
    }

    @Beta
    protected void standardClear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Beta
    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    public String standardToString() {
        return Collections2.a((Collection<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) ObjectArrays.a((Collection<?>) this, (Object[]) tArr);
    }
}
