package com.google.common.collect;

import com.google.common.collect.Table;

/* compiled from: ArrayTable.java */
/* renamed from: com.google.common.collect.u */
/* loaded from: classes2.dex */
public class C1548u<C, R, V> extends AbstractC1492b<Table.Cell<R, C, V>> {

    /* renamed from: c */
    final /* synthetic */ ArrayTable f15849c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1548u(ArrayTable arrayTable, int i) {
        super(i);
        this.f15849c = arrayTable;
    }

    @Override // com.google.common.collect.AbstractC1492b
    public Table.Cell<R, C, V> a(int i) {
        return new C1545t(this, i);
    }
}
