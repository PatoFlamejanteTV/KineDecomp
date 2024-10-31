package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesModalLandscapeConfigFactory implements c<InAppMessageLayoutConfig> {

    /* renamed from: a */
    private final InflaterConfigModule f17661a;

    /* renamed from: b */
    private final Provider<DisplayMetrics> f17662b;

    public InflaterConfigModule_ProvidesModalLandscapeConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.f17661a = inflaterConfigModule;
        this.f17662b = provider;
    }

    public static c<InAppMessageLayoutConfig> a(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesModalLandscapeConfigFactory(inflaterConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        InAppMessageLayoutConfig d2 = this.f17661a.d(this.f17662b.get());
        f.a(d2, "Cannot return null from a non-@Nullable @Provides method");
        return d2;
    }
}
