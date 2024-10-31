package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.ra */
/* loaded from: classes2.dex */
public class C1540ra<F, T> extends Bb<F, T> {

    /* renamed from: b */
    final /* synthetic */ Function f15834b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1540ra(Iterator it, Function function) {
        super(it);
        this.f15834b = function;
    }

    @Override // com.google.common.collect.Bb
    public T a(F f2) {
        return (T) this.f15834b.apply(f2);
    }
}
