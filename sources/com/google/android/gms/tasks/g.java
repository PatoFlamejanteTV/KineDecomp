package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class g<TResult> implements o<TResult> {

    /* renamed from: a */
    private final Executor f14292a;

    /* renamed from: b */
    private final Object f14293b = new Object();

    /* renamed from: c */
    private OnCanceledListener f14294c;

    public g(Executor executor, OnCanceledListener onCanceledListener) {
        this.f14292a = executor;
        this.f14294c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.o
    public final void cancel() {
        synchronized (this.f14293b) {
            this.f14294c = null;
        }
    }

    @Override // com.google.android.gms.tasks.o
    public final void onComplete(Task task) {
        if (task.c()) {
            synchronized (this.f14293b) {
                if (this.f14294c == null) {
                    return;
                }
                this.f14292a.execute(new h(this));
            }
        }
    }
}
