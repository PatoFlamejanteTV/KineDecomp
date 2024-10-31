package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class CacheStats {

    /* renamed from: a */
    private final long f15174a;

    /* renamed from: b */
    private final long f15175b;

    /* renamed from: c */
    private final long f15176c;

    /* renamed from: d */
    private final long f15177d;

    /* renamed from: e */
    private final long f15178e;

    /* renamed from: f */
    private final long f15179f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        Preconditions.a(j >= 0);
        Preconditions.a(j2 >= 0);
        Preconditions.a(j3 >= 0);
        Preconditions.a(j4 >= 0);
        Preconditions.a(j5 >= 0);
        Preconditions.a(j6 >= 0);
        this.f15174a = j;
        this.f15175b = j2;
        this.f15176c = j3;
        this.f15177d = j4;
        this.f15178e = j5;
        this.f15179f = j6;
    }

    public long a() {
        return this.f15179f;
    }

    public long b() {
        return this.f15174a;
    }

    public long c() {
        return this.f15177d;
    }

    public long d() {
        return this.f15176c;
    }

    public long e() {
        return this.f15175b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        return this.f15174a == cacheStats.f15174a && this.f15175b == cacheStats.f15175b && this.f15176c == cacheStats.f15176c && this.f15177d == cacheStats.f15177d && this.f15178e == cacheStats.f15178e && this.f15179f == cacheStats.f15179f;
    }

    public long f() {
        return this.f15178e;
    }

    public int hashCode() {
        return Objects.a(Long.valueOf(this.f15174a), Long.valueOf(this.f15175b), Long.valueOf(this.f15176c), Long.valueOf(this.f15177d), Long.valueOf(this.f15178e), Long.valueOf(this.f15179f));
    }

    public String toString() {
        return MoreObjects.a(this).a("hitCount", this.f15174a).a("missCount", this.f15175b).a("loadSuccessCount", this.f15176c).a("loadExceptionCount", this.f15177d).a("totalLoadTime", this.f15178e).a("evictionCount", this.f15179f).toString();
    }
}
