package com.nexstreaming.kinemaster.ui.store.model;

/* loaded from: classes2.dex */
public enum FontAssetFixSubCategoryAlias {
    Sans_serif(1, "Sans-serif"),
    Serif(2, "Serif"),
    Display(3, "Display"),
    Handwriting(4, "Handwriting");

    public String subCategoryAlias;
    public int value;

    FontAssetFixSubCategoryAlias(int i, String str) {
        this.value = i;
        this.subCategoryAlias = str;
    }
}
