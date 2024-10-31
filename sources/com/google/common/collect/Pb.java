package com.google.common.collect;

import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeRangeSet.java */
/* loaded from: classes2.dex */
public class Pb<C> extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Iterator f15635c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Cut f15636d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TreeRangeSet.d f15637e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pb(TreeRangeSet.d dVar, Iterator it, Cut cut) {
        this.f15637e = dVar;
        this.f15635c = it;
        this.f15636d = cut;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<Cut<C>, Range<C>> b() {
        Range range;
        if (!this.f15635c.hasNext()) {
            return c();
        }
        Range range2 = (Range) this.f15635c.next();
        if (!this.f15636d.isLessThan(range2.lowerBound)) {
            range = this.f15637e.f15737b;
            Range intersection = range2.intersection(range);
            return Maps.a(intersection.lowerBound, intersection);
        }
        return c();
    }
}
