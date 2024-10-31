package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.qa */
/* loaded from: classes3.dex */
class RunnableC2476qa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f27722a;

    /* renamed from: b */
    final /* synthetic */ Ea f27723b;

    public RunnableC2476qa(Ea ea, int i) {
        this.f27723b = ea;
        this.f27722a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27723b.f27264c;
        x.b(this.f27722a);
    }
}
