package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
class J implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ double f7017a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f7018b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(M m, double d2) {
        this.f7018b = m;
        this.f7017a = d2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7018b.f7057e.a(this.f7017a);
    }
}
