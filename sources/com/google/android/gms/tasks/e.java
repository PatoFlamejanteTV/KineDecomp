package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, o<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f14287a;

    /* renamed from: b, reason: collision with root package name */
    private final Continuation<TResult, Task<TContinuationResult>> f14288b;

    /* renamed from: c, reason: collision with root package name */
    private final s<TContinuationResult> f14289c;

    public e(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, s<TContinuationResult> sVar) {
        this.f14287a = executor;
        this.f14288b = continuation;
        this.f14289c = sVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void a() {
        this.f14289c.f();
    }

    @Override // com.google.android.gms.tasks.o
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.o
    public final void onComplete(Task<TResult> task) {
        this.f14287a.execute(new f(this, task));
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f14289c.a(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f14289c.a((s<TContinuationResult>) tcontinuationresult);
    }
}
