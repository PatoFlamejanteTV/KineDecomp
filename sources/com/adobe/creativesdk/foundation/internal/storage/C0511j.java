package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.a.b.va;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeAssetFileInternal.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0511j implements va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f6591a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6592b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f6593c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f6594d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ra f6595e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ sd f6596f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0511j(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, String str2, String str3, ra raVar, sd sdVar) {
        this.f6591a = jVar;
        this.f6592b = str;
        this.f6593c = str2;
        this.f6594d = str3;
        this.f6595e = raVar;
        this.f6596f = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f6591a.b("If-Match", "*");
        AdobeAssetFileInternal.a(this.f6591a, this.f6592b, this.f6593c, this.f6594d, this.f6595e, this.f6596f);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException.getHttpStatusCode().intValue() == 404) {
            AdobeAssetFileInternal.a(this.f6591a, this.f6592b, this.f6593c, this.f6594d, this.f6595e, this.f6596f);
        } else {
            this.f6596f.a((sd) adobeAssetException);
        }
    }
}
