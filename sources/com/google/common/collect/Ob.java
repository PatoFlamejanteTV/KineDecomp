package com.google.common.collect;

import com.google.common.collect.TreeRangeSet;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeRangeSet.java */
/* loaded from: classes2.dex */
class Ob<C> extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ PeekingIterator f15627c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TreeRangeSet.c f15628d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ob(TreeRangeSet.c cVar, PeekingIterator peekingIterator) {
        this.f15628d = cVar;
        this.f15627c = peekingIterator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<Cut<C>, Range<C>> b() {
        Range range;
        if (!this.f15627c.hasNext()) {
            return c();
        }
        Range range2 = (Range) this.f15627c.next();
        range = this.f15628d.f15735b;
        return range.lowerBound.isLessThan(range2.upperBound) ? Maps.a(range2.upperBound, range2) : c();
    }
}
