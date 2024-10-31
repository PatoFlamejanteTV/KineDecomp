package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.h */
/* loaded from: classes.dex */
class RunnableC0338h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeAssetException f5413a;

    /* renamed from: b */
    final /* synthetic */ C0339i f5414b;

    public RunnableC0338h(C0339i c0339i, AdobeAssetException adobeAssetException) {
        this.f5414b = c0339i;
        this.f5413a = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5414b.f5418a.a(this.f5413a);
    }
}
