package com.adobe.creativesdk.foundation.internal.utils.logging;

/* loaded from: classes.dex */
public enum Level {
    INFO(0),
    DEBUG(1),
    WARN(2),
    ERROR(3);

    private int _val;

    Level(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
