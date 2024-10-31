package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesModalPortraitConfigFactory implements c<InAppMessageLayoutConfig> {

    /* renamed from: a */
    private final InflaterConfigModule f17663a;

    /* renamed from: b */
    private final Provider<DisplayMetrics> f17664b;

    public InflaterConfigModule_ProvidesModalPortraitConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.f17663a = inflaterConfigModule;
        this.f17664b = provider;
    }

    public static c<InAppMessageLayoutConfig> a(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesModalPortraitConfigFactory(inflaterConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        InAppMessageLayoutConfig e2 = this.f17663a.e(this.f17664b.get());
        f.a(e2, "Cannot return null from a non-@Nullable @Provides method");
        return e2;
    }
}
