package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory implements c<InAppMessageLayoutConfig> {

    /* renamed from: a */
    private final InflaterConfigModule f17655a;

    /* renamed from: b */
    private final Provider<DisplayMetrics> f17656b;

    public InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.f17655a = inflaterConfigModule;
        this.f17656b = provider;
    }

    public static c<InAppMessageLayoutConfig> a(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory(inflaterConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        InAppMessageLayoutConfig b2 = this.f17655a.b(this.f17656b.get());
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
