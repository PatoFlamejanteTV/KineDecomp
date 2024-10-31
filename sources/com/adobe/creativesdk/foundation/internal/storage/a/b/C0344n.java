package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0344n implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.e f5449a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ta f5450b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5451c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0344n(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, ta taVar) {
        this.f5451c = raVar;
        this.f5449a = eVar;
        this.f5450b = taVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 201) {
            this.f5450b.a((ta) ra.a(lVar));
            return;
        }
        Map<String, List<String>> e2 = lVar.e();
        if (e2 != null) {
            if (e2.containsKey("etag")) {
                this.f5449a.f6613e = e2.get("etag").get(0);
            }
            if (e2.containsKey("x-resource-id")) {
                this.f5449a.f6609a = e2.get("x-resource-id").get(0);
            }
            if (e2.containsKey("date")) {
                this.f5449a.f6614f = e2.get("date").get(0);
                this.f5449a.f6615g = e2.get("date").get(0);
            }
        }
        this.f5450b.a(this.f5449a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5450b.a((ta) ra.a(adobeNetworkException));
    }
}
