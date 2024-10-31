package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final /* synthetic */ class C1634n implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCallbacksImpl f17980a;

    /* renamed from: b, reason: collision with root package name */
    private final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason f17981b;

    private C1634n(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.f17980a = displayCallbacksImpl;
        this.f17981b = inAppMessagingErrorReason;
    }

    public static io.reactivex.c.a a(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        return new C1634n(displayCallbacksImpl, inAppMessagingErrorReason);
    }

    @Override // io.reactivex.c.a
    public void run() {
        r0.f17756h.a(this.f17980a.j, this.f17981b);
    }
}
