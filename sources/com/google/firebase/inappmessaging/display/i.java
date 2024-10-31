package com.google.firebase.inappmessaging.display;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
final /* synthetic */ class i implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    private final FirebaseInAppMessagingDisplayRegistrar f17537a;

    private i(FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar) {
        this.f17537a = firebaseInAppMessagingDisplayRegistrar;
    }

    public static ComponentFactory a(FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar) {
        return new i(firebaseInAppMessagingDisplayRegistrar);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        FirebaseInAppMessagingDisplay buildFirebaseInAppMessagingUI;
        buildFirebaseInAppMessagingUI = this.f17537a.buildFirebaseInAppMessagingUI(componentContainer);
        return buildFirebaseInAppMessagingUI;
    }
}
