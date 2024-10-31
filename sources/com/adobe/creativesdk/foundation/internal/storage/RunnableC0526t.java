package com.adobe.creativesdk.foundation.internal.storage;

import java.lang.ref.WeakReference;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0526t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f6787a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WeakReference f6788b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6789c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0526t(RunnableC0531y runnableC0531y, ha haVar, WeakReference weakReference) {
        this.f6789c = runnableC0531y;
        this.f6787a = haVar;
        this.f6788b = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6787a.a(((C0532z) this.f6788b.get()).f6578f.size());
    }
}
