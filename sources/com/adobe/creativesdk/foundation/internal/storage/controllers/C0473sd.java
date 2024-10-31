package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0478td;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileCreationPackageItemsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.sd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0473sd implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f6401a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0478td.a.C0037a f6402b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0478td.a f6403c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0473sd(C0478td.a aVar, AdobeAssetFile adobeAssetFile, C0478td.a.C0037a c0037a) {
        this.f6403c = aVar;
        this.f6401a = adobeAssetFile;
        this.f6402b = c0037a;
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
        C0478td.this.p.a(this.f6401a.getGUID() + this.f6401a.getMd5Hash(), bArr, new C0464qd(this), new C0468rd(this));
    }
}
