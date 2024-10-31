package com.google.common.collect;

import com.google.common.collect.Lists;
import java.util.ListIterator;

/* compiled from: Lists.java */
/* loaded from: classes2.dex */
class Ba<F, T> extends Cb<F, T> {

    /* renamed from: b */
    final /* synthetic */ Lists.TransformingSequentialList f15342b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ba(Lists.TransformingSequentialList transformingSequentialList, ListIterator listIterator) {
        super(listIterator);
        this.f15342b = transformingSequentialList;
    }

    @Override // com.google.common.collect.Bb
    public T a(F f2) {
        return this.f15342b.function.apply(f2);
    }
}
