package com.google.common.collect;

import com.google.common.collect.Lists;
import java.util.ListIterator;

/* compiled from: Lists.java */
/* loaded from: classes2.dex */
class Aa<F, T> extends Cb<F, T> {

    /* renamed from: b */
    final /* synthetic */ Lists.TransformingRandomAccessList f15271b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Aa(Lists.TransformingRandomAccessList transformingRandomAccessList, ListIterator listIterator) {
        super(listIterator);
        this.f15271b = transformingRandomAccessList;
    }

    @Override // com.google.common.collect.Bb
    public T a(F f2) {
        return this.f15271b.function.apply(f2);
    }
}
