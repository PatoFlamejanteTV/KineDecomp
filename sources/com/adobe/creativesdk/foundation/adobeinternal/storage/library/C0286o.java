package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0286o implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0225c f4652a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ib f4653b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0287p f4654c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0286o(C0287p c0287p, C0225c c0225c, ib ibVar) {
        this.f4654c = c0287p;
        this.f4652a = c0225c;
        this.f4653b = ibVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
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
            } else if (this.f4652a.f() == 0 && a3 != this.f4652a.f()) {
                a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, String.format("Downloaded components has a length of %d. Expected: %d", Integer.valueOf(a3), Long.valueOf(this.f4652a.f())));
            }
        } else {
            a2 = this.f4654c.a(lVar);
            if (lVar.i()) {
                a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure, a2.getDescription());
            }
        }
        this.f4653b.a(this.f4652a, a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorFileDoesNotExist) {
            this.f4653b.a(this.f4652a, com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure, adobeNetworkException.getDescription()));
            return;
        }
        if (adobeNetworkException.getData() != null) {
            com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
            if (lVar != null) {
                a(lVar);
                return;
            } else {
                this.f4653b.a(null, adobeNetworkException);
                return;
            }
        }
        this.f4653b.a(null, adobeNetworkException);
    }
}
