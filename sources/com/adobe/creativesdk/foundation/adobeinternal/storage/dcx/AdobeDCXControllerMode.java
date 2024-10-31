package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* loaded from: classes.dex */
public enum AdobeDCXControllerMode {
    AdobeDCXControllerSyncing(0),
    AdobeDCXControllerPaused(1),
    AdobeDCXControllerStopped(2);

    private int _val;

    AdobeDCXControllerMode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
