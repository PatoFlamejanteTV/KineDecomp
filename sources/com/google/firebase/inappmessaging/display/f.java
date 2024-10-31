package com.google.firebase.inappmessaging.display;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
class f implements RenewableTimer.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f17531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f17531a = hVar;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
    public void onFinish() {
        InAppMessage inAppMessage;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        InAppMessage inAppMessage2;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2;
        inAppMessage = this.f17531a.f17536d.inAppMessage;
        if (inAppMessage != null) {
            firebaseInAppMessagingDisplayCallbacks = this.f17531a.f17536d.callbacks;
            if (firebaseInAppMessagingDisplayCallbacks != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Impression timer onFinish for: ");
                inAppMessage2 = this.f17531a.f17536d.inAppMessage;
                sb.append(inAppMessage2.getCampaignId());
                Logging.d(sb.toString());
                firebaseInAppMessagingDisplayCallbacks2 = this.f17531a.f17536d.callbacks;
                firebaseInAppMessagingDisplayCallbacks2.b();
            }
        }
    }
}
