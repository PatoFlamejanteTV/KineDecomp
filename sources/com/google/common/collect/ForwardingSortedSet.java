package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract SortedSet<E> delegate();

    protected ForwardingSortedSet() {
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return delegate().headSet(e);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return delegate().subSet(e, e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return delegate().tailSet(e);
    }

    private int a(Object obj, Object obj2) {
        Comparator<? super E> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardContains(@Nullable Object obj) {
        try {
            return a(tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        } catch (NoSuchElementException e3) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardRemove(@Nullable Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (!it.hasNext() || a(it.next(), obj) != 0) {
                return false;
            }
            it.remove();
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }
}
