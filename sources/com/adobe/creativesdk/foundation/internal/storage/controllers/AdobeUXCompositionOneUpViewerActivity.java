package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetCompPage;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetPSMixPage;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* loaded from: classes.dex */
public class AdobeUXCompositionOneUpViewerActivity extends AdobeUXMobilePackageItemOneUpViewerActivity {
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity
    protected void D() {
        this.k.setVisibility(8);
        String name = this.B.b().getName();
        if (name == null) {
            AdobeAssetFile a2 = this.B.a(this.f6156d);
            String b2 = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_lineordrawcollection_singular);
            if (a2 instanceof AdobeAssetCompPage) {
                name = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_composition_collection_singular);
            } else {
                name = a2 instanceof AdobeAssetPSMixPage ? com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psmix_collection_singular) : b2;
            }
        }
        d(name);
    }
}
