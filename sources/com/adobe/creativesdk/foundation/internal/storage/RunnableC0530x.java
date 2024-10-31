package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0530x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f6797a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetException f6798b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6799c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0530x(RunnableC0531y runnableC0531y, ha haVar, AdobeAssetException adobeAssetException) {
        this.f6799c = runnableC0531y;
        this.f6797a = haVar;
        this.f6798b = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6797a.a(this.f6798b);
        this.f6797a.c();
    }
}
