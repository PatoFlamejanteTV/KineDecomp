package com.google.firebase.crash;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class a implements Executor {

    /* renamed from: a */
    static final Executor f16613a = new a();

    private a() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
