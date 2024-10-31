package com.facebook;

import com.facebook.GraphRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestProgress.java */
/* loaded from: classes.dex */
public class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.OnProgressCallback f245a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ ai d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, GraphRequest.OnProgressCallback onProgressCallback, long j, long j2) {
        this.d = aiVar;
        this.f245a = onProgressCallback;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f245a.onProgress(this.b, this.c);
    }
}
