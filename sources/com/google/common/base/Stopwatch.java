package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Stopwatch {

    /* renamed from: a */
    private final Ticker f15118a = Ticker.b();

    /* renamed from: b */
    private boolean f15119b;

    /* renamed from: c */
    private long f15120c;

    /* renamed from: d */
    private long f15121d;

    Stopwatch() {
    }

    public static Stopwatch a() {
        return new Stopwatch().d();
    }

    public static Stopwatch b() {
        return new Stopwatch();
    }

    private long f() {
        return this.f15119b ? (this.f15118a.a() - this.f15121d) + this.f15120c : this.f15120c;
    }

    @CanIgnoreReturnValue
    public Stopwatch c() {
        this.f15120c = 0L;
        this.f15119b = false;
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch d() {
        Preconditions.b(!this.f15119b, "This stopwatch is already running.");
        this.f15119b = true;
        this.f15121d = this.f15118a.a();
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch e() {
        long a2 = this.f15118a.a();
        Preconditions.b(this.f15119b, "This stopwatch is already stopped.");
        this.f15119b = false;
        this.f15120c += a2 - this.f15121d;
        return this;
    }

    public String toString() {
        long f2 = f();
        TimeUnit a2 = a(f2);
        double d2 = f2;
        double convert = TimeUnit.NANOSECONDS.convert(1L, a2);
        Double.isNaN(d2);
        Double.isNaN(convert);
        return l.a(d2 / convert) + " " + b(a2);
    }

    private static String b(TimeUnit timeUnit) {
        switch (s.f15149a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return com.umeng.commonsdk.proguard.e.ap;
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return com.umeng.commonsdk.proguard.e.am;
            default:
                throw new AssertionError();
        }
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    private static TimeUnit a(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }
}
