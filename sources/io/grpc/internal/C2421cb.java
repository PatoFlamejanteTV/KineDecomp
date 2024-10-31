package io.grpc.internal;

import com.google.common.base.Stopwatch;
import io.grpc.internal.Y;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Ping.java */
/* renamed from: io.grpc.internal.cb */
/* loaded from: classes3.dex */
public class C2421cb {

    /* renamed from: a */
    private static final Logger f27586a = Logger.getLogger(C2421cb.class.getName());

    /* renamed from: b */
    private final long f27587b;

    /* renamed from: c */
    private final Stopwatch f27588c;

    /* renamed from: d */
    private Map<Y.a, Executor> f27589d = new LinkedHashMap();

    /* renamed from: e */
    private boolean f27590e;

    /* renamed from: f */
    private Throwable f27591f;

    /* renamed from: g */
    private long f27592g;

    public C2421cb(long j, Stopwatch stopwatch) {
        this.f27587b = j;
        this.f27588c = stopwatch;
    }

    public void a(Y.a aVar, Executor executor) {
        synchronized (this) {
            if (!this.f27590e) {
                this.f27589d.put(aVar, executor);
            } else {
                a(executor, this.f27591f != null ? a(aVar, this.f27591f) : a(aVar, this.f27592g));
            }
        }
    }

    public long b() {
        return this.f27587b;
    }

    public boolean a() {
        synchronized (this) {
            if (this.f27590e) {
                return false;
            }
            this.f27590e = true;
            long a2 = this.f27588c.a(TimeUnit.NANOSECONDS);
            this.f27592g = a2;
            Map<Y.a, Executor> map = this.f27589d;
            this.f27589d = null;
            for (Map.Entry<Y.a, Executor> entry : map.entrySet()) {
                a(entry.getValue(), a(entry.getKey(), a2));
            }
            return true;
        }
    }

    public void a(Throwable th) {
        synchronized (this) {
            if (this.f27590e) {
                return;
            }
            this.f27590e = true;
            this.f27591f = th;
            Map<Y.a, Executor> map = this.f27589d;
            this.f27589d = null;
            for (Map.Entry<Y.a, Executor> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue(), th);
            }
        }
    }

    public static void a(Y.a aVar, Executor executor, Throwable th) {
        a(executor, a(aVar, th));
    }

    private static void a(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f27586a.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    private static Runnable a(Y.a aVar, long j) {
        return new RunnableC2413ab(aVar, j);
    }

    private static Runnable a(Y.a aVar, Throwable th) {
        return new RunnableC2417bb(aVar, th);
    }
}
