package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: WellBehavedMap.java */
/* loaded from: classes2.dex */
public class dt<K, V> extends f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2873a;
    final /* synthetic */ ds b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Object obj) {
        this.b = dsVar;
        this.f2873a = obj;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return (K) this.f2873a;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V getValue() {
        return dr.this.get(this.f2873a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V setValue(V v) {
        return (V) dr.this.put(this.f2873a, v);
    }
}
