package com.nexstreaming.kinemaster.ui.widget;

/* compiled from: ItemsRange.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a */
    private int f23868a;

    /* renamed from: b */
    private int f23869b;

    public h() {
        this(0, 0);
    }

    public int a() {
        return this.f23869b;
    }

    public int b() {
        return this.f23868a;
    }

    public int c() {
        return (b() + a()) - 1;
    }

    public h(int i, int i2) {
        this.f23868a = i;
        this.f23869b = i2;
    }

    public boolean a(int i) {
        return i >= b() && i <= c();
    }
}
