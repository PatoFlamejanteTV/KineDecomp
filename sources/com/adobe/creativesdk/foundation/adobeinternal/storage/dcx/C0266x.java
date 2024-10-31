package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0266x implements ib {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4478a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0270z f4479b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0266x(C0270z c0270z, String str) {
        this.f4479b = c0270z;
        this.f4478a = str;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib
    public void a(C0225c c0225c, AdobeCSDKException adobeCSDKException) {
        String str;
        AdobeCSDKException adobeCSDKException2 = null;
        if (adobeCSDKException != null) {
            if (adobeCSDKException.getData() != null && adobeCSDKException.getData().containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey) && ((Integer) adobeCSDKException.getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)).intValue() == 404) {
                adobeCSDKException = null;
                adobeCSDKException2 = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorMissingComponentAsset);
            }
        } else if (this.f4479b.f4494e.f4105f.L()) {
            try {
                this.f4479b.a();
            } catch (Exception e2) {
                AdobeDCXErrorCode adobeDCXErrorCode = AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure;
                StringBuilder sb = new StringBuilder();
                sb.append("invalid write permissions for filePath : ");
                str = this.f4479b.f4490a;
                sb.append(str);
                adobeCSDKException2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(adobeDCXErrorCode, sb.toString(), e2);
            }
            if (adobeCSDKException2 != null && this.f4479b.f4494e.f4105f.v()) {
                com.adobe.creativesdk.foundation.internal.storage.model.util.f.c(this.f4478a);
            }
        }
        if (adobeCSDKException2 == null) {
            adobeCSDKException2 = adobeCSDKException;
        }
        this.f4479b.f4492c.a(adobeCSDKException2);
        this.f4479b.f4494e.f4104e.a(adobeCSDKException2);
    }
}
