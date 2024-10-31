package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimaps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class bc<K, V> extends Multimaps.a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap f2813a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(LinkedListMultimap linkedListMultimap) {
        this.f2813a = linkedListMultimap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2813a.c.elementSet().size();
    }

    @Override // com.google.common.collect.Multimaps.a
    Multimap<K, V> a() {
        return this.f2813a;
    }

    @Override // com.google.common.collect.Multimaps.a
    Iterator<Map.Entry<K, Collection<V>>> c() {
        return new bd(this, new LinkedListMultimap.a(this.f2813a, null));
    }
}
