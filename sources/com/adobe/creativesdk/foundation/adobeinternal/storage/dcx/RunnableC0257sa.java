package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.sa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0257sa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4450a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4451b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4452c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0257sa(Aa aa, nb nbVar, Aa aa2) {
        this.f4452c = aa;
        this.f4450a = nbVar;
        this.f4451b = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4450a.a(this.f4451b);
    }
}
