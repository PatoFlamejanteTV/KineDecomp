package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.storage.C0512k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* loaded from: classes.dex */
public class Z implements com.adobe.creativesdk.foundation.internal.storage.a.b.ta {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0578la f7183a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7184b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7185c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(C0578la c0578la, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f7183a = c0578la;
        this.f7184b = bVar;
        this.f7185c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ta
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        if (eVar != null) {
            this.f7184b.b(new C0512k(eVar, this.f7183a.g()));
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null) {
            this.f7185c.a(adobeAssetException);
        }
    }
}
