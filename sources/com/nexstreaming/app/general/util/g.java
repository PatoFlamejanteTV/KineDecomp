package com.nexstreaming.app.general.util;

/* compiled from: Stopwatch.java */
/* loaded from: classes2.dex */
public class G {

    /* renamed from: a */
    private long f19822a;

    /* renamed from: b */
    private long f19823b;

    /* renamed from: c */
    private boolean f19824c;

    public long a() {
        if (this.f19824c) {
            return (this.f19823b + (System.nanoTime() - this.f19822a)) / 1000000;
        }
        return this.f19823b / 1000000;
    }

    public long b() {
        if (this.f19824c) {
            return this.f19823b + (System.nanoTime() - this.f19822a);
        }
        return this.f19823b;
    }

    public void c() {
        this.f19824c = false;
        this.f19823b = 0L;
    }

    public void d() {
        if (this.f19824c) {
            return;
        }
        this.f19824c = true;
        this.f19822a = System.nanoTime();
    }

    public void e() {
        if (this.f19824c) {
            this.f19824c = false;
            this.f19823b += System.nanoTime() - this.f19822a;
        }
    }

    public String toString() {
        double b2 = b();
        Double.isNaN(b2);
        return String.format("%1$,.3f", Double.valueOf(b2 / 1000000.0d));
    }
}
