package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(List<T> list) {
        this(a((List) list));
    }

    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return a((ExplicitOrdering<T>) t) - a((ExplicitOrdering<T>) t2);
    }

    private int a(T t) {
        Integer num = this.rankMap.get(t);
        if (num == null) {
            throw new Ordering.IncomparableValueException(t);
        }
        return num.intValue();
    }

    private static <T> ImmutableMap<T, Integer> a(List<T> list) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            builder.b(it.next(), Integer.valueOf(i));
            i++;
        }
        return builder.b();
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
