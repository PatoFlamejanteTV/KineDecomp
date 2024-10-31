package com.google.firebase.inappmessaging.display;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
class g implements RenewableTimer.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f17532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar) {
        this.f17532a = hVar;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
    public void onFinish() {
        InAppMessage inAppMessage;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2;
        inAppMessage = this.f17532a.f17536d.inAppMessage;
        if (inAppMessage != null) {
            firebaseInAppMessagingDisplayCallbacks = this.f17532a.f17536d.callbacks;
            if (firebaseInAppMessagingDisplayCallbacks != null) {
                firebaseInAppMessagingDisplayCallbacks2 = this.f17532a.f17536d.callbacks;
                firebaseInAppMessagingDisplayCallbacks2.a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
            }
        }
        h hVar = this.f17532a;
        hVar.f17536d.dismissFiam(hVar.f17534b);
    }
}
