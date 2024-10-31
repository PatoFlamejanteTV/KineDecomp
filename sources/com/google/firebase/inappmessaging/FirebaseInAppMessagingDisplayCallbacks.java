package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingDisplayCallbacks {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum InAppMessagingDismissType {
        UNKNOWN_DISMISS_TYPE,
        AUTO,
        CLICK,
        SWIPE
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum InAppMessagingErrorReason {
        UNSPECIFIED_RENDER_ERROR,
        IMAGE_FETCH_ERROR,
        IMAGE_DISPLAY_ERROR,
        IMAGE_UNSUPPORTED_FORMAT
    }

    Task<Void> a();

    Task<Void> a(InAppMessagingDismissType inAppMessagingDismissType);

    Task<Void> a(InAppMessagingErrorReason inAppMessagingErrorReason);

    Task<Void> b();
}
