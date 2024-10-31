package com.nexstreaming.app.general.nexasset.assetpackage.db;

import android.content.Context;
import com.nexstreaming.app.general.norm.b;
import com.nexstreaming.app.general.norm.c;

/* compiled from: AssetPackageDb.java */
/* loaded from: classes2.dex */
public class a extends b {
    public a(Context context) {
        super(context, "com.kinemaster.asset_package.db", 13);
    }

    @Override // com.nexstreaming.app.general.norm.b
    protected Class<? extends c>[] c() {
        return new Class[]{AssetPackageRecord.class, ItemRecord.class, CategoryRecord.class, SubCategoryRecord.class, InstallSourceRecord.class};
    }
}
