package io.grpc.internal;

import io.grpc.internal.Kc;
import java.util.IdentityHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SharedResourceHolder.java */
/* loaded from: classes3.dex */
public class Jc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Kc.a f27391a;

    /* renamed from: b */
    final /* synthetic */ Kc.b f27392b;

    /* renamed from: c */
    final /* synthetic */ Object f27393c;

    /* renamed from: d */
    final /* synthetic */ Kc f27394d;

    public Jc(Kc kc, Kc.a aVar, Kc.b bVar, Object obj) {
        this.f27394d = kc;
        this.f27391a = aVar;
        this.f27392b = bVar;
        this.f27393c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        IdentityHashMap identityHashMap;
        IdentityHashMap identityHashMap2;
        ScheduledExecutorService scheduledExecutorService;
        synchronized (this.f27394d) {
            if (this.f27391a.f27406b == 0) {
                this.f27392b.a(this.f27393c);
                identityHashMap = this.f27394d.f27402b;
                identityHashMap.remove(this.f27392b);
                identityHashMap2 = this.f27394d.f27402b;
                if (identityHashMap2.isEmpty()) {
                    scheduledExecutorService = this.f27394d.f27404d;
                    scheduledExecutorService.shutdown();
                    this.f27394d.f27404d = null;
                }
            }
        }
    }
}
