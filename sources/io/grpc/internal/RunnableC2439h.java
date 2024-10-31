package io.grpc.internal;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2439h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2426dc f27624a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2463n f27625b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2439h(C2463n c2463n, InterfaceC2426dc interfaceC2426dc) {
        this.f27625b = c2463n;
        this.f27624a = interfaceC2426dc;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer messageDeframer;
        MessageDeframer messageDeframer2;
        try {
            messageDeframer2 = this.f27625b.f27697b;
            messageDeframer2.a(this.f27624a);
        } catch (Throwable th) {
            this.f27625b.a(th);
            messageDeframer = this.f27625b.f27697b;
            messageDeframer.close();
        }
    }
}
