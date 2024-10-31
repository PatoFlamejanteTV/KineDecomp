package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public enum SplitScreenType {
    OFF(KMProto.KMProject.SplitScreenType.OFF),
    FULL(KMProto.KMProject.SplitScreenType.FULL),
    BOTTOM(KMProto.KMProject.SplitScreenType.BOTTOM),
    TOP(KMProto.KMProject.SplitScreenType.TOP),
    LEFT(KMProto.KMProject.SplitScreenType.LEFT),
    RIGHT(KMProto.KMProject.SplitScreenType.RIGHT);

    private final KMProto.KMProject.SplitScreenType protoBufId;

    SplitScreenType(KMProto.KMProject.SplitScreenType splitScreenType) {
        this.protoBufId = splitScreenType;
    }

    public KMProto.KMProject.SplitScreenType asProtoBuf() {
        return this.protoBufId;
    }

    public static SplitScreenType fromProtoBuf(KMProto.KMProject.SplitScreenType splitScreenType) {
        for (SplitScreenType splitScreenType2 : values()) {
            if (splitScreenType2.protoBufId == splitScreenType) {
                return splitScreenType2;
            }
        }
        return OFF;
    }
}
