package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: AbstractSortedMultiset.java */
/* renamed from: com.google.common.collect.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1534p<E> extends H<E> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AbstractC1537q f15828d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1534p(AbstractC1537q abstractC1537q) {
        this.f15828d = abstractC1537q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.H
    public Iterator<Multiset.Entry<E>> c() {
        return this.f15828d.descendingEntryIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.H
    public SortedMultiset<E> d() {
        return this.f15828d;
    }

    @Override // com.google.common.collect.H, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f15828d.descendingIterator();
    }
}
