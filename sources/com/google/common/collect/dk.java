package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

/* compiled from: TransformedIterator.java */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class dk<F, T> implements Iterator<T> {
    final Iterator<? extends F> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(Iterator<? extends F> it) {
        this.c = (Iterator) Preconditions.a(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.c.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.c.remove();
    }
}
