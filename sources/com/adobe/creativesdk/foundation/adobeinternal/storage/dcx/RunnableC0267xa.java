package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0267xa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4480a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4481b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4482c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4483d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0267xa(Aa aa, nb nbVar, Aa aa2, AdobeCSDKException adobeCSDKException) {
        this.f4483d = aa;
        this.f4480a = nbVar;
        this.f4481b = aa2;
        this.f4482c = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4480a.a(this.f4481b, this.f4482c);
    }
}
