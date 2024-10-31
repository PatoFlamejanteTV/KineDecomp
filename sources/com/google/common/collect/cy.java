package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.StandardTable;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
public class cy<R, V> extends f<R, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2853a;
    final /* synthetic */ StandardTable.c.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(StandardTable.c.b bVar, Map.Entry entry) {
        this.b = bVar;
        this.f2853a = entry;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public R getKey() {
        return (R) this.f2853a.getKey();
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V getValue() {
        return (V) ((Map) this.f2853a.getValue()).get(StandardTable.c.this.f2766a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V setValue(V v) {
        return (V) ((Map) this.f2853a.getValue()).put(StandardTable.c.this.f2766a, Preconditions.a(v));
    }
}
