package com.adobe.creativesdk.foundation.internal.storage.asset;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.net.URI;

/* loaded from: classes.dex */
public class AdobeAssetPSMixPage extends AdobeAssetFile {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public AdobeAssetPackagePages _package;
    public int pageNumber;

    public AdobeAssetPSMixPage(String str, int i, C0225c c0225c, AdobeAssetPackagePages adobeAssetPackagePages) {
        URI uri;
        this.name = str;
        this.pageNumber = i;
        this.GUID = c0225c.b();
        if (adobeAssetPackagePages.getHref() == null || c0225c.b() == null) {
            uri = null;
        } else {
            uri = URI.create(adobeAssetPackagePages.getHref().getPath() + c0225c.b());
        }
        this.href = uri;
        this.parentHref = adobeAssetPackagePages.getHref();
        this.type = c0225c.n();
        this.etag = c0225c.d();
        this.md5Hash = c0225c.h();
        this.creationDate = adobeAssetPackagePages.getCreationDate();
        this.modificationDate = adobeAssetPackagePages.getModificationDate();
        this._package = adobeAssetPackagePages;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof AdobeAssetPSMixPage) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobeAssetFile, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return 42;
    }

    public AdobeAssetPSMixPage() {
    }
}
