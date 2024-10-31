package com.facebook.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* compiled from: LockOnGetVariable.java */
/* loaded from: classes.dex */
public class x implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ Callable f9342a;

    /* renamed from: b */
    final /* synthetic */ LockOnGetVariable f9343b;

    public x(LockOnGetVariable lockOnGetVariable, Callable callable) {
        this.f9343b = lockOnGetVariable;
        this.f9342a = callable;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f9343b.value = this.f9342a.call();
            countDownLatch2 = this.f9343b.initLatch;
            countDownLatch2.countDown();
            return null;
        } catch (Throwable th) {
            countDownLatch = this.f9343b.initLatch;
            countDownLatch.countDown();
            throw th;
        }
    }
}
