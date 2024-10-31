package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
@GwtCompatible
/* renamed from: com.google.common.collect.b */
/* loaded from: classes2.dex */
abstract class AbstractC1492b<E> extends UnmodifiableListIterator<E> {

    /* renamed from: a */
    private final int f15766a;

    /* renamed from: b */
    private int f15767b;

    public AbstractC1492b(int i) {
        this(i, 0);
    }

    protected abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f15767b < this.f15766a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f15767b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f15767b;
            this.f15767b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f15767b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f15767b - 1;
            this.f15767b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f15767b - 1;
    }

    public AbstractC1492b(int i, int i2) {
        Preconditions.b(i2, i);
        this.f15766a = i;
        this.f15767b = i2;
    }
}
