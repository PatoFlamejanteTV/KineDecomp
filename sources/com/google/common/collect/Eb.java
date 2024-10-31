package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

/* compiled from: TreeBasedTable.java */
/* loaded from: classes2.dex */
class Eb<C> extends AbstractIterator<C> {

    /* renamed from: c */
    C f15367c;

    /* renamed from: d */
    final /* synthetic */ Iterator f15368d;

    /* renamed from: e */
    final /* synthetic */ Comparator f15369e;

    /* renamed from: f */
    final /* synthetic */ TreeBasedTable f15370f;

    public Eb(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
        this.f15370f = treeBasedTable;
        this.f15368d = it;
        this.f15369e = comparator;
    }

    @Override // com.google.common.collect.AbstractIterator
    protected C b() {
        while (this.f15368d.hasNext()) {
            C c2 = (C) this.f15368d.next();
            C c3 = this.f15367c;
            if (!(c3 != null && this.f15369e.compare(c2, c3) == 0)) {
                this.f15367c = c2;
                return this.f15367c;
            }
        }
        this.f15367c = null;
        return c();
    }
}
