package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class Zc implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7189a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7190b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zc(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar) {
        this.f7190b = adobePhotoCollection;
        this.f7189a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        c.a.a.a.b bVar = this.f7189a;
        if (bVar != null) {
            bVar.b(arrayList);
        }
    }
}