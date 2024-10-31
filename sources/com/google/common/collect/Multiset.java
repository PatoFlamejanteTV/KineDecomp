package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
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

        String toString();
    }

    @CanIgnoreReturnValue
    int add(@Nullable E e2, int i);

    @CanIgnoreReturnValue
    boolean add(E e2);

    boolean contains(@Nullable Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@Nullable Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@Nullable Object obj);

    int hashCode();

    @CanIgnoreReturnValue
    int remove(@Nullable Object obj, int i);

    @CanIgnoreReturnValue
    boolean remove(@Nullable Object obj);

    @CanIgnoreReturnValue
    int setCount(E e2, int i);

    @CanIgnoreReturnValue
    boolean setCount(E e2, int i, int i2);
}
