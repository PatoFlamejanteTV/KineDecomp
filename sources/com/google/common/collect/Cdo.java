package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.TreeMultiset;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TreeMultiset.java */
/* renamed from: com.google.common.collect.do, reason: invalid class name */
/* loaded from: classes2.dex */
class Cdo<E> extends Multisets.a<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TreeMultiset.a f2867a;
    final /* synthetic */ TreeMultiset b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(TreeMultiset treeMultiset, TreeMultiset.a aVar) {
        this.b = treeMultiset;
        this.f2867a = aVar;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public E getElement() {
        return (E) this.f2867a.getElement();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        int count = this.f2867a.getCount();
        if (count == 0) {
            return this.b.count(getElement());
        }
        return count;
    }
}
