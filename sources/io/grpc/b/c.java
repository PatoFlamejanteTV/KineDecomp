package io.grpc.b;

import com.google.common.base.Preconditions;
import io.grpc.A;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.InterfaceC2409h;
import io.grpc.MethodDescriptor;
import io.grpc.P;

/* compiled from: MetadataUtils.java */
/* loaded from: classes3.dex */
public final class c {

    /* compiled from: MetadataUtils.java */
    /* loaded from: classes3.dex */
    private static final class a implements InterfaceC2409h {

        /* renamed from: a, reason: collision with root package name */
        private final P f27169a;

        /* compiled from: MetadataUtils.java */
        /* renamed from: io.grpc.b.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private final class C0155a<ReqT, RespT> extends A.a<ReqT, RespT> {
            C0155a(AbstractC2408g<ReqT, RespT> abstractC2408g) {
                super(abstractC2408g);
            }

            @Override // io.grpc.A, io.grpc.AbstractC2408g
            public void a(AbstractC2408g.a<RespT> aVar, P p) {
                p.a(a.this.f27169a);
                super.a(aVar, p);
            }
        }

        a(P p) {
            Preconditions.a(p, p);
            this.f27169a = p;
        }

        @Override // io.grpc.InterfaceC2409h
        public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
            return new C0155a(abstractC2407f.a(methodDescriptor, c2406e));
        }
    }

    public static InterfaceC2409h a(P p) {
        return new a(p);
    }
}
