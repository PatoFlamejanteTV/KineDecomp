package io.grpc.internal;

/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
class Bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Db f27207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bb(Db db) {
        this.f27207a = db;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27207a.f27228a.d();
    }
}
