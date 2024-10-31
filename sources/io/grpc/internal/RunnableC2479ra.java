package io.grpc.internal;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.ra */
/* loaded from: classes3.dex */
class RunnableC2479ra implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f27726a;

    /* renamed from: b */
    final /* synthetic */ Ea f27727b;

    public RunnableC2479ra(Ea ea, int i) {
        this.f27727b = ea;
        this.f27726a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27727b.f27264c;
        x.c(this.f27726a);
    }
}
