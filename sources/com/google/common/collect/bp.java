package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes2.dex */
public class bp<K, V> extends MapMakerInternalMap.a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    MapMakerInternalMap.i<K, V> f2824a = this;
    MapMakerInternalMap.i<K, V> b = this;
    final /* synthetic */ MapMakerInternalMap.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(MapMakerInternalMap.e eVar) {
        this.c = eVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public long getExpirationTime() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setExpirationTime(long j) {
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getNextExpirable() {
        return this.f2824a;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setNextExpirable(MapMakerInternalMap.i<K, V> iVar) {
        this.f2824a = iVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getPreviousExpirable() {
        return this.b;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setPreviousExpirable(MapMakerInternalMap.i<K, V> iVar) {
        this.b = iVar;
    }
}
