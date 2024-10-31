package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class X implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ vb f5358a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f5359b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5360c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(ra raVar, vb vbVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f5360c = raVar;
        this.f5358a = vbVar;
        this.f5359b = fVar;
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
                this.f5358a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f5358a.a(null, adobeNetworkException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        AdobeAssetException adobeAssetException = null;
        if (g2 != 200 && g2 != 304) {
            adobeAssetException = ra.a(lVar);
        } else {
            Map<String, List<String>> e2 = lVar.e();
            this.f5359b.f6613e = (e2 == null || !e2.containsKey("etag")) ? null : e2.get("etag").get(0);
            if (e2 != null && e2.containsKey("content-md5")) {
                this.f5359b.c(e2.get("content-md5").get(0));
            } else {
                this.f5359b.c(null);
            }
        }
        this.f5358a.a(this.f5359b, adobeAssetException);
    }
}
