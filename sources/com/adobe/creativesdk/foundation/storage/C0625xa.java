package com.adobe.creativesdk.foundation.storage;

import org.json.JSONArray;

/* compiled from: AdobeAssetLibraryItemColorTheme.java */
@Deprecated
/* renamed from: com.adobe.creativesdk.foundation.storage.xa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0625xa extends C0605sa {

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f7465g;

    /* renamed from: h, reason: collision with root package name */
    private AdobeAssetLibraryColorThemeRule f7466h;
    private AdobeAssetLibraryColorThemeMood i;
    private JSONArray j;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0625xa(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha, JSONArray jSONArray, String str, String str2, JSONArray jSONArray2, C0590oa c0590oa) {
        super(ha, null, c0590oa);
        this.f7465g = jSONArray;
        this.j = jSONArray2;
        this.f7466h = b(str);
        this.i = a(str2);
    }

    private static AdobeAssetLibraryColorThemeMood a(String str) {
        String lowerCase = str != null ? str.toLowerCase() : null;
        if (lowerCase == null) {
            return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodNotSet;
        }
        if (lowerCase.equals("colorful")) {
            return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodColorful;
        }
        if (lowerCase.equals("bright")) {
            return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodBright;
        }
        if (lowerCase.equals("muted")) {
            return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodMuted;
        }
        if (lowerCase.equals("dark")) {
            return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodDark;
        }
        if (lowerCase.equals("custom")) {
            return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodCustom;
        }
        return AdobeAssetLibraryColorThemeMood.AdobeAssetLibraryColorThemeMoodUnknown;
    }

    private static AdobeAssetLibraryColorThemeRule b(String str) {
        String lowerCase = str != null ? str.toLowerCase() : null;
        if (lowerCase == null) {
            return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleNotSet;
        }
        if (lowerCase.equals("analogous")) {
            return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleAnalogous;
        }
        if (lowerCase.equals("complimentary")) {
            return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleComplimentary;
        }
        if (lowerCase.equals("monochromatic")) {
            return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleMonochromatic;
        }
        if (lowerCase.equals("triad")) {
            return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleTriad;
        }
        if (lowerCase.equals("custom")) {
            return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleCustom;
        }
        return AdobeAssetLibraryColorThemeRule.AdobeAssetLibraryColorThemeRuleUnknown;
    }
}
