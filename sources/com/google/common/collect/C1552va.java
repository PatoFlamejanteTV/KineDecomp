package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* compiled from: LinkedListMultimap.java */
/* renamed from: com.google.common.collect.va */
/* loaded from: classes2.dex */
public class C1552va<V> extends AbstractSequentialList<V> {

    /* renamed from: a */
    final /* synthetic */ Object f15858a;

    /* renamed from: b */
    final /* synthetic */ LinkedListMultimap f15859b;

    public C1552va(LinkedListMultimap linkedListMultimap, Object obj) {
        this.f15859b = linkedListMultimap;
        this.f15858a = obj;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<V> listIterator(int i) {
        return new LinkedListMultimap.e(this.f15858a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        LinkedListMultimap.b bVar = (LinkedListMultimap.b) this.f15859b.f15504h.get(this.f15858a);
        if (bVar == null) {
            return 0;
        }
        return bVar.f15512c;
    }
}
