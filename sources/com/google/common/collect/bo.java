package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes2.dex */
class bo<K, V> extends AbstractSequentialIterator<MapMakerInternalMap.i<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapMakerInternalMap.d f2823a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(MapMakerInternalMap.d dVar, MapMakerInternalMap.i iVar) {
        super(iVar);
        this.f2823a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public MapMakerInternalMap.i<K, V> a(MapMakerInternalMap.i<K, V> iVar) {
        MapMakerInternalMap.i<K, V> nextEvictable = iVar.getNextEvictable();
        if (nextEvictable == this.f2823a.f2725a) {
            return null;
        }
        return nextEvictable;
    }
}
