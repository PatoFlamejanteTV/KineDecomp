package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.va */
/* loaded from: classes3.dex */
class RunnableC2495va implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Ea f27752a;

    public RunnableC2495va(Ea ea) {
        this.f27752a = ea;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27752a.f27264c;
        x.flush();
    }
}
