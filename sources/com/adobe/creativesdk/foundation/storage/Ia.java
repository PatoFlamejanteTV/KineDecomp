package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Ia implements com.adobe.creativesdk.foundation.internal.net.H {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7009a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f7010b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(AdobeAssetPSDFile adobeAssetPSDFile, sd sdVar) {
        this.f7010b = adobeAssetPSDFile;
        this.f7009a = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.H
    public void a(double d2) {
        sd sdVar = this.f7009a;
        if (sdVar != null) {
            sdVar.a(d2);
        }
    }
}
