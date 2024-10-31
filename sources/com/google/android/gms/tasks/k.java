package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class k<TResult> implements o<TResult> {

    /* renamed from: a */
    private final Executor f14301a;

    /* renamed from: b */
    private final Object f14302b = new Object();

    /* renamed from: c */
    private OnFailureListener f14303c;

    public k(Executor executor, OnFailureListener onFailureListener) {
        this.f14301a = executor;
        this.f14303c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.o
    public final void cancel() {
        synchronized (this.f14302b) {
            this.f14303c = null;
        }
    }

    @Override // com.google.android.gms.tasks.o
    public final void onComplete(Task<TResult> task) {
        if (task.e() || task.c()) {
            return;
        }
        synchronized (this.f14302b) {
            if (this.f14303c == null) {
                return;
            }
            this.f14301a.execute(new l(this, task));
        }
    }
}
