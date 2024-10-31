package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
class Yc implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7181a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7182b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yc(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar) {
        this.f7182b = adobePhotoCollection;
        this.f7181a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        c.a.a.a.b bVar = this.f7181a;
        if (bVar != null) {
            bVar.b(arrayList.get(0));
        }
    }
}
