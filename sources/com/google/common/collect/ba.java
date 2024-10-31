package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class ba<K, V> extends AbstractSequentialList<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap f2811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(LinkedListMultimap linkedListMultimap) {
        this.f2811a = linkedListMultimap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2811a.c.size();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<Map.Entry<K, V>> listIterator(int i) {
        return new bb(this, new LinkedListMultimap.d(i));
    }
}
