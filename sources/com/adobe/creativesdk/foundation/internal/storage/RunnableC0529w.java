package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0529w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f6794a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetException f6795b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6796c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0529w(RunnableC0531y runnableC0531y, ha haVar, AdobeAssetException adobeAssetException) {
        this.f6796c = runnableC0531y;
        this.f6794a = haVar;
        this.f6795b = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6794a.a(this.f6795b);
    }
}
