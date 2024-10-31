package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [R, C, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
class vb<C, R, V> implements Function<C, Map<R, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardTable.e.a f15860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vb(StandardTable.e.a aVar) {
        this.f15860a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((vb<C, R, V>) obj);
    }

    @Override // com.google.common.base.Function
    public Map<R, V> apply(C c2) {
        return StandardTable.this.column(c2);
    }
}
