package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.wc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0623wc implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7460a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7461b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAssetRendition f7462c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7463d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0623wc(AdobePhotoAsset adobePhotoAsset, sd sdVar, String str, AdobePhotoAssetRendition adobePhotoAssetRendition) {
        this.f7463d = adobePhotoAsset;
        this.f7460a = sdVar;
        this.f7461b = str;
        this.f7462c = adobePhotoAssetRendition;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        this.f7460a.b(bArr);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        com.adobe.creativesdk.foundation.internal.net.E e2;
        com.adobe.creativesdk.foundation.internal.net.H h2;
        this.f7463d._downloadRequestHandle = null;
        this.f7463d._downloadProgressListener = new C0607sc(this);
        C0615uc c0615uc = new C0615uc(this);
        C0619vc c0619vc = new C0619vc(this);
        if (this.f7463d.getSession() == null) {
            return;
        }
        AdobePhotoAsset adobePhotoAsset = this.f7463d;
        adobePhotoAsset._downloadRequestHandle = adobePhotoAsset.getSession().a(this.f7462c, this.f7463d, c0615uc, c0619vc);
        e2 = this.f7463d._downloadRequestHandle;
        h2 = this.f7463d._downloadProgressListener;
        e2.a(h2);
    }
}
