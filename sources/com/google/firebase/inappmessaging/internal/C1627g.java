package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.g */
/* loaded from: classes2.dex */
final /* synthetic */ class C1627g implements io.reactivex.c.e {

    /* renamed from: a */
    private final TaskCompletionSource f17860a;

    private C1627g(TaskCompletionSource taskCompletionSource) {
        this.f17860a = taskCompletionSource;
    }

    public static io.reactivex.c.e a(TaskCompletionSource taskCompletionSource) {
        return new C1627g(taskCompletionSource);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17860a.a((TaskCompletionSource) obj);
    }
}
