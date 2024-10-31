package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapConstraints.java */
/* loaded from: classes2.dex */
public class Ca<K, V> extends ForwardingMapEntry<K, V> {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f15347a;

    /* renamed from: b */
    final /* synthetic */ MapConstraint f15348b;

    public Ca(Map.Entry entry, MapConstraint mapConstraint) {
        this.f15347a = entry;
        this.f15348b = mapConstraint;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        this.f15348b.a(getKey(), v);
        return (V) this.f15347a.setValue(v);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    public Map.Entry<K, V> delegate() {
        return this.f15347a;
    }
}
