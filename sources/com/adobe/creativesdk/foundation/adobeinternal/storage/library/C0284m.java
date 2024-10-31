package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0284m implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ vb f4645a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f4646b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0287p f4647c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0284m(C0287p c0287p, vb vbVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f4647c = c0287p;
        this.f4645a = vbVar;
        this.f4646b = fVar;
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
                this.f4645a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f4645a.a(null, adobeNetworkException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        AdobeAssetException adobeAssetException = null;
        if (g2 != 200 && g2 != 304) {
            adobeAssetException = this.f4647c.a(lVar);
        } else {
            Map<String, List<String>> e2 = lVar.e();
            this.f4646b.f6613e = (e2 == null || !e2.containsKey("etag")) ? null : e2.get("etag").get(0);
            if (e2 != null && e2.containsKey("content-md5")) {
                this.f4646b.c(e2.get("content-md5").get(0));
            } else {
                this.f4646b.c(null);
            }
        }
        this.f4645a.a(this.f4646b, adobeAssetException);
    }
}
