package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public enum ProjectAspectRatio {
    R_16_9("16:9"),
    SQUARE("1:1");

    private final String mId;

    ProjectAspectRatio(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public static ProjectAspectRatio fromId(String str) {
        for (ProjectAspectRatio projectAspectRatio : values()) {
            if (projectAspectRatio.getId().equals(str)) {
                return projectAspectRatio;
            }
        }
        return null;
    }

    public KMProto.KMProject.AspectRatio asProtoBuf() {
        switch (this) {
            case R_16_9:
                return KMProto.KMProject.AspectRatio.ASPECT_R_16_9;
            case SQUARE:
                return KMProto.KMProject.AspectRatio.ASPECT_SQUARE;
            default:
                return null;
        }
    }

    public static ProjectAspectRatio fromProtoBuf(KMProto.KMProject.AspectRatio aspectRatio) {
        if (aspectRatio == null) {
            return null;
        }
        switch (aspectRatio) {
            case ASPECT_R_16_9:
                return R_16_9;
            case ASPECT_SQUARE:
                return SQUARE;
            default:
                return null;
        }
    }
}
