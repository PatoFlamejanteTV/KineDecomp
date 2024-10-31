package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.oa */
/* loaded from: classes3.dex */
class RunnableC2468oa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f27707a;

    /* renamed from: b */
    final /* synthetic */ Ea f27708b;

    public RunnableC2468oa(Ea ea, boolean z) {
        this.f27708b = ea;
        this.f27707a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27708b.f27264c;
        x.a(this.f27707a);
    }
}
