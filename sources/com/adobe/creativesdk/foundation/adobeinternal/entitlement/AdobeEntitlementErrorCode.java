package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

/* loaded from: classes.dex */
public enum AdobeEntitlementErrorCode {
    AdobeEntitlementErrorUnexpectedResponse(2),
    AdobeEntitlementErrorMissingJSONData(11),
    AdobeEntitlementErrorNoCloudsAvailable(12),
    AdobeEntitlementErrorNoServicesAvailable(13);

    private int _val;

    AdobeEntitlementErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
