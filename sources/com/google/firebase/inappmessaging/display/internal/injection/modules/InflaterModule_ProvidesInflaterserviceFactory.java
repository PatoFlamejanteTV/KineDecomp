package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.view.LayoutInflater;
import d.a.c;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class InflaterModule_ProvidesInflaterserviceFactory implements c<LayoutInflater> {

    /* renamed from: a */
    private final InflaterModule f17672a;

    public InflaterModule_ProvidesInflaterserviceFactory(InflaterModule inflaterModule) {
        this.f17672a = inflaterModule;
    }

    public static c<LayoutInflater> a(InflaterModule inflaterModule) {
        return new InflaterModule_ProvidesInflaterserviceFactory(inflaterModule);
    }

    @Override // javax.inject.Provider
    public LayoutInflater get() {
        LayoutInflater c2 = this.f17672a.c();
        f.a(c2, "Cannot return null from a non-@Nullable @Provides method");
        return c2;
    }
}
