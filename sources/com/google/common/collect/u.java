package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: ArrayTable.java */
/* loaded from: classes2.dex */
class u<C, R, V> extends dk<Table.Cell<R, C, V>, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayTable.g f2891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(ArrayTable.g gVar, Iterator it) {
        super(it);
        this.f2891a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public V a(Table.Cell<R, C, V> cell) {
        return cell.getValue();
    }
}
