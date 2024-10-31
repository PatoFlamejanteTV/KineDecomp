package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.GrpcClient_Factory;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstanceIdFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule_ProvidesClearcutClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.AbstractC2407f;
import io.grpc.P;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class DaggerAppComponent implements AppComponent {
    private ApiClientModule A;

    /* renamed from: a, reason: collision with root package name */
    private Provider<io.reactivex.b.a<String>> f17867a;

    /* renamed from: b, reason: collision with root package name */
    private Provider<CampaignCacheClient> f17868b;

    /* renamed from: c, reason: collision with root package name */
    private Provider<Clock> f17869c;

    /* renamed from: d, reason: collision with root package name */
    private Provider<AbstractC2407f> f17870d;

    /* renamed from: e, reason: collision with root package name */
    private Provider<P> f17871e;

    /* renamed from: f, reason: collision with root package name */
    private Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> f17872f;

    /* renamed from: g, reason: collision with root package name */
    private Provider<GrpcClient> f17873g;

    /* renamed from: h, reason: collision with root package name */
    private Provider<Application> f17874h;
    private Provider<SharedPreferencesUtils> i;
    private Provider<Subscriber> j;
    private Provider<DataCollectionHelper> k;
    private Provider<ApiClient> l;
    private Provider<AnalyticsEventsManager> m;
    private Provider<Schedulers> n;
    private Provider<ImpressionStorageClient> o;
    private Provider<RateLimiterClient> p;
    private Provider<RateLimit> q;
    private Provider<TestDeviceHelper> r;
    private Provider<InAppMessageStreamManager> s;
    private Provider<ClearcutLogger> t;
    private Provider<AnalyticsConnector> u;
    private Provider<FirebaseInstanceId> v;
    private Provider<MetricsLoggerClient> w;
    private Provider<DisplayCallbacksFactory> x;
    private Provider<FirebaseInAppMessaging> y;
    private UniversalComponent z;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private GrpcClientModule f17875a;

        /* renamed from: b, reason: collision with root package name */
        private ApiClientModule f17876b;

        /* renamed from: c, reason: collision with root package name */
        private ClearcutLoggerClientModule f17877c;

        /* renamed from: d, reason: collision with root package name */
        private UniversalComponent f17878d;

        private Builder() {
        }

        public AppComponent a() {
            if (this.f17875a != null) {
                if (this.f17876b != null) {
                    if (this.f17877c != null) {
                        if (this.f17878d != null) {
                            return new DaggerAppComponent(this);
                        }
                        throw new IllegalStateException(UniversalComponent.class.getCanonicalName() + " must be set");
                    }
                    throw new IllegalStateException(ClearcutLoggerClientModule.class.getCanonicalName() + " must be set");
                }
                throw new IllegalStateException(ApiClientModule.class.getCanonicalName() + " must be set");
            }
            throw new IllegalStateException(GrpcClientModule.class.getCanonicalName() + " must be set");
        }

        public Builder a(ApiClientModule apiClientModule) {
            d.a.f.a(apiClientModule);
            this.f17876b = apiClientModule;
            return this;
        }

        public Builder a(GrpcClientModule grpcClientModule) {
            d.a.f.a(grpcClientModule);
            this.f17875a = grpcClientModule;
            return this;
        }

        public Builder a(ClearcutLoggerClientModule clearcutLoggerClientModule) {
            d.a.f.a(clearcutLoggerClientModule);
            this.f17877c = clearcutLoggerClientModule;
            return this;
        }

        public Builder a(UniversalComponent universalComponent) {
            d.a.f.a(universalComponent);
            this.f17878d = universalComponent;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class a implements Provider<AnalyticsConnector> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17879a;

        a(UniversalComponent universalComponent) {
            this.f17879a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AnalyticsConnector get() {
            AnalyticsConnector l = this.f17879a.l();
            d.a.f.a(l, "Cannot return null from a non-@Nullable component method");
            return l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class b implements Provider<AnalyticsEventsManager> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17880a;

        b(UniversalComponent universalComponent) {
            this.f17880a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AnalyticsEventsManager get() {
            AnalyticsEventsManager b2 = this.f17880a.b();
            d.a.f.a(b2, "Cannot return null from a non-@Nullable component method");
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class c implements Provider<io.reactivex.b.a<String>> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17881a;

        c(UniversalComponent universalComponent) {
            this.f17881a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public io.reactivex.b.a<String> get() {
            io.reactivex.b.a<String> e2 = this.f17881a.e();
            d.a.f.a(e2, "Cannot return null from a non-@Nullable component method");
            return e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class d implements Provider<RateLimit> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17882a;

        d(UniversalComponent universalComponent) {
            this.f17882a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public RateLimit get() {
            RateLimit a2 = this.f17882a.a();
            d.a.f.a(a2, "Cannot return null from a non-@Nullable component method");
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class e implements Provider<Application> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17883a;

        e(UniversalComponent universalComponent) {
            this.f17883a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Application get() {
            Application h2 = this.f17883a.h();
            d.a.f.a(h2, "Cannot return null from a non-@Nullable component method");
            return h2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class f implements Provider<CampaignCacheClient> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17884a;

        f(UniversalComponent universalComponent) {
            this.f17884a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public CampaignCacheClient get() {
            CampaignCacheClient k = this.f17884a.k();
            d.a.f.a(k, "Cannot return null from a non-@Nullable component method");
            return k;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class g implements Provider<Clock> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17885a;

        g(UniversalComponent universalComponent) {
            this.f17885a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Clock get() {
            Clock f2 = this.f17885a.f();
            d.a.f.a(f2, "Cannot return null from a non-@Nullable component method");
            return f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class h implements Provider<Subscriber> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17886a;

        h(UniversalComponent universalComponent) {
            this.f17886a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Subscriber get() {
            Subscriber i = this.f17886a.i();
            d.a.f.a(i, "Cannot return null from a non-@Nullable component method");
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class i implements Provider<AbstractC2407f> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17887a;

        i(UniversalComponent universalComponent) {
            this.f17887a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AbstractC2407f get() {
            AbstractC2407f g2 = this.f17887a.g();
            d.a.f.a(g2, "Cannot return null from a non-@Nullable component method");
            return g2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class j implements Provider<ImpressionStorageClient> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17888a;

        j(UniversalComponent universalComponent) {
            this.f17888a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ImpressionStorageClient get() {
            ImpressionStorageClient c2 = this.f17888a.c();
            d.a.f.a(c2, "Cannot return null from a non-@Nullable component method");
            return c2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class k implements Provider<RateLimiterClient> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17889a;

        k(UniversalComponent universalComponent) {
            this.f17889a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public RateLimiterClient get() {
            RateLimiterClient d2 = this.f17889a.d();
            d.a.f.a(d2, "Cannot return null from a non-@Nullable component method");
            return d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class l implements Provider<Schedulers> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17890a;

        l(UniversalComponent universalComponent) {
            this.f17890a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Schedulers get() {
            Schedulers j = this.f17890a.j();
            d.a.f.a(j, "Cannot return null from a non-@Nullable component method");
            return j;
        }
    }

    private void a(Builder builder) {
        this.f17867a = new c(builder.f17878d);
        this.f17868b = new f(builder.f17878d);
        this.f17869c = new g(builder.f17878d);
        this.f17870d = new i(builder.f17878d);
        this.f17871e = GrpcClientModule_ProvidesApiKeyHeadersFactory.a(builder.f17875a);
        this.f17872f = d.a.b.a(GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.a(builder.f17875a, this.f17870d, this.f17871e));
        this.f17873g = d.a.b.a(GrpcClient_Factory.a(this.f17872f));
        this.f17874h = new e(builder.f17878d);
        this.i = ApiClientModule_ProvidesSharedPreferencesUtilsFactory.a(builder.f17876b);
        this.j = new h(builder.f17878d);
        this.k = ApiClientModule_ProvidesDataCollectionHelperFactory.a(builder.f17876b, this.i, this.j);
        this.l = d.a.b.a(ApiClientModule_ProvidesApiClientFactory.a(builder.f17876b, this.f17873g, this.f17874h, this.k));
        this.m = new b(builder.f17878d);
        this.n = new l(builder.f17878d);
        this.o = new j(builder.f17878d);
        this.p = new k(builder.f17878d);
        this.q = new d(builder.f17878d);
        this.r = ApiClientModule_ProvidesTestDeviceHelperFactory.a(builder.f17876b, this.i);
        this.s = d.a.b.a(InAppMessageStreamManager_Factory.a(this.f17867a, this.f17868b, this.f17869c, this.l, this.m, this.n, this.o, this.p, this.q, this.r));
        this.t = d.a.b.a(ClearcutLoggerClientModule_ProvidesClearcutClientFactory.a(builder.f17877c, this.f17874h));
        this.u = new a(builder.f17878d);
        this.v = ApiClientModule_ProvidesFirebaseInstanceIdFactory.a(builder.f17876b);
        this.w = d.a.b.a(ClearcutLoggerClientModule_ProvidesApiClientFactory.a(builder.f17877c, this.t, this.u, this.v, this.f17869c));
        this.x = DisplayCallbacksFactory_Factory.a(this.o, this.f17869c, this.n, this.p, this.f17868b, this.q, this.w, this.k);
        this.y = d.a.b.a(FirebaseInAppMessaging_Factory.a(this.s, this.k, this.x));
        this.z = builder.f17878d;
        this.A = builder.f17876b;
    }

    public static Builder b() {
        return new Builder();
    }

    private DaggerAppComponent(Builder builder) {
        a(builder);
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent
    public FirebaseInAppMessaging a() {
        return this.y.get();
    }
}
