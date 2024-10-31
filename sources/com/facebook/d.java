package com.facebook;

import com.facebook.GraphRequestBatch;

/* compiled from: ProgressOutputStream.java */
/* loaded from: classes.dex */
public class D implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GraphRequestBatch.OnProgressCallback f9123a;

    /* renamed from: b */
    final /* synthetic */ E f9124b;

    public D(E e2, GraphRequestBatch.OnProgressCallback onProgressCallback) {
        this.f9124b = e2;
        this.f9123a = onProgressCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        GraphRequestBatch graphRequestBatch;
        long j;
        long j2;
        GraphRequestBatch.OnProgressCallback onProgressCallback = this.f9123a;
        graphRequestBatch = this.f9124b.f9126b;
        j = this.f9124b.f9128d;
        j2 = this.f9124b.f9130f;
        onProgressCallback.onBatchProgress(graphRequestBatch, j, j2);
    }
}
