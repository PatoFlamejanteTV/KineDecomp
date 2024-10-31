package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterConfigModule_ProvidesDisplayMetricsFactory implements c<DisplayMetrics> {

    /* renamed from: a */
    private final InflaterConfigModule f17657a;

    /* renamed from: b */
    private final Provider<Application> f17658b;

    public InflaterConfigModule_ProvidesDisplayMetricsFactory(InflaterConfigModule inflaterConfigModule, Provider<Application> provider) {
        this.f17657a = inflaterConfigModule;
        this.f17658b = provider;
    }

    public static c<DisplayMetrics> a(InflaterConfigModule inflaterConfigModule, Provider<Application> provider) {
        return new InflaterConfigModule_ProvidesDisplayMetricsFactory(inflaterConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public DisplayMetrics get() {
        DisplayMetrics a2 = this.f17657a.a(this.f17658b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
