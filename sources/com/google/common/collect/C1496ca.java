package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* compiled from: ImmutableMultiset.java */
/* renamed from: com.google.common.collect.ca */
/* loaded from: classes2.dex */
public class C1496ca<E> extends UnmodifiableIterator<E> {

    /* renamed from: a */
    int f15770a;

    /* renamed from: b */
    E f15771b;

    /* renamed from: c */
    final /* synthetic */ Iterator f15772c;

    /* renamed from: d */
    final /* synthetic */ ImmutableMultiset f15773d;

    public C1496ca(ImmutableMultiset immutableMultiset, Iterator it) {
        this.f15773d = immutableMultiset;
        this.f15772c = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15770a > 0 || this.f15772c.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.f15770a <= 0) {
            Multiset.Entry entry = (Multiset.Entry) this.f15772c.next();
            this.f15771b = (E) entry.getElement();
            this.f15770a = entry.getCount();
        }
        this.f15770a--;
        return this.f15771b;
    }
}
