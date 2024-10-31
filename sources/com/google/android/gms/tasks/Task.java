package com.google.android.gms.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class Task<TResult> {
    public abstract Task<TResult> a(Activity activity, OnFailureListener onFailureListener);

    public abstract Task<TResult> a(Activity activity, OnSuccessListener<? super TResult> onSuccessListener);

    public Task<TResult> a(OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task<TResult> a(OnFailureListener onFailureListener);

    public abstract Task<TResult> a(OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Task<TResult> a(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<TResult> a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Exception a();

    public abstract <X extends Throwable> TResult a(Class<X> cls) throws Throwable;

    public <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, Task<TContinuationResult>> continuation) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract TResult b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();

    public Task<TResult> a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> b(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public Task<TResult> a(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> a(OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> a(Executor executor, OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> a(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }
}
