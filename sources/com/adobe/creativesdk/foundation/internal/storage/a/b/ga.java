package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
class ga implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ib f5410a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f5411b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5412c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(ra raVar, ib ibVar, C0225c c0225c) {
        this.f5412c = raVar;
        this.f5410a = ibVar;
        this.f5411b = c0225c;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorFileDoesNotExist) {
            this.f5410a.a(this.f5411b, com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure, adobeNetworkException.getDescription()));
            return;
        }
        if (adobeNetworkException.getData() != null) {
            com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
            if (lVar != null) {
                a(lVar);
                return;
            } else {
                this.f5410a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f5410a.a(null, adobeNetworkException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobeCSDKException a2;
        if (lVar.g() == 200) {
            Map<String, List<String>> e2 = lVar.e();
            a2 = null;
            String str = (e2 == null || !e2.containsKey("etag")) ? null : e2.get("etag").get(0);
            int a3 = lVar.a();
            if (str == null) {
                a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Missing header field Etag");
            } else if (this.f5411b.f() == 0 && a3 != this.f5411b.f()) {
                a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, String.format("Downloaded components has a length of %d. Expected: %d", Integer.valueOf(a3), Long.valueOf(this.f5411b.f())));
            }
        } else {
            a2 = ra.a(lVar);
            if (lVar.i()) {
                a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure, a2.getDescription());
            }
        }
        this.f5410a.a(this.f5411b, a2);
    }
}
