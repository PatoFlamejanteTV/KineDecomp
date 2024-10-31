package com.nexstreaming.app.general.nexasset.assetpackage.db;

import com.nexstreaming.app.general.nexasset.assetpackage.ItemCategory;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemType;
import com.nexstreaming.app.general.nexasset.assetpackage.b;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.norm.c;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ItemRecord extends c implements r {
    public long _id;

    @c.InterfaceC0098c
    @c.d
    public AssetPackageRecord assetPackageRecord;
    public String filePath;
    public boolean hidden;
    public String iconPath;
    public ItemCategory itemCategory;

    @c.g
    @c.e
    public String itemId;
    public ItemType itemType;
    public Map<String, String> label;
    public String packageURI;

    @c.a(13)
    public List<String> ratios;
    public String sampleText;
    public String thumbPath;

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public b getAssetPackage() {
        return this.assetPackageRecord;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public ItemCategory getCategory() {
        return this.itemCategory;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public String getIconPath() {
        return this.iconPath;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public String getId() {
        return this.itemId;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public Map<String, String> getLabel() {
        Map<String, String> map = this.label;
        if (map != null && !map.isEmpty()) {
            return this.label;
        }
        return Collections.singletonMap("en", this.itemId);
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public String getPackageURI() {
        return this.packageURI;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public List<String> getRatios() {
        return this.ratios;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public String getSampleText() {
        return this.sampleText;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public String getThumbPath() {
        return this.thumbPath;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public ItemType getType() {
        return this.itemType;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
    public boolean isHidden() {
        return this.hidden;
    }

    public String toString() {
        return "ItemRecord{_id=" + this._id + ", itemId='" + this.itemId + "', packageURI='" + this.packageURI + "', filePath='" + this.filePath + "', iconPath='" + this.iconPath + "', thumbPath='" + this.thumbPath + "', label=" + this.label + ", itemType=" + this.itemType + ", itemCategory=" + this.itemCategory + ", assetPackageRecord=" + this.assetPackageRecord + ", ratios=" + this.ratios + '}';
    }
}
