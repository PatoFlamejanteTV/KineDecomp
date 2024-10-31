package com.google.common.collect;

import com.google.common.collect.ImmutableRangeSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: ImmutableRangeSet.java */
/* renamed from: com.google.common.collect.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1502ea<C> extends AbstractIterator<C> {

    /* renamed from: c, reason: collision with root package name */
    final Iterator<Range<C>> f15779c;

    /* renamed from: d, reason: collision with root package name */
    Iterator<C> f15780d = Iterators.a();

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ImmutableRangeSet.AsSet f15781e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1502ea(ImmutableRangeSet.AsSet asSet) {
        this.f15781e = asSet;
        this.f15779c = ImmutableRangeSet.this.f15458c.reverse().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: ()TC; */
    @Override // com.google.common.collect.AbstractIterator
    public Comparable b() {
        DiscreteDomain discreteDomain;
        while (!this.f15780d.hasNext()) {
            if (this.f15779c.hasNext()) {
                Range<C> next = this.f15779c.next();
                discreteDomain = this.f15781e.domain;
                this.f15780d = ContiguousSet.create(next, discreteDomain).descendingIterator();
            } else {
                return (Comparable) c();
            }
        }
        return (Comparable) this.f15780d.next();
    }
}
