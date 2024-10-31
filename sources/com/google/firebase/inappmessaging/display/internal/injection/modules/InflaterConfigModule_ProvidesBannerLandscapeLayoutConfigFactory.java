package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory implements c<InAppMessageLayoutConfig> {

    /* renamed from: a */
    private final InflaterConfigModule f17653a;

    /* renamed from: b */
    private final Provider<DisplayMetrics> f17654b;

    public InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.f17653a = inflaterConfigModule;
        this.f17654b = provider;
    }

    public static c<InAppMessageLayoutConfig> a(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory(inflaterConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        InAppMessageLayoutConfig a2 = this.f17653a.a(this.f17654b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}