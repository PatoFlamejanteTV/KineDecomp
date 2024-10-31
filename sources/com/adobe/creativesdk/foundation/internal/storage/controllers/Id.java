package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.adobe.creativesdk.foundation.storage.C0582ma;

/* compiled from: PhotosBaseListView.java */
/* loaded from: classes.dex */
public class Id implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobePhotoException> {

    /* renamed from: a */
    final /* synthetic */ com.adobe.creativesdk.foundation.storage.sd f5671a;

    /* renamed from: b */
    final /* synthetic */ String f5672b;

    /* renamed from: c */
    final /* synthetic */ AdobeAssetFileRenditionType f5673c;

    /* renamed from: d */
    final /* synthetic */ C0582ma f5674d;

    /* renamed from: e */
    final /* synthetic */ Jd f5675e;

    public Id(Jd jd, com.adobe.creativesdk.foundation.storage.sd sdVar, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        this.f5675e = jd;
        this.f5671a = sdVar;
        this.f5672b = str;
        this.f5673c = adobeAssetFileRenditionType;
        this.f5674d = c0582ma;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        this.f5671a.a();
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(byte[] bArr) {
        this.f5675e.a(bArr, this.f5672b, this.f5673c, this.f5674d, new Gd(this), new Hd(this));
    }

    @Override // c.a.a.a.c
    public void a(AdobePhotoException adobePhotoException) {
        this.f5671a.a((com.adobe.creativesdk.foundation.storage.sd) adobePhotoException);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f5671a.a(d2);
    }
}
