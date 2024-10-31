package io.grpc.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSubchannel.java */
/* renamed from: io.grpc.internal.jb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2449jb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2424da f27646a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f27647b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2461mb f27648c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2449jb(C2461mb c2461mb, InterfaceC2424da interfaceC2424da, boolean z) {
        this.f27648c = c2461mb;
        this.f27646a = interfaceC2424da;
        this.f27647b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC2425db abstractC2425db;
        abstractC2425db = this.f27648c.t;
        abstractC2425db.a(this.f27646a, this.f27647b);
    }
}
