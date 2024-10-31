package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* loaded from: classes.dex */
public enum AdobeDCXMetadataErrorCode {
    UNKNOWN(0),
    BADPARAM(4),
    BADVALUE(5),
    INTERNALFAILURE(9),
    BADSCHEMA(101),
    BADXPATH(102),
    BADOPTIONS(103),
    BADINDEX(104),
    BADSERIALIZE(107),
    BADXML(201),
    BADRDF(202),
    BADXMP(203),
    BADSTREAM(204);

    private int _val;

    AdobeDCXMetadataErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
