package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final /* synthetic */ class k implements io.reactivex.c.e {

    /* renamed from: a */
    private final FirebaseInAppMessaging f18008a;

    /* renamed from: b */
    private final TriggeredInAppMessage f18009b;

    private k(FirebaseInAppMessaging firebaseInAppMessaging, TriggeredInAppMessage triggeredInAppMessage) {
        this.f18008a = firebaseInAppMessaging;
        this.f18009b = triggeredInAppMessage;
    }

    public static io.reactivex.c.e a(FirebaseInAppMessaging firebaseInAppMessaging, TriggeredInAppMessage triggeredInAppMessage) {
        return new k(firebaseInAppMessaging, triggeredInAppMessage);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        ((FirebaseInAppMessagingDisplay) obj).displayMessage(r1.a(), this.f18008a.f17473c.a(r1.a(), this.f18009b.b()));
    }
}
