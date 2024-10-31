package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class ApiClient {

    /* renamed from: a, reason: collision with root package name */
    private final GrpcClient f17710a;

    /* renamed from: b, reason: collision with root package name */
    private final FirebaseApp f17711b;

    /* renamed from: c, reason: collision with root package name */
    private final Application f17712c;

    /* renamed from: d, reason: collision with root package name */
    private final FirebaseInstanceId f17713d;

    /* renamed from: e, reason: collision with root package name */
    private final DataCollectionHelper f17714e;

    /* renamed from: f, reason: collision with root package name */
    private final Clock f17715f;

    public ApiClient(GrpcClient grpcClient, FirebaseApp firebaseApp, Application application, FirebaseInstanceId firebaseInstanceId, DataCollectionHelper dataCollectionHelper, Clock clock) {
        this.f17710a = grpcClient;
        this.f17711b = firebaseApp;
        this.f17712c = application;
        this.f17713d = firebaseInstanceId;
        this.f17714e = dataCollectionHelper;
        this.f17715f = clock;
    }

    @VisibleForTesting
    static FetchEligibleCampaignsResponse a() {
        return FetchEligibleCampaignsResponse.q().a(1L).build();
    }

    private ClientAppInfo b() {
        ClientAppInfo.Builder c2 = ClientAppInfo.r().c(this.f17711b.e().b());
        String a2 = this.f17713d.a();
        if (!TextUtils.isEmpty(a2)) {
            c2.a(a2);
        }
        String d2 = this.f17713d.d();
        if (!TextUtils.isEmpty(d2)) {
            c2.b(d2);
        }
        return c2.build();
    }

    private ClientSignalsProto.ClientSignals c() {
        ClientSignalsProto.ClientSignals.Builder d2 = ClientSignalsProto.ClientSignals.s().c(String.valueOf(Build.VERSION.SDK_INT)).b(Locale.getDefault().toString()).d(TimeZone.getDefault().getID());
        String d3 = d();
        if (!TextUtils.isEmpty(d3)) {
            d2.a(d3);
        }
        return d2.build();
    }

    @Nullable
    private String d() {
        try {
            return this.f17712c.getPackageManager().getPackageInfo(this.f17712c.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            Logging.b("Error finding versionName : " + e2.getMessage());
            return null;
        }
    }

    private boolean e() {
        return (TextUtils.isEmpty(this.f17713d.d()) || TextUtils.isEmpty(this.f17713d.a())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FetchEligibleCampaignsResponse a(CampaignImpressionList campaignImpressionList) {
        if (!this.f17714e.a()) {
            Logging.c("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return a();
        }
        if (!e()) {
            Logging.c("FirebaseInstanceId not yet initialized, not attempting campaign fetch from service.");
            return a();
        }
        Logging.c("Fetching campaigns from service.");
        return a(this.f17710a.a(FetchEligibleCampaignsRequest.r().a(this.f17711b.e().d()).a((Iterable<? extends CampaignImpression>) campaignImpressionList.n()).a(c()).a(b()).build()));
    }

    private FetchEligibleCampaignsResponse a(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return (fetchEligibleCampaignsResponse.o() < this.f17715f.now() + TimeUnit.MINUTES.toMillis(1L) || fetchEligibleCampaignsResponse.o() > this.f17715f.now() + TimeUnit.DAYS.toMillis(3L)) ? fetchEligibleCampaignsResponse.b().a(this.f17715f.now() + TimeUnit.DAYS.toMillis(1L)).build() : fetchEligibleCampaignsResponse;
    }
}
