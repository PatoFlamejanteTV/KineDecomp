package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [C, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
class df<C, V> extends ForwardingMapEntry<C, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2861a;
    final /* synthetic */ de b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, Map.Entry entry) {
        this.b = deVar;
        this.f2861a = entry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: a */
    public Map.Entry<C, V> delegate() {
        return this.f2861a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        return (V) super.setValue(Preconditions.a(v));
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public boolean equals(Object obj) {
        return a(obj);
    }
}
