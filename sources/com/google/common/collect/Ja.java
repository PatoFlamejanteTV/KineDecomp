package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Ja<K, V> extends AbstractC1513i<K, V> {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f15481a;

    public Ja(Map.Entry entry) {
        this.f15481a = entry;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public K getKey() {
        return (K) this.f15481a.getKey();
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V getValue() {
        return (V) this.f15481a.getValue();
    }
}
