package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeCollaborationException extends AdobeCSDKException {
    private final String description;
    private final AdobeCollaborationErrorCode errorCode;

    public AdobeCollaborationException(AdobeCollaborationErrorCode adobeCollaborationErrorCode, HashMap<String, Object> hashMap, String str, Exception exc) {
        super(hashMap, exc);
        this.errorCode = adobeCollaborationErrorCode;
        this.description = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        String str = this.description;
        if (str != null) {
            return str;
        }
        return "Adobe Collaboration Error. Error code :" + this.errorCode;
    }

    public AdobeCollaborationErrorCode getErrorCode() {
        return this.errorCode;
    }

    public Integer getHttpStatusCode() {
        HashMap<String, Object> hashMap = this._data;
        if (hashMap != null && hashMap.containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)) {
            return (Integer) this._data.get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey);
        }
        return 0;
    }

    public AdobeCollaborationException(AdobeCollaborationErrorCode adobeCollaborationErrorCode, HashMap<String, Object> hashMap, String str) {
        this(adobeCollaborationErrorCode, hashMap, str, null);
    }

    public AdobeCollaborationException(AdobeCollaborationErrorCode adobeCollaborationErrorCode) {
        this(adobeCollaborationErrorCode, null, null);
    }
}
