package com.nexstreaming.app.general.util;

/* compiled from: Stopwatch.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private long f3241a;
    private long b;
    private boolean c;

    public void a() {
        if (!this.c) {
            this.c = true;
            this.f3241a = System.nanoTime();
        }
    }

    public void b() {
        if (this.c) {
            this.c = false;
            this.b += System.nanoTime() - this.f3241a;
        }
    }

    public void c() {
        this.c = false;
        this.b = 0L;
    }

    public long d() {
        return this.c ? this.b + (System.nanoTime() - this.f3241a) : this.b;
    }

    public long e() {
        return this.c ? (this.b + (System.nanoTime() - this.f3241a)) / 1000000 : this.b / 1000000;
    }

    public String toString() {
        return String.format("%1$,.3f", Double.valueOf(d() / 1000000.0d));
    }
}
