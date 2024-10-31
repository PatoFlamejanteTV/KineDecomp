package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: LinkedListMultimap.java */
/* renamed from: com.google.common.collect.wa */
/* loaded from: classes2.dex */
public class C1554wa<K, V> extends AbstractSequentialList<Map.Entry<K, V>> {

    /* renamed from: a */
    final /* synthetic */ LinkedListMultimap f15862a;

    public C1554wa(LinkedListMultimap linkedListMultimap) {
        this.f15862a = linkedListMultimap;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<Map.Entry<K, V>> listIterator(int i) {
        return new LinkedListMultimap.d(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int i;
        i = this.f15862a.i;
        return i;
    }
}
