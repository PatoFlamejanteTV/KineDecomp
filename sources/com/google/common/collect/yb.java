package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
class yb<C, R, V> implements Function<R, Map<C, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardTable.g.a f15871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yb(StandardTable.g.a aVar) {
        this.f15871a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((yb<C, R, V>) obj);
    }

    @Override // com.google.common.base.Function
    public Map<C, V> apply(R r) {
        return StandardTable.this.row(r);
    }
}
