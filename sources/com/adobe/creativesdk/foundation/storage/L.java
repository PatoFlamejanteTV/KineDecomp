package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetException f7038a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f7039b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(M m, AdobeAssetException adobeAssetException) {
        this.f7039b = m;
        this.f7038a = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7039b.f7057e.a((sd) this.f7038a);
    }
}
