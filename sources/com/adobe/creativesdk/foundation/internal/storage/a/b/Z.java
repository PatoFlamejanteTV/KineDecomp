package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.ud;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class Z implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ud f5365a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ib f5366b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f5367c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0225c f5368d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ra f5369e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(ra raVar, ud udVar, ib ibVar, String str, C0225c c0225c) {
        this.f5369e = raVar;
        this.f5365a = udVar;
        this.f5366b = ibVar;
        this.f5367c = str;
        this.f5368d = c0225c;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        ud udVar = this.f5365a;
        if (udVar != null) {
            udVar.a(d2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        AdobeAssetException a2 = ra.a(adobeNetworkException);
        if (a2 != null && a2.getData() != null && a2.getData().get("Response") != null) {
            a2 = ra.a((com.adobe.creativesdk.foundation.internal.net.l) a2.getData().get("Response"));
        }
        this.f5366b.a(null, a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobeAssetException a2;
        Long l;
        AdobeCSDKException adobeCSDKException;
        int g2 = lVar.g();
        Ka ka = null;
        if (g2 != 200 && g2 != 201 && g2 != 204) {
            AdobeAssetException a3 = ra.a(lVar);
            AdobeAssetErrorCode errorCode = a3.getErrorCode();
            adobeCSDKException = a3;
            if (errorCode == AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure) {
                adobeCSDKException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentReadFailure, a3.getDescription());
            }
        } else {
            Map<String, List<String>> e2 = lVar.e();
            String str = (e2 == null || !e2.containsKey("etag")) ? null : e2.get("etag").get(0);
            String str2 = (e2 == null || !e2.containsKey("x-latest-version")) ? null : e2.get("x-latest-version").get(0);
            String str3 = (e2 == null || !e2.containsKey("content-md5")) ? null : e2.get("content-md5").get(0);
            try {
                l = Long.valueOf(org.apache.commons.io.b.h(new File(this.f5367c)));
                a2 = null;
            } catch (Exception e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
                a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure, "couldn't get file length");
                l = null;
            }
            if (str == null) {
                adobeCSDKException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Missing header field Etag");
            } else if (str2 == null) {
                adobeCSDKException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Missing header field x-latest-version");
            } else if (str3 == null) {
                adobeCSDKException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Missing header field content-md5");
            } else if (l != null && a2 == null) {
                Ka i = this.f5368d.i();
                i.c(str);
                i.d(str3);
                i.h(str2);
                i.a(l.intValue());
                adobeCSDKException = null;
                ka = i;
            } else {
                adobeCSDKException = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorComponentReadFailure);
            }
        }
        this.f5366b.a(ka, adobeCSDKException);
    }
}
