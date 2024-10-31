package io.grpc;

import io.grpc.AbstractC2408g;
import javax.annotation.Nullable;

/* compiled from: ForwardingClientCall.java */
/* loaded from: classes3.dex */
public abstract class A<ReqT, RespT> extends V<ReqT, RespT> {

    /* compiled from: ForwardingClientCall.java */
    /* loaded from: classes3.dex */
    public static abstract class a<ReqT, RespT> extends A<ReqT, RespT> {

        /* renamed from: a */
        private final AbstractC2408g<ReqT, RespT> f27072a;

        public a(AbstractC2408g<ReqT, RespT> abstractC2408g) {
            this.f27072a = abstractC2408g;
        }

        @Override // io.grpc.A, io.grpc.V, io.grpc.AbstractC2408g
        public /* bridge */ /* synthetic */ void a(@Nullable String str, @Nullable Throwable th) {
            super.a(str, th);
        }

        @Override // io.grpc.V
        public AbstractC2408g<ReqT, RespT> b() {
            return this.f27072a;
        }

        @Override // io.grpc.A, io.grpc.V
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // io.grpc.A, io.grpc.V, io.grpc.AbstractC2408g
        public /* bridge */ /* synthetic */ void a() {
            super.a();
        }

        @Override // io.grpc.A, io.grpc.V, io.grpc.AbstractC2408g
        public /* bridge */ /* synthetic */ void a(int i) {
            super.a(i);
        }
    }

    @Override // io.grpc.V, io.grpc.AbstractC2408g
    public /* bridge */ /* synthetic */ void a(@Nullable String str, @Nullable Throwable th) {
        super.a(str, th);
    }

    @Override // io.grpc.V
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.grpc.V, io.grpc.AbstractC2408g
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // io.grpc.V, io.grpc.AbstractC2408g
    public /* bridge */ /* synthetic */ void a(int i) {
        super.a(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.AbstractC2408g
    public void a(AbstractC2408g.a<RespT> aVar, P p) {
        b().a((AbstractC2408g.a<?>) aVar, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.AbstractC2408g
    public void a(ReqT reqt) {
        b().a((AbstractC2408g<?, ?>) reqt);
    }
}
