package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
public class Ka implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobePhotoException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5700a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f5701b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity f5702c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity, int i, AdobePhotoAsset adobePhotoAsset) {
        this.f5702c = adobeUXPhotoAssetOneUpViewerActivity;
        this.f5700a = i;
        this.f5701b = adobePhotoAsset;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public final void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        b();
    }

    protected void b() {
        if (this.f5702c.B.c()) {
            this.f5702c.f6157e = null;
        } else {
            this.f5702c.a(this.f5700a, false);
        }
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        new Ja(this).execute(bArr);
    }

    @Override // c.a.a.a.c
    public void a(AdobePhotoException adobePhotoException) {
        b();
    }
}
