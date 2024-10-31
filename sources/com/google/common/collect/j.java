package com.google.common.collect;

import java.util.Iterator;

/* compiled from: FluentIterable.java */
/* loaded from: classes2.dex */
public class J<E> extends FluentIterable<E> {

    /* renamed from: b */
    final /* synthetic */ Iterable f15480b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(Iterable iterable, Iterable iterable2) {
        super(iterable);
        this.f15480b = iterable2;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.f15480b.iterator();
    }
}
