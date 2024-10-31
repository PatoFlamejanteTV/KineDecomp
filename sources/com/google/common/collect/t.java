package com.google.common.collect;

import com.google.common.collect.Tables;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: ArrayTable.java */
/* loaded from: classes2.dex */
public class t<C, R, V> extends Tables.a<R, C, V> {

    /* renamed from: a, reason: collision with root package name */
    final int f2890a;
    final int b;
    final /* synthetic */ int c;
    final /* synthetic */ s d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, int i) {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        this.d = sVar;
        this.c = i;
        int i2 = this.c;
        immutableList = ArrayTable.this.columnList;
        this.f2890a = i2 / immutableList.size();
        int i3 = this.c;
        immutableList2 = ArrayTable.this.columnList;
        this.b = i3 % immutableList2.size();
    }

    @Override // com.google.common.collect.Table.Cell
    public R getRowKey() {
        ImmutableList immutableList;
        immutableList = ArrayTable.this.rowList;
        return (R) immutableList.get(this.f2890a);
    }

    @Override // com.google.common.collect.Table.Cell
    public C getColumnKey() {
        ImmutableList immutableList;
        immutableList = ArrayTable.this.columnList;
        return (C) immutableList.get(this.b);
    }

    @Override // com.google.common.collect.Table.Cell
    public V getValue() {
        return (V) ArrayTable.this.array[this.f2890a][this.b];
    }
}
