package io.grpc;

import java.util.concurrent.TimeUnit;

/* compiled from: Deadline.java */
/* renamed from: io.grpc.v */
/* loaded from: classes3.dex */
public final class C2526v implements Comparable<C2526v> {

    /* renamed from: a */
    private static final a f28025a = new a();

    /* renamed from: b */
    private static final long f28026b = TimeUnit.DAYS.toNanos(36500);

    /* renamed from: c */
    private static final long f28027c = -f28026b;

    /* renamed from: d */
    private final b f28028d;

    /* renamed from: e */
    private final long f28029e;

    /* renamed from: f */
    private volatile boolean f28030f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Deadline.java */
    /* renamed from: io.grpc.v$a */
    /* loaded from: classes3.dex */
    public static class a extends b {
        private a() {
        }

        @Override // io.grpc.C2526v.b
        public long a() {
            return System.nanoTime();
        }

        /* synthetic */ a(C2525u c2525u) {
            this();
        }
    }

    /* compiled from: Deadline.java */
    /* renamed from: io.grpc.v$b */
    /* loaded from: classes3.dex */
    public static abstract class b {
        b() {
        }

        public abstract long a();
    }

    private C2526v(b bVar, long j, boolean z) {
        this(bVar, bVar.a(), j, z);
    }

    public static C2526v a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, f28025a);
    }

    public boolean b(C2526v c2526v) {
        return this.f28029e - c2526v.f28029e < 0;
    }

    public C2526v c(C2526v c2526v) {
        return b(c2526v) ? this : c2526v;
    }

    public String toString() {
        return a(TimeUnit.NANOSECONDS) + " ns from now";
    }

    private C2526v(b bVar, long j, long j2, boolean z) {
        this.f28028d = bVar;
        long min = Math.min(f28026b, Math.max(f28027c, j2));
        this.f28029e = j + min;
        this.f28030f = z && min <= 0;
    }

    static C2526v a(long j, TimeUnit timeUnit, b bVar) {
        a(timeUnit, "units");
        return new C2526v(bVar, timeUnit.toNanos(j), true);
    }

    public boolean a() {
        if (!this.f28030f) {
            if (this.f28029e - this.f28028d.a() > 0) {
                return false;
            }
            this.f28030f = true;
        }
        return true;
    }

    public long a(TimeUnit timeUnit) {
        long a2 = this.f28028d.a();
        if (!this.f28030f && this.f28029e - a2 <= 0) {
            this.f28030f = true;
        }
        return timeUnit.convert(this.f28029e - a2, TimeUnit.NANOSECONDS);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C2526v c2526v) {
        long j = this.f28029e - c2526v.f28029e;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    private static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
