package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class dd implements td {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ td f7233a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7234b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(AdobePhotoCollection adobePhotoCollection, td tdVar) {
        this.f7234b = adobePhotoCollection;
        this.f7233a = tdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.td
    public void a(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoPage adobePhotoPage, AdobePhotoPage adobePhotoPage2) {
        td tdVar = this.f7233a;
        if (tdVar != null) {
            tdVar.a(arrayList, adobePhotoPage, adobePhotoPage2);
        }
    }
}
