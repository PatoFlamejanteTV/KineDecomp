package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class F implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f5302a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f5303b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5304c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar) {
        this.f5304c = raVar;
        this.f5302a = fVar;
        this.f5303b = vaVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 204) {
            this.f5303b.a((va) ra.a(lVar));
            return;
        }
        Map<String, List<String>> e2 = lVar.e();
        if (e2 != null) {
            if (e2.containsKey("etag")) {
                this.f5302a.f6613e = e2.get("etag").get(0);
            }
            if (e2.containsKey("content-md5")) {
                this.f5302a.c(e2.get("content-md5").get(0));
            }
            if (e2.containsKey("x-resource-id")) {
                this.f5302a.f6609a = e2.get("x-resource-id").get(0);
            }
            if (e2.containsKey("content-length")) {
                this.f5302a.a(Integer.valueOf(Integer.parseInt(e2.get("content-length").get(0))));
            }
        }
        this.f5303b.a(this.f5302a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5303b.a((va) ra.a(adobeNetworkException));
    }
}
