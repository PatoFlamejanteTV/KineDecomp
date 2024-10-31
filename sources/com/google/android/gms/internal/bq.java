package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class bq implements Executor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Handler f1457a;
    final /* synthetic */ zze b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(zze zzeVar, Handler handler) {
        this.b = zzeVar;
        this.f1457a = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1457a.post(runnable);
    }
}
