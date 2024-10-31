package com.adobe.creativesdk.foundation.storage;

import android.graphics.Color;
import org.json.JSONObject;

/* compiled from: AdobeAssetLibraryItemColor.java */
@Deprecated
/* renamed from: com.adobe.creativesdk.foundation.storage.wa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0621wa extends C0605sa {

    /* renamed from: g, reason: collision with root package name */
    private AdobeAssetLibraryColorType f7457g;

    /* renamed from: h, reason: collision with root package name */
    private AdobeAssetLibraryColorMode f7458h;
    private Object i;
    private Number j;
    private String k;
    private AdobeAssetLibraryColorType l;
    private AdobeAssetLibraryColorMode m;
    private Object n;
    private Number o;
    private String p;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0621wa(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha, String str, String str2, String str3, Object obj, Number number, String str4, String str5, String str6, Object obj2, Number number2, String str7, C0590oa c0590oa) {
        super(ha, str, c0590oa);
        this.f7457g = b(str2);
        this.f7458h = a(str3);
        this.i = obj;
        this.j = number;
        this.k = str4;
        this.l = b(str5);
        this.m = a(str6);
        this.n = obj2;
        this.o = number2;
        this.p = str7;
    }

    public int a() {
        AdobeAssetLibraryColorMode adobeAssetLibraryColorMode = this.f7458h;
        if (adobeAssetLibraryColorMode == null) {
            return -1;
        }
        switch (C0617va.f7449a[adobeAssetLibraryColorMode.ordinal()]) {
            case 1:
                return d();
            case 2:
                return e();
            case 3:
                return b();
            case 4:
                return c();
            case 5:
                return e();
            case 6:
                return e();
            default:
                return e();
        }
    }

    int b() {
        int doubleValue = (int) (((100.0d - ((Number) this.i).doubleValue()) / 100.0d) * 255.0d);
        return Color.rgb(doubleValue, doubleValue, doubleValue);
    }

    int c() {
        JSONObject jSONObject = (JSONObject) this.i;
        return Color.HSVToColor(new float[]{jSONObject.optInt("h"), jSONObject.optInt(com.umeng.commonsdk.proguard.e.ap), jSONObject.optInt("b")});
    }

    int d() {
        JSONObject jSONObject = (JSONObject) this.i;
        return Color.argb(255, jSONObject.optInt("r"), jSONObject.optInt("g"), jSONObject.optInt("b"));
    }

    int e() {
        Object obj = this.n;
        if (obj == null) {
            return -1;
        }
        JSONObject jSONObject = (JSONObject) obj;
        return Color.rgb(jSONObject.optInt("r"), jSONObject.optInt("g"), jSONObject.optInt("b"));
    }

    static AdobeAssetLibraryColorType b(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().equals("spot")) {
            return AdobeAssetLibraryColorType.AdobeAssetLibraryColorTypeSpot;
        }
        return AdobeAssetLibraryColorType.AdobeAssetLibraryColorTypeProcess;
    }

    static AdobeAssetLibraryColorMode a(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("rgb")) {
            return AdobeAssetLibraryColorMode.AdobeAssetLibraryColorModeRGB;
        }
        if (lowerCase.equals("cmyk")) {
            return AdobeAssetLibraryColorMode.AdobeAssetLibraryColorModeCMYK;
        }
        if (lowerCase.equals("lab")) {
            return AdobeAssetLibraryColorMode.AdobeAssetLibraryColorModeLab;
        }
        if (lowerCase.equals("hsb")) {
            return AdobeAssetLibraryColorMode.AdobeAssetLibraryColorModeHSB;
        }
        if (lowerCase.equals("gray")) {
            return AdobeAssetLibraryColorMode.AdobeAssetLibraryColorModeGray;
        }
        return AdobeAssetLibraryColorMode.AdobeAssetLibraryColorModeUnknown;
    }
}
