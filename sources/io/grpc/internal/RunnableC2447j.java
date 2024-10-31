package io.grpc.internal;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2447j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2463n f27643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2447j(C2463n c2463n) {
        this.f27643a = c2463n;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer messageDeframer;
        messageDeframer = this.f27643a.f27697b;
        messageDeframer.close();
    }
}
