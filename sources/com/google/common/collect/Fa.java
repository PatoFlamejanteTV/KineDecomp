package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Fa<K, V2> extends AbstractC1513i<K, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f15378a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Maps.EntryTransformer f15379b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa(Map.Entry entry, Maps.EntryTransformer entryTransformer) {
        this.f15378a = entry;
        this.f15379b = entryTransformer;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public K getKey() {
        return (K) this.f15378a.getKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V2 getValue() {
        return (V2) this.f15379b.a(this.f15378a.getKey(), this.f15378a.getValue());
    }
}
