package com.adobe.creativesdk.foundation.internal.storage;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0527u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f6790a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6791b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0527u(RunnableC0531y runnableC0531y, ha haVar) {
        this.f6791b = runnableC0531y;
        this.f6790a = haVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6790a.c();
    }
}
