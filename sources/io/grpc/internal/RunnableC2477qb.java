package io.grpc.internal;

import io.grpc.internal.KeepAliveManager;

/* compiled from: KeepAliveManager.java */
/* renamed from: io.grpc.internal.qb */
/* loaded from: classes3.dex */
public class RunnableC2477qb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ KeepAliveManager f27724a;

    public RunnableC2477qb(KeepAliveManager keepAliveManager) {
        this.f27724a = keepAliveManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeepAliveManager.State state;
        boolean z;
        KeepAliveManager.b bVar;
        synchronized (this.f27724a) {
            state = this.f27724a.f27415h;
            if (state != KeepAliveManager.State.DISCONNECTED) {
                this.f27724a.f27415h = KeepAliveManager.State.DISCONNECTED;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            bVar = this.f27724a.f27413f;
            bVar.b();
        }
    }
}
