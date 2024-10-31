package com.nexstreaming.kinemaster.ui.assetbrowser;

import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemCategory;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: AssetBrowserType.kt */
/* loaded from: classes.dex */
public enum AssetBrowserType {
    ClipEffect(ItemCategory.effect, true, true, R.string.opt_clip_graphics, AssetCategoryAlias.ClipGraphics),
    EffectLayer(ItemCategory.filter, true, false, R.string.layer_menu_effect, AssetCategoryAlias.Effect),
    ColorFilter(ItemCategory.filter, false, false, R.string.colortint_panel_title, AssetCategoryAlias.Effect),
    Transition(ItemCategory.transition, true, true, R.string.transition_effect_panel_title, AssetCategoryAlias.Transition),
    Overlay(ItemCategory.overlay, false, false, R.string.layer_menu_overlay, AssetCategoryAlias.Overlay),
    Font(ItemCategory.font, false, false, R.string.toolbar_title_font_browser, AssetCategoryAlias.Font),
    Audio(ItemCategory.audio, false, false, R.string.edit_project_toolbar_title_audio_browser, AssetCategoryAlias.Audio),
    Template(ItemCategory.template, false, false, R.string.template_browser, AssetCategoryAlias.Template);

    private final AssetCategoryAlias assetCategoryAlias;
    private final ItemCategory itemCategory;
    private final boolean needSettings;
    private final boolean needTitle;
    private final int titleResource;

    AssetBrowserType(ItemCategory itemCategory, boolean z, boolean z2, int i, AssetCategoryAlias assetCategoryAlias) {
        this.itemCategory = itemCategory;
        this.needTitle = z;
        this.needSettings = z2;
        this.titleResource = i;
        this.assetCategoryAlias = assetCategoryAlias;
    }

    public final AssetCategoryAlias getAssetCategoryAlias() {
        return this.assetCategoryAlias;
    }

    public final ItemCategory getItemCategory() {
        return this.itemCategory;
    }

    public final int getTitleResource() {
        return this.titleResource;
    }

    public final boolean needSettings() {
        return this.needSettings;
    }

    public final boolean needTitle() {
        return this.needTitle;
    }
}
