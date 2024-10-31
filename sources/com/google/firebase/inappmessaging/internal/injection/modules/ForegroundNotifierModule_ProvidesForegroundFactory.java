package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ForegroundNotifierModule_ProvidesForegroundFactory implements d.a.c<ForegroundNotifier> {

    /* renamed from: a */
    private final ForegroundNotifierModule f17945a;

    public ForegroundNotifierModule_ProvidesForegroundFactory(ForegroundNotifierModule foregroundNotifierModule) {
        this.f17945a = foregroundNotifierModule;
    }

    public static d.a.c<ForegroundNotifier> a(ForegroundNotifierModule foregroundNotifierModule) {
        return new ForegroundNotifierModule_ProvidesForegroundFactory(foregroundNotifierModule);
    }

    @Override // javax.inject.Provider
    public ForegroundNotifier get() {
        ForegroundNotifier a2 = this.f17945a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
