package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
final class ap implements Iterator<Object> {
    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException();
    }
}
