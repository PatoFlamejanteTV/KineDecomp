package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1629i implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f17864a;

    private C1629i(TaskCompletionSource taskCompletionSource) {
        this.f17864a = taskCompletionSource;
    }

    public static io.reactivex.c.f a(TaskCompletionSource taskCompletionSource) {
        return new C1629i(taskCompletionSource);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        return DisplayCallbacksImpl.a(this.f17864a, (Throwable) obj);
    }
}
