package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import d.a.c;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class ModalBindingWrapper_Factory implements c<ModalBindingWrapper> {

    /* renamed from: a */
    private final Provider<InAppMessageLayoutConfig> f17599a;

    /* renamed from: b */
    private final Provider<LayoutInflater> f17600b;

    /* renamed from: c */
    private final Provider<InAppMessage> f17601c;

    public ModalBindingWrapper_Factory(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        this.f17599a = provider;
        this.f17600b = provider2;
        this.f17601c = provider3;
    }

    public static c<ModalBindingWrapper> a(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        return new ModalBindingWrapper_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public ModalBindingWrapper get() {
        return new ModalBindingWrapper(this.f17599a.get(), this.f17600b.get(), this.f17601c.get());
    }
}
