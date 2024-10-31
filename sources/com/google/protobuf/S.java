package com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: SmallSortedMap.java */
/* loaded from: classes2.dex */
class S implements Iterator<Object> {
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
        throw new UnsupportedOperationException();
    }
}
