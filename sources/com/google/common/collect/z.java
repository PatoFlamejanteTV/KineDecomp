package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: ImmutableMapValues.java */
/* loaded from: classes2.dex */
public class Z<V> extends UnmodifiableIterator<V> {

    /* renamed from: a, reason: collision with root package name */
    final UnmodifiableIterator<Map.Entry<K, V>> f15758a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableMapValues f15759b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(ImmutableMapValues immutableMapValues) {
        ImmutableMap immutableMap;
        this.f15759b = immutableMapValues;
        immutableMap = this.f15759b.map;
        this.f15758a = immutableMap.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15758a.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((Map.Entry) this.f15758a.next()).getValue();
    }
}
