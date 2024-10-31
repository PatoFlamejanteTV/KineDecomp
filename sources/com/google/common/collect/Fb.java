package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.TreeMultiset;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TreeMultiset.java */
/* loaded from: classes2.dex */
public class Fb<E> extends Multisets.a<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TreeMultiset.a f15380a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TreeMultiset f15381b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fb(TreeMultiset treeMultiset, TreeMultiset.a aVar) {
        this.f15381b = treeMultiset;
        this.f15380a = aVar;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        int count = this.f15380a.getCount();
        return count == 0 ? this.f15381b.count(getElement()) : count;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public E getElement() {
        return (E) this.f15380a.getElement();
    }
}
