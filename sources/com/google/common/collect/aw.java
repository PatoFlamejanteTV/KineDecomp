package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Sets;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class aw<K> extends Sets.a<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap f2806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(LinkedListMultimap linkedListMultimap) {
        this.f2806a = linkedListMultimap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f2806a.c.elementSet().size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new LinkedListMultimap.a(this.f2806a, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f2806a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return !this.f2806a.removeAll(obj).isEmpty();
    }
}
