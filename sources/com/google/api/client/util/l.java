package com.google.api.client.util;

import java.util.Iterator;

/* compiled from: Types.java */
/* loaded from: classes2.dex */
public class l<T> implements Iterable<T> {

    /* renamed from: a */
    final /* synthetic */ Object f15010a;

    public l(Object obj) {
        this.f15010a = obj;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new k(this);
    }
}
