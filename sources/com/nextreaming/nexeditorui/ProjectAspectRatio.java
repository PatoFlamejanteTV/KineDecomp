package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public enum ProjectAspectRatio {
    R_16_9(1.7777778f, "16:9"),
    SQUARE(1.0f, "1:1"),
    R_9_16(0.5625f, "9:16");

    private final String mAspectRatioString;
    private final float mId;

    ProjectAspectRatio(float f2, String str) {
        this.mId = f2;
        this.mAspectRatioString = str;
    }

    public static ProjectAspectRatio fromId(float f2) {
        for (ProjectAspectRatio projectAspectRatio : values()) {
            if (projectAspectRatio.getValue() == f2) {
                return projectAspectRatio;
            }
        }
        return null;
    }

    public static ProjectAspectRatio fromProtoBuf(KMProto.KMProject.AspectRatio aspectRatio) {
        if (aspectRatio == null) {
            return null;
        }
        int i = kb.f24310b[aspectRatio.ordinal()];
        if (i == 1) {
            return R_16_9;
        }
        if (i == 2) {
            return SQUARE;
        }
        if (i != 3) {
            return null;
        }
        return R_9_16;
    }

    public KMProto.KMProject.AspectRatio asProtoBuf() {
        int i = kb.f24309a[ordinal()];
        if (i == 1) {
            return KMProto.KMProject.AspectRatio.ASPECT_R_16_9;
        }
        if (i == 2) {
            return KMProto.KMProject.AspectRatio.ASPECT_SQUARE;
        }
        if (i != 3) {
            return null;
        }
        return KMProto.KMProject.AspectRatio.ASPECT_R_9_16;
    }

    public String getString() {
        return this.mAspectRatioString;
    }

    public float getValue() {
        return this.mId;
    }
}
