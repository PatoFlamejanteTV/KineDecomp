package com.google.firebase.inappmessaging.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final /* synthetic */ class C1633m implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCallbacksImpl f17977a;

    private C1633m(DisplayCallbacksImpl displayCallbacksImpl) {
        this.f17977a = displayCallbacksImpl;
    }

    public static io.reactivex.c.a a(DisplayCallbacksImpl displayCallbacksImpl) {
        return new C1633m(displayCallbacksImpl);
    }

    @Override // io.reactivex.c.a
    public void run() {
        r0.f17756h.b(this.f17977a.j);
    }
}
