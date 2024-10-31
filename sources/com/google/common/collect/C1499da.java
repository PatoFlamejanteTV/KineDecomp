package com.google.common.collect;

import com.google.common.collect.ImmutableRangeSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: ImmutableRangeSet.java */
/* renamed from: com.google.common.collect.da, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1499da<C> extends AbstractIterator<C> {

    /* renamed from: c, reason: collision with root package name */
    final Iterator<Range<C>> f15775c;

    /* renamed from: d, reason: collision with root package name */
    Iterator<C> f15776d = Iterators.a();

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ImmutableRangeSet.AsSet f15777e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1499da(ImmutableRangeSet.AsSet asSet) {
        this.f15777e = asSet;
        this.f15775c = ImmutableRangeSet.this.f15458c.iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: ()TC; */
    @Override // com.google.common.collect.AbstractIterator
    public Comparable b() {
        DiscreteDomain discreteDomain;
        while (!this.f15776d.hasNext()) {
            if (this.f15775c.hasNext()) {
                Range<C> next = this.f15775c.next();
                discreteDomain = this.f15777e.domain;
                this.f15776d = ContiguousSet.create(next, discreteDomain).iterator();
            } else {
                return (Comparable) c();
            }
        }
        return (Comparable) this.f15776d.next();
    }
}
