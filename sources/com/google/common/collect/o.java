package com.google.common.collect;

import com.google.common.collect.HashBiMap;

/* compiled from: HashBiMap.java */
/* loaded from: classes2.dex */
class O<V> extends HashBiMap<K, V>.a<V> {

    /* renamed from: e */
    final /* synthetic */ HashBiMap.Inverse.a f15625e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(HashBiMap.Inverse.a aVar) {
        super();
        this.f15625e = aVar;
    }

    @Override // com.google.common.collect.HashBiMap.a
    V a(HashBiMap.BiEntry<K, V> biEntry) {
        return biEntry.value;
    }
}
