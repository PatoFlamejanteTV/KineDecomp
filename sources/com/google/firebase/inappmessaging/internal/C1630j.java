package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1630j implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCallbacksImpl f17968a;

    private C1630j(DisplayCallbacksImpl displayCallbacksImpl) {
        this.f17968a = displayCallbacksImpl;
    }

    public static io.reactivex.c.a a(DisplayCallbacksImpl displayCallbacksImpl) {
        return new C1630j(displayCallbacksImpl);
    }

    @Override // io.reactivex.c.a
    public void run() {
        r0.f17756h.a(this.f17968a.j);
    }
}
