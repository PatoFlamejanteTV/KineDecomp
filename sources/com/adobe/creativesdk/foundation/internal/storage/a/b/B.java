package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class B implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f5289a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f5290b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5291c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar) {
        this.f5291c = raVar;
        this.f5289a = fVar;
        this.f5290b = vaVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 304) {
            this.f5290b.a((va) ra.a(lVar));
            return;
        }
        Map<String, List<String>> e2 = lVar.e();
        if (e2 != null) {
            if (e2.containsKey("etag")) {
                this.f5289a.f6613e = e2.get("etag").get(0);
            }
            if (this.f5289a.k() == null && e2.containsKey("x-latest-version")) {
                this.f5289a.e(e2.get("x-latest-version").get(0));
            }
            if (e2.containsKey("content-md5")) {
                this.f5289a.c(e2.get("content-md5").get(0));
            }
            if (e2.containsKey("x-resource-id")) {
                this.f5289a.f6609a = e2.get("x-resource-id").get(0);
            }
        }
        if (g2 != 304) {
            this.f5289a.a(Integer.valueOf(lVar.a()));
        }
        this.f5290b.a(this.f5289a);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f5290b.a(d2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5290b.a((va) ra.a(adobeNetworkException));
    }
}
