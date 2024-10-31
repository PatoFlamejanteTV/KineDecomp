package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ba implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0533a f5590a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity f5591b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity, C0533a c0533a) {
        this.f5591b = adobeUXMobilePackageItemOneUpViewerActivity;
        this.f5590a = c0533a;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public final void a(double d2) {
    }

    protected void b() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        b();
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        new Aa(this).execute(bArr);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        b();
    }
}
