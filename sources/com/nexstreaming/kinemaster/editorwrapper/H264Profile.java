package com.nexstreaming.kinemaster.editorwrapper;

/* loaded from: classes.dex */
public enum H264Profile {
    AVCProfileBaseline(1),
    AVCProfileMain(2),
    AVCProfileExtended(3),
    AVCProfileHigh(4),
    AVCProfileHigh10(5),
    AVCProfileHigh422(6),
    AVCProfileHigh444(7);

    public final int value;

    H264Profile(int i) {
        this.value = i;
    }
}
