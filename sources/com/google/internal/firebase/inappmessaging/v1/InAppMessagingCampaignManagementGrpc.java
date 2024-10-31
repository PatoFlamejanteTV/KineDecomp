package com.google.internal.firebase.inappmessaging.v1;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.protobuf.Empty;
import io.grpc.InterfaceC2404c;
import io.grpc.MethodDescriptor;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class InAppMessagingCampaignManagementGrpc {

    /* renamed from: b, reason: collision with root package name */
    private static volatile MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> f18257b;

    /* renamed from: d, reason: collision with root package name */
    private static volatile MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> f18259d;

    /* renamed from: f, reason: collision with root package name */
    private static volatile MethodDescriptor<DeleteCampaignRequest, Empty> f18261f;

    /* renamed from: h, reason: collision with root package name */
    private static volatile MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> f18263h;
    private static volatile MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> j;
    private static volatile MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> l;
    private static volatile MethodDescriptor<TestCampaignOnDeviceRequest, Empty> n;

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> f18256a = a();

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> f18258c = g();

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final MethodDescriptor<DeleteCampaignRequest, Empty> f18260e = b();

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> f18262g = d();

    @Deprecated
    public static final MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> i = e();

    @Deprecated
    public static final MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> k = c();

    @Deprecated
    public static final MethodDescriptor<TestCampaignOnDeviceRequest, Empty> m = f();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class InAppMessagingCampaignManagementBlockingStub extends io.grpc.b.a<InAppMessagingCampaignManagementBlockingStub> {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class InAppMessagingCampaignManagementFutureStub extends io.grpc.b.a<InAppMessagingCampaignManagementFutureStub> {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static abstract class InAppMessagingCampaignManagementImplBase implements InterfaceC2404c {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class InAppMessagingCampaignManagementStub extends io.grpc.b.a<InAppMessagingCampaignManagementStub> {
    }

    private InAppMessagingCampaignManagementGrpc() {
    }

    private static MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> a() {
        MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> methodDescriptor = f18257b;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = f18257b;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "CreateCampaign"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(CreateCampaignRequest.o()));
                    g2.b(io.grpc.a.a.d.a(CampaignProto.Campaign.p()));
                    methodDescriptor = g2.a();
                    f18257b = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    private static MethodDescriptor<DeleteCampaignRequest, Empty> b() {
        MethodDescriptor<DeleteCampaignRequest, Empty> methodDescriptor = f18261f;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = f18261f;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "DeleteCampaign"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(DeleteCampaignRequest.o()));
                    g2.b(io.grpc.a.a.d.a(Empty.n()));
                    methodDescriptor = g2.a();
                    f18261f = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    private static MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> c() {
        MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> methodDescriptor = l;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = l;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "GetConditionEstimation"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(GetConditionEstimationRequest.n()));
                    g2.b(io.grpc.a.a.d.a(GetConditionEstimationResponse.n()));
                    methodDescriptor = g2.a();
                    l = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    private static MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> d() {
        MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> methodDescriptor = f18263h;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = f18263h;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "ListCampaigns"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(ListCampaignsRequest.n()));
                    g2.b(io.grpc.a.a.d.a(ListCampaignsResponse.n()));
                    methodDescriptor = g2.a();
                    f18263h = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    private static MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> e() {
        MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> methodDescriptor = j;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = j;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "RolloutExperimentalCampaign"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(RolloutExperimentRequest.n()));
                    g2.b(io.grpc.a.a.d.a(RolloutExperimentResponse.n()));
                    methodDescriptor = g2.a();
                    j = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    private static MethodDescriptor<TestCampaignOnDeviceRequest, Empty> f() {
        MethodDescriptor<TestCampaignOnDeviceRequest, Empty> methodDescriptor = n;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = n;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "TestCampaignOnDevice"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(TestCampaignOnDeviceRequest.o()));
                    g2.b(io.grpc.a.a.d.a(Empty.n()));
                    methodDescriptor = g2.a();
                    n = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    private static MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> g() {
        MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> methodDescriptor = f18259d;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingCampaignManagementGrpc.class) {
                methodDescriptor = f18259d;
                if (methodDescriptor == null) {
                    MethodDescriptor.a g2 = MethodDescriptor.g();
                    g2.a(MethodDescriptor.MethodType.UNARY);
                    g2.a(MethodDescriptor.a("google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement", "UpdateCampaign"));
                    g2.c(true);
                    g2.a(io.grpc.a.a.d.a(UpdateCampaignRequest.o()));
                    g2.b(io.grpc.a.a.d.a(CampaignProto.Campaign.p()));
                    methodDescriptor = g2.a();
                    f18259d = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }
}
