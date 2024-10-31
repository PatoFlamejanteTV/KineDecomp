package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
class Vc implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7150a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7151b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vc(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar) {
        this.f7151b = adobePhotoCollection;
        this.f7150a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        c.a.a.a.b bVar = this.f7150a;
        if (bVar != null) {
            bVar.b(arrayList.get(0));
        }
    }
}
