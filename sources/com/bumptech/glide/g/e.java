package com.bumptech.glide.g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* loaded from: classes.dex */
class e implements Executor {

    /* renamed from: a */
    private final Handler f8506a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f8506a.post(runnable);
    }
}
