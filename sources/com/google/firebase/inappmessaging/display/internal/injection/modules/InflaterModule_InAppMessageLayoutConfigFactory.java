package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import d.a.c;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterModule_InAppMessageLayoutConfigFactory implements c<InAppMessageLayoutConfig> {

    /* renamed from: a */
    private final InflaterModule f17670a;

    public InflaterModule_InAppMessageLayoutConfigFactory(InflaterModule inflaterModule) {
        this.f17670a = inflaterModule;
    }

    public static c<InAppMessageLayoutConfig> a(InflaterModule inflaterModule) {
        return new InflaterModule_InAppMessageLayoutConfigFactory(inflaterModule);
    }

    @Override // javax.inject.Provider
    public InAppMessageLayoutConfig get() {
        InAppMessageLayoutConfig a2 = this.f17670a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
