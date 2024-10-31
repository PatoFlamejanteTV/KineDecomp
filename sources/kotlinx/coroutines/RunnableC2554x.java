package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;

/* compiled from: DefaultExecutor.kt */
/* renamed from: kotlinx.coroutines.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2554x extends H implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g, reason: collision with root package name */
    private static final long f28728g;

    /* renamed from: h, reason: collision with root package name */
    public static final RunnableC2554x f28729h;

    static {
        Long l;
        RunnableC2554x runnableC2554x = new RunnableC2554x();
        f28729h = runnableC2554x;
        G.a(runnableC2554x, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        kotlin.jvm.internal.h.a((Object) l, "try {\n            java.l…AULT_KEEP_ALIVE\n        }");
        f28728g = timeUnit.toNanos(l.longValue());
    }

    private RunnableC2554x() {
    }

    private final synchronized void Q() {
        if (S()) {
            debugStatus = 3;
            L();
            notifyAll();
        }
    }

    private final synchronized Thread R() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean S() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    private final synchronized boolean T() {
        if (S()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        ga.f28622b.a(this);
        ia.a().e();
        try {
            if (!T()) {
                if (z) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long A = A();
                if (A == Long.MAX_VALUE) {
                    if (j == Long.MAX_VALUE) {
                        long b2 = ia.a().b();
                        if (j == Long.MAX_VALUE) {
                            j = f28728g + b2;
                        }
                        long j2 = j - b2;
                        if (j2 <= 0) {
                            _thread = null;
                            Q();
                            ia.a().c();
                            if (z()) {
                                return;
                            }
                            y();
                            return;
                        }
                        A = kotlin.c.h.b(A, j2);
                    } else {
                        A = kotlin.c.h.b(A, f28728g);
                    }
                }
                if (A > 0) {
                    if (S()) {
                        _thread = null;
                        Q();
                        ia.a().c();
                        if (z()) {
                            return;
                        }
                        y();
                        return;
                    }
                    ia.a().a(this, A);
                }
            }
        } finally {
            _thread = null;
            Q();
            ia.a().c();
            if (!z()) {
                y();
            }
        }
    }

    @Override // kotlinx.coroutines.H
    protected Thread y() {
        Thread thread = _thread;
        return thread != null ? thread : R();
    }
}
