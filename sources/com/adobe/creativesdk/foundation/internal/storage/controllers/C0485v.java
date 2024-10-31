package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDesignLibraryItemFilterType;
import com.adobe.creativesdk.foundation.storage.C0549e;
import java.util.EnumSet;

/* compiled from: AdobeDesignLibraryCollectionConfiguration.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.v */
/* loaded from: classes.dex */
public class C0485v extends C0474t {

    /* renamed from: h */
    private String f6501h;
    private C0549e i;

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0474t
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f6501h = (String) bundle.get("designLibraryID");
        this.i = C0549e.a((EnumSet) bundle.getSerializable("design_library_items_key"), (AdobeAssetDesignLibraryItemFilterType) bundle.getSerializable("design_library_items_filtertype"));
    }

    public C0549e h() {
        return this.i;
    }

    public String i() {
        return this.f6501h;
    }
}
