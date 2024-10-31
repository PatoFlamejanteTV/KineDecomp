package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0453oc;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompositionsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.nc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0448nc implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f6346a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0453oc.a.C0036a f6347b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPackagePages f6348c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f6349d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0453oc.a f6350e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0448nc(C0453oc.a aVar, AdobeAssetFile adobeAssetFile, C0453oc.a.C0036a c0036a, AdobeAssetPackagePages adobeAssetPackagePages, ArrayList arrayList) {
        this.f6350e = aVar;
        this.f6346a = adobeAssetFile;
        this.f6347b = c0036a;
        this.f6348c = adobeAssetPackagePages;
        this.f6349d = arrayList;
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
        C0453oc.this.q.a(this.f6346a.getGUID() + this.f6346a.getMd5Hash(), bArr, new C0435lc(this), new C0440mc(this));
    }
}
