package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class A implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f5285a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5286b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ va f5287c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5288d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, String str, va vaVar) {
        this.f5288d = raVar;
        this.f5285a = fVar;
        this.f5286b = str;
        this.f5287c = vaVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 304) {
            this.f5287c.a((va) ra.a(lVar));
            return;
        }
        if (this.f5285a.i() == null && this.f5286b == null && g2 != 304 && lVar.c() != null) {
            this.f5285a.a(lVar.c());
        }
        Map<String, List<String>> e2 = lVar.e();
        if (e2 != null) {
            if (e2.containsKey("etag")) {
                this.f5285a.f6613e = e2.get("etag").get(0);
            }
            if (this.f5285a.k() == null && e2.containsKey("x-latest-version")) {
                this.f5285a.e(e2.get("x-latest-version").get(0));
            }
            if (e2.containsKey("content-md5")) {
                this.f5285a.c(e2.get("content-md5").get(0));
            }
            if (e2.containsKey("x-resource-id")) {
                this.f5285a.f6609a = e2.get("x-resource-id").get(0);
            }
        }
        if (g2 != 304) {
            this.f5285a.a(Integer.valueOf(lVar.a()));
        }
        this.f5287c.a(this.f5285a);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f5287c.a(d2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5287c.a((va) ra.a(adobeNetworkException));
    }
}
