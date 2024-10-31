package com.google.api.client.util;

import java.io.IOException;

/* loaded from: classes.dex */
public class ExponentialBackOff implements BackOff {
    long c;
    private int d;
    private final int e;
    private final double f;
    private final double g;
    private final int h;
    private final int i;
    private final NanoClock j;

    public ExponentialBackOff() {
        this(new Builder());
    }

    protected ExponentialBackOff(Builder builder) {
        this.e = builder.f2535a;
        this.f = builder.b;
        this.g = builder.c;
        this.h = builder.d;
        this.i = builder.e;
        this.j = builder.f;
        Preconditions.a(this.e > 0);
        Preconditions.a(0.0d <= this.f && this.f < 1.0d);
        Preconditions.a(this.g >= 1.0d);
        Preconditions.a(this.h >= this.e);
        Preconditions.a(this.i > 0);
        a();
    }

    @Override // com.google.api.client.util.BackOff
    public final void a() {
        this.d = this.e;
        this.c = this.j.a();
    }

    @Override // com.google.api.client.util.BackOff
    public long b() throws IOException {
        if (c() > this.i) {
            return -1L;
        }
        int a2 = a(this.f, Math.random(), this.d);
        d();
        return a2;
    }

    static int a(double d, double d2, int i) {
        double d3 = i * d;
        double d4 = i - d3;
        return (int) (((((d3 + i) - d4) + 1.0d) * d2) + d4);
    }

    public final long c() {
        return (this.j.a() - this.c) / 1000000;
    }

    private void d() {
        if (this.d >= this.h / this.g) {
            this.d = this.h;
        } else {
            this.d = (int) (this.d * this.g);
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        int f2535a = 500;
        double b = 0.5d;
        double c = 1.5d;
        int d = 60000;
        int e = 900000;
        NanoClock f = NanoClock.f2544a;

        public ExponentialBackOff a() {
            return new ExponentialBackOff(this);
        }
    }
}
