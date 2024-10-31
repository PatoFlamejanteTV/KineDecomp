package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExecutorDelivery.java */
/* loaded from: classes.dex */
public class e implements Executor {

    /* renamed from: a */
    final /* synthetic */ Handler f8056a;

    /* renamed from: b */
    final /* synthetic */ f f8057b;

    public e(f fVar, Handler handler) {
        this.f8057b = fVar;
        this.f8056a = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f8056a.post(runnable);
    }
}
