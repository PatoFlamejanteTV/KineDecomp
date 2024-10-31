package com.google.common.base;

import java.util.Iterator;

/* compiled from: Converter.java */
/* loaded from: classes2.dex */
public class c<B> implements Iterable<B> {

    /* renamed from: a */
    final /* synthetic */ Iterable f15129a;

    /* renamed from: b */
    final /* synthetic */ Converter f15130b;

    public c(Converter converter, Iterable iterable) {
        this.f15130b = converter;
        this.f15129a = iterable;
    }

    @Override // java.lang.Iterable
    public Iterator<B> iterator() {
        return new b(this);
    }
}
