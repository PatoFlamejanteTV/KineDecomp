package io.grpc.internal;

import io.grpc.ConnectivityState;
import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSubchannel.java */
/* renamed from: io.grpc.internal.gb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2437gb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2461mb f27617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2437gb(C2461mb c2461mb) {
        this.f27617a = c2461mb;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        try {
            try {
            } catch (Throwable th) {
                C2461mb.f27681a.log(Level.WARNING, "Exception handling end of backoff", th);
            }
            synchronized (this.f27617a.k) {
                this.f27617a.q = null;
                z = this.f27617a.r;
                if (z) {
                    return;
                }
                this.f27617a.a(ConnectivityState.CONNECTING);
                this.f27617a.g();
            }
        } finally {
            this.f27617a.l.a();
        }
    }
}
