package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeCloudException extends AdobeCSDKException {
    private final String description;
    private final AdobeCloudErrorCode errorCode;

    public AdobeCloudException(AdobeCloudErrorCode adobeCloudErrorCode, String str, HashMap<String, Object> hashMap, Exception exc) {
        super(hashMap, exc);
        this.errorCode = adobeCloudErrorCode;
        this.description = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        return this.description;
    }

    public AdobeCloudErrorCode getErrorCode() {
        return this.errorCode;
    }

    public AdobeCloudException(AdobeCloudErrorCode adobeCloudErrorCode, String str, Exception exc) {
        this(adobeCloudErrorCode, str, null, exc);
    }

    public AdobeCloudException(AdobeCloudErrorCode adobeCloudErrorCode, String str) {
        this(adobeCloudErrorCode, str, null, null);
    }

    public AdobeCloudException(AdobeCloudErrorCode adobeCloudErrorCode) {
        this(adobeCloudErrorCode, null, null, null);
    }
}
