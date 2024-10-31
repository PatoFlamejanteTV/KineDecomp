package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import io.grpc.AbstractC2407f;
import io.grpc.InterfaceC2404c;
import io.grpc.MethodDescriptor;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class InAppMessagingSdkServingGrpc {

    /* renamed from: a */
    @Deprecated
    public static final MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> f18325a = b();

    /* renamed from: b */
    private static volatile MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> f18326b;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class InAppMessagingSdkServingBlockingStub extends io.grpc.b.a<InAppMessagingSdkServingBlockingStub> {
        /* synthetic */ InAppMessagingSdkServingBlockingStub(AbstractC2407f abstractC2407f, f fVar) {
            this(abstractC2407f);
        }

        public FetchEligibleCampaignsResponse a(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return (FetchEligibleCampaignsResponse) io.grpc.b.b.a(b(), (MethodDescriptor<FetchEligibleCampaignsRequest, RespT>) InAppMessagingSdkServingGrpc.a(), a(), fetchEligibleCampaignsRequest);
        }

        private InAppMessagingSdkServingBlockingStub(AbstractC2407f abstractC2407f) {
            super(abstractC2407f);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class InAppMessagingSdkServingFutureStub extends io.grpc.b.a<InAppMessagingSdkServingFutureStub> {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static abstract class InAppMessagingSdkServingImplBase implements InterfaceC2404c {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class InAppMessagingSdkServingStub extends io.grpc.b.a<InAppMessagingSdkServingStub> {
    }

    private InAppMessagingSdkServingGrpc() {
    }

    static /* synthetic */ MethodDescriptor a() {
        return b();
    }

    private static MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> b() {
        MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> methodDescriptor = f18326b;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingSdkServingGrpc.class) {
                methodDescriptor = f18326b;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", "FetchEligibleCampaigns"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(FetchEligibleCampaignsRequest.o()));
                    g2.b(io.grpc.a.a.d.a(FetchEligibleCampaignsResponse.n()));
                    methodDescriptor = g2.a();
                    f18326b = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static InAppMessagingSdkServingBlockingStub a(AbstractC2407f abstractC2407f) {
        return new InAppMessagingSdkServingBlockingStub(abstractC2407f);
    }
}
