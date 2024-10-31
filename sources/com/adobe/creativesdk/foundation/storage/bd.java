package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class bd implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7213a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7214b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar) {
        this.f7214b = adobePhotoCollection;
        this.f7213a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        c.a.a.a.b bVar = this.f7213a;
        if (bVar != null) {
            bVar.b(arrayList);
        }
    }
}
