package io.grpc.internal;

import io.grpc.internal.MessageDeframer;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2435g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f27615a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2463n f27616b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2435g(C2463n c2463n, int i) {
        this.f27616b = c2463n;
        this.f27615a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer messageDeframer;
        MessageDeframer.a aVar;
        MessageDeframer messageDeframer2;
        MessageDeframer messageDeframer3;
        messageDeframer = this.f27616b.f27697b;
        if (messageDeframer.isClosed()) {
            return;
        }
        try {
            messageDeframer3 = this.f27616b.f27697b;
            messageDeframer3.a(this.f27615a);
        } catch (Throwable th) {
            aVar = this.f27616b.f27696a;
            aVar.a(th);
            messageDeframer2 = this.f27616b.f27697b;
            messageDeframer2.close();
        }
    }
}
