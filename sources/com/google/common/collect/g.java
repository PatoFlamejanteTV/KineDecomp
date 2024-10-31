package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: DescendingMultiset.java */
/* loaded from: classes2.dex */
class G<E> extends Multisets.c<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f15387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(H h2) {
        this.f15387a = h2;
    }

    @Override // com.google.common.collect.Multisets.c
    Multiset<E> a() {
        return this.f15387a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Multiset.Entry<E>> iterator() {
        return this.f15387a.c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15387a.d().entrySet().size();
    }
}
