package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class CallableC1628h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f17862a;

    private CallableC1628h(TaskCompletionSource taskCompletionSource) {
        this.f17862a = taskCompletionSource;
    }

    public static Callable a(TaskCompletionSource taskCompletionSource) {
        return new CallableC1628h(taskCompletionSource);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return DisplayCallbacksImpl.a(this.f17862a);
    }
}
