package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.model.InAppMessage;
import d.a.c;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterModule_ProvidesBannerMessageFactory implements c<InAppMessage> {

    /* renamed from: a */
    private final InflaterModule f17671a;

    public InflaterModule_ProvidesBannerMessageFactory(InflaterModule inflaterModule) {
        this.f17671a = inflaterModule;
    }

    public static c<InAppMessage> a(InflaterModule inflaterModule) {
        return new InflaterModule_ProvidesBannerMessageFactory(inflaterModule);
    }

    @Override // javax.inject.Provider
    public InAppMessage get() {
        InAppMessage b2 = this.f17671a.b();
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
