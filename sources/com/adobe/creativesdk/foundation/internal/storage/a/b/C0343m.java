package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.storage.model.util.ParsingDataException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0343m implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.e f5442a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeStoragePagingMode f5443b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ta f5444c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5445d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0343m(ra raVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode, ta taVar) {
        this.f5445d = raVar;
        this.f5442a = eVar;
        this.f5443b = adobeStoragePagingMode;
        this.f5444c = taVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 304) {
            this.f5444c.a((ta) ra.a(lVar));
            return;
        }
        if (g2 != 304) {
            try {
                this.f5442a.a(lVar.d(), this.f5443b == AdobeStoragePagingMode.AdobeStorageNextPageAppend);
                if (lVar.e() != null && lVar.e().containsKey("x-children-next-start")) {
                    this.f5442a.b(lVar.e().get("x-children-next-start").get(0));
                } else {
                    this.f5442a.b(null);
                }
                this.f5444c.a(this.f5442a);
            } catch (ParsingDataException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                this.f5444c.a((ta) e2.getError());
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5444c.a((ta) ra.a(adobeNetworkException));
    }
}
