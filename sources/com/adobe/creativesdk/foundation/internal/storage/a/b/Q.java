package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class Q implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ pb f5337a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fa f5338b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f5339c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5340d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(ra raVar, pb pbVar, Fa fa, C0231f c0231f) {
        this.f5340d = raVar;
        this.f5337a = pbVar;
        this.f5338b = fa;
        this.f5339c = c0231f;
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
                this.f5337a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f5337a.a(null, adobeNetworkException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobeCSDKException adobeCSDKException;
        int g2 = lVar.g();
        Fa fa = null;
        if (g2 == 200 || g2 == 201 || g2 == 204) {
            Map<String, List<String>> e2 = lVar.e();
            String str = (e2 == null || !e2.containsKey("etag")) ? null : e2.get("etag").get(0);
            if (str != null) {
                try {
                    Fa j = this.f5338b.j();
                    j.g(str);
                    if (j.g() == null) {
                        j.a(this.f5339c.r());
                    }
                    fa = j;
                    adobeCSDKException = null;
                } catch (AdobeDCXException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
                    return;
                }
            } else {
                adobeCSDKException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, lVar.h(), lVar.c(), g2, e2);
            }
        } else if (g2 == 409) {
            adobeCSDKException = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorCompositeAlreadyExists);
        } else if (g2 == 404) {
            adobeCSDKException = (c.a.a.a.c.a.a.b().a() == null || com.adobe.creativesdk.foundation.adobeinternal.net.a.c()) ? null : com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorOffline, lVar.h(), lVar.c(), lVar.g(), lVar.e());
            if (adobeCSDKException == null) {
                adobeCSDKException = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorUnknownComposite);
            }
        } else {
            adobeCSDKException = ra.a(lVar);
        }
        this.f5337a.a(fa, adobeCSDKException);
    }
}
