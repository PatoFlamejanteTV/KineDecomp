package com.nexstreaming.kinemaster.ui.store.model;

import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.ViewType;
import com.nexstreaming.kinemaster.network.m;
import java.util.List;
import java.util.Map;

/* compiled from: CategoryInventory.java */
/* loaded from: classes2.dex */
public class d implements InterfaceC1822k {

    /* renamed from: a */
    private com.nexstreaming.app.general.nexasset.assetpackage.a f23656a;

    /* renamed from: b */
    private int f23657b;

    /* renamed from: c */
    private int f23658c;

    public d(com.nexstreaming.app.general.nexasset.assetpackage.a aVar) {
        this.f23656a = aVar;
        this.f23657b = (int) aVar.getCategoryId();
        a(aVar.getCategoryAlias());
    }

    private void a(String str) {
        if (str.equalsIgnoreCase(AssetCategoryAlias.Effect.name())) {
            this.f23658c = R.drawable.normal_effect_icon;
            return;
        }
        if (str.equalsIgnoreCase(AssetCategoryAlias.Transition.name())) {
            this.f23658c = R.drawable.normal_transition_icon;
            return;
        }
        if (str.equalsIgnoreCase(AssetCategoryAlias.Font.name())) {
            this.f23658c = R.drawable.normal_font_icon;
            return;
        }
        if (str.equalsIgnoreCase(AssetCategoryAlias.Overlay.name())) {
            this.f23658c = R.drawable.normal_overlay_icon;
            return;
        }
        if (str.equalsIgnoreCase(AssetCategoryAlias.Audio.name())) {
            this.f23658c = R.drawable.normal_audio_icon;
            return;
        }
        if (str.equalsIgnoreCase(AssetCategoryAlias.ClipGraphics.name())) {
            this.f23658c = R.drawable.asset_clipgrahics_icon;
            return;
        }
        if (str.equalsIgnoreCase(AssetCategoryAlias.Brand.name())) {
            this.f23658c = R.drawable.normal_brand_icon;
        } else if (str.equalsIgnoreCase(AssetCategoryAlias.Fandoms.name())) {
            this.f23658c = R.drawable.normal_fandoms_icon;
        } else {
            this.f23658c = R.drawable.normal_effect_icon;
        }
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public String getCategoryAliasName() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public int getCategoryIdx() {
        return this.f23657b;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public Map<String, String> getCategoryName() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public String getIconURL() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public List<m> getSubCategories() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1822k
    public ViewType getViewType() {
        return ViewType.GRID;
    }

    public d(InterfaceC1821j interfaceC1821j) {
        this.f23657b = interfaceC1821j.r();
        a(interfaceC1821j.getCategoryAliasName());
    }

    public int a() {
        return this.f23658c;
    }
}
