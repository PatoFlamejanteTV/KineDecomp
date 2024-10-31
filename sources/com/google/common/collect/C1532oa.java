package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.oa */
/* loaded from: classes2.dex */
class C1532oa implements Iterator<Object> {
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
        C1555x.a(false);
    }
}
