package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Ua implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ya f4247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(Ya ya) {
        this.f4247a = ya;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4247a.a(true);
    }
}
