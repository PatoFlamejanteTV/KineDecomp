package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Ga implements com.adobe.creativesdk.foundation.internal.net.H {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f6985a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f6986b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(AdobeAssetPSDFile adobeAssetPSDFile, sd sdVar) {
        this.f6986b = adobeAssetPSDFile;
        this.f6985a = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.H
    public void a(double d2) {
        sd sdVar = this.f6985a;
        if (sdVar != null) {
            sdVar.a(d2);
        }
    }
}
