package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderByProperty;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderRelation;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderBy;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderDirection;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.qd;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeAssetProductFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0276e extends C0578la {
    static Map<Number, String> p = new HashMap();

    static {
        p.put(Integer.valueOf(AdobeAssetProduct.AdobeAssetProductDraw.ordinal()), "adobedraw");
        p.put(Integer.valueOf(AdobeAssetProduct.AdobeAssetProductLibrary.ordinal()), "adobe-libraries");
        p.put(Integer.valueOf(AdobeAssetProduct.AdobeAssetProductSketch.ordinal()), "adobesketch");
        p.put(Integer.valueOf(AdobeAssetProduct.AdobeAssetProductPSMix.ordinal()), "adobe-psmix");
        p.put(Integer.valueOf(AdobeAssetProduct.AdobeAssetProductPSFix.ordinal()), "adobe-psfix");
        p.put(Integer.valueOf(AdobeAssetProduct.AdobeAssetProductComposition.ordinal()), "adobe-layup");
    }

    protected C0276e(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStorageOrderByProperty adobeStorageOrderByProperty, AdobeStorageOrderRelation adobeStorageOrderRelation, URI uri) {
        super(eVar, adobeStorageOrderByProperty, adobeStorageOrderRelation, uri);
    }

    public static List<C0276e> b(AdobeAssetProduct adobeAssetProduct, AdobeCloud adobeCloud) {
        return b(adobeAssetProduct, adobeCloud, AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED, AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING);
    }

    public static List<C0276e> b(AdobeAssetProduct adobeAssetProduct, AdobeCloud adobeCloud, AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        ArrayList arrayList = new ArrayList();
        String str = p.get(Integer.valueOf(adobeAssetProduct.ordinal()));
        if (str == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0276e.class.getSimpleName(), String.format("Undefined product: %s", adobeAssetProduct));
            return arrayList;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(URI.create(String.format("/assets/%s/", str)));
        a2.a(adobeCloud);
        arrayList.add(new C0276e(a2, C0578la.a(adobeAssetFolderOrderBy), C0578la.a(adobeAssetFolderOrderDirection), null));
        a(adobeAssetProduct, adobeCloud, adobeAssetFolderOrderBy, adobeAssetFolderOrderDirection, arrayList);
        return arrayList;
    }

    public static C0276e a(AdobeAssetProduct adobeAssetProduct, AdobeCloud adobeCloud) {
        return a(adobeAssetProduct, adobeCloud, AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED, AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING);
    }

    public static C0276e a(AdobeAssetProduct adobeAssetProduct, AdobeCloud adobeCloud, AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        if (adobeAssetProduct == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetProductFolder.getRootForProduct", "AdobeAssetProduct enum is null");
            return null;
        }
        return b(adobeAssetProduct, adobeCloud, adobeAssetFolderOrderBy, adobeAssetFolderOrderDirection).get(0);
    }

    private static void a(AdobeAssetProduct adobeAssetProduct, AdobeCloud adobeCloud, AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection, List<C0276e> list) {
        ArrayList arrayList = new ArrayList();
        int i = C0275d.f4598a[adobeAssetProduct.ordinal()];
        if (i == 1) {
            arrayList.add("adobecompandroid");
        } else if (i == 2) {
            arrayList.add("adobedrawandroid");
        } else if (i == 3) {
            arrayList.add("adobeclsmix");
        } else if (i == 4) {
            arrayList.add("adobefixandroid");
            arrayList.add("adobe-psfix-cls");
        } else if (i == 5) {
            arrayList.add("adobesketch-android");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(URI.create(String.format("/assets/%s/", (String) it.next())));
            a2.a(adobeCloud);
            list.add(new C0276e(a2, C0578la.a(adobeAssetFolderOrderBy), C0578la.a(adobeAssetFolderOrderDirection), null));
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0578la
    public void a(int i, qd qdVar) {
        g().a(i);
        g().f6613e = null;
        C0274c c0274c = new C0274c(this, this, qdVar);
        ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(g(), this.f7329b ? AdobeStoragePagingMode.AdobeStorageNextPageReplace : AdobeStoragePagingMode.AdobeStorageFirstPage, c0274c);
    }

    public static C0276e a(AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType adobeAssetPackageSharedProjectType, AdobeCloud adobeCloud, AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        int i = C0275d.f4599b[adobeAssetPackageSharedProjectType.ordinal()];
        String str = i != 1 ? i != 2 ? i != 3 ? null : "adobeclsdemo" : "adobeclsprojects" : "adobecls";
        if (str == null) {
            return null;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(URI.create(String.format("/assets/%s/", str)));
        a2.a(adobeCloud);
        return new C0276e(a2, C0578la.a(adobeAssetFolderOrderBy), C0578la.a(adobeAssetFolderOrderDirection), null);
    }
}
