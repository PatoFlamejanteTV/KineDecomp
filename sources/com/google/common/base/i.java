package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Optional.java */
/* loaded from: classes2.dex */
public class i<T> implements Iterable<T> {

    /* renamed from: a */
    final /* synthetic */ Iterable f15135a;

    public i(Iterable iterable) {
        this.f15135a = iterable;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new h(this);
    }
}
