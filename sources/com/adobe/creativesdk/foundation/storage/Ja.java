package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
public class Ja implements com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lb f7019a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f7020b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.H f7021c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f7022d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ja(AdobeAssetPSDFile adobeAssetPSDFile, Lb lb, sd sdVar, com.adobe.creativesdk.foundation.internal.net.H h2) {
        this.f7022d = adobeAssetPSDFile;
        this.f7019a = lb;
        this.f7020b = sdVar;
        this.f7021c = h2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f
    public void a(boolean z) {
        if (z) {
            a();
            try {
                this.f7019a.a();
                com.adobe.creativesdk.foundation.internal.analytics.q.b("Product Saves", "Creative Cloud");
                if (this.f7020b != null) {
                    this.f7020b.b(this.f7019a);
                }
            } catch (AdobeDCXException unused) {
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f
    public void a(AdobeCSDKException adobeCSDKException) {
        a();
        if ((adobeCSDKException instanceof AdobeNetworkException) && ((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, AdobeAssetPSDFile.class.getSimpleName(), "PSD composite push request for %@ has been cancelled for" + this.f7022d.getHref().getPath());
        }
        sd sdVar = this.f7020b;
        if (sdVar != null) {
            sdVar.a((sd) adobeCSDKException);
        }
    }

    void a() {
        com.adobe.creativesdk.foundation.internal.net.E e2;
        e2 = this.f7022d._pushPSDCompositeRequestHandle;
        e2.b(this.f7021c);
        this.f7022d._pushPSDCompositeRequestHandle = null;
    }
}
