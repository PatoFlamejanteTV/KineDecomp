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

    public KMProto.KMProject.ThemeEffectType asProtoBuf() {
        switch (this) {
            case ACCENT:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_ACCENT;
            case OPENING:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_OPENING;
            case ENDING:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_ENDING;
            case MIDDLE:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_MIDDLE;
            case TRANSITION:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_TRANSITION;
            case CLIP:
                return KMProto.KMProject.ThemeEffectType.THEME_EFFECT_TYPE_CLIP;
            default:
                return null;
        }
    }

    public static ThemeEffectType fromProtoBuf(KMProto.KMProject.ThemeEffectType themeEffectType) {
        if (themeEffectType == null) {
            return null;
        }
        switch (themeEffectType) {
            case THEME_EFFECT_TYPE_ACCENT:
                return ACCENT;
            case THEME_EFFECT_TYPE_OPENING:
                return OPENING;
            case THEME_EFFECT_TYPE_ENDING:
                return ENDING;
            case THEME_EFFECT_TYPE_MIDDLE:
                return MIDDLE;
            case THEME_EFFECT_TYPE_TRANSITION:
                return TRANSITION;
            case THEME_EFFECT_TYPE_CLIP:
                return CLIP;
            default:
                return null;
        }
    }
}
