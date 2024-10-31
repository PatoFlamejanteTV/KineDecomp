package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public interface Multiset<E> extends Collection<E> {

    /* loaded from: classes2.dex */
    public interface Entry<E> {
        int getCount();

        E getElement();
    }

    int add(@Nullable E e, int i);

    boolean add(E e);

    boolean contains(@Nullable Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@Nullable Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    int remove(@Nullable Object obj, int i);

    boolean remove(@Nullable Object obj);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);
}
