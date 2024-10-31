package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.Fb;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
public class Jb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f27389a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fb.c f27390b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Jb(Fb.c cVar, Status status) {
        this.f27390b = cVar;
        this.f27389a = status;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fb.b bVar;
        ScheduledFuture scheduledFuture;
        InterfaceC2486t interfaceC2486t;
        InterfaceC2486t interfaceC2486t2;
        Fb.d dVar;
        C2492ub c2492ub;
        Fb.c cVar = this.f27390b;
        Fb.b bVar2 = cVar.f27290a;
        bVar = Fb.this.B;
        if (bVar2 != bVar) {
            return;
        }
        this.f27390b.f27290a.f27287a.a(this.f27389a);
        scheduledFuture = Fb.this.X;
        if (scheduledFuture != null) {
            return;
        }
        interfaceC2486t = Fb.this.Z;
        if (interfaceC2486t == null) {
            Fb fb = Fb.this;
            fb.Z = fb.w.get();
        }
        interfaceC2486t2 = Fb.this.Z;
        long a2 = interfaceC2486t2.a();
        if (Fb.f27278a.isLoggable(Level.FINE)) {
            Logger logger = Fb.f27278a;
            Level level = Level.FINE;
            c2492ub = Fb.this.f27283f;
            logger.log(level, "[{0}] Scheduling DNS resolution backoff for {1} ns", new Object[]{c2492ub, Long.valueOf(a2)});
        }
        Fb fb2 = Fb.this;
        fb2.Y = new Fb.d();
        Fb fb3 = Fb.this;
        ScheduledExecutorService I = fb3.k.I();
        dVar = Fb.this.Y;
        fb3.X = I.schedule(dVar, a2, TimeUnit.NANOSECONDS);
    }
}
