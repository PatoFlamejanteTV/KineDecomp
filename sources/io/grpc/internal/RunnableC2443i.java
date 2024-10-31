package io.grpc.internal;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2443i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2463n f27630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2443i(C2463n c2463n) {
        this.f27630a = c2463n;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer messageDeframer;
        messageDeframer = this.f27630a.f27697b;
        messageDeframer.a();
    }
}
