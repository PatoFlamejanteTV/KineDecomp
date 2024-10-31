package com.bumptech.glide.g;

import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* loaded from: classes.dex */
class f implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
