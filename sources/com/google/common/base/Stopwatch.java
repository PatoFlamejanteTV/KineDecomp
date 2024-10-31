package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.TimeUnit;

@Beta
@GwtCompatible
/* loaded from: classes.dex */
public final class Stopwatch {

    /* renamed from: a, reason: collision with root package name */
    private final Ticker f2586a;
    private boolean b;
    private long c;
    private long d;

    public Stopwatch() {
        this(Ticker.b());
    }

    public Stopwatch(Ticker ticker) {
        this.f2586a = (Ticker) Preconditions.a(ticker);
    }

    public Stopwatch a() {
        Preconditions.b(!this.b);
        this.b = true;
        this.d = this.f2586a.a();
        return this;
    }

    public Stopwatch b() {
        long a2 = this.f2586a.a();
        Preconditions.b(this.b);
        this.b = false;
        this.c = (a2 - this.d) + this.c;
        return this;
    }

    private long c() {
        return this.b ? (this.f2586a.a() - this.d) + this.c : this.c;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(c(), TimeUnit.NANOSECONDS);
    }

    @GwtIncompatible
    public String toString() {
        return a(4);
    }

    @GwtIncompatible
    @Deprecated
    public String a(int i) {
        long c = c();
        return String.format("%." + i + "g %s", Double.valueOf(c / TimeUnit.NANOSECONDS.convert(1L, r2)), b(a(c)));
    }

    private static TimeUnit a(long j) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.base.Stopwatch$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2587a = new int[TimeUnit.values().length];

        static {
            try {
                f2587a[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2587a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2587a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2587a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static String b(TimeUnit timeUnit) {
        switch (AnonymousClass1.f2587a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            default:
                throw new AssertionError();
        }
    }
}
