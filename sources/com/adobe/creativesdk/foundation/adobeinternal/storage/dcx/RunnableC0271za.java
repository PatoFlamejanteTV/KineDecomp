package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.za, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0271za implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4495a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4496b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4497c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4498d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0271za(Aa aa, nb nbVar, Aa aa2, AdobeCSDKException adobeCSDKException) {
        this.f4498d = aa;
        this.f4495a = nbVar;
        this.f4496b = aa2;
        this.f4497c = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4495a.a(this.f4496b, this.f4497c);
    }
}
