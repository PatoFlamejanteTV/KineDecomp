package com.facebook;

import com.facebook.GraphRequestBatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressOutputStream.java */
/* loaded from: classes.dex */
public class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequestBatch.OnProgressCallback f243a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, GraphRequestBatch.OnProgressCallback onProgressCallback) {
        this.b = afVar;
        this.f243a = onProgressCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        GraphRequestBatch graphRequestBatch;
        long j;
        long j2;
        GraphRequestBatch.OnProgressCallback onProgressCallback = this.f243a;
        graphRequestBatch = this.b.b;
        j = this.b.d;
        j2 = this.b.f;
        onProgressCallback.onBatchProgress(graphRequestBatch, j, j2);
    }
}
