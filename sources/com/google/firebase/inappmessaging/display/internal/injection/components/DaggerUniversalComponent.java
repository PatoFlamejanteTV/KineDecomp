package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesDisplayMetricsFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalLandscapeConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalPortraitConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory;
import d.a.e;
import d.a.f;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class DaggerUniversalComponent implements UniversalComponent {

    /* renamed from: a, reason: collision with root package name */
    private Provider<Application> f17637a;

    /* renamed from: b, reason: collision with root package name */
    private InflaterConfigModule f17638b;

    /* renamed from: c, reason: collision with root package name */
    private Provider<FiamWindowManager> f17639c;

    /* renamed from: d, reason: collision with root package name */
    private Provider<BindingWrapperFactory> f17640d;

    /* renamed from: e, reason: collision with root package name */
    private Provider<DisplayMetrics> f17641e;

    /* renamed from: f, reason: collision with root package name */
    private Provider<InAppMessageLayoutConfig> f17642f;

    /* renamed from: g, reason: collision with root package name */
    private Provider<InAppMessageLayoutConfig> f17643g;

    /* renamed from: h, reason: collision with root package name */
    private Provider<InAppMessageLayoutConfig> f17644h;
    private Provider<InAppMessageLayoutConfig> i;
    private Provider<InAppMessageLayoutConfig> j;
    private Provider<InAppMessageLayoutConfig> k;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private ApplicationModule f17645a;

        /* renamed from: b, reason: collision with root package name */
        private InflaterConfigModule f17646b;

        private Builder() {
        }

        public UniversalComponent a() {
            if (this.f17645a != null) {
                if (this.f17646b == null) {
                    this.f17646b = new InflaterConfigModule();
                }
                return new DaggerUniversalComponent(this);
            }
            throw new IllegalStateException(ApplicationModule.class.getCanonicalName() + " must be set");
        }

        public Builder a(ApplicationModule applicationModule) {
            f.a(applicationModule);
            this.f17645a = applicationModule;
            return this;
        }
    }

    private void a(Builder builder) {
        this.f17637a = d.a.b.a(ApplicationModule_ProvidesApplicationFactory.a(builder.f17645a));
        this.f17638b = builder.f17646b;
        this.f17639c = d.a.b.a(FiamWindowManager_Factory.a());
        this.f17640d = d.a.b.a(BindingWrapperFactory_Factory.a(this.f17637a));
        this.f17641e = InflaterConfigModule_ProvidesDisplayMetricsFactory.a(builder.f17646b, this.f17637a);
        this.f17642f = InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory.a(builder.f17646b, this.f17641e);
        this.f17643g = InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory.a(builder.f17646b, this.f17641e);
        this.f17644h = InflaterConfigModule_ProvidesModalLandscapeConfigFactory.a(builder.f17646b, this.f17641e);
        this.i = InflaterConfigModule_ProvidesModalPortraitConfigFactory.a(builder.f17646b, this.f17641e);
        this.j = InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory.a(builder.f17646b, this.f17641e);
        this.k = InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory.a(builder.f17646b, this.f17641e);
    }

    public static Builder e() {
        return new Builder();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public Application b() {
        return this.f17637a.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public Map<String, Provider<InAppMessageLayoutConfig>> c() {
        e a2 = e.a(6);
        a2.a("IMAGE_ONLY_PORTRAIT", this.f17642f);
        a2.a("IMAGE_ONLY_LANDSCAPE", this.f17643g);
        a2.a("MODAL_LANDSCAPE", this.f17644h);
        a2.a("MODAL_PORTRAIT", this.i);
        a2.a("BANNER_PORTRAIT", this.j);
        a2.a("BANNER_LANDSCAPE", this.k);
        return a2.a();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public BindingWrapperFactory d() {
        return this.f17640d.get();
    }

    private DaggerUniversalComponent(Builder builder) {
        a(builder);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public FiamWindowManager a() {
        return this.f17639c.get();
    }
}
