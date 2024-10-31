package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.StandardTable;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R, V] */
/* compiled from: StandardTable.java */
/* renamed from: com.google.common.collect.ub, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1550ub<R, V> extends AbstractC1513i<R, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f15854a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StandardTable.b.C0091b f15855b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1550ub(StandardTable.b.C0091b c0091b, Map.Entry entry) {
        this.f15855b = c0091b;
        this.f15854a = entry;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public R getKey() {
        return (R) this.f15854a.getKey();
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V getValue() {
        return (V) ((Map) this.f15854a.getValue()).get(StandardTable.b.this.f15679d);
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public V setValue(V v) {
        Map map = (Map) this.f15854a.getValue();
        C c2 = StandardTable.b.this.f15679d;
        Preconditions.a(v);
        return (V) map.put(c2, v);
    }
}
