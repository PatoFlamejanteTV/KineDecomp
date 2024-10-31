package io.grpc;

import io.grpc.AbstractC2408g;

/* compiled from: ForwardingClientCallListener.java */
/* loaded from: classes3.dex */
public abstract class B<RespT> extends W<RespT> {

    /* compiled from: ForwardingClientCallListener.java */
    /* loaded from: classes3.dex */
    public static abstract class a<RespT> extends B<RespT> {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractC2408g.a<RespT> f27073a;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(AbstractC2408g.a<RespT> aVar) {
            this.f27073a = aVar;
        }

        @Override // io.grpc.B, io.grpc.W, io.grpc.AbstractC2408g.a
        public /* bridge */ /* synthetic */ void a(Status status, P p) {
            super.a(status, p);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.W
        public AbstractC2408g.a<RespT> b() {
            return this.f27073a;
        }

        @Override // io.grpc.B, io.grpc.W
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // io.grpc.B, io.grpc.W, io.grpc.AbstractC2408g.a
        public /* bridge */ /* synthetic */ void a(P p) {
            super.a(p);
        }

        @Override // io.grpc.B, io.grpc.W, io.grpc.AbstractC2408g.a
        public /* bridge */ /* synthetic */ void a() {
            super.a();
        }
    }

    @Override // io.grpc.W, io.grpc.AbstractC2408g.a
    public /* bridge */ /* synthetic */ void a(Status status, P p) {
        super.a(status, p);
    }

    @Override // io.grpc.W
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.grpc.W, io.grpc.AbstractC2408g.a
    public /* bridge */ /* synthetic */ void a(P p) {
        super.a(p);
    }

    @Override // io.grpc.W, io.grpc.AbstractC2408g.a
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.AbstractC2408g.a
    public void a(RespT respt) {
        b().a((AbstractC2408g.a<?>) respt);
    }
}
