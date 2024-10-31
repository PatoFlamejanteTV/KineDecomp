package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.r;

/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a */
    public static final long f28713a = r.a("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);

    /* renamed from: b */
    public static final int f28714b = r.a("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4, (Object) null);

    /* renamed from: c */
    public static final int f28715c = r.a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);

    /* renamed from: d */
    public static final int f28716d;

    /* renamed from: e */
    public static final int f28717e;

    /* renamed from: f */
    public static final long f28718f;

    /* renamed from: g */
    public static l f28719g;

    static {
        int a2;
        int a3;
        a2 = kotlin.c.h.a(r.a(), 2);
        f28716d = r.a("kotlinx.coroutines.scheduler.core.pool.size", a2, 1, 0, 8, (Object) null);
        a3 = kotlin.c.h.a(r.a() * 128, f28716d, 2097150);
        f28717e = r.a("kotlinx.coroutines.scheduler.max.pool.size", a3, 0, 2097150, 4, (Object) null);
        f28718f = TimeUnit.SECONDS.toNanos(r.a("kotlinx.coroutines.scheduler.keep.alive.sec", 5L, 0L, 0L, 12, (Object) null));
        f28719g = f.f28707a;
    }
}
