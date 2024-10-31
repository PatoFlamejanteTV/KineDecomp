package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

/* compiled from: AudioEffectContract.kt */
/* loaded from: classes2.dex */
public enum AudioEffectType {
    VOICE_CHANGER("voice_changer"),
    EQ("eq"),
    NORMAL(null);

    private final String path;

    AudioEffectType(String str) {
        this.path = str;
    }

    public final String getPath() {
        return this.path;
    }
}
