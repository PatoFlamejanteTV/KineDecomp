package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.w */
/* loaded from: classes.dex */
public class RunnableC0620w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ sd f7455a;

    /* renamed from: b */
    final /* synthetic */ AdobeAssetException f7456b;

    public RunnableC0620w(sd sdVar, AdobeAssetException adobeAssetException) {
        this.f7455a = sdVar;
        this.f7456b = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7455a.a((sd) this.f7456b);
    }
}
