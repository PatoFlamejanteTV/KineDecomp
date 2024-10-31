package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout.java */
/* renamed from: okio.c */
/* loaded from: classes3.dex */
public class C2576c extends B {

    /* renamed from: e */
    private static final long f29234e = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: f */
    private static final long f29235f = TimeUnit.MILLISECONDS.toNanos(f29234e);

    /* renamed from: g */
    @Nullable
    static C2576c f29236g;

    /* renamed from: h */
    private boolean f29237h;

    @Nullable
    private C2576c i;
    private long j;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: okio.c$a */
    /* loaded from: classes3.dex */
    public static final class a extends Thread {
        a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:            r1.j();     */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<okio.c> r0 = okio.C2576c.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                okio.c r1 = okio.C2576c.g()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                okio.c r2 = okio.C2576c.f29236g     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                okio.C2576c.f29236g = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.j()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.C2576c.a.run():void");
        }
    }

    private static synchronized void a(C2576c c2576c, long j, boolean z) {
        synchronized (C2576c.class) {
            if (f29236g == null) {
                f29236g = new C2576c();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                c2576c.j = Math.min(j, c2576c.c() - nanoTime) + nanoTime;
            } else if (j != 0) {
                c2576c.j = j + nanoTime;
            } else if (z) {
                c2576c.j = c2576c.c();
            } else {
                throw new AssertionError();
            }
            long b2 = c2576c.b(nanoTime);
            C2576c c2576c2 = f29236g;
            while (c2576c2.i != null && b2 >= c2576c2.i.b(nanoTime)) {
                c2576c2 = c2576c2.i;
            }
            c2576c.i = c2576c2.i;
            c2576c2.i = c2576c;
            if (c2576c2 == f29236g) {
                C2576c.class.notify();
            }
        }
    }

    private long b(long j) {
        return this.j - j;
    }

    @Nullable
    static C2576c g() throws InterruptedException {
        C2576c c2576c = f29236g.i;
        if (c2576c == null) {
            long nanoTime = System.nanoTime();
            C2576c.class.wait(f29234e);
            if (f29236g.i != null || System.nanoTime() - nanoTime < f29235f) {
                return null;
            }
            return f29236g;
        }
        long b2 = c2576c.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / 1000000;
            C2576c.class.wait(j, (int) (b2 - (1000000 * j)));
            return null;
        }
        f29236g.i = c2576c.i;
        c2576c.i = null;
        return c2576c;
    }

    public final void h() {
        if (!this.f29237h) {
            long f2 = f();
            boolean d2 = d();
            if (f2 != 0 || d2) {
                this.f29237h = true;
                a(this, f2, d2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean i() {
        if (!this.f29237h) {
            return false;
        }
        this.f29237h = false;
        return a(this);
    }

    protected void j() {
    }

    protected IOException b(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized boolean a(C2576c c2576c) {
        synchronized (C2576c.class) {
            for (C2576c c2576c2 = f29236g; c2576c2 != null; c2576c2 = c2576c2.i) {
                if (c2576c2.i == c2576c) {
                    c2576c2.i = c2576c.i;
                    c2576c.i = null;
                    return false;
                }
            }
            return true;
        }
    }

    public final y a(y yVar) {
        return new C2574a(this, yVar);
    }

    public final z a(z zVar) {
        return new C2575b(this, zVar);
    }

    public final void a(boolean z) throws IOException {
        if (i() && z) {
            throw b((IOException) null);
        }
    }

    public final IOException a(IOException iOException) throws IOException {
        return !i() ? iOException : b(iOException);
    }
}
