package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: ArrayTable.java */
/* loaded from: classes2.dex */
class s<C, R, V> extends c<Table.Cell<R, C, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayTable.b f2889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(ArrayTable.b bVar, int i) {
        super(i);
        this.f2889a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Table.Cell<R, C, V> a(int i) {
        return new t(this, i);
    }
}
