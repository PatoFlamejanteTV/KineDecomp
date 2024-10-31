package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

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
/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0279h implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ pb f4622a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4623b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0287p f4624c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0279h(C0287p c0287p, pb pbVar, C0231f c0231f) {
        this.f4624c = c0287p;
        this.f4622a = pbVar;
        this.f4623b = c0231f;
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
                this.f4622a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f4622a.a(null, adobeNetworkException);
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
            adobeCSDKException = this.f4624c.a(lVar);
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
                if (e3 != null && e3.containsKey("etag")) {
                    str = e3.get("etag").get(0);
                }
                if (str != null) {
                    fa.g(str);
                    fa.a(this.f4623b.r());
                } else {
                    adobeCSDKException3 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Missing header field ETAG");
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
        this.f4622a.a(fa2, adobeCSDKException);
    }
}
