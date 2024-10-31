package com.nexstreaming.app.general.nexasset.assetpackage.db;

import com.nexstreaming.app.general.nexasset.assetpackage.p;
import com.nexstreaming.app.general.norm.c;
import java.util.Map;

/* loaded from: classes2.dex */
public class SubCategoryRecord extends c implements p {
    public long _id;
    public String subCategoryAlias;

    @c.g
    @c.e
    public long subCategoryId;
    public Map<String, String> subCategoryName;

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.p
    public String getSubCategoryAlias() {
        return this.subCategoryAlias;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.p
    public long getSubCategoryId() {
        return this.subCategoryId;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.p
    public Map<String, String> getSubCategoryName() {
        return this.subCategoryName;
    }
}
