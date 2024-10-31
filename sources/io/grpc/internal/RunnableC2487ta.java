package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.ta */
/* loaded from: classes3.dex */
class RunnableC2487ta implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ClientStreamListener f27739a;

    /* renamed from: b */
    final /* synthetic */ Ea f27740b;

    public RunnableC2487ta(Ea ea, ClientStreamListener clientStreamListener) {
        this.f27740b = ea;
        this.f27739a = clientStreamListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27740b.f27264c;
        x.a(this.f27739a);
    }
}
