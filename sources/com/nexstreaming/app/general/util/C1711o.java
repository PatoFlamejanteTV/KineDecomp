package com.nexstreaming.app.general.util;

import java.util.AbstractList;

/* compiled from: ImmutableArrayList.java */
/* renamed from: com.nexstreaming.app.general.util.o */
/* loaded from: classes2.dex */
public class C1711o<E> extends AbstractList<E> {

    /* renamed from: a */
    private final E[] f19873a;

    public C1711o(E... eArr) {
        if (eArr != null) {
            this.f19873a = eArr;
            return;
        }
        throw new NullPointerException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.f19873a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f19873a.length;
    }
}
