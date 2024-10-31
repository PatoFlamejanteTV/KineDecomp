package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K, V2] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
class ck<K, V2> extends f<K, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2844a;
    final /* synthetic */ cj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, Map.Entry entry) {
        this.b = cjVar;
        this.f2844a = entry;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return (K) this.f2844a.getKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V2 getValue() {
        return (V2) this.b.b.a(this.f2844a.getKey(), this.f2844a.getValue());
    }
}
