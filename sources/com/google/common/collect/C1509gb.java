package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX WARN: Incorrect field signature: TC; */
/* compiled from: RegularContiguousSet.java */
/* renamed from: com.google.common.collect.gb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1509gb<C> extends AbstractSequentialIterator<C> {

    /* renamed from: b, reason: collision with root package name */
    final Comparable f15792b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RegularContiguousSet f15793c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1509gb(RegularContiguousSet regularContiguousSet, Comparable comparable) {
        super(comparable);
        this.f15793c = regularContiguousSet;
        this.f15792b = this.f15793c.last();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: (TC;)TC; */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public Comparable a(Comparable comparable) {
        boolean a2;
        a2 = RegularContiguousSet.a((Comparable<?>) comparable, (Comparable<?>) this.f15792b);
        if (a2) {
            return null;
        }
        return this.f15793c.domain.next(comparable);
    }
}
