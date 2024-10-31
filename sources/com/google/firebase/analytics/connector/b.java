package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class b implements Executor {

    /* renamed from: a */
    static final Executor f16348a = new b();

    private b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
