package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements io.reactivex.c.e {

    /* renamed from: a */
    private final FirebaseInAppMessaging f18007a;

    private j(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.f18007a = firebaseInAppMessaging;
    }

    public static io.reactivex.c.e a(FirebaseInAppMessaging firebaseInAppMessaging) {
        return new j(firebaseInAppMessaging);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        r0.f17475e.b(k.a(this.f18007a, (TriggeredInAppMessage) obj)).d();
    }
}
