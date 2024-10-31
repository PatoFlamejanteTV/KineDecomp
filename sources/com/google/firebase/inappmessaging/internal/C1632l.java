package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final /* synthetic */ class C1632l implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCallbacksImpl f17973a;

    /* renamed from: b, reason: collision with root package name */
    private final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType f17974b;

    private C1632l(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        this.f17973a = displayCallbacksImpl;
        this.f17974b = inAppMessagingDismissType;
    }

    public static io.reactivex.c.a a(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        return new C1632l(displayCallbacksImpl, inAppMessagingDismissType);
    }

    @Override // io.reactivex.c.a
    public void run() {
        r0.f17756h.a(this.f17973a.j, this.f17974b);
    }
}
