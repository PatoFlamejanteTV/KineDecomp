package com.nexstreaming.kinemaster.usage.analytics;

import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.m;
import com.nexstreaming.kinemaster.usage.AssetDownloadResult;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.v;

/* compiled from: StoreEventMaker.kt */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static String f23919a = "unknown";

    public static final void a(InterfaceC1822k interfaceC1822k, AssetStoreEntry assetStoreEntry) {
        kotlin.jvm.internal.h.b(interfaceC1822k, "storeCategoryInfo");
        HashMap hashMap = new HashMap();
        String a2 = a(interfaceC1822k);
        if (a2 != null) {
            hashMap.put("title", a2);
            f23919a = a2;
        } else {
            hashMap.put("title", "unknown");
        }
        KMEvents.ASSET_SELECT_CATEGORY.logEvent(hashMap);
        List<m> subCategories = interfaceC1822k.getSubCategories();
        if (subCategories == null || !(!subCategories.isEmpty())) {
            return;
        }
        a(subCategories.get(0), AssetStoreEntry.STORE);
    }

    private static final String b(InterfaceC1821j interfaceC1821j) {
        Map<String, String> j = interfaceC1821j.j();
        return j.get("en") != null ? j.get("en") : interfaceC1821j.f();
    }

    public static final void a(m mVar, AssetStoreEntry assetStoreEntry) {
        kotlin.jvm.internal.h.b(mVar, "subcategoryInfo");
        if (!kotlin.jvm.internal.h.a((Object) f23919a, (Object) "Featured")) {
            String a2 = a(mVar);
            HashMap hashMap = new HashMap();
            if (a2 != null) {
                hashMap.put("title", a2);
            } else {
                hashMap.put("title", "unknown");
            }
            KMEvents.ASSET_SELECT_SUBCATEGORY.logEvent(hashMap);
        }
    }

    private static final String a(InterfaceC1822k interfaceC1822k) {
        if (interfaceC1822k.getCategoryAliasName() == null) {
            if (interfaceC1822k.getCategoryName() == null || !interfaceC1822k.getCategoryName().containsKey("en") || interfaceC1822k.getCategoryName().get("en") == null) {
                return null;
            }
            return interfaceC1822k.getCategoryName().get("en");
        }
        return interfaceC1822k.getCategoryAliasName();
    }

    private static final String a(m mVar) {
        if (mVar.getSubcategoryAliasName() == null) {
            if (mVar.getSubcategoryName() == null || !mVar.getSubcategoryName().containsKey("en") || mVar.getSubcategoryName().get("en") == null) {
                return null;
            }
            return mVar.getSubcategoryName().get("en");
        }
        return mVar.getSubcategoryAliasName();
    }

    public static final void a(InterfaceC1821j interfaceC1821j) {
        kotlin.jvm.internal.h.b(interfaceC1821j, "assetInfo");
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(interfaceC1821j.a()));
        String b2 = b(interfaceC1821j);
        if (b2 != null) {
            hashMap.put("title", b2);
        }
        hashMap.put("category", interfaceC1821j.getCategoryAliasName());
        String k = interfaceC1821j.k();
        if (k != null) {
            hashMap.put("sub_category", k);
            kotlin.k kVar = kotlin.k.f28545a;
        }
        Map<String, String> c2 = interfaceC1821j.c();
        String str = c2.containsKey("en") ? c2.get("en") : null;
        if (str != null) {
            hashMap.put("sub_category", str);
        }
        KMEvents.ASSET_DETAILVIEW.logEvent(hashMap);
    }

    public static final void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(PlaceFields.LOCATION, String.valueOf(i + 1));
        KMEvents.ASSET_DETAIL_THUMBNAIL.logEvent(hashMap);
    }

    public static final void a(InterfaceC1821j interfaceC1821j, AssetDownloadResult assetDownloadResult) {
        boolean b2;
        kotlin.jvm.internal.h.b(interfaceC1821j, "assetInfo");
        kotlin.jvm.internal.h.b(assetDownloadResult, "result");
        if (kotlin.jvm.internal.h.a((Object) "release", (Object) "debug") || kotlin.jvm.internal.h.a((Object) "release", (Object) UMModuleRegister.INNER)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(interfaceC1821j.a()));
        String b3 = b(interfaceC1821j);
        if (b3 != null) {
            hashMap.put("title", b3);
        }
        hashMap.put("price_type", interfaceC1821j.getPriceType());
        hashMap.put("category", interfaceC1821j.getCategoryAliasName());
        String k = interfaceC1821j.k();
        if (k != null) {
            hashMap.put("sub_category", k);
            kotlin.k kVar = kotlin.k.f28545a;
        }
        Map<String, String> c2 = interfaceC1821j.c();
        String str = c2.containsKey("en") ? c2.get("en") : null;
        if (str != null) {
            hashMap.put("sub_category", str);
        }
        if (assetDownloadResult == AssetDownloadResult.SUCCESS) {
            b2 = v.b(interfaceC1821j.getPriceType(), "free", true);
            if (b2) {
                String value = AssetDownloadResult.SUCCESS.getValue();
                kotlin.jvm.internal.h.a((Object) value, "AssetDownloadResult.SUCCESS.value");
                hashMap.put("result", value);
            } else {
                String value2 = AssetDownloadResult.PURCHASE_SUCCESS.getValue();
                kotlin.jvm.internal.h.a((Object) value2, "AssetDownloadResult.PURCHASE_SUCCESS.value");
                hashMap.put("result", value2);
            }
        } else {
            String value3 = assetDownloadResult.getValue();
            kotlin.jvm.internal.h.a((Object) value3, "result.value");
            hashMap.put("result", value3);
        }
        KMEvents.ASSET_DOWNLOAD_RESULT.logEvent(hashMap);
    }

    public static final void a(String str, String str2, String str3, String str4, String str5) {
        kotlin.jvm.internal.h.b(str, "assetId");
        kotlin.jvm.internal.h.b(str2, "assetIndex");
        kotlin.jvm.internal.h.b(str3, "assetName");
        kotlin.jvm.internal.h.b(str4, "mediaType");
        kotlin.jvm.internal.h.b(str5, "categoryName");
        HashMap hashMap = new HashMap();
        hashMap.put("id", str2);
        hashMap.put(MessengerShareContentUtility.MEDIA_TYPE, str4);
        hashMap.put("title", str3);
        hashMap.put("category", str5);
        KMEvents.ASSET_DETAIL_PREVIEW.logEvent(hashMap);
    }
}
