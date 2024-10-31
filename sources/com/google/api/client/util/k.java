package com.google.api.client.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Types.java */
/* loaded from: classes2.dex */
class k<T> implements Iterator<T> {

    /* renamed from: a */
    final int f15007a;

    /* renamed from: b */
    int f15008b = 0;

    /* renamed from: c */
    final /* synthetic */ l f15009c;

    public k(l lVar) {
        this.f15009c = lVar;
        this.f15007a = Array.getLength(this.f15009c.f15010a);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15008b < this.f15007a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            Object obj = this.f15009c.f15010a;
            int i = this.f15008b;
            this.f15008b = i + 1;
            return (T) Array.get(obj, i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
