package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class av<V> extends AbstractSequentialList<V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2805a;
    final /* synthetic */ LinkedListMultimap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(LinkedListMultimap linkedListMultimap, Object obj) {
        this.b = linkedListMultimap;
        this.f2805a = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.b.c.count(this.f2805a);
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<V> listIterator(int i) {
        return new LinkedListMultimap.e(this.f2805a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        return Iterators.a((Iterator<?>) iterator(), collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        return Iterators.b((Iterator<?>) iterator(), collection);
    }
}
