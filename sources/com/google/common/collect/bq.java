package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes2.dex */
class bq<K, V> extends AbstractSequentialIterator<MapMakerInternalMap.i<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapMakerInternalMap.e f2825a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(MapMakerInternalMap.e eVar, MapMakerInternalMap.i iVar) {
        super(iVar);
        this.f2825a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public MapMakerInternalMap.i<K, V> a(MapMakerInternalMap.i<K, V> iVar) {
        MapMakerInternalMap.i<K, V> nextExpirable = iVar.getNextExpirable();
        if (nextExpirable == this.f2825a.f2726a) {
            return null;
        }
        return nextExpirable;
    }
}
