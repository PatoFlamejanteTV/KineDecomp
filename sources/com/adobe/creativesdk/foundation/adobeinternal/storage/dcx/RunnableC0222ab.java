package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ab, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0222ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0225c f4310a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4311b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4312c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4313d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ db f4314e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0222ab(db dbVar, C0225c c0225c, C0231f c0231f, String str, AdobeCSDKException adobeCSDKException) {
        this.f4314e = dbVar;
        this.f4310a = c0225c;
        this.f4311b = c0231f;
        this.f4312c = str;
        this.f4313d = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4314e.f4346a.a(this.f4310a, this.f4311b, this.f4312c, this.f4313d);
    }
}
