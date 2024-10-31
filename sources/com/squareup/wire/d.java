package com.squareup.wire;

import com.squareup.wire.m;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: EnumAdapter.java */
/* loaded from: classes.dex */
public final class d<E extends m> {

    /* renamed from: a */
    private static final Comparator<m> f25706a = new c();

    /* renamed from: b */
    private final Class<E> f25707b;

    /* renamed from: c */
    private final int[] f25708c;

    /* renamed from: d */
    private final E[] f25709d;

    /* renamed from: e */
    private final boolean f25710e;

    public d(Class<E> cls) {
        this.f25707b = cls;
        this.f25709d = cls.getEnumConstants();
        Arrays.sort(this.f25709d, f25706a);
        E[] eArr = this.f25709d;
        int length = eArr.length;
        if (eArr[0].getValue() == 1 && this.f25709d[length - 1].getValue() == length) {
            this.f25710e = true;
            this.f25708c = null;
            return;
        }
        this.f25710e = false;
        this.f25708c = new int[length];
        for (int i = 0; i < length; i++) {
            this.f25708c[i] = this.f25709d[i].getValue();
        }
    }

    public int a(E e2) {
        return e2.getValue();
    }

    public E a(int i) {
        try {
            return this.f25709d[this.f25710e ? i - 1 : Arrays.binarySearch(this.f25708c, i)];
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Unknown enum tag " + i + " for " + this.f25707b.getCanonicalName());
        }
    }
}
