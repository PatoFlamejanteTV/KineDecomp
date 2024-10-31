package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    public ComparatorOrdering(Comparator<T> comparator) {
        this.comparator = (Comparator) Preconditions.a(comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return this.comparator.compare(t, t2);
    }

    @Override // com.google.common.collect.Ordering
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this.comparator);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        ArrayList a2 = Lists.a(iterable);
        Collections.sort(a2, this.comparator);
        return a2;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        Object[] c = Iterables.c(iterable);
        for (Object obj : c) {
            Preconditions.a(obj);
        }
        Arrays.sort(c, this.comparator);
        return ImmutableList.asImmutableList(c);
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComparatorOrdering) {
            return this.comparator.equals(((ComparatorOrdering) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
