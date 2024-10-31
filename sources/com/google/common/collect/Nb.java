package com.google.common.collect;

import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeRangeSet.java */
/* loaded from: classes2.dex */
public class Nb<C> extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Iterator f15623c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TreeRangeSet.c f15624d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nb(TreeRangeSet.c cVar, Iterator it) {
        this.f15624d = cVar;
        this.f15623c = it;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<Cut<C>, Range<C>> b() {
        Range range;
        if (!this.f15623c.hasNext()) {
            return c();
        }
        Range range2 = (Range) this.f15623c.next();
        range = this.f15624d.f15735b;
        if (range.upperBound.isLessThan(range2.upperBound)) {
            return c();
        }
        return Maps.a(range2.upperBound, range2);
    }
}
