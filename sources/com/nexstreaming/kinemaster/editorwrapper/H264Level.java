package com.nexstreaming.kinemaster.editorwrapper;

/* loaded from: classes.dex */
public enum H264Level {
    AVCLevel1(1),
    AVCLevel1b(2),
    AVCLevel11(4),
    AVCLevel12(8),
    AVCLevel13(16),
    AVCLevel2(32),
    AVCLevel21(64),
    AVCLevel22(128),
    AVCLevel3(256),
    AVCLevel31(512),
    AVCLevel32(1024),
    AVCLevel4(2048),
    AVCLevel41(4096),
    AVCLevel42(8192),
    AVCLevel5(16384),
    AVCLevel51(32768),
    AVCLevel52(65536);

    public final int value;

    H264Level(int i) {
        this.value = i;
    }
}
