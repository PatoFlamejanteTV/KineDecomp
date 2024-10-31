package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ya, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0269ya implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4486a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4487b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4488c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4489d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0269ya(Aa aa, nb nbVar, Aa aa2, AdobeCSDKException adobeCSDKException) {
        this.f4489d = aa;
        this.f4486a = nbVar;
        this.f4487b = aa2;
        this.f4488c = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4486a.a(this.f4487b, this.f4488c);
    }
}
