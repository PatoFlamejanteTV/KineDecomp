package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class StatsAccumulator {

    /* renamed from: a */
    private long f16003a = 0;

    /* renamed from: b */
    private double f16004b = 0.0d;

    /* renamed from: c */
    private double f16005c = 0.0d;

    /* renamed from: d */
    private double f16006d = Double.NaN;

    /* renamed from: e */
    private double f16007e = Double.NaN;

    public void a(double d2) {
        long j = this.f16003a;
        if (j == 0) {
            this.f16003a = 1L;
            this.f16004b = d2;
            this.f16006d = d2;
            this.f16007e = d2;
            if (Doubles.a(d2)) {
                return;
            }
            this.f16005c = Double.NaN;
            return;
        }
        this.f16003a = j + 1;
        if (Doubles.a(d2) && Doubles.a(this.f16004b)) {
            double d3 = this.f16004b;
            double d4 = d2 - d3;
            double d5 = this.f16003a;
            Double.isNaN(d5);
            this.f16004b = d3 + (d4 / d5);
            this.f16005c += d4 * (d2 - this.f16004b);
        } else {
            this.f16004b = a(this.f16004b, d2);
            this.f16005c = Double.NaN;
        }
        this.f16006d = Math.min(this.f16006d, d2);
        this.f16007e = Math.max(this.f16007e, d2);
    }

    public void a(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void a(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void a(double... dArr) {
        for (double d2 : dArr) {
            a(d2);
        }
    }

    public void a(int... iArr) {
        for (int i : iArr) {
            a(i);
        }
    }

    public void a(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public Stats a() {
        return new Stats(this.f16003a, this.f16004b, this.f16005c, this.f16006d, this.f16007e);
    }

    public static double a(double d2, double d3) {
        if (Doubles.a(d2)) {
            return d3;
        }
        if (Doubles.a(d3) || d2 == d3) {
            return d2;
        }
        return Double.NaN;
    }
}
