package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Sets;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: LinkedListMultimap.java */
/* renamed from: com.google.common.collect.xa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1556xa<K> extends Sets.b<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap f15865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1556xa(LinkedListMultimap linkedListMultimap) {
        this.f15865a = linkedListMultimap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f15865a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new LinkedListMultimap.a(this.f15865a, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return !this.f15865a.removeAll(obj).isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15865a.f15504h.size();
    }
}
