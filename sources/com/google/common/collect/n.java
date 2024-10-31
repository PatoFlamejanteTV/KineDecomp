package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: HashBiMap.java */
/* loaded from: classes2.dex */
class N<K, V> extends Maps.c<V, K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HashBiMap.Inverse f15619a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(HashBiMap.Inverse inverse) {
        this.f15619a = inverse;
    }

    @Override // com.google.common.collect.Maps.c
    Map<V, K> a() {
        return this.f15619a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<V, K>> iterator() {
        return new M(this);
    }
}
