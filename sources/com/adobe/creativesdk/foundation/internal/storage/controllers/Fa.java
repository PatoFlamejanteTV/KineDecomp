package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Fa implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PhotoView f5639a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity.b f5640b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa(AdobeUXMobilePackageItemOneUpViewerActivity.b bVar, PhotoView photoView) {
        this.f5640b = bVar;
        this.f5639a = photoView;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        new Ea(this).execute(bArr);
        AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity = (AdobeUXMobilePackageItemOneUpViewerActivity) this.f5640b.getActivity();
        if (adobeUXMobilePackageItemOneUpViewerActivity == null) {
            return;
        }
        adobeUXMobilePackageItemOneUpViewerActivity.B();
    }
}
