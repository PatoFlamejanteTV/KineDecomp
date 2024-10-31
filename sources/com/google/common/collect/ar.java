package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T, F] */
/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
final class ar<F, T> extends dk<F, T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function f2801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(Iterator it, Function function) {
        super(it);
        this.f2801a = function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public T a(F f) {
        return (T) this.f2801a.apply(f);
    }
}
