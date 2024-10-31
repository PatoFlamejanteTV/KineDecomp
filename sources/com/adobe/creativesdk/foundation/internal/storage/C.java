package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAssetsDataSource.java */
/* loaded from: classes.dex */
public class C implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f5226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(I i) {
        this.f5226a = i;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        ia iaVar;
        ia iaVar2;
        int i;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashSet hashSet;
        ArrayList arrayList4;
        if (arrayList != null) {
            this.f5226a.f5240g = arrayList.size() == 0;
            this.f5226a.k = arrayList;
            i = this.f5226a.i;
            if (i == 0) {
                I i2 = this.f5226a;
                arrayList4 = i2.k;
                i2.i = arrayList4.size();
            }
            I i3 = this.f5226a;
            arrayList2 = i3.k;
            i3.l = new HashSet(arrayList2.size());
            arrayList3 = this.f5226a.k;
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                AdobePhotoAsset adobePhotoAsset = (AdobePhotoAsset) it.next();
                hashSet = this.f5226a.l;
                hashSet.add(adobePhotoAsset.getGUID());
            }
        } else {
            this.f5226a.f5240g = true;
        }
        this.f5226a.f5238e = true;
        iaVar = this.f5226a.f5235b;
        if (iaVar != null) {
            iaVar2 = this.f5226a.f5235b;
            iaVar2.b();
        }
        this.f5226a.f5237d = false;
    }
}
