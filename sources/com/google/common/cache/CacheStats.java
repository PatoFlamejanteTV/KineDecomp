package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class CacheStats {

    /* renamed from: a, reason: collision with root package name */
    private final long f2602a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        Preconditions.a(j >= 0);
        Preconditions.a(j2 >= 0);
        Preconditions.a(j3 >= 0);
        Preconditions.a(j4 >= 0);
        Preconditions.a(j5 >= 0);
        Preconditions.a(j6 >= 0);
        this.f2602a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }

    public long a() {
        return this.f2602a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public int hashCode() {
        return Objects.a(Long.valueOf(this.f2602a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        return this.f2602a == cacheStats.f2602a && this.b == cacheStats.b && this.c == cacheStats.c && this.d == cacheStats.d && this.e == cacheStats.e && this.f == cacheStats.f;
    }

    public String toString() {
        return Objects.a(this).a("hitCount", this.f2602a).a("missCount", this.b).a("loadSuccessCount", this.c).a("loadExceptionCount", this.d).a("totalLoadTime", this.e).a("evictionCount", this.f).toString();
    }
}
