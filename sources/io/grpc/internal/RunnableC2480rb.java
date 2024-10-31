package io.grpc.internal;

import io.grpc.internal.KeepAliveManager;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: KeepAliveManager.java */
/* renamed from: io.grpc.internal.rb */
/* loaded from: classes3.dex */
public class RunnableC2480rb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ KeepAliveManager f27728a;

    public RunnableC2480rb(KeepAliveManager keepAliveManager) {
        this.f27728a = keepAliveManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeepAliveManager.State state;
        KeepAliveManager.State state2;
        boolean z;
        ScheduledExecutorService scheduledExecutorService;
        Runnable runnable;
        long j;
        KeepAliveManager.d dVar;
        KeepAliveManager.b bVar;
        ScheduledExecutorService scheduledExecutorService2;
        Runnable runnable2;
        long j2;
        this.f27728a.k = null;
        synchronized (this.f27728a) {
            state = this.f27728a.f27415h;
            if (state != KeepAliveManager.State.PING_SCHEDULED) {
                state2 = this.f27728a.f27415h;
                if (state2 == KeepAliveManager.State.PING_DELAYED) {
                    KeepAliveManager keepAliveManager = this.f27728a;
                    scheduledExecutorService = this.f27728a.f27411d;
                    runnable = this.f27728a.m;
                    j = this.f27728a.i;
                    dVar = this.f27728a.f27412e;
                    keepAliveManager.k = scheduledExecutorService.schedule(runnable, j - dVar.a(), TimeUnit.NANOSECONDS);
                    this.f27728a.f27415h = KeepAliveManager.State.PING_SCHEDULED;
                }
                z = false;
            } else {
                z = true;
                this.f27728a.f27415h = KeepAliveManager.State.PING_SENT;
                KeepAliveManager keepAliveManager2 = this.f27728a;
                scheduledExecutorService2 = this.f27728a.f27411d;
                runnable2 = this.f27728a.l;
                j2 = this.f27728a.o;
                keepAliveManager2.j = scheduledExecutorService2.schedule(runnable2, j2, TimeUnit.NANOSECONDS);
            }
        }
        if (z) {
            bVar = this.f27728a.f27413f;
            bVar.a();
        }
    }
}
