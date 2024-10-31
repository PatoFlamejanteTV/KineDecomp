package com.google.common.util.concurrent;

import java.util.concurrent.BlockingQueue;

/* compiled from: MoreExecutors.java */
/* loaded from: classes2.dex */
final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BlockingQueue f2980a;
    final /* synthetic */ ListenableFuture b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BlockingQueue blockingQueue, ListenableFuture listenableFuture) {
        this.f2980a = blockingQueue;
        this.b = listenableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2980a.add(this.b);
    }
}
