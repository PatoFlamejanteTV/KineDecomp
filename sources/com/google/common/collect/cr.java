package com.google.common.collect;

import com.google.common.collect.RegularContiguousSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX WARN: Incorrect field signature: TC; */
/* compiled from: RegularContiguousSet.java */
/* loaded from: classes2.dex */
public class cr<C> extends AbstractSequentialIterator<C> {

    /* renamed from: a, reason: collision with root package name */
    final Comparable f2848a;
    final /* synthetic */ RegularContiguousSet.DescendingContiguousSet b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(RegularContiguousSet.DescendingContiguousSet descendingContiguousSet, Comparable comparable) {
        super(comparable);
        this.b = descendingContiguousSet;
        this.f2848a = this.b.last();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: (TC;)TC; */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public Comparable a(Comparable comparable) {
        boolean a2;
        a2 = RegularContiguousSet.a((Comparable<?>) comparable, (Comparable<?>) this.f2848a);
        if (a2) {
            return null;
        }
        return RegularContiguousSet.this.domain.b(comparable);
    }
}
