package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.adobe.creativesdk.foundation.storage.sd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class U implements ga {

    /* renamed from: a, reason: collision with root package name */
    private ja f5256a;

    /* renamed from: b, reason: collision with root package name */
    private AdobePhotoCatalog f5257b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5258c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5259d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5260e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5261f;

    /* renamed from: g, reason: collision with root package name */
    private String f5262g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5263h;
    private ArrayList<AdobePhotoCollection> i;
    private AdobeCloud j;

    public U(ja jaVar, AdobeCloud adobeCloud) {
        this.f5256a = null;
        this.f5257b = null;
        this.f5258c = false;
        this.f5259d = false;
        this.f5260e = false;
        this.f5261f = false;
        this.f5262g = null;
        this.f5263h = false;
        this.i = null;
        this.f5256a = jaVar;
        this.f5257b = null;
        this.f5258c = false;
        this.f5259d = false;
        this.f5260e = false;
        this.f5261f = false;
        this.f5262g = null;
        this.f5263h = false;
        this.i = null;
        this.j = adobeCloud;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ja jaVar = this.f5256a;
        if (jaVar != null) {
            jaVar.a();
        }
        this.f5259d = true;
        this.f5260e = false;
        this.f5261f = false;
        this.f5262g = null;
        if (this.f5259d) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, U.class.getSimpleName(), "Show first page of collections.");
        }
        a(null, new M(this), new N(this));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public int getCount() {
        ArrayList<AdobePhotoCollection> arrayList = this.i;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void e() {
        ArrayList<AdobePhotoCollection> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
        }
        ja jaVar = this.f5256a;
        if (jaVar != null) {
            jaVar.d();
        }
        AdobePhotoCatalog.listCatalogOfType(AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom, this.j, new K(this), new L(this));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void b() {
        a((ja) null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void c() {
        if (this.f5260e) {
            return;
        }
        if (this.f5259d) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, U.class.getSimpleName(), "Show next page of collections.");
        }
        ja jaVar = this.f5256a;
        if (jaVar != null) {
            jaVar.c();
        }
        a(this.f5262g, new Q(this), new S(this));
    }

    public ArrayList<AdobePhotoCollection> d() {
        return this.i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public boolean a() {
        e();
        return true;
    }

    public void a(ja jaVar) {
        this.f5256a = jaVar;
    }

    public ArrayList<AdobePhotoCollection> a(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return this.i;
        }
        ArrayList<AdobePhotoCollection> arrayList = new ArrayList<>();
        ArrayList<AdobePhotoCollection> arrayList2 = this.i;
        if (arrayList2 != null) {
            Iterator<AdobePhotoCollection> it = arrayList2.iterator();
            while (it.hasNext()) {
                AdobePhotoCollection next = it.next();
                if (next.getName() != null && next.getName().toLowerCase().contains(str.toLowerCase())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private void a(String str, c.a.a.a.b<ArrayList<AdobePhotoCollection>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (this.f5259d) {
            this.f5259d = false;
            if (this.f5261f && this.f5262g == null) {
                this.f5259d = true;
                if (bVar != null) {
                    bVar.b(null);
                    return;
                }
                return;
            }
            this.f5257b.listCollectionsAfterName(str, 20, false, new O(this, str, bVar), new P(this, cVar));
        }
    }

    public static void a(AdobePhotoCollection adobePhotoCollection, sd<byte[], AdobePhotoException> sdVar) {
        if (adobePhotoCollection.getCoverAsset() != null) {
            Map<String, AdobePhotoAssetRendition> renditions = adobePhotoCollection.getCoverAsset().getRenditions();
            if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x) != null) {
                adobePhotoCollection.getCoverAsset().downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x), sdVar);
                return;
            } else {
                sdVar.b(null);
                return;
            }
        }
        adobePhotoCollection.listAssetsOnPage(null, AdobePhotoCollection.AdobePhotoCollectionSort.ADOBE_PHOTO_COLLECTION_SORT_BY_DATE, 1, AdobePhotoCollection.AdobePhotoCollectionFlag.ADOBE_PHOTO_COLLECTION_FLAG_ALL, new T(adobePhotoCollection, sdVar), new J(sdVar));
    }
}
