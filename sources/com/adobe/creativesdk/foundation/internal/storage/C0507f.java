package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.AdobeAssetProduct;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0276e;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderBy;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderDirection;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AdobeAssetDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0507f implements ga {

    /* renamed from: a, reason: collision with root package name */
    private static int f6573a = 20;

    /* renamed from: b, reason: collision with root package name */
    protected AdobeCloud f6574b;

    /* renamed from: c, reason: collision with root package name */
    private ha f6575c;

    /* renamed from: d, reason: collision with root package name */
    private C0578la f6576d;

    /* renamed from: e, reason: collision with root package name */
    AdobeAssetDataSourceType f6577e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<C0533a> f6578f;

    /* renamed from: g, reason: collision with root package name */
    boolean f6579g;

    /* renamed from: h, reason: collision with root package name */
    boolean f6580h;

    public C0507f(AdobeAssetDataSourceType adobeAssetDataSourceType, AdobeCloud adobeCloud) {
        this.f6577e = adobeAssetDataSourceType;
        this.f6574b = adobeCloud;
    }

    public void a(ha haVar) {
        this.f6575c = haVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void b() {
        a((ha) null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void c() {
        g();
    }

    public ArrayList<C0533a> d() {
        return this.f6578f;
    }

    public ha e() {
        return this.f6575c;
    }

    public C0578la f() {
        return this.f6576d;
    }

    public boolean g() {
        if (this.f6579g) {
            return false;
        }
        if (!this.f6576d.c()) {
            ha e2 = e();
            if (e2 != null) {
                e2.c();
            }
            return false;
        }
        this.f6579g = true;
        this.f6576d.a(f6573a, new C0506e(this, new WeakReference(this)));
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public int getCount() {
        ArrayList<C0533a> arrayList = this.f6578f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public ArrayList<C0533a> a(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return d();
        }
        ArrayList<C0533a> arrayList = new ArrayList<>();
        ArrayList<C0533a> arrayList2 = this.f6578f;
        if (arrayList2 != null) {
            Iterator<C0533a> it = arrayList2.iterator();
            while (it.hasNext()) {
                C0533a next = it.next();
                if (next.getName() != null && next.getName().toLowerCase().contains(str.toLowerCase())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean a(boolean z) {
        ha e2;
        if (this.f6579g) {
            return false;
        }
        C0578la c0578la = this.f6576d;
        if (c0578la != null) {
            this.f6580h = z;
            if (z) {
                c0578la.b(AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED, AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING);
                ha e3 = e();
                if (e3 != null) {
                    e3.a();
                }
            }
            if (this.f6576d.c()) {
                ha e4 = e();
                if (e4 != null) {
                    e4.b();
                }
                return g();
            }
            ha e5 = e();
            if (e5 == null) {
                return true;
            }
            e5.c();
            return true;
        }
        AdobeAssetProduct adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductUndefined;
        if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceDraw)) {
            adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductDraw;
        } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceSketches)) {
            adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductSketch;
        } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary)) {
            adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductLibrary;
        } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix)) {
            adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductPSMix;
        } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions)) {
            adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductComposition;
        }
        this.f6576d = C0276e.a(adobeAssetProduct, this.f6574b);
        if (z && (e2 = e()) != null) {
            e2.a();
        }
        return g();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public boolean a() {
        return a(true);
    }
}
