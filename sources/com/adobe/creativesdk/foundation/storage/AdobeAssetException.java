package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class AdobeAssetException extends AdobeCSDKException {
    private final AdobeAssetErrorCode errorCode;

    public AdobeAssetException(AdobeAssetErrorCode adobeAssetErrorCode, HashMap<String, Object> hashMap, Exception exc) {
        super(hashMap, exc);
        this.errorCode = adobeAssetErrorCode;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        return "Adobe Storage Error. Error code :" + this.errorCode;
    }

    public AdobeAssetErrorCode getErrorCode() {
        return this.errorCode;
    }

    public Integer getHttpStatusCode() {
        HashMap<String, Object> hashMap = this._data;
        if (hashMap != null && hashMap.containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)) {
            return (Integer) this._data.get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey);
        }
        return 0;
    }

    public AdobeAssetException(AdobeAssetErrorCode adobeAssetErrorCode, HashMap<String, Object> hashMap) {
        this(adobeAssetErrorCode, hashMap, null);
    }

    public AdobeAssetException(AdobeAssetErrorCode adobeAssetErrorCode) {
        this(adobeAssetErrorCode, null, null);
    }
}
