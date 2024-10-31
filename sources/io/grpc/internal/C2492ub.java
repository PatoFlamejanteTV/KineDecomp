package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LogId.java */
/* renamed from: io.grpc.internal.ub */
/* loaded from: classes3.dex */
public final class C2492ub {

    /* renamed from: a */
    private static final AtomicLong f27747a = new AtomicLong();

    /* renamed from: b */
    private final String f27748b;

    /* renamed from: c */
    private final long f27749c;

    protected C2492ub(String str, long j) {
        this.f27748b = str;
        this.f27749c = j;
    }

    public static C2492ub a(String str) {
        return new C2492ub(str, b());
    }

    static long b() {
        return f27747a.incrementAndGet();
    }

    public String toString() {
        return this.f27748b + "-" + this.f27749c;
    }

    public long a() {
        return this.f27749c;
    }
}
