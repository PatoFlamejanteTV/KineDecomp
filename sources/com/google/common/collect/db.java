package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TreeBasedTable.java */
/* loaded from: classes2.dex */
class Db<C, V> implements Function<Map<C, V>, Iterator<C>> {

    /* renamed from: a */
    final /* synthetic */ TreeBasedTable f15365a;

    public Db(TreeBasedTable treeBasedTable) {
        this.f15365a = treeBasedTable;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a */
    public Iterator<C> apply(Map<C, V> map) {
        return map.keySet().iterator();
    }
}
