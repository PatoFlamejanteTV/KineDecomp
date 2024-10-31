package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Ha implements com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lb f7000a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f7001b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.H f7002c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f7003d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(AdobeAssetPSDFile adobeAssetPSDFile, Lb lb, sd sdVar, com.adobe.creativesdk.foundation.internal.net.H h2) {
        this.f7003d = adobeAssetPSDFile;
        this.f7000a = lb;
        this.f7001b = sdVar;
        this.f7002c = h2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e
    public void a(Mb mb) {
        a();
        try {
            this.f7000a.f();
            if (this.f7001b != null) {
                this.f7001b.b(this.f7000a);
            }
        } catch (AdobeDCXException unused) {
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e
    public void a(AdobeCSDKException adobeCSDKException) {
        a();
        if ((adobeCSDKException instanceof AdobeNetworkException) && ((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, AdobeAssetPSDFile.class.getSimpleName(), "PSD composite pull request for %@ has been cancelled for" + this.f7003d.getHref().getPath());
            this.f7001b.a();
        }
    }

    void a() {
        com.adobe.creativesdk.foundation.internal.net.E e2;
        com.adobe.creativesdk.foundation.internal.net.E e3;
        e2 = this.f7003d._pullPSDCompositeRequestHandle;
        if (e2 != null) {
            e3 = this.f7003d._pullPSDCompositeRequestHandle;
            e3.b(this.f7002c);
            this.f7003d._pullPSDCompositeRequestHandle = null;
        }
    }
}
