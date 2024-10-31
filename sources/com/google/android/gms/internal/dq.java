package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class dq implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f1510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(Runnable runnable) {
        this.f1510a = runnable;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f1510a.run();
        return null;
    }
}
