package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class GrpcClient {

    /* renamed from: a */
    private final InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub f17766a;

    @Inject
    public GrpcClient(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub inAppMessagingSdkServingBlockingStub) {
        this.f17766a = inAppMessagingSdkServingBlockingStub;
    }

    public FetchEligibleCampaignsResponse a(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
        return this.f17766a.a(fetchEligibleCampaignsRequest);
    }
}
