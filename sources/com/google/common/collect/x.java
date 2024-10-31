package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMap.java */
/* loaded from: classes2.dex */
public class X<K, V> extends AbstractC1513i<K, ImmutableSet<V>> {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f15751a;

    /* renamed from: b */
    final /* synthetic */ Y f15752b;

    public X(Y y, Map.Entry entry) {
        this.f15752b = y;
        this.f15751a = entry;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public K getKey() {
        return (K) this.f15751a.getKey();
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public ImmutableSet<V> getValue() {
        return ImmutableSet.of(this.f15751a.getValue());
    }
}
