package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.v */
/* loaded from: classes.dex */
public class RunnableC0616v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ sd f7447a;

    /* renamed from: b */
    final /* synthetic */ AdobeAssetException f7448b;

    public RunnableC0616v(sd sdVar, AdobeAssetException adobeAssetException) {
        this.f7447a = sdVar;
        this.f7448b = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7447a.a((sd) this.f7448b);
    }
}
