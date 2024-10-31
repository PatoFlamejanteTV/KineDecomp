package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX WARN: Incorrect field signature: TC; */
/* compiled from: RegularContiguousSet.java */
/* loaded from: classes2.dex */
public class cq<C> extends AbstractSequentialIterator<C> {

    /* renamed from: a, reason: collision with root package name */
    final Comparable f2847a;
    final /* synthetic */ RegularContiguousSet b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(RegularContiguousSet regularContiguousSet, Comparable comparable) {
        super(comparable);
        this.b = regularContiguousSet;
        this.f2847a = this.b.last();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: (TC;)TC; */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public Comparable a(Comparable comparable) {
        boolean a2;
        a2 = RegularContiguousSet.a((Comparable<?>) comparable, (Comparable<?>) this.f2847a);
        if (a2) {
            return null;
        }
        return this.b.domain.a(comparable);
    }
}
