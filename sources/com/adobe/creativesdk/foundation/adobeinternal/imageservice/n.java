package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class n implements F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f4040a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f4041b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f4042c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ t f4043d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(t tVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, sd sdVar, com.adobe.creativesdk.foundation.internal.net.j jVar) {
        this.f4043d = tVar;
        this.f4040a = fVar;
        this.f4041b = sdVar;
        this.f4042c = jVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Map map;
        int g2 = lVar.g();
        AdobeNetworkException adobeNetworkException = null;
        if (g2 != 200 && g2 != 304) {
            adobeNetworkException = this.f4043d.a(lVar);
        } else if (g2 == 200) {
            this.f4040a.a(lVar.c());
            Map<String, List<String>> e2 = lVar.e();
            String str = (e2 == null || !e2.containsKey("etag")) ? null : e2.get("etag").get(0);
            if (str != null) {
                com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar = this.f4040a;
                fVar.f6613e = str;
                this.f4041b.b(fVar);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "Missing header field 'etag'");
                adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, hashMap);
                this.f4041b.a((sd) adobeNetworkException);
            }
        }
        if (adobeNetworkException != null) {
            this.f4041b.a((sd) adobeNetworkException);
        }
        map = this.f4043d.k;
        map.remove(this.f4042c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:            r5 = r5;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.adobe.creativesdk.foundation.storage.AdobeAssetException] */
    @Override // com.adobe.creativesdk.foundation.internal.net.F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.network.AdobeNetworkException r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L42
            java.util.HashMap r0 = r5.getData()
            if (r0 == 0) goto L42
            java.util.HashMap r0 = r5.getData()
            java.lang.String r1 = "Response"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L42
            java.util.HashMap r0 = r5.getData()
            java.lang.Object r0 = r0.get(r1)
            com.adobe.creativesdk.foundation.internal.net.l r0 = (com.adobe.creativesdk.foundation.internal.net.l) r0
            int r1 = r0.g()
            r2 = 404(0x194, float:5.66E-43)
            if (r1 != r2) goto L42
            boolean r1 = com.adobe.creativesdk.foundation.adobeinternal.net.a.c()
            if (r1 != 0) goto L42
            com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode r5 = com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode.AdobeAssetErrorOffline
            java.net.URL r1 = r0.h()
            byte[] r2 = r0.c()
            int r3 = r0.g()
            java.util.Map r0 = r0.e()
            com.adobe.creativesdk.foundation.storage.AdobeAssetException r5 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(r5, r1, r2, r3, r0)
        L42:
            com.adobe.creativesdk.foundation.storage.sd r0 = r4.f4041b
            r0.a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.imageservice.n.a(com.adobe.creativesdk.foundation.network.AdobeNetworkException):void");
    }
}
