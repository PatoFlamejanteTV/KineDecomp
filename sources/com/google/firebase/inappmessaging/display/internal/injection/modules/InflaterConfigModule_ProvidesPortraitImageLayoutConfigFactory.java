package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory implements c<InAppMessageLayoutConfig> {

    /* renamed from: a */
    private final InflaterConfigModule f17665a;

    /* renamed from: b */
    private final Provider<DisplayMetrics> f17666b;

    public InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.f17665a = inflaterConfigModule;
        this.f17666b = provider;
    }

    public static c<InAppMessageLayoutConfig> a(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(inflaterConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        InAppMessageLayoutConfig f2 = this.f17665a.f(this.f17666b.get());
        f.a(f2, "Cannot return null from a non-@Nullable @Provides method");
        return f2;
    }
}
