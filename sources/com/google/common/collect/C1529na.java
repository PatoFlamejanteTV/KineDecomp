package com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.na */
/* loaded from: classes2.dex */
class C1529na extends UnmodifiableListIterator<Object> {
    @Override // java.util.Iterator, java.util.ListIterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }
}
