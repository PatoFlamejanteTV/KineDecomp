package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoPage;
import com.adobe.creativesdk.foundation.storage.sd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobePhotoAssetsDataSource.java */
/* loaded from: classes.dex */
public class I implements ga {

    /* renamed from: b */
    private ia f5235b;

    /* renamed from: d */
    private boolean f5237d;
    private AdobePhotoCollection j;

    /* renamed from: a */
    private AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType f5234a = c.a.a.a.c.a.c.a();

    /* renamed from: c */
    private boolean f5236c = false;

    /* renamed from: e */
    private boolean f5238e = false;

    /* renamed from: f */
    private boolean f5239f = false;

    /* renamed from: g */
    private boolean f5240g = false;

    /* renamed from: h */
    private AdobePhotoPage f5241h = null;
    private int i = 0;
    private ArrayList<AdobePhotoAsset> k = null;
    private HashSet<String> l = null;

    public I(AdobePhotoCollection adobePhotoCollection, ia iaVar) {
        this.f5235b = iaVar;
        this.j = adobePhotoCollection;
    }

    public boolean f() {
        return (this.f5239f && this.f5241h == null) ? false : true;
    }

    public void g() {
        if (this.f5237d) {
            return;
        }
        ArrayList<AdobePhotoAsset> arrayList = this.k;
        if (arrayList != null) {
            arrayList.clear();
        }
        ia iaVar = this.f5235b;
        if (iaVar != null) {
            iaVar.a();
        }
        this.f5237d = true;
        this.f5236c = false;
        this.f5238e = true;
        this.f5239f = false;
        this.f5240g = false;
        this.f5241h = null;
        this.i = 0;
        Level level = Level.DEBUG;
        String simpleName = I.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Show first page for photos with sorting by ");
        sb.append(this.f5234a == AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType.ADOBE_PHOTO_SORT_TYPE_TIME ? "time" : "custom order");
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
        this.j.assetCount(new A(this), new B(this));
        a(null, this.f5234a, new C(this), new D(this));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public int getCount() {
        ArrayList<AdobePhotoAsset> arrayList = this.k;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void c() {
        if (this.f5237d || this.f5236c) {
            return;
        }
        if (this.f5238e) {
            Level level = Level.DEBUG;
            String simpleName = I.class.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("Show first page for photos with sorting by ");
            sb.append(this.f5234a == AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType.ADOBE_PHOTO_SORT_TYPE_TIME ? "time" : "custom order");
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
        }
        ia iaVar = this.f5235b;
        if (iaVar != null) {
            iaVar.c();
        }
        a(this.f5241h, this.f5234a, new G(this), new H(this));
    }

    public ArrayList<AdobePhotoAsset> d() {
        return this.k;
    }

    public int e() {
        return this.i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void b() {
        a((ia) null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public boolean a() {
        g();
        return true;
    }

    public ArrayList<AdobePhotoAsset> a(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return this.k;
        }
        ArrayList<AdobePhotoAsset> arrayList = new ArrayList<>();
        ArrayList<AdobePhotoAsset> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<AdobePhotoAsset> it = arrayList2.iterator();
            while (it.hasNext()) {
                AdobePhotoAsset next = it.next();
                if (next.getName() != null && next.getName().toLowerCase().contains(str.toLowerCase())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void a(ia iaVar) {
        this.f5235b = iaVar;
    }

    private void a(AdobePhotoPage adobePhotoPage, AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType adobeUXAssetBrowserCommonTypes$AdobePhotoSortType, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (this.f5238e) {
            this.f5238e = false;
            if (this.f5239f && this.f5241h == null) {
                this.f5238e = true;
                if (bVar != null) {
                    bVar.b(null);
                    return;
                }
                return;
            }
            AdobePhotoCollection.AdobePhotoCollectionSort adobePhotoCollectionSort = AdobePhotoCollection.AdobePhotoCollectionSort.ADOBE_PHOTO_COLLECTION_SORT_BY_DATE;
            if (adobeUXAssetBrowserCommonTypes$AdobePhotoSortType == AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType.ADOBE_PHOTO_SORT_TYPE_CUSTOM) {
                adobePhotoCollectionSort = AdobePhotoCollection.AdobePhotoCollectionSort.ADOBE_PHOTO_COLLECTION_SORT_BY_CUSTOM_ORDER;
            }
            this.j.listAssetsOnPage(adobePhotoPage, adobePhotoCollectionSort, 20, AdobePhotoCollection.AdobePhotoCollectionFlag.ADOBE_PHOTO_COLLECTION_FLAG_ALL, new E(this, bVar), new F(this, cVar));
        }
    }

    public boolean a(ArrayList<AdobePhotoAsset> arrayList) {
        if (arrayList == null) {
            return false;
        }
        Iterator<AdobePhotoAsset> it = arrayList.iterator();
        float f2 = 0.0f;
        while (it.hasNext()) {
            AdobePhotoAsset next = it.next();
            if (this.l.contains(next.getGUID())) {
                f2 += 1.0f;
            } else {
                this.k.add(next);
            }
        }
        if (this.i == 0) {
            this.i = this.k.size();
        }
        if (f2 / arrayList.size() < 0.7d) {
            return false;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, I.class.getSimpleName(), "More than 70% of the last page had duplicate values. Pulling the next page.");
        this.f5238e = true;
        c();
        return true;
    }

    public static void a(AdobePhotoAsset adobePhotoAsset, sd<byte[], AdobePhotoException> sdVar) {
        Map<String, AdobePhotoAssetRendition> renditions = adobePhotoAsset.getRenditions();
        if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x) != null) {
            adobePhotoAsset.downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x), sdVar);
        } else {
            sdVar.b(null);
        }
    }
}
