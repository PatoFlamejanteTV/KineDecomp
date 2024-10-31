package com.adobe.creativesdk.foundation.internal.ucf;

/* loaded from: classes.dex */
public enum AdobeUCFErrorCode {
    AdobeUCFErrorArchiveInvalid(0),
    AdobeUCFErrorArchiveCreateFailed(1),
    AdobeUCFErrorArchiveWriteFailed(2),
    AdobeUCFErrorArchiveReadFailed(3),
    AdobeUCFErrorOperationCancelled(4);

    private int _val;

    AdobeUCFErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
