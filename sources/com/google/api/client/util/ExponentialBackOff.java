package com.google.api.client.util;

import java.io.IOException;

/* loaded from: classes2.dex */
public class ExponentialBackOff implements BackOff {

    /* renamed from: a */
    private int f14934a;

    /* renamed from: b */
    private final int f14935b;

    /* renamed from: c */
    private final double f14936c;

    /* renamed from: d */
    private final double f14937d;

    /* renamed from: e */
    private final int f14938e;

    /* renamed from: f */
    long f14939f;

    /* renamed from: g */
    private final int f14940g;

    /* renamed from: h */
    private final NanoClock f14941h;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        int f14942a = 500;

        /* renamed from: b */
        double f14943b = 0.5d;

        /* renamed from: c */
        double f14944c = 1.5d;

        /* renamed from: d */
        int f14945d = 60000;

        /* renamed from: e */
        int f14946e = 900000;

        /* renamed from: f */
        NanoClock f14947f = NanoClock.f14970a;

        public ExponentialBackOff a() {
            return new ExponentialBackOff(this);
        }
    }

    public ExponentialBackOff() {
        this(new Builder());
    }

    private void c() {
        int i = this.f14934a;
        double d2 = i;
        int i2 = this.f14938e;
        double d3 = i2;
        double d4 = this.f14937d;
        Double.isNaN(d3);
        if (d2 >= d3 / d4) {
            this.f14934a = i2;
            return;
        }
        double d5 = i;
        Double.isNaN(d5);
        this.f14934a = (int) (d5 * d4);
    }

    @Override // com.google.api.client.util.BackOff
    public long a() throws IOException {
        if (b() > this.f14940g) {
            return -1L;
        }
        int a2 = a(this.f14936c, Math.random(), this.f14934a);
        c();
        return a2;
    }

    public final long b() {
        return (this.f14941h.b() - this.f14939f) / 1000000;
    }

    @Override // com.google.api.client.util.BackOff
    public final void reset() {
        this.f14934a = this.f14935b;
        this.f14939f = this.f14941h.b();
    }

    protected ExponentialBackOff(Builder builder) {
        this.f14935b = builder.f14942a;
        this.f14936c = builder.f14943b;
        this.f14937d = builder.f14944c;
        this.f14938e = builder.f14945d;
        this.f14940g = builder.f14946e;
        this.f14941h = builder.f14947f;
        Preconditions.a(this.f14935b > 0);
        double d2 = this.f14936c;
        Preconditions.a(0.0d <= d2 && d2 < 1.0d);
        Preconditions.a(this.f14937d >= 1.0d);
        Preconditions.a(this.f14938e >= this.f14935b);
        Preconditions.a(this.f14940g > 0);
        reset();
    }

    static int a(double d2, double d3, int i) {
        double d4 = i;
        Double.isNaN(d4);
        double d5 = d2 * d4;
        Double.isNaN(d4);
        double d6 = d4 - d5;
        Double.isNaN(d4);
        return (int) (d6 + (d3 * (((d4 + d5) - d6) + 1.0d)));
    }
}
