package com.nexstreaming.app.general.util;

import java.util.Iterator;

/* compiled from: IterUtil.java */
/* loaded from: classes2.dex */
public class r<T> implements Iterable<T> {

    /* renamed from: a */
    final /* synthetic */ Iterable f19880a;

    /* renamed from: b */
    final /* synthetic */ Iterable f19881b;

    public r(Iterable iterable, Iterable iterable2) {
        this.f19880a = iterable;
        this.f19881b = iterable2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return t.a(this.f19880a.iterator(), this.f19881b.iterator());
    }
}
