package com.adobe.creativesdk.foundation.adobeinternal.cloud;

/* loaded from: classes.dex */
public enum AdobeCloudErrorCode {
    ADOBE_CLOUD_ERROR_UNEXPECTED_RESPONSE(2),
    ADOBE_CLOUD_ERROR_MISSING_JSON_DATA(11),
    ADOBE_CLOUD_ERROR_DECODE_FAILURE(3),
    ADOBE_CLOUD_ERROR_INVALID_CLOUD(4),
    ADOBE_CLOUD_ERROR_CLOUD_NOT_FOUND(5);

    private int val;

    AdobeCloudErrorCode(int i) {
        this.val = i;
    }

    public int getValue() {
        return this.val;
    }
}
