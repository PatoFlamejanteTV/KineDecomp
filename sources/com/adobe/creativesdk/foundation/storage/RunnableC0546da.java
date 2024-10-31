package com.adobe.creativesdk.foundation.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.da, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0546da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetException f7228a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0550ea f7229b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0546da(C0550ea c0550ea, AdobeAssetException adobeAssetException) {
        this.f7229b = c0550ea;
        this.f7228a = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7229b.f7237a.f7273b.f7286b.a(this.f7228a);
    }
}
