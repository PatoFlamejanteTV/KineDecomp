package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.sa */
/* loaded from: classes3.dex */
class RunnableC2483sa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f27734a;

    /* renamed from: b */
    final /* synthetic */ Ea f27735b;

    public RunnableC2483sa(Ea ea, String str) {
        this.f27735b = ea;
        this.f27734a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27735b.f27264c;
        x.a(this.f27734a);
    }
}
