package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* compiled from: LinkedListMultimap.java */
/* renamed from: com.google.common.collect.za */
/* loaded from: classes2.dex */
public class C1560za<V> extends AbstractSequentialList<V> {

    /* renamed from: a */
    final /* synthetic */ LinkedListMultimap f15872a;

    public C1560za(LinkedListMultimap linkedListMultimap) {
        this.f15872a = linkedListMultimap;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<V> listIterator(int i) {
        LinkedListMultimap.d dVar = new LinkedListMultimap.d(i);
        return new C1558ya(this, dVar, dVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int i;
        i = this.f15872a.i;
        return i;
    }
}
