package com.facebook;

import com.facebook.GraphRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestProgress.java */
/* loaded from: classes.dex */
public class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.OnProgressCallback f9134a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f9135b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f9136c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ H f9137d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(H h2, GraphRequest.OnProgressCallback onProgressCallback, long j, long j2) {
        this.f9137d = h2;
        this.f9134a = onProgressCallback;
        this.f9135b = j;
        this.f9136c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9134a.onProgress(this.f9135b, this.f9136c);
    }
}
