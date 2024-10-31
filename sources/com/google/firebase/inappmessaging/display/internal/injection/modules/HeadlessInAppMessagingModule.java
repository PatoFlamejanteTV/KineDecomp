package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class HeadlessInAppMessagingModule {

    /* renamed from: a */
    private final FirebaseInAppMessaging f17649a;

    public HeadlessInAppMessagingModule(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.f17649a = firebaseInAppMessaging;
    }

    @FirebaseAppScope
    public FirebaseInAppMessaging a() {
        return this.f17649a;
    }
}
