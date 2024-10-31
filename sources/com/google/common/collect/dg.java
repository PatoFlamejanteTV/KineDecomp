package com.google.common.collect;

import com.google.common.collect.StandardTable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
class dg<C, R, V> extends dk<R, Map.Entry<R, Map<C, V>>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardTable.i.a f2862a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(StandardTable.i.a aVar, Iterator it) {
        super(it);
        this.f2862a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<R, Map<C, V>> a(R r) {
        return new ImmutableEntry(r, StandardTable.this.row(r));
    }
}
