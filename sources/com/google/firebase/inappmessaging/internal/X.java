package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class X implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17844a;

    private X(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f17844a = inAppMessageStreamManager;
    }

    public static io.reactivex.c.f a(InAppMessageStreamManager inAppMessageStreamManager) {
        return new X(inAppMessageStreamManager);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        return InAppMessageStreamManager.a(this.f17844a, (String) obj);
    }
}
