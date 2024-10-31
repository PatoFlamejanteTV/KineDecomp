package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

/* compiled from: TransformedIterator.java */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class Bb<F, T> implements Iterator<T> {

    /* renamed from: a */
    final Iterator<? extends F> f15343a;

    public Bb(Iterator<? extends F> it) {
        Preconditions.a(it);
        this.f15343a = it;
    }

    public abstract T a(F f2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15343a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f15343a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f15343a.remove();
    }
}
