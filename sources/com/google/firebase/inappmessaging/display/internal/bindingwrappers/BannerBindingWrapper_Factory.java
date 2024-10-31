package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import d.a.c;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class BannerBindingWrapper_Factory implements c<BannerBindingWrapper> {

    /* renamed from: a */
    private final Provider<InAppMessage> f17580a;

    /* renamed from: b */
    private final Provider<LayoutInflater> f17581b;

    /* renamed from: c */
    private final Provider<InAppMessageLayoutConfig> f17582c;

    public BannerBindingWrapper_Factory(Provider<InAppMessage> provider, Provider<LayoutInflater> provider2, Provider<InAppMessageLayoutConfig> provider3) {
        this.f17580a = provider;
        this.f17581b = provider2;
        this.f17582c = provider3;
    }

    public static c<BannerBindingWrapper> a(Provider<InAppMessage> provider, Provider<LayoutInflater> provider2, Provider<InAppMessageLayoutConfig> provider3) {
        return new BannerBindingWrapper_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public BannerBindingWrapper get() {
        return new BannerBindingWrapper(this.f17580a.get(), this.f17581b.get(), this.f17582c.get());
    }
}
