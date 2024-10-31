package com.google.api.client.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Types.java */
/* loaded from: classes.dex */
class k<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    final int f2559a;
    int b = 0;
    final /* synthetic */ j c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.c = jVar;
        this.f2559a = Array.getLength(this.c.f2558a);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f2559a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.c.f2558a;
        int i = this.b;
        this.b = i + 1;
        return (T) Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
