package io.grpc.internal;

import io.grpc.internal.C2461mb;

/* compiled from: InternalSubchannel.java */
/* renamed from: io.grpc.internal.lb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2457lb extends La {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ X f27664a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2461mb.a f27665b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2457lb(C2461mb.a aVar, X x) {
        this.f27665b = aVar;
        this.f27664a = x;
    }

    @Override // io.grpc.internal.La, io.grpc.internal.X
    public void a(ClientStreamListener clientStreamListener) {
        C c2;
        c2 = this.f27665b.f27690b;
        c2.b();
        super.a(new C2453kb(this, clientStreamListener));
    }

    @Override // io.grpc.internal.La
    protected X b() {
        return this.f27664a;
    }
}
