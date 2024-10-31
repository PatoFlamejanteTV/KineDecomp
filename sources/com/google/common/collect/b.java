package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: AbstractBiMap.java */
/* loaded from: classes2.dex */
public class b<K, V> extends ForwardingMapEntry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2810a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Map.Entry entry) {
        this.b = aVar;
        this.f2810a = entry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: a */
    public Map.Entry<K, V> delegate() {
        return this.f2810a;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        Preconditions.b(this.b.c.contains(this), "entry no longer in map");
        if (!Objects.a(v, getValue())) {
            Preconditions.a(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V v2 = (V) this.f2810a.setValue(v);
            Preconditions.b(Objects.a(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.a(getKey(), true, v2, v);
            return v2;
        }
        return v;
    }
}
