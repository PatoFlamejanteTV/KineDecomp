package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class dp implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f1509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(Runnable runnable) {
        this.f1509a = runnable;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f1509a.run();
        return null;
    }
}
