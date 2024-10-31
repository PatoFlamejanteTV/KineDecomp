package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: NetworkDispatcher.java */
/* loaded from: classes.dex */
public class i extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f8065a;

    /* renamed from: b, reason: collision with root package name */
    private final h f8066b;

    /* renamed from: c, reason: collision with root package name */
    private final a f8067c;

    /* renamed from: d, reason: collision with root package name */
    private final n f8068d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f8069e = false;

    public i(BlockingQueue<Request<?>> blockingQueue, h hVar, a aVar, n nVar) {
        this.f8065a = blockingQueue;
        this.f8066b = hVar;
        this.f8067c = aVar;
        this.f8068d = nVar;
    }

    @TargetApi(14)
    private void a(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.p());
        }
    }

    private void c() throws InterruptedException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Request<?> take = this.f8065a.take();
        try {
            take.a("network-queue-take");
            if (take.B()) {
                take.b("network-discard-cancelled");
                take.D();
                return;
            }
            a(take);
            j a2 = this.f8066b.a(take);
            take.a("network-http-complete");
            if (a2.f8074e && take.t()) {
                take.b("not-modified");
                take.D();
                return;
            }
            m<?> a3 = take.a(a2);
            take.a("network-parse-complete");
            if (take.E() && a3.f8088b != null) {
                this.f8067c.a(take.f(), a3.f8088b);
                take.a("network-cache-written");
            }
            take.C();
            this.f8068d.a(take, a3);
            take.a(a3);
        } catch (VolleyError e2) {
            e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            a(take, e2);
            take.D();
        } catch (Exception e3) {
            p.a(e3, "Unhandled exception %s", e3.toString());
            VolleyError volleyError = new VolleyError(e3);
            volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f8068d.a(take, volleyError);
            take.D();
        }
    }

    public void b() {
        this.f8069e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f8069e) {
                    return;
                }
            }
        }
    }

    private void a(Request<?> request, VolleyError volleyError) {
        request.b(volleyError);
        this.f8068d.a(request, volleyError);
    }
}
