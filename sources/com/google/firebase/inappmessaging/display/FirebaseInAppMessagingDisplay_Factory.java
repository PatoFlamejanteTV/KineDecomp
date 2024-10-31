package com.google.firebase.inappmessaging.display;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class FirebaseInAppMessagingDisplay_Factory implements d.a.c<FirebaseInAppMessagingDisplay> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<FirebaseInAppMessaging> f17513a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Map<String, Provider<InAppMessageLayoutConfig>>> f17514b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<FiamImageLoader> f17515c;

    /* renamed from: d, reason: collision with root package name */
    private final Provider<RenewableTimer> f17516d;

    /* renamed from: e, reason: collision with root package name */
    private final Provider<FiamWindowManager> f17517e;

    /* renamed from: f, reason: collision with root package name */
    private final Provider<Application> f17518f;

    /* renamed from: g, reason: collision with root package name */
    private final Provider<BindingWrapperFactory> f17519g;

    /* renamed from: h, reason: collision with root package name */
    private final Provider<FiamAnimator> f17520h;

    public FirebaseInAppMessagingDisplay_Factory(Provider<FirebaseInAppMessaging> provider, Provider<Map<String, Provider<InAppMessageLayoutConfig>>> provider2, Provider<FiamImageLoader> provider3, Provider<RenewableTimer> provider4, Provider<FiamWindowManager> provider5, Provider<Application> provider6, Provider<BindingWrapperFactory> provider7, Provider<FiamAnimator> provider8) {
        this.f17513a = provider;
        this.f17514b = provider2;
        this.f17515c = provider3;
        this.f17516d = provider4;
        this.f17517e = provider5;
        this.f17518f = provider6;
        this.f17519g = provider7;
        this.f17520h = provider8;
    }

    public static d.a.c<FirebaseInAppMessagingDisplay> a(Provider<FirebaseInAppMessaging> provider, Provider<Map<String, Provider<InAppMessageLayoutConfig>>> provider2, Provider<FiamImageLoader> provider3, Provider<RenewableTimer> provider4, Provider<FiamWindowManager> provider5, Provider<Application> provider6, Provider<BindingWrapperFactory> provider7, Provider<FiamAnimator> provider8) {
        return new FirebaseInAppMessagingDisplay_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public FirebaseInAppMessagingDisplay get() {
        return new FirebaseInAppMessagingDisplay(this.f17513a.get(), this.f17514b.get(), this.f17515c.get(), this.f17516d.get(), this.f17516d.get(), this.f17517e.get(), this.f17518f.get(), this.f17519g.get(), this.f17520h.get());
    }
}
