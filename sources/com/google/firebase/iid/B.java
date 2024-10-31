package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final /* synthetic */ class B implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f17297a = new B();

    private B() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return A.a(runnable);
    }
}
