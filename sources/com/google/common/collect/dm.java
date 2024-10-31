package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [C, V] */
/* compiled from: TreeBasedTable.java */
/* loaded from: classes2.dex */
class dm<C, V> implements Function<Map<C, V>, Iterator<C>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TreeBasedTable f2865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(TreeBasedTable treeBasedTable) {
        this.f2865a = treeBasedTable;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Iterator<C> apply(Map<C, V> map) {
        return map.keySet().iterator();
    }
}
