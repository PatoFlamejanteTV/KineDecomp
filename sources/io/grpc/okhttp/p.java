package io.grpc.okhttp;

import io.grpc.internal.C2471p;
import io.grpc.okhttp.q;

/* compiled from: OkHttpChannelBuilder.java */
/* loaded from: classes3.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2471p.a f27982a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ q.a f27983b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q.a aVar, C2471p.a aVar2) {
        this.f27983b = aVar;
        this.f27982a = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27982a.a();
    }
}
