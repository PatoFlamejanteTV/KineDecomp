package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.cv;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: AbstractSortedMultiset.java */
/* loaded from: classes2.dex */
public class o<E> extends cv.a<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f2885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.f2885a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.cv.a
    public SortedMultiset<E> a() {
        return this.f2885a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.cv.a
    public Iterator<Multiset.Entry<E>> b() {
        return this.f2885a.descendingEntryIterator();
    }

    @Override // com.google.common.collect.cv.a, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f2885a.descendingIterator();
    }
}
