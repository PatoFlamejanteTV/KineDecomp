package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
class a implements com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f17521a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FirebaseInAppMessagingDisplay f17522b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity) {
        this.f17522b = firebaseInAppMessagingDisplay;
        this.f17521a = activity;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        InAppMessage inAppMessage2;
        FirebaseInAppMessaging firebaseInAppMessaging;
        inAppMessage2 = this.f17522b.inAppMessage;
        if (inAppMessage2 == null) {
            firebaseInAppMessaging = this.f17522b.headlessInAppMessaging;
            if (!firebaseInAppMessaging.areMessagesSuppressed()) {
                this.f17522b.inAppMessage = inAppMessage;
                this.f17522b.callbacks = firebaseInAppMessagingDisplayCallbacks;
                this.f17522b.showActiveFiam(this.f17521a);
                return;
            }
        }
        Logging.a("Active FIAM exists. Skipping trigger");
    }
}
