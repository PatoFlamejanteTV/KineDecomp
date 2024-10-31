package io.grpc.internal;

import io.grpc.C2403b;
import io.grpc.internal.Fb;
import io.grpc.internal.wc;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
final class Kb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2403b f27398a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f27399b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fb.c f27400c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kb(Fb.c cVar, C2403b c2403b, List list) {
        this.f27400c = cVar;
        this.f27398a = c2403b;
        this.f27399b = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fb.b bVar;
        Gc gc;
        wc.h b2;
        Fb.c cVar = this.f27400c;
        Fb.b bVar2 = cVar.f27290a;
        bVar = Fb.this.B;
        if (bVar2 != bVar) {
            return;
        }
        Fb.this.Z = null;
        Map<String, Object> map = (Map) this.f27398a.a(Sa.f27502a);
        if (map != null) {
            try {
                gc = Fb.this.v;
                gc.a(map);
                if (Fb.this.U) {
                    Fb fb = Fb.this;
                    b2 = Fb.b(this.f27398a);
                    fb.R = b2;
                }
            } catch (RuntimeException e2) {
                Fb.f27278a.log(Level.WARNING, "[" + Fb.this.a() + "] Unexpected exception from parsing service config", (Throwable) e2);
            }
        }
        this.f27400c.f27290a.f27287a.a(this.f27399b, this.f27398a);
    }
}
