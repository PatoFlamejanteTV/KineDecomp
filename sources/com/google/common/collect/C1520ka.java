package com.google.common.collect;

import java.util.Iterator;

/* compiled from: Iterables.java */
/* renamed from: com.google.common.collect.ka */
/* loaded from: classes2.dex */
public class C1520ka<T> extends FluentIterable<T> {

    /* renamed from: b */
    final /* synthetic */ Iterable f15814b;

    /* renamed from: c */
    final /* synthetic */ int f15815c;

    public C1520ka(Iterable iterable, int i) {
        this.f15814b = iterable;
        this.f15815c = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator<T> it = this.f15814b.iterator();
        Iterators.a((Iterator<?>) it, this.f15815c);
        return new C1517ja(this, it);
    }
}
