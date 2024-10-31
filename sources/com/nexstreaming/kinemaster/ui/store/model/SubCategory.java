package com.nexstreaming.kinemaster.ui.store.model;

import com.nexstreaming.kinemaster.network.ViewType;
import com.nexstreaming.kinemaster.network.m;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public class SubCategory implements Serializable, m {
    private m storeSubcategoryInfo;

    public SubCategory(m mVar) {
        this.storeSubcategoryInfo = mVar;
    }

    @Override // com.nexstreaming.kinemaster.network.m
    public int getCategoryIdx() {
        return this.storeSubcategoryInfo.getCategoryIdx();
    }

    @Override // com.nexstreaming.kinemaster.network.m
    public String getSubcategoryAliasName() {
        return this.storeSubcategoryInfo.getSubcategoryAliasName();
    }

    @Override // com.nexstreaming.kinemaster.network.m
    public int getSubcategoryIdx() {
        return this.storeSubcategoryInfo.getSubcategoryIdx();
    }

    @Override // com.nexstreaming.kinemaster.network.m
    public Map<String, String> getSubcategoryName() {
        return this.storeSubcategoryInfo.getSubcategoryName();
    }

    @Override // com.nexstreaming.kinemaster.network.m
    public ViewType getViewType() {
        return this.storeSubcategoryInfo.getViewType();
    }
}
