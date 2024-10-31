package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArrayTable.java */
/* renamed from: com.google.common.collect.v */
/* loaded from: classes2.dex */
public class C1551v<K, V> extends AbstractC1513i<K, V> {

    /* renamed from: a */
    final /* synthetic */ int f15856a;

    /* renamed from: b */
    final /* synthetic */ C1553w f15857b;

    public C1551v(C1553w c1553w, int i) {
        this.f15857b = c1553w;
        this.f15856a = i;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public K getKey() {
        return (K) this.f15857b.f15861c.a(this.f15856a);
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V getValue() {
        return (V) this.f15857b.f15861c.b(this.f15856a);
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V setValue(V v) {
        return (V) this.f15857b.f15861c.a(this.f15856a, v);
    }
}
