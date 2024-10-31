package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c<TResult, TContinuationResult> implements o<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f14282a;

    /* renamed from: b, reason: collision with root package name */
    private final Continuation<TResult, TContinuationResult> f14283b;

    /* renamed from: c, reason: collision with root package name */
    private final s<TContinuationResult> f14284c;

    public c(Executor executor, Continuation<TResult, TContinuationResult> continuation, s<TContinuationResult> sVar) {
        this.f14282a = executor;
        this.f14283b = continuation;
        this.f14284c = sVar;
    }

    @Override // com.google.android.gms.tasks.o
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.o
    public final void onComplete(Task<TResult> task) {
        this.f14282a.execute(new d(this, task));
    }
}
