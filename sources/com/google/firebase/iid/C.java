package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class C implements Executor {

    /* renamed from: a */
    static final Executor f17298a = new C();

    private C() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
