package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
class da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4600a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ fa f4601b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(fa faVar, String str) {
        this.f4601b = faVar;
        this.f4600a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4601b.f4610e.b(this.f4600a);
    }
}
