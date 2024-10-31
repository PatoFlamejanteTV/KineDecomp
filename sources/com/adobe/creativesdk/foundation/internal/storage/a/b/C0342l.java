package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0342l implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.e f5434a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f5435b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f5436c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5437d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0342l(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f5437d = raVar;
        this.f5434a = eVar;
        this.f5435b = bVar;
        this.f5436c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 304) {
            this.f5436c.a(ra.a(lVar));
        } else if (g2 != 304) {
            if (lVar.e() != null && lVar.e().containsKey("x-children-next-start")) {
                this.f5434a.b(lVar.e().get("x-children-next-start").get(0));
            } else {
                this.f5434a.b(null);
            }
            this.f5435b.b(lVar.d());
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5436c.a(ra.a(adobeNetworkException));
    }
}
