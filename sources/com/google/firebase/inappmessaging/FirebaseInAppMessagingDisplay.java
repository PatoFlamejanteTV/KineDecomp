package com.google.firebase.inappmessaging;

import android.support.annotation.Keep;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Keep
/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingDisplay {
    @Keep
    void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks);
}
