package com.adobe.creativesdk.foundation.internal.storage;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0528v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f6792a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6793b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0528v(RunnableC0531y runnableC0531y, ha haVar) {
        this.f6793b = runnableC0531y;
        this.f6792a = haVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6792a.c();
    }
}
