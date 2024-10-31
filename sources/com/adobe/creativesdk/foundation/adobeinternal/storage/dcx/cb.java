package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class cb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0225c f4334a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4335b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4336c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4337d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4338e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ db f4339f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(db dbVar, C0225c c0225c, C0231f c0231f, String str, String str2, AdobeCSDKException adobeCSDKException) {
        this.f4339f = dbVar;
        this.f4334a = c0225c;
        this.f4335b = c0231f;
        this.f4336c = str;
        this.f4337d = str2;
        this.f4338e = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4339f.f4346a.a(this.f4334a, this.f4335b, this.f4336c, this.f4337d, this.f4338e);
    }
}
