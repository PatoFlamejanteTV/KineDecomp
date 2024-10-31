package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient_Factory;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient_Factory;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient_Factory;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.Schedulers_Factory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesAnalyticsConnectorFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesSubsriberFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule_ProvidesForegroundFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesGrpcChannelFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesServiceHostFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesComputeSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesIOSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesMainThreadSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule_ProvidesSystemClockModuleFactory;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory;
import com.google.firebase.inappmessaging.model.RateLimit;
import d.a.f;
import io.grpc.AbstractC2407f;
import io.reactivex.r;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class DaggerUniversalComponent implements UniversalComponent {

    /* renamed from: a, reason: collision with root package name */
    private Provider<String> f17891a;

    /* renamed from: b, reason: collision with root package name */
    private Provider<AbstractC2407f> f17892b;

    /* renamed from: c, reason: collision with root package name */
    private Provider<r> f17893c;

    /* renamed from: d, reason: collision with root package name */
    private Provider<r> f17894d;

    /* renamed from: e, reason: collision with root package name */
    private Provider<r> f17895e;

    /* renamed from: f, reason: collision with root package name */
    private Provider<Schedulers> f17896f;

    /* renamed from: g, reason: collision with root package name */
    private Provider<Application> f17897g;

    /* renamed from: h, reason: collision with root package name */
    private Provider<ForegroundNotifier> f17898h;
    private Provider<io.reactivex.b.a<String>> i;
    private Provider<AnalyticsConnector> j;
    private Provider<AnalyticsEventsManager> k;
    private Provider<io.reactivex.b.a<String>> l;
    private Provider<Subscriber> m;
    private Provider<AnalyticsConnectorHandleManager> n;
    private Provider<ProtoStorageClient> o;
    private Provider<Clock> p;
    private Provider<CampaignCacheClient> q;
    private Provider<ProtoStorageClient> r;
    private Provider<ImpressionStorageClient> s;
    private SystemClockModule t;
    private Provider<ProtoMarshallerClient> u;
    private Provider<ProtoStorageClient> v;
    private Provider<RateLimiterClient> w;
    private RateLimitModule x;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private GrpcChannelModule f17899a;

        /* renamed from: b, reason: collision with root package name */
        private SchedulerModule f17900b;

        /* renamed from: c, reason: collision with root package name */
        private ApplicationModule f17901c;

        /* renamed from: d, reason: collision with root package name */
        private ForegroundNotifierModule f17902d;

        /* renamed from: e, reason: collision with root package name */
        private ForegroundFlowableModule f17903e;

        /* renamed from: f, reason: collision with root package name */
        private AppMeasurementModule f17904f;

        /* renamed from: g, reason: collision with root package name */
        private AnalyticsEventsModule f17905g;

        /* renamed from: h, reason: collision with root package name */
        private ProtoStorageClientModule f17906h;
        private SystemClockModule i;
        private RateLimitModule j;

        private Builder() {
        }

        public UniversalComponent a() {
            if (this.f17899a == null) {
                this.f17899a = new GrpcChannelModule();
            }
            if (this.f17900b == null) {
                this.f17900b = new SchedulerModule();
            }
            if (this.f17901c != null) {
                if (this.f17902d == null) {
                    this.f17902d = new ForegroundNotifierModule();
                }
                if (this.f17903e == null) {
                    this.f17903e = new ForegroundFlowableModule();
                }
                if (this.f17904f != null) {
                    if (this.f17905g == null) {
                        this.f17905g = new AnalyticsEventsModule();
                    }
                    if (this.f17906h == null) {
                        this.f17906h = new ProtoStorageClientModule();
                    }
                    if (this.i == null) {
                        this.i = new SystemClockModule();
                    }
                    if (this.j == null) {
                        this.j = new RateLimitModule();
                    }
                    return new DaggerUniversalComponent(this);
                }
                throw new IllegalStateException(AppMeasurementModule.class.getCanonicalName() + " must be set");
            }
            throw new IllegalStateException(ApplicationModule.class.getCanonicalName() + " must be set");
        }

        public Builder a(ApplicationModule applicationModule) {
            f.a(applicationModule);
            this.f17901c = applicationModule;
            return this;
        }

        public Builder a(AnalyticsEventsModule analyticsEventsModule) {
            f.a(analyticsEventsModule);
            this.f17905g = analyticsEventsModule;
            return this;
        }

        public Builder a(AppMeasurementModule appMeasurementModule) {
            f.a(appMeasurementModule);
            this.f17904f = appMeasurementModule;
            return this;
        }
    }

    private void a(Builder builder) {
        this.f17891a = d.a.b.a(GrpcChannelModule_ProvidesServiceHostFactory.a(builder.f17899a));
        this.f17892b = d.a.b.a(GrpcChannelModule_ProvidesGrpcChannelFactory.a(builder.f17899a, this.f17891a));
        this.f17893c = d.a.b.a(SchedulerModule_ProvidesIOSchedulerFactory.a(builder.f17900b));
        this.f17894d = d.a.b.a(SchedulerModule_ProvidesComputeSchedulerFactory.a(builder.f17900b));
        this.f17895e = d.a.b.a(SchedulerModule_ProvidesMainThreadSchedulerFactory.a(builder.f17900b));
        this.f17896f = d.a.b.a(Schedulers_Factory.a(this.f17893c, this.f17894d, this.f17895e));
        this.f17897g = d.a.b.a(ApplicationModule_ProvidesApplicationFactory.a(builder.f17901c));
        this.f17898h = d.a.b.a(ForegroundNotifierModule_ProvidesForegroundFactory.a(builder.f17902d));
        this.i = d.a.b.a(ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory.a(builder.f17903e, this.f17897g, this.f17898h));
        this.j = d.a.b.a(AppMeasurementModule_ProvidesAnalyticsConnectorFactory.a(builder.f17904f));
        this.k = d.a.b.a(AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory.a(builder.f17905g, this.j));
        this.l = d.a.b.a(AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory.a(builder.f17905g, this.k));
        this.m = d.a.b.a(AppMeasurementModule_ProvidesSubsriberFactory.a(builder.f17904f));
        this.n = d.a.b.a(AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory.a(builder.f17905g, this.k));
        this.o = d.a.b.a(ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory.a(builder.f17906h, this.f17897g));
        this.p = SystemClockModule_ProvidesSystemClockModuleFactory.a(builder.i);
        this.q = d.a.b.a(CampaignCacheClient_Factory.a(this.o, this.f17897g, this.p));
        this.r = d.a.b.a(ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory.a(builder.f17906h, this.f17897g));
        this.s = d.a.b.a(ImpressionStorageClient_Factory.a(this.r));
        this.t = builder.i;
        this.u = d.a.b.a(ProtoMarshallerClient_Factory.a());
        this.v = d.a.b.a(ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory.a(builder.f17906h, this.f17897g));
        this.w = d.a.b.a(RateLimiterClient_Factory.a(this.v, this.p));
        this.x = builder.j;
    }

    public static Builder m() {
        return new Builder();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AnalyticsEventsManager b() {
        return this.k.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ImpressionStorageClient c() {
        return this.s.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public RateLimiterClient d() {
        return this.w.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public io.reactivex.b.a<String> e() {
        return this.i.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Clock f() {
        Clock a2 = this.t.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AbstractC2407f g() {
        return this.f17892b.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Application h() {
        return this.f17897g.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Subscriber i() {
        return this.m.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Schedulers j() {
        return this.f17896f.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public CampaignCacheClient k() {
        return this.q.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AnalyticsConnector l() {
        return this.j.get();
    }

    private DaggerUniversalComponent(Builder builder) {
        a(builder);
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public RateLimit a() {
        RateLimit a2 = this.x.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
