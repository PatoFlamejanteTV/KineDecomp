package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.rc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0603rc implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7404a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7405b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7406c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0603rc(AdobePhotoAsset adobePhotoAsset, sd sdVar, String str) {
        this.f7406c = adobePhotoAsset;
        this.f7404a = sdVar;
        this.f7405b = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        this.f7404a.b(bArr);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        com.adobe.creativesdk.foundation.internal.net.E e2;
        com.adobe.creativesdk.foundation.internal.net.H h2;
        this.f7406c._downloadRequestHandle = null;
        this.f7406c._downloadProgressListener = new C0588nc(this);
        C0596pc c0596pc = new C0596pc(this);
        C0600qc c0600qc = new C0600qc(this);
        if (this.f7406c.getSession() == null) {
            return;
        }
        AdobePhotoAsset adobePhotoAsset = this.f7406c;
        adobePhotoAsset._downloadRequestHandle = adobePhotoAsset.getSession().b(this.f7406c, c0596pc, c0600qc);
        e2 = this.f7406c._downloadRequestHandle;
        h2 = this.f7406c._downloadProgressListener;
        e2.a(h2);
    }
}
