package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SensorRequest {

    /* renamed from: a, reason: collision with root package name */
    private final DataSource f1262a;
    private final DataType b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final LocationRequest g;
    private final long h;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private long f1263a = -1;
        private long b = 0;
        private long c = 0;
        private boolean d = false;
        private int e = 2;
        private long f = Long.MAX_VALUE;
    }

    private boolean a(SensorRequest sensorRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.f1262a, sensorRequest.f1262a) && com.google.android.gms.common.internal.zzw.a(this.b, sensorRequest.b) && this.c == sensorRequest.c && this.d == sensorRequest.d && this.e == sensorRequest.e && this.f == sensorRequest.f && com.google.android.gms.common.internal.zzw.a(this.g, sensorRequest.g) && this.h == sensorRequest.h;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.MICROSECONDS);
    }

    public DataSource a() {
        return this.f1262a;
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(this.d, TimeUnit.MICROSECONDS);
    }

    public DataType b() {
        return this.b;
    }

    public int c() {
        return this.f;
    }

    public long c(TimeUnit timeUnit) {
        return timeUnit.convert(this.e, TimeUnit.MICROSECONDS);
    }

    public long d() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRequest) && a((SensorRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.f1262a, this.b, Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), this.g, Long.valueOf(this.h));
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("dataSource", this.f1262a).a("dataType", this.b).a("samplingRateMicros", Long.valueOf(this.c)).a("deliveryLatencyMicros", Long.valueOf(this.e)).a("timeOutMicros", Long.valueOf(this.h)).toString();
    }
}
