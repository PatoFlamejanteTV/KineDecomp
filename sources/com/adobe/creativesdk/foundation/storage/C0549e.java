package com.adobe.creativesdk.foundation.storage;

import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: AdobeAssetDesignLibraryItemFilter.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.e */
/* loaded from: classes.dex */
public class C0549e {

    /* renamed from: a */
    private EnumSet<AdobeAssetDesignLibraryItemType> f7235a;

    /* renamed from: b */
    private AdobeAssetDesignLibraryItemFilterType f7236b;

    public static C0549e a(EnumSet<AdobeAssetDesignLibraryItemType> enumSet, AdobeAssetDesignLibraryItemFilterType adobeAssetDesignLibraryItemFilterType) {
        C0549e c0549e = new C0549e();
        c0549e.f7235a = enumSet;
        c0549e.f7236b = adobeAssetDesignLibraryItemFilterType;
        return c0549e;
    }

    public boolean b() {
        return this.f7236b == AdobeAssetDesignLibraryItemFilterType.ADOBE_ASSET_DESIGNLIBRARYITEM_FILTER_INCLUSION;
    }

    public EnumSet<AdobeAssetDesignLibraryItemType> a() {
        if (b()) {
            return this.f7235a;
        }
        EnumSet<AdobeAssetDesignLibraryItemType> allOf = EnumSet.allOf(AdobeAssetDesignLibraryItemType.class);
        EnumSet<AdobeAssetDesignLibraryItemType> enumSet = this.f7235a;
        if (enumSet != null && enumSet.size() != 0) {
            Iterator it = this.f7235a.iterator();
            while (it.hasNext()) {
                allOf.remove((AdobeAssetDesignLibraryItemType) it.next());
            }
        }
        return allOf;
    }
}
