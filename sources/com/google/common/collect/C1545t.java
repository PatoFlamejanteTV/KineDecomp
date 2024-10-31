package com.google.common.collect;

import com.google.common.collect.Tables;

/* compiled from: ArrayTable.java */
/* renamed from: com.google.common.collect.t */
/* loaded from: classes2.dex */
public class C1545t<C, R, V> extends Tables.a<R, C, V> {

    /* renamed from: a */
    final int f15842a;

    /* renamed from: b */
    final int f15843b;

    /* renamed from: c */
    final /* synthetic */ int f15844c;

    /* renamed from: d */
    final /* synthetic */ C1548u f15845d;

    public C1545t(C1548u c1548u, int i) {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        this.f15845d = c1548u;
        this.f15844c = i;
        int i2 = this.f15844c;
        immutableList = this.f15845d.f15849c.columnList;
        this.f15842a = i2 / immutableList.size();
        int i3 = this.f15844c;
        immutableList2 = this.f15845d.f15849c.columnList;
        this.f15843b = i3 % immutableList2.size();
    }

    @Override // com.google.common.collect.Table.Cell
    public C getColumnKey() {
        ImmutableList immutableList;
        immutableList = this.f15845d.f15849c.columnList;
        return (C) immutableList.get(this.f15843b);
    }

    @Override // com.google.common.collect.Table.Cell
    public R getRowKey() {
        ImmutableList immutableList;
        immutableList = this.f15845d.f15849c.rowList;
        return (R) immutableList.get(this.f15842a);
    }

    @Override // com.google.common.collect.Table.Cell
    public V getValue() {
        return (V) this.f15845d.f15849c.at(this.f15842a, this.f15843b);
    }
}
