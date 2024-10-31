package com.facebook.internal;

import com.facebook.internal.WorkQueue;

/* compiled from: WorkQueue.java */
/* loaded from: classes.dex */
public class K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WorkQueue.a f9301a;

    /* renamed from: b */
    final /* synthetic */ WorkQueue f9302b;

    public K(WorkQueue workQueue, WorkQueue.a aVar) {
        this.f9302b = workQueue;
        this.f9301a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f9301a.a().run();
        } finally {
            this.f9302b.finishItemAndStartNew(this.f9301a);
        }
    }
}
