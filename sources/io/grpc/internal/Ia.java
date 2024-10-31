package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.internal.InterfaceC2486t;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* compiled from: ExponentialBackoffPolicy.java */
/* loaded from: classes3.dex */
final class Ia implements InterfaceC2486t {

    /* renamed from: a */
    private Random f27360a = new Random();

    /* renamed from: b */
    private long f27361b = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: c */
    private long f27362c = TimeUnit.MINUTES.toNanos(2);

    /* renamed from: d */
    private double f27363d = 1.6d;

    /* renamed from: e */
    private double f27364e = 0.2d;

    /* renamed from: f */
    private long f27365f = this.f27361b;

    /* compiled from: ExponentialBackoffPolicy.java */
    /* loaded from: classes3.dex */
    static final class a implements InterfaceC2486t.a {
        @Override // io.grpc.internal.InterfaceC2486t.a
        public InterfaceC2486t get() {
            return new Ia();
        }
    }

    Ia() {
    }

    @Override // io.grpc.internal.InterfaceC2486t
    public long a() {
        long j = this.f27365f;
        double d2 = j;
        double d3 = this.f27363d;
        Double.isNaN(d2);
        this.f27365f = Math.min((long) (d3 * d2), this.f27362c);
        double d4 = this.f27364e;
        Double.isNaN(d2);
        Double.isNaN(d2);
        return j + a((-d4) * d2, d4 * d2);
    }

    private long a(double d2, double d3) {
        Preconditions.a(d3 >= d2);
        return (long) ((this.f27360a.nextDouble() * (d3 - d2)) + d2);
    }
}
