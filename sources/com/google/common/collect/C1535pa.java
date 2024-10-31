package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.pa */
/* loaded from: classes2.dex */
public class C1535pa<T> extends UnmodifiableIterator<T> {

    /* renamed from: a */
    final /* synthetic */ Iterator f15829a;

    public C1535pa(Iterator it) {
        this.f15829a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15829a.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        return (T) this.f15829a.next();
    }
}
