package com.google.common.collect;

import com.google.common.collect.TreeRangeSet;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeRangeSet.java */
/* loaded from: classes2.dex */
class Mb<C> extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

    /* renamed from: c, reason: collision with root package name */
    Cut<C> f15586c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Cut f15587d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ PeekingIterator f15588e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ TreeRangeSet.b f15589f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mb(TreeRangeSet.b bVar, Cut cut, PeekingIterator peekingIterator) {
        this.f15589f = bVar;
        this.f15587d = cut;
        this.f15588e = peekingIterator;
        this.f15586c = this.f15587d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<Cut<C>, Range<C>> b() {
        Range range;
        Range range2;
        if (this.f15586c == Cut.belowAll()) {
            return c();
        }
        if (!this.f15588e.hasNext()) {
            range = this.f15589f.f15733c;
            if (range.lowerBound.isLessThan(Cut.belowAll())) {
                Range create = Range.create(Cut.belowAll(), this.f15586c);
                this.f15586c = Cut.belowAll();
                return Maps.a(Cut.belowAll(), create);
            }
        } else {
            Range range3 = (Range) this.f15588e.next();
            Range create2 = Range.create(range3.upperBound, this.f15586c);
            this.f15586c = range3.lowerBound;
            range2 = this.f15589f.f15733c;
            if (range2.lowerBound.isLessThan(create2.lowerBound)) {
                return Maps.a(create2.lowerBound, create2);
            }
        }
        return c();
    }
}
