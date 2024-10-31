package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ArrayTable.java */
/* loaded from: classes2.dex */
public class r<K, V> extends f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2888a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, int i) {
        this.b = qVar;
        this.f2888a = i;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return (K) this.b.f2887a.f2886a.a(this.f2888a);
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V getValue() {
        return (V) this.b.f2887a.f2886a.b(this.f2888a);
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V setValue(V v) {
        return (V) this.b.f2887a.f2886a.a(this.f2888a, v);
    }
}
