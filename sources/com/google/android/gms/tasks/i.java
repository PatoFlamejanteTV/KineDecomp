package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class i<TResult> implements o<TResult> {

    /* renamed from: a */
    private final Executor f14296a;

    /* renamed from: b */
    private final Object f14297b = new Object();

    /* renamed from: c */
    private OnCompleteListener<TResult> f14298c;

    public i(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f14296a = executor;
        this.f14298c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.o
    public final void cancel() {
        synchronized (this.f14297b) {
            this.f14298c = null;
        }
    }

    @Override // com.google.android.gms.tasks.o
    public final void onComplete(Task<TResult> task) {
        synchronized (this.f14297b) {
            if (this.f14298c == null) {
                return;
            }
            this.f14296a.execute(new j(this, task));
        }
    }
}
