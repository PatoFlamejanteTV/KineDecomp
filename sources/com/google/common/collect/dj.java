package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TransformedImmutableSet.java */
/* loaded from: classes2.dex */
class dj<E> extends UnmodifiableIterator<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f2864a;
    final /* synthetic */ TransformedImmutableSet b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(TransformedImmutableSet transformedImmutableSet, Iterator it) {
        this.b = transformedImmutableSet;
        this.f2864a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2864a.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return (E) this.b.transform(this.f2864a.next());
    }
}
