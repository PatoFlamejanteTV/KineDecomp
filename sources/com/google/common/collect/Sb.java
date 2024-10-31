package com.google.common.collect;

/* compiled from: WellBehavedMap.java */
/* loaded from: classes2.dex */
public class Sb<K, V> extends AbstractC1513i<K, V> {

    /* renamed from: a */
    final /* synthetic */ Object f15666a;

    /* renamed from: b */
    final /* synthetic */ Tb f15667b;

    public Sb(Tb tb, Object obj) {
        this.f15667b = tb;
        this.f15666a = obj;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public K getKey() {
        return (K) this.f15666a;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V getValue() {
        return Ub.this.get(this.f15666a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V setValue(V v) {
        return (V) Ub.this.put(this.f15666a, v);
    }
}
