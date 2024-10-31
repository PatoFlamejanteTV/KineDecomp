package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
final class br<K, V> extends f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2826a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(Map.Entry entry) {
        this.f2826a = entry;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return (K) this.f2826a.getKey();
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V getValue() {
        return (V) this.f2826a.getValue();
    }
}
