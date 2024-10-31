package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AdobeAssetPackagePages extends Ya {
    ArrayList<AdobeAssetFile> s;

    /* loaded from: classes.dex */
    public enum AdobeAssetPackageSharedProjectType {
        AdobeAssetPackageSharedProjectTypeSinglePage,
        AdobeAssetPackageSharedProjectTypeMultiPage,
        AdobeAssetPackageSharedProjectTypeMaxDemo
    }

    public AdobeAssetPackagePages(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar2) {
        super(eVar, eVar2);
    }

    @Override // com.adobe.creativesdk.foundation.storage.Ya, com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof AdobeAssetPackagePages) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Ya, com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return 42;
    }

    public ArrayList<AdobeAssetFile> j() {
        return this.s;
    }

    public List<String> k() {
        return Arrays.asList(AdobeAssetMimeTypes.MIMETYPE_PNG.getMimeType(), AdobeAssetMimeTypes.MIMETYPE_JPEG.getMimeType());
    }

    protected AdobeAssetPackagePages() {
    }
}
