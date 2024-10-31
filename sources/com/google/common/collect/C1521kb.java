package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

/* compiled from: RegularImmutableTable.java */
/* renamed from: com.google.common.collect.kb */
/* loaded from: classes2.dex */
class C1521kb<C, R, V> implements Comparator<Table.Cell<R, C, V>> {

    /* renamed from: a */
    final /* synthetic */ Comparator f15816a;

    /* renamed from: b */
    final /* synthetic */ Comparator f15817b;

    public C1521kb(Comparator comparator, Comparator comparator2) {
        this.f15816a = comparator;
        this.f15817b = comparator2;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Table.Cell<R, C, V> cell, Table.Cell<R, C, V> cell2) {
        Comparator comparator = this.f15816a;
        int compare = comparator == null ? 0 : comparator.compare(cell.getRowKey(), cell2.getRowKey());
        if (compare != 0) {
            return compare;
        }
        Comparator comparator2 = this.f15817b;
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
    }
}
