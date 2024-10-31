package com.nexstreaming.kinemaster.ui.store.model;

import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.ViewType;
import com.nexstreaming.kinemaster.network.m;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Category implements Serializable, InterfaceC1822k {
    private InterfaceC1822k categoryInfo;

    public Category(InterfaceC1822k interfaceC1822k) {
        this.categoryInfo = interfaceC1822k;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public String getCategoryAliasName() {
        return this.categoryInfo.getCategoryAliasName();
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public int getCategoryIdx() {
        return this.categoryInfo.getCategoryIdx();
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public Map<String, String> getCategoryName() {
        return this.categoryInfo.getCategoryName();
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public String getIconURL() {
        return this.categoryInfo.getIconURL();
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public List<m> getSubCategories() {
        return this.categoryInfo.getSubCategories();
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public ViewType getViewType() {
        return this.categoryInfo.getViewType();
    }
}
