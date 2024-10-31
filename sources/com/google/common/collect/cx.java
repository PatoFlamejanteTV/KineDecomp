package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.cv;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: SortedMultisets.java */
/* loaded from: classes2.dex */
class cx<E> extends Multisets.c<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cv.a f2852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cv.a aVar) {
        this.f2852a = aVar;
    }

    @Override // com.google.common.collect.Multisets.c
    Multiset<E> a() {
        return this.f2852a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Multiset.Entry<E>> iterator() {
        return this.f2852a.b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f2852a.a().entrySet().size();
    }
}
