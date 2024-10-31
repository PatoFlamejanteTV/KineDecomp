package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes2.dex */
public class bn<K, V> extends MapMakerInternalMap.a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    MapMakerInternalMap.i<K, V> f2822a = this;
    MapMakerInternalMap.i<K, V> b = this;
    final /* synthetic */ MapMakerInternalMap.d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(MapMakerInternalMap.d dVar) {
        this.c = dVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getNextEvictable() {
        return this.f2822a;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setNextEvictable(MapMakerInternalMap.i<K, V> iVar) {
        this.f2822a = iVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getPreviousEvictable() {
        return this.b;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setPreviousEvictable(MapMakerInternalMap.i<K, V> iVar) {
        this.b = iVar;
    }
}
