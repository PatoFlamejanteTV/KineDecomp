package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.a(comparable);
        Preconditions.a(comparable2);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public int binarySearch(List<? extends Comparable> list, Comparable comparable) {
        return Collections.binarySearch(list, comparable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> List<E> sortedCopy(Iterable<E> iterable) {
        ArrayList a2 = Lists.a(iterable);
        Collections.sort(a2);
        return a2;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}
