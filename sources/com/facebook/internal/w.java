package com.facebook.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockOnGetVariable.java */
/* loaded from: classes.dex */
public class w implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callable f301a;
    final /* synthetic */ LockOnGetVariable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LockOnGetVariable lockOnGetVariable, Callable callable) {
        this.b = lockOnGetVariable;
        this.f301a = callable;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.b.value = this.f301a.call();
            countDownLatch2 = this.b.initLatch;
            countDownLatch2.countDown();
            return null;
        } catch (Throwable th) {
            countDownLatch = this.b.initLatch;
            countDownLatch.countDown();
            throw th;
        }
    }
}
