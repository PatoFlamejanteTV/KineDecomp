package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeBasedTable.java */
/* loaded from: classes2.dex */
class dn<C> extends AbstractIterator<C> {

    /* renamed from: a, reason: collision with root package name */
    C f2866a;
    final /* synthetic */ Iterator b;
    final /* synthetic */ Comparator c;
    final /* synthetic */ TreeBasedTable d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
        this.d = treeBasedTable;
        this.b = it;
        this.c = comparator;
    }

    @Override // com.google.common.collect.AbstractIterator
    protected C a() {
        while (this.b.hasNext()) {
            C c = (C) this.b.next();
            if (!(this.f2866a != null && this.c.compare(c, this.f2866a) == 0)) {
                this.f2866a = c;
                return this.f2866a;
            }
        }
        this.f2866a = null;
        return b();
    }
}
