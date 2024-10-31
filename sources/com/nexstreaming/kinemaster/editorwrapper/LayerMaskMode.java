package com.nexstreaming.kinemaster.editorwrapper;

/* loaded from: classes.dex */
public enum LayerMaskMode {
    Contributes(1),
    MaskedBy(2);

    private final int id;

    LayerMaskMode(int i) {
        this.id = i;
    }

    public static LayerMaskMode fromId(int i) {
        for (LayerMaskMode layerMaskMode : values()) {
            if (layerMaskMode.id == i) {
                return layerMaskMode;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }
}
