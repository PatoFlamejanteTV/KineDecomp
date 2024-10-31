package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.AdobeAssetProduct;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0276e;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderBy;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderDirection;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.z */
/* loaded from: classes.dex */
public class C0532z extends C0516o {
    private static int n = 20;
    private List<C0276e> o;
    private Map<String, C0516o> p;
    private EnumSet<AdobeAssetDataSourceType> q;
    private volatile int r;
    private volatile int s;
    private volatile int t;
    private volatile int u;

    public C0532z(AdobeAssetDataSourceType adobeAssetDataSourceType, AdobeCloud adobeCloud) {
        super(adobeAssetDataSourceType, adobeCloud);
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.o = new ArrayList();
        this.p = new HashMap();
    }

    public static /* synthetic */ int b(C0532z c0532z) {
        int i = c0532z.r;
        c0532z.r = i + 1;
        return i;
    }

    public static /* synthetic */ int d(C0532z c0532z) {
        int i = c0532z.s;
        c0532z.s = i + 1;
        return i;
    }

    public static /* synthetic */ int f(C0532z c0532z) {
        int i = c0532z.t;
        c0532z.t = i + 1;
        return i;
    }

    public static /* synthetic */ int h(C0532z c0532z) {
        int i = c0532z.u;
        c0532z.u = i + 1;
        return i;
    }

    public static /* synthetic */ Map i(C0532z c0532z) {
        return c0532z.p;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x015b A[Catch: all -> 0x017e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x000a, B:10:0x0012, B:12:0x0018, B:15:0x0027, B:17:0x002d, B:18:0x0030, B:20:0x0032, B:22:0x0038, B:23:0x003b, B:25:0x0041, B:26:0x0054, B:27:0x0061, B:29:0x0067, B:31:0x007b, B:34:0x015b, B:38:0x0085, B:41:0x008e, B:43:0x0094, B:46:0x00a0, B:47:0x00cb, B:49:0x00d1, B:51:0x00dd, B:56:0x0109, B:75:0x013e, B:58:0x0111, B:62:0x0118, B:64:0x011e, B:67:0x0124, B:69:0x012a, B:83:0x0164, B:84:0x017b, B:86:0x0049, B:88:0x004d), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015e A[SYNTHETIC] */
    @Override // com.adobe.creativesdk.foundation.internal.storage.C0507f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g() {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.C0532z.g():boolean");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.C0507f
    public boolean a(boolean z) {
        synchronized (this) {
            boolean z2 = false;
            if (this.f6579g) {
                return false;
            }
            boolean z3 = true;
            if (this.o != null && this.o.size() > 0) {
                if (z) {
                    this.f6580h = true;
                    Iterator<C0276e> it = this.o.iterator();
                    while (it.hasNext()) {
                        it.next().b(AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED, AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING);
                    }
                    this.p.clear();
                    ha e2 = e();
                    if (e2 != null) {
                        e2.a();
                    }
                }
                Iterator<C0276e> it2 = this.o.iterator();
                while (it2.hasNext()) {
                    z2 |= it2.next().c();
                }
                if (z2) {
                    ha e3 = e();
                    if (e3 != null) {
                        e3.b();
                    }
                    return g();
                }
                ha e4 = e();
                if (e4 != null) {
                    e4.c();
                }
                return true;
            }
            AdobeAssetProduct a2 = a(this.f6577e);
            if (a2 != AdobeAssetProduct.AdobeAssetProductUndefined) {
                this.o = C0276e.b(a2, this.f6574b);
            } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations) && this.q == null) {
                this.o.addAll(C0276e.b(AdobeAssetProduct.AdobeAssetProductDraw, this.f6574b));
                this.o.addAll(C0276e.b(AdobeAssetProduct.AdobeAssetProductSketch, this.f6574b));
                this.o.addAll(C0276e.b(AdobeAssetProduct.AdobeAssetProductPSMix, this.f6574b));
                this.o.addAll(C0276e.b(AdobeAssetProduct.AdobeAssetProductPSFix, this.f6574b));
                this.o.addAll(C0276e.b(AdobeAssetProduct.AdobeAssetProductComposition, this.f6574b));
            } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations)) {
                Iterator it3 = this.q.iterator();
                while (it3.hasNext()) {
                    this.o.addAll(C0276e.b(a((AdobeAssetDataSourceType) it3.next()), this.f6574b));
                }
            } else {
                AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType adobeAssetPackageSharedProjectType = null;
                if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceSharedFile)) {
                    adobeAssetPackageSharedProjectType = AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType.AdobeAssetPackageSharedProjectTypeSinglePage;
                } else if (this.f6577e.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceSharedProject)) {
                    adobeAssetPackageSharedProjectType = AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType.AdobeAssetPackageSharedProjectTypeMultiPage;
                } else {
                    z3 = false;
                }
                if (z3) {
                    this.o = new ArrayList();
                    this.o.add(C0276e.a(adobeAssetPackageSharedProjectType, this.f6574b, AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED, AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING));
                }
            }
            return g();
        }
    }

    public C0532z(EnumSet<AdobeAssetDataSourceType> enumSet, AdobeCloud adobeCloud) {
        super(AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations, adobeCloud);
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.o = new ArrayList();
        this.p = new HashMap();
        this.q = enumSet;
    }

    private AdobeAssetProduct a(AdobeAssetDataSourceType adobeAssetDataSourceType) {
        AdobeAssetProduct adobeAssetProduct = AdobeAssetProduct.AdobeAssetProductUndefined;
        if (adobeAssetDataSourceType.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceDraw)) {
            return AdobeAssetProduct.AdobeAssetProductDraw;
        }
        if (adobeAssetDataSourceType.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceSketches)) {
            return AdobeAssetProduct.AdobeAssetProductSketch;
        }
        if (adobeAssetDataSourceType.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary)) {
            return AdobeAssetProduct.AdobeAssetProductLibrary;
        }
        if (adobeAssetDataSourceType.equals(AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix)) {
            return AdobeAssetProduct.AdobeAssetProductPSMix;
        }
        if (adobeAssetDataSourceType.equals(AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix)) {
            return AdobeAssetProduct.AdobeAssetProductPSFix;
        }
        return adobeAssetDataSourceType.equals(AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) ? AdobeAssetProduct.AdobeAssetProductComposition : adobeAssetProduct;
    }
}
