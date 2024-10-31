package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ta, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0259ta implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC0261ua f4455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0259ta(RunnableC0261ua runnableC0261ua) {
        this.f4455a = runnableC0261ua;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        RunnableC0261ua runnableC0261ua = this.f4455a;
        nb nbVar = runnableC0261ua.f4459b;
        Aa aa = runnableC0261ua.f4458a;
        j = aa.k;
        nbVar.a(aa, j);
    }
}
