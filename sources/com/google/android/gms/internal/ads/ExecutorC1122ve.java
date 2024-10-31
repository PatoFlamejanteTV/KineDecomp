package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.ve */
/* loaded from: classes2.dex */
public final class ExecutorC1122ve implements Executor {

    /* renamed from: a */
    private final Handler f12606a = new zzaya(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzbv.e();
                zzayh.zza(com.google.android.gms.ads.internal.zzbv.i().getApplicationContext(), th);
                throw th;
            }
        }
        this.f12606a.post(runnable);
    }
}
