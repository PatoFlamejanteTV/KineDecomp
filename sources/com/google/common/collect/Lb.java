package com.google.common.collect;

import com.google.common.collect.TreeRangeSet;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: TreeRangeSet.java */
/* loaded from: classes2.dex */
public class Lb<C> extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

    /* renamed from: c, reason: collision with root package name */
    Cut<C> f15490c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Cut f15491d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ PeekingIterator f15492e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ TreeRangeSet.b f15493f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lb(TreeRangeSet.b bVar, Cut cut, PeekingIterator peekingIterator) {
        this.f15493f = bVar;
        this.f15491d = cut;
        this.f15492e = peekingIterator;
        this.f15490c = this.f15491d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<Cut<C>, Range<C>> b() {
        Range range;
        Range create;
        range = this.f15493f.f15733c;
        if (!range.upperBound.isLessThan(this.f15490c) && this.f15490c != Cut.aboveAll()) {
            if (this.f15492e.hasNext()) {
                Range range2 = (Range) this.f15492e.next();
                create = Range.create(this.f15490c, range2.lowerBound);
                this.f15490c = range2.upperBound;
            } else {
                create = Range.create(this.f15490c, Cut.aboveAll());
                this.f15490c = Cut.aboveAll();
            }
            return Maps.a(create.lowerBound, create);
        }
        return c();
    }
}
