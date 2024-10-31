package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public enum ThemeEffectType {
    OPENING,
    MIDDLE,
    ENDING,
    ACCENT,
    TRANSITION,
    CLIP;

    public static ThemeEffectType fromProtoBuf(KMProto.KMProject.ThemeEffectType themeEffectType) {
        if (themeEffectType == null) {
            return null;
        }
        switch (a.f20623b[themeEffectType.ordinal()]) {
            case 1:
                return ACCENT;
            case 2:
                return OPENING;
            case 3:
                return ENDING;
            case 4:
                return MIDDLE;
            case 5:
                return TRANSITION;
            case 6:
                return CLIP;
            default:
                return null;
        }
    }

    public KMProto.KMProject.ThemeEffectType asProtoBuf() {
        switch (a.f20622a[ordinal()]) {
            case 1:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_ACCENT;
            case 2:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_OPENING;
            case 3:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_ENDING;
            case 4:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_MIDDLE;
            case 5:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_TRANSITION;
            case 6:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_CLIP;
            default:
                return null;
        }
    }
}
