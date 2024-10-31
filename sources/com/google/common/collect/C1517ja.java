package com.google.common.collect;

import java.util.Iterator;

/* compiled from: Iterables.java */
/* renamed from: com.google.common.collect.ja */
/* loaded from: classes2.dex */
class C1517ja<T> implements Iterator<T> {

    /* renamed from: a */
    boolean f15803a = true;

    /* renamed from: b */
    final /* synthetic */ Iterator f15804b;

    /* renamed from: c */
    final /* synthetic */ C1520ka f15805c;

    public C1517ja(C1520ka c1520ka, Iterator it) {
        this.f15805c = c1520ka;
        this.f15804b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15804b.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T t = (T) this.f15804b.next();
        this.f15803a = false;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(!this.f15803a);
        this.f15804b.remove();
    }
}
