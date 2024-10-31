package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class ca<K, V2> extends f<K, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2834a;
    final /* synthetic */ bz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, Map.Entry entry) {
        this.b = bzVar;
        this.f2834a = entry;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return (K) this.f2834a.getKey();
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V2 getValue() {
        return this.b.f2832a.f2831a.b.a(this.f2834a.getKey(), this.f2834a.getValue());
    }
}
