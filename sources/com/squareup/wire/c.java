package com.squareup.wire;

import com.squareup.wire.m;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnumAdapter.java */
/* loaded from: classes.dex */
public final class c<E extends m> {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<m> f4856a = new d();
    private final Class<E> b;
    private final int[] c;
    private final E[] d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Class<E> cls) {
        this.b = cls;
        this.d = cls.getEnumConstants();
        Arrays.sort(this.d, f4856a);
        int length = this.d.length;
        if (this.d[0].getValue() == 1 && this.d[length - 1].getValue() == length) {
            this.e = true;
            this.c = null;
            return;
        }
        this.e = false;
        this.c = new int[length];
        for (int i = 0; i < length; i++) {
            this.c[i] = this.d[i].getValue();
        }
    }

    public int a(E e) {
        return e.getValue();
    }

    public E a(int i) {
        try {
            return this.d[this.e ? i - 1 : Arrays.binarySearch(this.c, i)];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Unknown enum tag " + i + " for " + this.b.getCanonicalName());
        }
    }
}
