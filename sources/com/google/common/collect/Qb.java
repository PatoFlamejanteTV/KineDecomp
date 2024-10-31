package com.google.common.collect;

import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeRangeSet.java */
/* loaded from: classes2.dex */
class Qb<C> extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Iterator f15639c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TreeRangeSet.d f15640d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qb(TreeRangeSet.d dVar, Iterator it) {
        this.f15640d = dVar;
        this.f15639c = it;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<Cut<C>, Range<C>> b() {
        Range range;
        Range range2;
        Range range3;
        if (!this.f15639c.hasNext()) {
            return c();
        }
        Range range4 = (Range) this.f15639c.next();
        range = this.f15640d.f15737b;
        if (range.lowerBound.compareTo((Cut) range4.upperBound) < 0) {
            range2 = this.f15640d.f15737b;
            Range intersection = range4.intersection(range2);
            range3 = this.f15640d.f15736a;
            if (range3.contains(intersection.lowerBound)) {
                return Maps.a(intersection.lowerBound, intersection);
            }
            return c();
        }
        return c();
    }
}
