package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Ta implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ya f4238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(Ya ya) {
        this.f4238a = ya;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4238a.a(false);
    }
}
