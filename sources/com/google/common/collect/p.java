package com.google.common.collect;

import com.google.common.collect.HashBiMap;

/* compiled from: HashBiMap.java */
/* loaded from: classes2.dex */
class P<K> extends HashBiMap<K, V>.a<K> {

    /* renamed from: e */
    final /* synthetic */ HashBiMap.b f15633e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(HashBiMap.b bVar) {
        super();
        this.f15633e = bVar;
    }

    @Override // com.google.common.collect.HashBiMap.a
    K a(HashBiMap.BiEntry<K, V> biEntry) {
        return biEntry.key;
    }
}
