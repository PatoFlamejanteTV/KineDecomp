package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapConstraints.java */
/* loaded from: classes2.dex */
final class bj<K, V> extends ForwardingMapEntry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2820a;
    final /* synthetic */ MapConstraint b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(Map.Entry entry, MapConstraint mapConstraint) {
        this.f2820a = entry;
        this.b = mapConstraint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: a */
    public Map.Entry<K, V> delegate() {
        return this.f2820a;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        this.b.a(getKey(), v);
        return (V) this.f2820a.setValue(v);
    }
}
