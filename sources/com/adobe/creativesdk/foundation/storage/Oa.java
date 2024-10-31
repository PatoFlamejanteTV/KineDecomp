package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Oa implements sd<Lb, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7076a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f7077b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(sd sdVar, AdobeAssetPSDFile adobeAssetPSDFile) {
        this.f7076a = sdVar;
        this.f7077b = adobeAssetPSDFile;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Lb lb) {
        sd sdVar = this.f7076a;
        if (sdVar != null) {
            sdVar.b(this.f7077b);
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        sd sdVar = this.f7076a;
        if (sdVar != null) {
            sdVar.a((sd) adobeCSDKException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        sd sdVar = this.f7076a;
        if (sdVar != null) {
            sdVar.a();
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        sd sdVar = this.f7076a;
        if (sdVar != null) {
            sdVar.a(d2);
        }
    }
}
