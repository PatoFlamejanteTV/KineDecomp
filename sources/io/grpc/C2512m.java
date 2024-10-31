package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.MethodDescriptor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClientInterceptors.java */
/* renamed from: io.grpc.m */
/* loaded from: classes3.dex */
public class C2512m {

    /* renamed from: a */
    private static final AbstractC2408g<Object, Object> f27818a = new C2511l();

    /* compiled from: ClientInterceptors.java */
    /* renamed from: io.grpc.m$a */
    /* loaded from: classes3.dex */
    public static class a extends AbstractC2407f {

        /* renamed from: a */
        private final AbstractC2407f f27819a;

        /* renamed from: b */
        private final InterfaceC2409h f27820b;

        /* synthetic */ a(AbstractC2407f abstractC2407f, InterfaceC2409h interfaceC2409h, C2510k c2510k) {
            this(abstractC2407f, interfaceC2409h);
        }

        @Override // io.grpc.AbstractC2407f
        public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e) {
            return this.f27820b.a(methodDescriptor, c2406e, this.f27819a);
        }

        @Override // io.grpc.AbstractC2407f
        public String b() {
            return this.f27819a.b();
        }

        private a(AbstractC2407f abstractC2407f, InterfaceC2409h interfaceC2409h) {
            this.f27819a = abstractC2407f;
            Preconditions.a(interfaceC2409h, "interceptor");
            this.f27820b = interfaceC2409h;
        }
    }

    public static AbstractC2407f a(AbstractC2407f abstractC2407f, InterfaceC2409h... interfaceC2409hArr) {
        return a(abstractC2407f, (List<? extends InterfaceC2409h>) Arrays.asList(interfaceC2409hArr));
    }

    public static AbstractC2407f a(AbstractC2407f abstractC2407f, List<? extends InterfaceC2409h> list) {
        Preconditions.a(abstractC2407f, "channel");
        Iterator<? extends InterfaceC2409h> it = list.iterator();
        while (it.hasNext()) {
            abstractC2407f = new a(abstractC2407f, it.next(), null);
        }
        return abstractC2407f;
    }

    public static <WReqT, WRespT> InterfaceC2409h a(InterfaceC2409h interfaceC2409h, MethodDescriptor.b<WReqT> bVar, MethodDescriptor.b<WRespT> bVar2) {
        return new C2510k(bVar, bVar2, interfaceC2409h);
    }
}
