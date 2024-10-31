package com.adobe.creativesdk.foundation.internal.ucf;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeUCFException extends AdobeCSDKException {
    private final String _description;
    private final AdobeUCFErrorCode _errorCode;

    public AdobeUCFException(AdobeUCFErrorCode adobeUCFErrorCode, String str, HashMap<String, Object> hashMap, Exception exc) {
        super(hashMap, exc);
        this._errorCode = adobeUCFErrorCode;
        this._description = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        return this._description;
    }

    public AdobeUCFErrorCode getErrorCode() {
        return this._errorCode;
    }

    public AdobeUCFException(AdobeUCFErrorCode adobeUCFErrorCode, String str, Exception exc) {
        this(adobeUCFErrorCode, str, null, exc);
    }

    public AdobeUCFException(AdobeUCFErrorCode adobeUCFErrorCode, String str) {
        this(adobeUCFErrorCode, str, null, null);
    }

    public AdobeUCFException(AdobeUCFErrorCode adobeUCFErrorCode) {
        this(adobeUCFErrorCode, null, null, null);
    }
}
