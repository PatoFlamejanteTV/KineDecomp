package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public enum BlendMode {
    NONE(R.string.blending_normal, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_NONE, IABManager.BillingType.FREE),
    ADD(R.string.blending_add, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_ADD, IABManager.BillingType.PREMIUM),
    AVERAGE(R.string.blending_average, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_AVERAGE, IABManager.BillingType.PREMIUM),
    COLORBURN(R.string.blending_color_burn, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_COLOR_BURN, IABManager.BillingType.PREMIUM),
    COLORDODGE(R.string.blending_color_dodge, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_COLOR_DODGE, IABManager.BillingType.PREMIUM),
    DARKEN(R.string.blending_darken, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_DARKEN, IABManager.BillingType.PREMIUM),
    DIFFERNCE(R.string.blending_difference, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_DIFFERENCE, IABManager.BillingType.PREMIUM),
    EXCLUSION(R.string.blending_exclusion, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_EXCLUSION, IABManager.BillingType.PREMIUM),
    GLOW(R.string.blending_glow, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_GLOW, IABManager.BillingType.PREMIUM),
    HARDLIGHT(R.string.blending_hard_light, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_HARD_LIGHT, IABManager.BillingType.PREMIUM),
    HARDMIX(R.string.blending_hardmix, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_HARD_MIX, IABManager.BillingType.PREMIUM),
    LIGHTEN(R.string.blending_lighten, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_LIGHTEN, IABManager.BillingType.PREMIUM),
    LINEARBURN(R.string.blending_linear_burn, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_LINEAR_BURN, IABManager.BillingType.PREMIUM),
    LINEARDODGE(R.string.blending_linear_dodge, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_LINEAR_DODGE, IABManager.BillingType.PREMIUM),
    LINEARLIGHT(R.string.blending_linear_light, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_LINEAR_LIGHT, IABManager.BillingType.PREMIUM),
    MULTIPLY(R.string.blending_multiply, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_MULTIPLY, IABManager.BillingType.PREMIUM),
    NEGATION(R.string.blending_negation, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_NEGATION, IABManager.BillingType.PREMIUM),
    NORMAL(R.string.blending_normal, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_NORMAL, IABManager.BillingType.FREE),
    OVERLAY(R.string.blending_overlay, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_OVERLAY, IABManager.BillingType.FREE),
    PHOENIX(R.string.blending_phoenix, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_PHOENIX, IABManager.BillingType.PREMIUM),
    PINLIGHT(R.string.blending_pinlight, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_PIN_LIGHT, IABManager.BillingType.PREMIUM),
    REFLECT(R.string.blending_reflect, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_REFLECT, IABManager.BillingType.PREMIUM),
    SCREEN(R.string.blending_screen, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_SCREEN, IABManager.BillingType.PREMIUM),
    SOFTLIGHT(R.string.blending_soft_light, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_SOFT_LIGHT, IABManager.BillingType.PREMIUM),
    SUBTRACT(R.string.blending_subtract, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_SUBTRACT, IABManager.BillingType.PREMIUM),
    VIVIDELIGHT(R.string.blending_vividlight, KMProto.KMProject.LayerBlendModeType.LAYER_BLEND_VIVID_LIGHT, IABManager.BillingType.PREMIUM);

    private final KMProto.KMProject.LayerBlendModeType BlendModeType;
    private final int name;
    private final IABManager.BillingType paidtype;

    BlendMode(int i, KMProto.KMProject.LayerBlendModeType layerBlendModeType, IABManager.BillingType billingType) {
        this.name = i;
        this.BlendModeType = layerBlendModeType;
        this.paidtype = billingType;
    }

    public static BlendMode[] getDisplayedBlend() {
        return new BlendMode[]{NONE, OVERLAY, MULTIPLY, SCREEN, SOFTLIGHT, HARDLIGHT, LIGHTEN, DARKEN, COLORBURN};
    }

    public KMProto.KMProject.LayerBlendModeType getBlendModeType() {
        return this.BlendModeType;
    }

    public IABManager.BillingType getPaidType() {
        return this.paidtype;
    }

    public int getResid() {
        return this.name;
    }
}
