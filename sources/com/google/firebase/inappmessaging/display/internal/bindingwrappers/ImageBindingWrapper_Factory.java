package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import d.a.c;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class ImageBindingWrapper_Factory implements c<ImageBindingWrapper> {

    /* renamed from: a */
    private final Provider<InAppMessageLayoutConfig> f17590a;

    /* renamed from: b */
    private final Provider<LayoutInflater> f17591b;

    /* renamed from: c */
    private final Provider<InAppMessage> f17592c;

    public ImageBindingWrapper_Factory(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        this.f17590a = provider;
        this.f17591b = provider2;
        this.f17592c = provider3;
    }

    public static c<ImageBindingWrapper> a(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        return new ImageBindingWrapper_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public ImageBindingWrapper get() {
        return new ImageBindingWrapper(this.f17590a.get(), this.f17591b.get(), this.f17592c.get());
    }
}
