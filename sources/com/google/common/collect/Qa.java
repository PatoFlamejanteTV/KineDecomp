package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Qa<K, V> extends Maps.c<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.d f15638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(Maps.d dVar) {
        this.f15638a = dVar;
    }

    @Override // com.google.common.collect.Maps.c
    Map<K, V> a() {
        return this.f15638a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f15638a.entryIterator();
    }
}
