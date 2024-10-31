package com.nextreaming.nexeditorui;

/* loaded from: classes.dex */
public enum WhichTimeline {
    PRIMARY,
    SECONDARY;

    public int getInt() {
        return this == PRIMARY ? 1 : 2;
    }
}
