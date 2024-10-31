package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes3.dex */
public final class A {

    /* renamed from: a */
    private int f25274a;

    /* renamed from: b */
    private int f25275b;

    /* renamed from: c */
    private int f25276c;

    /* renamed from: d */
    private final int[] f25277d = new int[10];

    public void a() {
        this.f25276c = 0;
        this.f25275b = 0;
        this.f25274a = 0;
        Arrays.fill(this.f25277d, 0);
    }

    public int b(int i) {
        return this.f25277d[i];
    }

    public int c() {
        return Integer.bitCount(this.f25274a);
    }

    public int d(int i) {
        return (this.f25274a & 16) != 0 ? this.f25277d[4] : i;
    }

    public int e(int i) {
        return (this.f25274a & 32) != 0 ? this.f25277d[5] : i;
    }

    boolean f(int i) {
        return ((1 << i) & this.f25276c) != 0;
    }

    public boolean g(int i) {
        return ((1 << i) & this.f25274a) != 0;
    }

    boolean h(int i) {
        return ((1 << i) & this.f25275b) != 0;
    }

    public int b() {
        if ((this.f25274a & 2) != 0) {
            return this.f25277d[1];
        }
        return -1;
    }

    public int c(int i) {
        return (this.f25274a & 128) != 0 ? this.f25277d[7] : i;
    }

    public A a(int i, int i2, int i3) {
        if (i >= this.f25277d.length) {
            return this;
        }
        int i4 = 1 << i;
        this.f25274a |= i4;
        if ((i2 & 1) != 0) {
            this.f25275b |= i4;
        } else {
            this.f25275b &= i4 ^ (-1);
        }
        if ((i2 & 2) != 0) {
            this.f25276c |= i4;
        } else {
            this.f25276c &= i4 ^ (-1);
        }
        this.f25277d[i] = i3;
        return this;
    }

    public int a(int i) {
        int i2 = f(i) ? 2 : 0;
        return h(i) ? i2 | 1 : i2;
    }

    public void a(A a2) {
        for (int i = 0; i < 10; i++) {
            if (a2.g(i)) {
                a(i, a2.a(i), a2.b(i));
            }
        }
    }
}
