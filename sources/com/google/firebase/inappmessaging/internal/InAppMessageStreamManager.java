package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class InAppMessageStreamManager {

    /* renamed from: a, reason: collision with root package name */
    private final io.reactivex.b.a<String> f17778a;

    /* renamed from: b, reason: collision with root package name */
    private final CampaignCacheClient f17779b;

    /* renamed from: c, reason: collision with root package name */
    private final Clock f17780c;

    /* renamed from: d, reason: collision with root package name */
    private final ApiClient f17781d;

    /* renamed from: e, reason: collision with root package name */
    private final Schedulers f17782e;

    /* renamed from: f, reason: collision with root package name */
    private final ImpressionStorageClient f17783f;

    /* renamed from: g, reason: collision with root package name */
    private final RateLimiterClient f17784g;

    /* renamed from: h, reason: collision with root package name */
    private final RateLimit f17785h;
    private final AnalyticsEventsManager i;
    private final TestDeviceHelper j;

    @Inject
    public InAppMessageStreamManager(@AppForeground io.reactivex.b.a<String> aVar, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper) {
        this.f17778a = aVar;
        this.f17779b = campaignCacheClient;
        this.f17780c = clock;
        this.f17781d = apiClient;
        this.i = analyticsEventsManager;
        this.f17782e = schedulers;
        this.f17783f = impressionStorageClient;
        this.f17784g = rateLimiterClient;
        this.f17785h = rateLimit;
        this.j = testDeviceHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CampaignProto.ThickContent a(CampaignProto.ThickContent thickContent, Boolean bool) throws Exception {
        return thickContent;
    }

    private static boolean a(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.o() != null && triggeringCondition.o().o().toString().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, CampaignProto.ThickContent thickContent) {
        if (a(str) && thickContent.o()) {
            return true;
        }
        for (CommonTypesProto.TriggeringCondition triggeringCondition : thickContent.r()) {
            if (b(triggeringCondition, str) || a(triggeringCondition, str)) {
                Logging.a(String.format("The event %s is contained in the list of triggers", str));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CampaignProto.ThickContent c(CampaignProto.ThickContent thickContent, Boolean bool) throws Exception {
        return thickContent;
    }

    private boolean c(String str) {
        if (this.j.a()) {
            return a(str);
        }
        return this.j.b();
    }

    private static boolean a(Clock clock, CampaignProto.VanillaCampaignPayload vanillaCampaignPayload) {
        long q = vanillaCampaignPayload.q();
        long n = vanillaCampaignPayload.n();
        long now = clock.now();
        return now > q && now < n;
    }

    public static boolean a(String str) {
        return str.equals("ON_FOREGROUND");
    }

    private static boolean b(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.p() != null && triggeringCondition.p().toString().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.i<CampaignProto.ThickContent> c(String str, CampaignProto.ThickContent thickContent) {
        if (!thickContent.o() && a(str)) {
            return this.f17784g.b(this.f17785h).b(aa.a()).a(io.reactivex.s.a(false)).a(ba.a()).d(ca.a(thickContent));
        }
        return io.reactivex.i.b(thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(CampaignProto.ThickContent thickContent, CampaignProto.ThickContent thickContent2) {
        if (thickContent.o() && !thickContent2.o()) {
            return -1;
        }
        if (!thickContent2.o() || thickContent.o()) {
            return Integer.compare(thickContent.q().o(), thickContent2.q().o());
        }
        return 1;
    }

    public io.reactivex.e<TriggeredInAppMessage> a() {
        return io.reactivex.e.a(this.f17778a, this.i.a()).a(L.a()).a(this.f17782e.a()).a(X.a(this)).a(this.f17782e.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g.b.a a(InAppMessageStreamManager inAppMessageStreamManager, String str) throws Exception {
        io.reactivex.i<FetchEligibleCampaignsResponse> a2 = inAppMessageStreamManager.f17779b.a().b(C.a()).a(D.a()).a(io.reactivex.i.b());
        io.reactivex.c.e a3 = E.a(inAppMessageStreamManager);
        io.reactivex.c.f<? super FetchEligibleCampaignsResponse, ? extends io.reactivex.k<? extends R>> a4 = I.a(inAppMessageStreamManager, str, F.a(inAppMessageStreamManager), G.a(inAppMessageStreamManager, str), H.a());
        io.reactivex.i<CampaignImpressionList> a5 = inAppMessageStreamManager.f17783f.a().a(J.a()).a((io.reactivex.i<CampaignImpressionList>) CampaignImpressionList.o()).a(io.reactivex.i.b(CampaignImpressionList.o()));
        io.reactivex.c.f<? super CampaignImpressionList, ? extends io.reactivex.k<? extends R>> a6 = K.a(inAppMessageStreamManager);
        if (inAppMessageStreamManager.c(str)) {
            Logging.c(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", Boolean.valueOf(inAppMessageStreamManager.j.b()), Boolean.valueOf(inAppMessageStreamManager.j.a())));
            return a5.a(a6).a((io.reactivex.c.f<? super R, ? extends io.reactivex.k<? extends R>>) a4).e();
        }
        Logging.a("Attempting to fetch campaigns using cache");
        return a2.b(a5.a(a6).b((io.reactivex.c.e<? super R>) a3)).a(a4).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ io.reactivex.i b(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) throws Exception {
        io.reactivex.i b2 = io.reactivex.i.a(M.a(inAppMessageStreamManager, campaignImpressionList)).b(N.a());
        AnalyticsEventsManager analyticsEventsManager = inAppMessageStreamManager.i;
        analyticsEventsManager.getClass();
        io.reactivex.i b3 = b2.b(O.a(analyticsEventsManager));
        TestDeviceHelper testDeviceHelper = inAppMessageStreamManager.j;
        testDeviceHelper.getClass();
        return b3.b(P.a(testDeviceHelper)).a(Q.a()).a((io.reactivex.k) io.reactivex.i.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(InAppMessageStreamManager inAppMessageStreamManager, CampaignProto.ThickContent thickContent) throws Exception {
        return inAppMessageStreamManager.j.b() || a(inAppMessageStreamManager.f17780c, thickContent.s());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ io.reactivex.i a(InAppMessageStreamManager inAppMessageStreamManager, CampaignProto.ThickContent thickContent) throws Exception {
        if (thickContent.o()) {
            return io.reactivex.i.b(thickContent);
        }
        return inAppMessageStreamManager.f17783f.a(thickContent.s().o()).a(S.a()).a(io.reactivex.s.a(false)).b(T.a(thickContent)).a(U.a()).d(V.a(thickContent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ io.reactivex.i a(CampaignProto.ThickContent thickContent) throws Exception {
        int i = ha.f17863a[thickContent.n().q().ordinal()];
        if (i == 1) {
            return io.reactivex.i.b(thickContent);
        }
        if (i == 2) {
            return io.reactivex.i.b(thickContent);
        }
        if (i != 3) {
            return io.reactivex.i.b();
        }
        return io.reactivex.i.b(thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.i<TriggeredInAppMessage> a(String str, io.reactivex.c.f<CampaignProto.ThickContent, io.reactivex.i<CampaignProto.ThickContent>> fVar, io.reactivex.c.f<CampaignProto.ThickContent, io.reactivex.i<CampaignProto.ThickContent>> fVar2, io.reactivex.c.f<CampaignProto.ThickContent, io.reactivex.i<CampaignProto.ThickContent>> fVar3, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return io.reactivex.e.a((Iterable) fetchEligibleCampaignsResponse.p()).a(da.a()).a(ea.a(this)).a(fa.a(str)).c(fVar).c(fVar2).c(fVar3).a(ga.a()).c().a(B.a(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.i<TriggeredInAppMessage> a(CampaignProto.ThickContent thickContent, String str) {
        InAppMessage a2 = ProtoMarshallerClient.a(thickContent.n(), thickContent.s().o(), thickContent.s().p(), thickContent.o());
        if (a2.getMessageType().equals(MessageType.UNSUPPORTED)) {
            return io.reactivex.i.b();
        }
        return io.reactivex.i.b(new TriggeredInAppMessage(a2, str));
    }
}
