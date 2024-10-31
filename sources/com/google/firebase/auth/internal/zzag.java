package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzag implements Executor {

    /* renamed from: a */
    private static zzag f16514a = new zzag();

    /* renamed from: b */
    private Handler f16515b = new com.google.android.gms.internal.firebase_auth.zzf(Looper.getMainLooper());

    private zzag() {
    }

    public static zzag a() {
        return f16514a;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f16515b.post(runnable);
    }
}
