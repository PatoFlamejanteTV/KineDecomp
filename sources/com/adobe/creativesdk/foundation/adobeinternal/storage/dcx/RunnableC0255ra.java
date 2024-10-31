package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ra, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0255ra implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4440a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4441b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4442c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0255ra(Aa aa, nb nbVar, Aa aa2) {
        this.f4442c = aa;
        this.f4440a = nbVar;
        this.f4441b = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4440a.b(this.f4441b);
    }
}
