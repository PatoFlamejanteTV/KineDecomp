package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ImmutableMultiset.java */
/* loaded from: classes2.dex */
class ag<E> extends UnmodifiableIterator<E> {

    /* renamed from: a, reason: collision with root package name */
    int f2792a;
    E b;
    final /* synthetic */ Iterator c;
    final /* synthetic */ ImmutableMultiset d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ImmutableMultiset immutableMultiset, Iterator it) {
        this.d = immutableMultiset;
        this.c = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2792a > 0 || this.c.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.f2792a <= 0) {
            Multiset.Entry entry = (Multiset.Entry) this.c.next();
            this.b = (E) entry.getElement();
            this.f2792a = entry.getCount();
        }
        this.f2792a--;
        return this.b;
    }
}
