package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.umeng.commonsdk.proguard.c;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class RetryHelper {

    /* renamed from: a */
    private final ScheduledExecutorService f16801a;

    /* renamed from: b */
    private final LogWrapper f16802b;

    /* renamed from: c */
    private final long f16803c;

    /* renamed from: d */
    private final long f16804d;

    /* renamed from: e */
    private final double f16805e;

    /* renamed from: f */
    private final double f16806f;

    /* renamed from: g */
    private final Random f16807g;

    /* renamed from: h */
    private ScheduledFuture<?> f16808h;
    private long i;
    private boolean j;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private final ScheduledExecutorService f16809a;

        /* renamed from: b */
        private long f16810b = 1000;

        /* renamed from: c */
        private double f16811c = 0.5d;

        /* renamed from: d */
        private long f16812d = c.f26227d;

        /* renamed from: e */
        private double f16813e = 1.3d;

        /* renamed from: f */
        private final LogWrapper f16814f;

        public Builder(ScheduledExecutorService scheduledExecutorService, Logger logger, String str) {
            this.f16809a = scheduledExecutorService;
            this.f16814f = new LogWrapper(logger, str);
        }

        public Builder a(long j) {
            this.f16812d = j;
            return this;
        }

        public Builder b(long j) {
            this.f16810b = j;
            return this;
        }

        public Builder a(double d2) {
            if (d2 >= 0.0d && d2 <= 1.0d) {
                this.f16811c = d2;
                return this;
            }
            throw new IllegalArgumentException("Argument out of range: " + d2);
        }

        public Builder b(double d2) {
            this.f16813e = d2;
            return this;
        }

        public RetryHelper a() {
            return new RetryHelper(this.f16809a, this.f16814f, this.f16810b, this.f16812d, this.f16813e, this.f16811c, null);
        }
    }

    /* synthetic */ RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper, long j, long j2, double d2, double d3, a aVar) {
        this(scheduledExecutorService, logWrapper, j, j2, d2, d3);
    }

    public void b() {
        this.i = this.f16804d;
    }

    public void c() {
        this.j = true;
        this.i = 0L;
    }

    private RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper, long j, long j2, double d2, double d3) {
        this.f16807g = new Random();
        this.j = true;
        this.f16801a = scheduledExecutorService;
        this.f16802b = logWrapper;
        this.f16803c = j;
        this.f16804d = j2;
        this.f16806f = d2;
        this.f16805e = d3;
    }

    public void a(Runnable runnable) {
        a aVar = new a(this, runnable);
        if (this.f16808h != null) {
            this.f16802b.a("Cancelling previous scheduled retry", new Object[0]);
            this.f16808h.cancel(false);
            this.f16808h = null;
        }
        long j = 0;
        if (!this.j) {
            long j2 = this.i;
            if (j2 == 0) {
                this.i = this.f16803c;
            } else {
                double d2 = j2;
                double d3 = this.f16806f;
                Double.isNaN(d2);
                this.i = Math.min((long) (d2 * d3), this.f16804d);
            }
            double d4 = this.f16805e;
            long j3 = this.i;
            double d5 = j3;
            Double.isNaN(d5);
            double d6 = j3;
            Double.isNaN(d6);
            j = (long) (((1.0d - d4) * d5) + (d4 * d6 * this.f16807g.nextDouble()));
        }
        this.j = false;
        this.f16802b.a("Scheduling retry in %dms", Long.valueOf(j));
        this.f16808h = this.f16801a.schedule(aVar, j, TimeUnit.MILLISECONDS);
    }

    public void a() {
        if (this.f16808h != null) {
            this.f16802b.a("Cancelling existing retry attempt", new Object[0]);
            this.f16808h.cancel(false);
            this.f16808h = null;
        } else {
            this.f16802b.a("No existing retry attempt to cancel", new Object[0]);
        }
        this.i = 0L;
    }
}
