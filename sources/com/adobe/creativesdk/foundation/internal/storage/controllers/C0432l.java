package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeEntitlementServices;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0399q;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0401t;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceFilterType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetMIMETypeFilterType;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: AdobeAssetViewBrowserControllerFactory.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0432l {

    /* renamed from: a, reason: collision with root package name */
    private static EnumSet<AdobeAssetDataSourceType> f6173a = EnumSet.noneOf(AdobeAssetDataSourceType.class);

    /* compiled from: AdobeAssetViewBrowserControllerFactory.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.l$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Bundle f6174a;

        /* renamed from: b, reason: collision with root package name */
        private Class f6175b;

        public Class b() {
            return this.f6175b;
        }

        public Bundle a() {
            return this.f6174a;
        }

        public void a(Bundle bundle) {
            this.f6174a = bundle;
        }

        public void a(Class cls) {
            this.f6175b = cls;
        }
    }

    public static Bundle a(AdobeAssetDataSourceType adobeAssetDataSourceType, Bundle bundle, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("ASSET_CONTAINER_DATA_SOURCE_TYPE", adobeAssetDataSourceType);
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations) {
            bundle2.putSerializable("MOBILE_CREATION_FILTERED_TYPES", f6173a);
        }
        if (bundle != null) {
            EnumSet enumSet = (EnumSet) bundle.getSerializable("MIME_TYPES_FILTER_ARRAY");
            if (enumSet != null) {
                bundle2.putSerializable("ASSET_CONTAINER_MIME_FILTERS", enumSet);
            }
            bundle2.putBoolean("ASSET_CONTAINER_MIME_TYPES_FILTER", ((AdobeAssetMIMETypeFilterType) bundle.getSerializable("MIME_TYPES_FILTER_TYPE")) != AdobeAssetMIMETypeFilterType.ADOBE_ASSET_MIMETYPE_FILTERTYPE_EXCLUSION);
            bundle2.putSerializable("ADOBE_CLOUD", bundle.getSerializable("ADOBE_CLOUD"));
        }
        if (eVar != null) {
            bundle2.putParcelable("ASSET_CONTAINER_TARGET_COLLECTION", eVar);
        }
        return bundle2;
    }

    public static Va b(Context context, AdobeAssetDataSourceType adobeAssetDataSourceType, Bundle bundle, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        a a2 = a(context, adobeAssetDataSourceType, bundle, eVar);
        return (Va) Fragment.instantiate(context, a2.b().getName(), a2.a());
    }

    public static C0373d c(Bundle bundle) {
        if (bundle == null) {
            return new C0373d(null, false, false);
        }
        return new C0373d(bundle.getString("START_WITH_COLLECTION_KEY"), bundle.getBoolean("SHOULD_SHOW_ONLY_ASSETS", false), bundle.getBoolean("SHOW_LIBRARY_ITEM", false));
    }

    private static EnumSet<AdobeAssetDataSourceType> b() {
        return EnumSet.of(AdobeAssetDataSourceType.AdobeAssetDataSourceFiles, AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary, AdobeAssetDataSourceType.AdobeAssetDataSourcePhotos, AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EnumSet<AdobeAssetDataSourceType> b(Bundle bundle) {
        if (bundle == null) {
            return b();
        }
        EnumSet<AdobeAssetDataSourceType> enumSet = (EnumSet) bundle.getSerializable("DATA_SOURCE_FILTER_ARRAY");
        boolean z = false;
        boolean z2 = ((AdobeAssetDataSourceFilterType) bundle.getSerializable("DATA_SOURCE_FILTER_TYPE")) == AdobeAssetDataSourceFilterType.ADOBE_ASSET_DATASOURCE_FILTER_INCLUSION;
        if (enumSet == null) {
            return b();
        }
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            AdobeAssetDataSourceType adobeAssetDataSourceType = (AdobeAssetDataSourceType) it.next();
            if (com.adobe.creativesdk.foundation.internal.storage.na.c().b(adobeAssetDataSourceType)) {
                f6173a.add(adobeAssetDataSourceType);
                z = true;
            }
        }
        if (z) {
            enumSet.add(AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations);
            Iterator it2 = f6173a.iterator();
            while (it2.hasNext()) {
                enumSet.remove((AdobeAssetDataSourceType) it2.next());
            }
        }
        if (z2) {
            return enumSet;
        }
        EnumSet<AdobeAssetDataSourceType> b2 = b();
        EnumSet<AdobeAssetDataSourceType> b3 = b();
        Iterator it3 = enumSet.iterator();
        while (it3.hasNext()) {
            AdobeAssetDataSourceType adobeAssetDataSourceType2 = (AdobeAssetDataSourceType) it3.next();
            if (b2.contains(adobeAssetDataSourceType2)) {
                b3.remove(adobeAssetDataSourceType2);
            }
        }
        return b3;
    }

    private static Class a(Context context) {
        if (C0455p.b(context)) {
            return C0415hc.class;
        }
        return Hb.class;
    }

    public static a a(Context context, AdobeAssetDataSourceType adobeAssetDataSourceType, Bundle bundle, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        a aVar = new a();
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceFiles) {
            aVar.a(a(context));
        } else if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourcePhotos) {
            aVar.a(Od.class);
        } else if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary) {
            aVar.a(C0477tc.class);
        } else if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations) {
            aVar.f6175b = C0416hd.class;
        }
        aVar.a(a(adobeAssetDataSourceType, bundle, eVar));
        return aVar;
    }

    public static DialogFragment b(Object obj) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.p pVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.upload.p();
        pVar.a(((t.c) obj).f6471a);
        return pVar;
    }

    public static Va a(Context context, AdobeAssetDataSourceType adobeAssetDataSourceType) {
        return b(context, adobeAssetDataSourceType, null, null);
    }

    private static AdobeAssetDataSourceType a(EnumSet<AdobeAssetDataSourceType> enumSet) {
        Iterator it = enumSet.iterator();
        if (it.hasNext()) {
            return (AdobeAssetDataSourceType) it.next();
        }
        return null;
    }

    public static Va a(Context context, Bundle bundle, C0368c c0368c) {
        return a(context, bundle, c0368c, (com.adobe.creativesdk.foundation.internal.storage.model.resources.e) null);
    }

    public static Va a(Context context, Bundle bundle, C0368c c0368c, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        EnumSet<AdobeAssetDataSourceType> b2 = b(bundle);
        if (b2 != null && b2.size() <= 1) {
            return b(context, a(b2), bundle, eVar);
        }
        Ua ua = new Ua();
        ua.setArguments(bundle);
        return ua;
    }

    public static boolean a(AdobeAssetDataSourceType adobeAssetDataSourceType, AdobeCloud adobeCloud) {
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourcePhotos) {
            return AdobeEntitlementServices.b().a("lightroom", adobeCloud);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary) {
            return AdobeEntitlementServices.b().a("libraries", adobeCloud);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceFiles) {
            return AdobeEntitlementServices.b().a("cc_storage", adobeCloud);
        }
        return adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations;
    }

    public static C0368c a(Bundle bundle) {
        if (bundle == null) {
            return new C0368c(null, true, null, true, com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c());
        }
        return new C0368c((EnumSet) bundle.getSerializable("DATA_SOURCE_FILTER_ARRAY"), ((AdobeAssetDataSourceFilterType) bundle.getSerializable("DATA_SOURCE_FILTER_TYPE")) == AdobeAssetDataSourceFilterType.ADOBE_ASSET_DATASOURCE_FILTER_INCLUSION, (EnumSet) bundle.getSerializable("MIME_TYPES_FILTER_ARRAY"), ((AdobeAssetMIMETypeFilterType) bundle.getSerializable("MIME_TYPES_FILTER_TYPE")) != AdobeAssetMIMETypeFilterType.ADOBE_ASSET_MIMETYPE_FILTERTYPE_EXCLUSION, (AdobeCloud) bundle.getSerializable("ADOBE_CLOUD"));
    }

    public static DialogFragment a(Object obj) {
        C0401t c0401t = new C0401t();
        c0401t.a(((C0399q.a) obj).f6069c);
        return c0401t;
    }

    public static DialogFragment a(C0578la c0578la) {
        return com.adobe.creativesdk.foundation.internal.storage.controllers.upload.l.a(c0578la);
    }

    public static DialogFragment a() {
        return new com.adobe.creativesdk.foundation.internal.storage.controllers.upload.m();
    }

    public static DialogFragment a(AdobeCloud adobeCloud) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.e eVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.upload.e();
        eVar.a(adobeCloud);
        return eVar;
    }
}
