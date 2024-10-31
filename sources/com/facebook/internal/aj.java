package com.facebook.internal;

import com.facebook.internal.WorkQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkQueue.java */
/* loaded from: classes.dex */
public class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WorkQueue.a f288a;
    final /* synthetic */ WorkQueue b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WorkQueue workQueue, WorkQueue.a aVar) {
        this.b = workQueue;
        this.f288a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f288a.a().run();
        } finally {
            this.b.finishItemAndStartNew(this.f288a);
        }
    }
}
