package com.google.common.collect;

import com.google.common.collect.StandardTable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
class dc<C, R, V> extends dk<C, Map.Entry<C, Map<R, V>>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardTable.f.a f2858a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(StandardTable.f.a aVar, Iterator it) {
        super(it);
        this.f2858a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<C, Map<R, V>> a(C c) {
        return new ImmutableEntry(c, StandardTable.this.column(c));
    }
}
