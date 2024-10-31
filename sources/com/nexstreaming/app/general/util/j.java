package com.nexstreaming.app.general.util;

import java.util.AbstractList;

/* compiled from: ImmutableArrayList.java */
/* loaded from: classes.dex */
public class j<E> extends AbstractList<E> {

    /* renamed from: a, reason: collision with root package name */
    private final E[] f3229a;

    public j(E... eArr) {
        if (eArr == null) {
            throw new NullPointerException();
        }
        this.f3229a = eArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.f3229a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3229a.length;
    }
}
