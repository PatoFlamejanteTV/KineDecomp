package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory implements d.a.c<io.reactivex.b.a<String>> {

    /* renamed from: a */
    private final ForegroundFlowableModule f17942a;

    /* renamed from: b */
    private final Provider<Application> f17943b;

    /* renamed from: c */
    private final Provider<ForegroundNotifier> f17944c;

    public ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(ForegroundFlowableModule foregroundFlowableModule, Provider<Application> provider, Provider<ForegroundNotifier> provider2) {
        this.f17942a = foregroundFlowableModule;
        this.f17943b = provider;
        this.f17944c = provider2;
    }

    public static d.a.c<io.reactivex.b.a<String>> a(ForegroundFlowableModule foregroundFlowableModule, Provider<Application> provider, Provider<ForegroundNotifier> provider2) {
        return new ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(foregroundFlowableModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public io.reactivex.b.a<String> get() {
        io.reactivex.b.a<String> a2 = this.f17942a.a(this.f17943b.get(), this.f17944c.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
