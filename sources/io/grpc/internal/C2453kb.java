package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* compiled from: InternalSubchannel.java */
/* renamed from: io.grpc.internal.kb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2453kb extends Ma {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ClientStreamListener f27655a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2457lb f27656b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2453kb(C2457lb c2457lb, ClientStreamListener clientStreamListener) {
        this.f27656b = c2457lb;
        this.f27655a = clientStreamListener;
    }

    @Override // io.grpc.internal.Ma, io.grpc.internal.ClientStreamListener
    public void a(Status status, io.grpc.P p) {
        C c2;
        c2 = this.f27656b.f27665b.f27690b;
        c2.a(status.g());
        super.a(status, p);
    }

    @Override // io.grpc.internal.Ma
    protected ClientStreamListener b() {
        return this.f27655a;
    }

    @Override // io.grpc.internal.Ma, io.grpc.internal.ClientStreamListener
    public void a(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
        C c2;
        c2 = this.f27656b.f27665b.f27690b;
        c2.a(status.g());
        super.a(status, rpcProgress, p);
    }
}
