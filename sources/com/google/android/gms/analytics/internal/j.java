package com.google.android.gms.analytics.internal;

import java.lang.Thread;

/* loaded from: classes.dex */
public class j implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ zzf f708a;

    public j(zzf zzfVar) {
        this.f708a = zzfVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        zzaf g = this.f708a.g();
        if (g != null) {
            g.e("Job execution failed", th);
        }
    }
}
