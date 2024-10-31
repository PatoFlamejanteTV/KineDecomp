package com.nexstreaming.app.general.nexasset.assetpackage.db;

import com.nexstreaming.app.general.nexasset.assetpackage.InstallSourceType;
import com.nexstreaming.app.general.nexasset.assetpackage.b;
import com.nexstreaming.app.general.nexasset.assetpackage.p;
import com.nexstreaming.app.general.norm.c;
import java.io.File;
import java.util.Map;

/* loaded from: classes2.dex */
public class AssetPackageRecord extends c implements b {
    public long _id;
    public Map<String, String> assetDesc;

    @c.g
    @c.e
    public String assetId;
    public int assetIdx;

    @c.a(13)
    public String assetLevel = "1";
    public Map<String, String> assetName;

    @c.a(12)
    public int assetSize;
    public String assetUrl;

    @c.a(12)
    public int assetVersion;
    public CategoryRecord category;

    @c.a(12)
    public boolean hasUpdate;

    @c.InterfaceC0098c
    @c.d
    public InstallSourceRecord installSource;
    public String localPath;
    public String packageURI;
    public String priceType;
    public SubCategoryRecord subCategory;
    public String thumbPath;
    public String thumbUrl;

    public com.nexstreaming.app.general.nexasset.assetpackage.a getAssetCategory() {
        return this.category;
    }

    public Map<String, String> getAssetDesc() {
        return this.assetDesc;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getAssetId() {
        return this.assetId;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public int getAssetIdx() {
        return this.assetIdx;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public Map<String, String> getAssetName() {
        return this.assetName;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public int getAssetSize() {
        return this.assetSize;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public p getAssetSubCategory() {
        return this.subCategory;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getAssetUrl() {
        return this.assetUrl;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public int getAssetVersion() {
        return this.assetVersion;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public InstallSourceType getInstallSourceType() {
        InstallSourceRecord installSourceRecord = this.installSource;
        if (installSourceRecord == null) {
            return null;
        }
        return installSourceRecord.installSourceType;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public File getLocalPath() {
        String str = this.localPath;
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getPackageURI() {
        return this.packageURI;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getPriceType() {
        return this.priceType;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getThumbPath() {
        return this.thumbPath;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public String getThumbUrl() {
        return this.thumbUrl;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.b
    public boolean hasUpdate() {
        return this.hasUpdate;
    }
}
