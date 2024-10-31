package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class ax<V> extends AbstractSequentialList<V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap f2807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(LinkedListMultimap linkedListMultimap) {
        this.f2807a = linkedListMultimap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2807a.c.size();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<V> listIterator(int i) {
        LinkedListMultimap.d dVar = new LinkedListMultimap.d(i);
        return new ay(this, dVar, dVar);
    }
}
