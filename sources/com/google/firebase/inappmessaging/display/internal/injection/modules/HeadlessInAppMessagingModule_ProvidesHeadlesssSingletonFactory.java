package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import d.a.c;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory implements c<FirebaseInAppMessaging> {

    /* renamed from: a */
    private final HeadlessInAppMessagingModule f17650a;

    public HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        this.f17650a = headlessInAppMessagingModule;
    }

    public static c<FirebaseInAppMessaging> a(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        return new HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(headlessInAppMessagingModule);
    }

    @Override // javax.inject.Provider
    public FirebaseInAppMessaging get() {
        FirebaseInAppMessaging a2 = this.f17650a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
