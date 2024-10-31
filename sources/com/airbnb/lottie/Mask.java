package com.airbnb.lottie;

import com.airbnb.lottie.C0664o;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Mask {

    /* renamed from: a */
    private final MaskMode f7656a;

    /* renamed from: b */
    private final C0664o f7657b;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    /* loaded from: classes.dex */
    public static class a {
        public static Mask a(JSONObject jSONObject, C0657ka c0657ka) {
            char c2;
            MaskMode maskMode;
            String optString = jSONObject.optString("mode");
            int hashCode = optString.hashCode();
            if (hashCode == 97) {
                if (optString.equals(com.umeng.commonsdk.proguard.e.al)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 105) {
                if (hashCode == 115 && optString.equals(com.umeng.commonsdk.proguard.e.ap)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (optString.equals(com.umeng.commonsdk.proguard.e.aq)) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                maskMode = MaskMode.MaskModeAdd;
            } else if (c2 == 1) {
                maskMode = MaskMode.MaskModeSubtract;
            } else if (c2 != 2) {
                maskMode = MaskMode.MaskModeUnknown;
            } else {
                maskMode = MaskMode.MaskModeIntersect;
            }
            return new Mask(maskMode, C0664o.a.a(jSONObject.optJSONObject("pt"), c0657ka));
        }
    }

    /* synthetic */ Mask(MaskMode maskMode, C0664o c0664o, C0667pa c0667pa) {
        this(maskMode, c0664o);
    }

    public MaskMode a() {
        return this.f7656a;
    }

    public C0664o b() {
        return this.f7657b;
    }

    private Mask(MaskMode maskMode, C0664o c0664o) {
        this.f7656a = maskMode;
        this.f7657b = c0664o;
    }
}
