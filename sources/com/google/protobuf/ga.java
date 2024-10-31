package com.google.protobuf;

import java.util.Iterator;

/* compiled from: UnmodifiableLazyStringList.java */
/* loaded from: classes2.dex */
class ga implements Iterator<String> {

    /* renamed from: a */
    Iterator<String> f18779a;

    /* renamed from: b */
    final /* synthetic */ UnmodifiableLazyStringList f18780b;

    public ga(UnmodifiableLazyStringList unmodifiableLazyStringList) {
        LazyStringList lazyStringList;
        this.f18780b = unmodifiableLazyStringList;
        lazyStringList = this.f18780b.f18729a;
        this.f18779a = lazyStringList.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f18779a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public String next() {
        return this.f18779a.next();
    }
}
