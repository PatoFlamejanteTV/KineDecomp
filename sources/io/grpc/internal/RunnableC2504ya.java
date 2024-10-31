package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.ya */
/* loaded from: classes3.dex */
class RunnableC2504ya implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f27799a;

    /* renamed from: b */
    final /* synthetic */ Ea f27800b;

    public RunnableC2504ya(Ea ea, int i) {
        this.f27800b = ea;
        this.f27799a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27800b.f27264c;
        x.a(this.f27799a);
    }
}
