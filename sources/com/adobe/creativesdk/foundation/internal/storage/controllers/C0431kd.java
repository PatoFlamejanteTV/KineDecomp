package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileCreationPackageCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.kd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0431kd implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f6168a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0436ld.a.C0033a f6169b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPackagePages f6170c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f6171d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0436ld.a f6172e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0431kd(C0436ld.a aVar, AdobeAssetFile adobeAssetFile, C0436ld.a.C0033a c0033a, AdobeAssetPackagePages adobeAssetPackagePages, ArrayList arrayList) {
        this.f6172e = aVar;
        this.f6168a = adobeAssetFile;
        this.f6169b = c0033a;
        this.f6170c = adobeAssetPackagePages;
        this.f6171d = arrayList;
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
        C0436ld.this.q.a(this.f6168a.getGUID() + this.f6168a.getMd5Hash(), bArr, new C0421id(this), new C0426jd(this));
    }
}
