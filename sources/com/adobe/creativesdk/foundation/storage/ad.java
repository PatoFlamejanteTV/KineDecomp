package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
class ad implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7201a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7202b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar) {
        this.f7202b = adobePhotoCollection;
        this.f7201a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        c.a.a.a.b bVar = this.f7201a;
        if (bVar != null) {
            bVar.b(arrayList.get(0));
        }
    }
}
