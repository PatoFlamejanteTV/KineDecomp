package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* loaded from: classes.dex */
public enum AdobeDCXSyncPhase {
    AdobeDCXSyncPhaseInSync(0),
    AdobeDCXSyncPhasePush(1),
    AdobeDCXSyncPhasePull(2),
    AdobeDCXSyncPhaseAccept(3),
    AdobeDCXSyncPhaseResolve(4),
    AdobeDCXSyncPhaseDelete(5),
    AdobeDCXSyncPhaseError(6);

    private int _val;

    AdobeDCXSyncPhase(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
