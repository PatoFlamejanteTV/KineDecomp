package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class dt implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1513a;
    private final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(String str) {
        this.f1513a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(" + this.f1513a + ") #" + this.b.getAndIncrement());
    }
}
