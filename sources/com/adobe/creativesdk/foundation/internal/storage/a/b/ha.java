package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
class ha implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0225c f5415a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ib f5416b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5417c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(ra raVar, C0225c c0225c, ib ibVar) {
        this.f5417c = raVar;
        this.f5415a = c0225c;
        this.f5416b = ibVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobeCSDKException adobeCSDKException;
        Ka ka = null;
        if (lVar.g() == 200) {
            long a2 = lVar.a();
            Ka i = this.f5415a.i();
            i.a(a2);
            ka = i;
            adobeCSDKException = null;
        } else {
            AdobeAssetException a3 = ra.a(lVar);
            AdobeAssetErrorCode errorCode = a3.getErrorCode();
            adobeCSDKException = a3;
            if (errorCode == AdobeAssetErrorCode.AdobeAssetErrorFileWriteFailure) {
                adobeCSDKException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure, "write failure");
            }
        }
        this.f5416b.a(ka, adobeCSDKException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5416b.a(null, adobeNetworkException);
    }
}
