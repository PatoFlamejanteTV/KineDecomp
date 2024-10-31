package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class FirebaseInAppMessaging_Factory implements d.a.c<FirebaseInAppMessaging> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<InAppMessageStreamManager> f17476a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<DataCollectionHelper> f17477b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<DisplayCallbacksFactory> f17478c;

    public FirebaseInAppMessaging_Factory(Provider<InAppMessageStreamManager> provider, Provider<DataCollectionHelper> provider2, Provider<DisplayCallbacksFactory> provider3) {
        this.f17476a = provider;
        this.f17477b = provider2;
        this.f17478c = provider3;
    }

    public static d.a.c<FirebaseInAppMessaging> a(Provider<InAppMessageStreamManager> provider, Provider<DataCollectionHelper> provider2, Provider<DisplayCallbacksFactory> provider3) {
        return new FirebaseInAppMessaging_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public FirebaseInAppMessaging get() {
        return new FirebaseInAppMessaging(this.f17476a.get(), this.f17477b.get(), this.f17478c.get());
    }
}
