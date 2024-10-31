package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class V implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ pb f5351a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f5352b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5353c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(ra raVar, pb pbVar, C0231f c0231f) {
        this.f5353c = raVar;
        this.f5351a = pbVar;
        this.f5352b = c0231f;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getData() != null) {
            com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
            if (lVar != null) {
                a(lVar);
                return;
            } else {
                this.f5351a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f5351a.a(null, adobeNetworkException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobeCSDKException adobeCSDKException;
        Fa fa;
        AdobeCSDKException adobeCSDKException2;
        AdobeCSDKException adobeCSDKException3;
        int g2 = lVar.g();
        Fa fa2 = null;
        fa2 = null;
        r2 = null;
        String str = null;
        if (g2 != 200 && g2 != 304) {
            adobeCSDKException = ra.a(lVar);
        } else if (g2 == 200) {
            try {
                fa = new Fa(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(lVar.d()));
                adobeCSDKException2 = null;
            } catch (AdobeDCXException e2) {
                fa = null;
                adobeCSDKException2 = e2;
            }
            if (fa != null) {
                Map<String, List<String>> e3 = lVar.e();
                String str2 = (e3 == null || !e3.containsKey("etag")) ? null : e3.get("etag").get(0);
                if (e3 != null && e3.containsKey("x-latest-version")) {
                    str = e3.get("x-latest-version").get(0);
                }
                if (str2 != null && str != null) {
                    fa.g(str2);
                    fa.a(this.f5352b.r());
                    fa.a(this.f5352b.m());
                } else {
                    AdobeAssetErrorCode adobeAssetErrorCode = AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse;
                    Object[] objArr = new Object[1];
                    objArr[0] = str2 != null ? "x-latest-version" : "etag";
                    adobeCSDKException3 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(adobeAssetErrorCode, String.format("Missing header field %s", objArr));
                    adobeCSDKException = adobeCSDKException3;
                    fa2 = fa;
                }
            }
            adobeCSDKException3 = adobeCSDKException2;
            adobeCSDKException = adobeCSDKException3;
            fa2 = fa;
        } else {
            adobeCSDKException = null;
        }
        this.f5351a.a(fa2, adobeCSDKException);
    }
}
