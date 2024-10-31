package com.nexstreaming.app.general.nexasset.assetpackage.db;

import com.nexstreaming.app.general.norm.c;

/* loaded from: classes2.dex */
public class CategoryRecord extends c implements com.nexstreaming.app.general.nexasset.assetpackage.a {
    public long _id;
    public String categoryIconURL;

    @c.g
    @c.e
    public long categoryId;
    public String categoryName;
    public String categoryURL;

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.a
    public String getCategoryAlias() {
        return this.categoryName;
    }

    public String getCategoryIconURL() {
        return this.categoryIconURL;
    }

    @Override // com.nexstreaming.app.general.nexasset.assetpackage.a
    public long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryURL() {
        return this.categoryURL;
    }
}
