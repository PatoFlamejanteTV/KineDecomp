package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class m<TResult> implements o<TResult> {

    /* renamed from: a */
    private final Executor f14306a;

    /* renamed from: b */
    private final Object f14307b = new Object();

    /* renamed from: c */
    private OnSuccessListener<? super TResult> f14308c;

    public m(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f14306a = executor;
        this.f14308c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.o
    public final void cancel() {
        synchronized (this.f14307b) {
            this.f14308c = null;
        }
    }

    @Override // com.google.android.gms.tasks.o
    public final void onComplete(Task<TResult> task) {
        if (task.e()) {
            synchronized (this.f14307b) {
                if (this.f14308c == null) {
                    return;
                }
                this.f14306a.execute(new n(this, task));
            }
        }
    }
}
