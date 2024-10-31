package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.xa */
/* loaded from: classes3.dex */
class RunnableC2501xa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Ea f27785a;

    public RunnableC2501xa(Ea ea) {
        this.f27785a = ea;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27785a.f27264c;
        x.a();
    }
}
