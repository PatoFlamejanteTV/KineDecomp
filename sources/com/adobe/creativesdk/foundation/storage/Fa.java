package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Fa implements com.adobe.creativesdk.foundation.adobeinternal.imageservice.v {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6970a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f6971b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f6972c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa(AdobeAssetPSDFile adobeAssetPSDFile, String str, sd sdVar) {
        this.f6972c = adobeAssetPSDFile;
        this.f6970a = str;
        this.f6971b = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.v
    public void a(com.adobe.creativesdk.foundation.adobeinternal.imageservice.b bVar) {
        this.f6972c._previewPSDCompositeRequest = null;
        try {
            com.adobe.creativesdk.foundation.adobeinternal.storage.psd.a a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.psd.a.a(this.f6970a, this.f6972c.name);
            if (a2 == null || this.f6971b == null) {
                return;
            }
            this.f6971b.b(a2);
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeAssetPSDFile.getPreviewWithAppliedLayerCompId", e2.getMessage());
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.v
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getErrorCode().equals(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetPSDFile.getPreviewWithAppliedLayerCompId", String.format("PSD preview request for %s has been cancelled.", this.f6972c.href));
            sd sdVar = this.f6971b;
            if (sdVar != null) {
                sdVar.a();
                return;
            }
            return;
        }
        sd sdVar2 = this.f6971b;
        if (sdVar2 != null) {
            sdVar2.a((sd) adobeNetworkException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        sd sdVar = this.f6971b;
        if (sdVar != null) {
            sdVar.a(d2);
        }
    }
}
