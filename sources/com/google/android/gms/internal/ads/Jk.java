package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Jk implements Executor {

    /* renamed from: a */
    private final /* synthetic */ Handler f11631a;

    public Jk(zzi zziVar, Handler handler) {
        this.f11631a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f11631a.post(runnable);
    }
}
