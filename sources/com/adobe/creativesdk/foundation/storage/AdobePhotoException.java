package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobePhotoException extends AdobeCSDKException {
    private final String description;
    private final AdobePhotoErrorCode errorCode;

    public AdobePhotoException(AdobePhotoErrorCode adobePhotoErrorCode, HashMap<String, Object> hashMap, String str, Exception exc) {
        super(hashMap, exc);
        this.errorCode = adobePhotoErrorCode;
        this.description = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        String str = this.description;
        if (str != null) {
            return str;
        }
        return "Adobe Photo Error. Error code :" + this.errorCode;
    }

    public AdobePhotoErrorCode getErrorCode() {
        return this.errorCode;
    }

    public AdobePhotoException(AdobePhotoErrorCode adobePhotoErrorCode, HashMap<String, Object> hashMap, String str) {
        this(adobePhotoErrorCode, hashMap, str, null);
    }

    public AdobePhotoException(AdobePhotoErrorCode adobePhotoErrorCode) {
        this(adobePhotoErrorCode, null, null);
    }
}
