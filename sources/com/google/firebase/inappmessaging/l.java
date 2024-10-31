package com.google.firebase.inappmessaging;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final /* synthetic */ class l implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    private final FirebaseInAppMessagingRegistrar f18010a;

    private l(FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar) {
        this.f18010a = firebaseInAppMessagingRegistrar;
    }

    public static ComponentFactory a(FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar) {
        return new l(firebaseInAppMessagingRegistrar);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        FirebaseInAppMessaging providesFirebaseInAppMessaging;
        providesFirebaseInAppMessaging = this.f18010a.providesFirebaseInAppMessaging(componentContainer);
        return providesFirebaseInAppMessaging;
    }
}
