package com.nexstreaming.kinemaster.ui.store.model;

/* loaded from: classes2.dex */
public enum FontAssetNotFixSubCategoryAlias {
    Arabic(5, "Arabic", "ar"),
    CHS(6, "CHS", "zh_CN"),
    CHT(7, "CHT", "zh_TW, zh_HK"),
    Japanese(8, "Japanese", "ja"),
    Korean(9, "Korean", "ko");

    public String locale;
    public String subCategoryAlias;
    public int value;

    FontAssetNotFixSubCategoryAlias(int i, String str, String str2) {
        this.value = i;
        this.subCategoryAlias = str;
        this.locale = str2;
    }

    public static FontAssetNotFixSubCategoryAlias fromLocale(String str) {
        if (!str.equals("zh_TW") && !str.equals("zh_HK")) {
            for (FontAssetNotFixSubCategoryAlias fontAssetNotFixSubCategoryAlias : values()) {
                if (fontAssetNotFixSubCategoryAlias.locale.equals(str)) {
                    return fontAssetNotFixSubCategoryAlias;
                }
            }
            return null;
        }
        return CHT;
    }
}
