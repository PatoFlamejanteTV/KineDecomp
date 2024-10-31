package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class c<E> extends UnmodifiableListIterator<E> {

    /* renamed from: a, reason: collision with root package name */
    private final int f2833a;
    private int b;

    protected abstract E a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i) {
        this(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i, int i2) {
        Preconditions.b(i2, i);
        this.f2833a = i;
        this.b = i2;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.b < this.f2833a;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }
}
