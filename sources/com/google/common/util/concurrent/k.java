package com.google.common.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: MoreExecutors.java */
/* loaded from: classes2.dex */
final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExecutorService f2979a;
    final /* synthetic */ long b;
    final /* synthetic */ TimeUnit c;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2979a.shutdown();
            this.f2979a.awaitTermination(this.b, this.c);
        } catch (InterruptedException e) {
        }
    }
}
