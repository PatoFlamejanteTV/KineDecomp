package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

/* compiled from: TransformedListIterator.java */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class dl<F, T> extends dk<F, T> implements ListIterator<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> a() {
        return Iterators.f(this.c);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return a().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(a().previous());
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return a().nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return a().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
