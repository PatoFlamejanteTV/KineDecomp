package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class TaskExecutors {

    /* renamed from: a */
    public static final Executor f14268a = new a();

    /* renamed from: b */
    static final Executor f14269b = new ExecutorC1462r();

    /* loaded from: classes2.dex */
    private static final class a implements Executor {

        /* renamed from: a */
        private final Handler f14270a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f14270a.post(runnable);
        }
    }

    private TaskExecutors() {
    }
}
