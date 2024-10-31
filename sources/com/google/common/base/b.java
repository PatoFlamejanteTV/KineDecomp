package com.google.common.base;

import java.util.Iterator;

/* compiled from: Converter.java */
/* loaded from: classes2.dex */
class b<B> implements Iterator<B> {

    /* renamed from: a */
    private final Iterator<? extends A> f15127a;

    /* renamed from: b */
    final /* synthetic */ c f15128b;

    public b(c cVar) {
        this.f15128b = cVar;
        this.f15127a = this.f15128b.f15129a.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15127a.hasNext();
    }

    @Override // java.util.Iterator
    public B next() {
        return (B) this.f15128b.f15130b.convert(this.f15127a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f15127a.remove();
    }
}
