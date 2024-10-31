package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeLibraryException extends AdobeCSDKException {
    private final String _description;
    private final AdobeLibraryErrorCode _errorCode;

    public AdobeLibraryException(AdobeLibraryErrorCode adobeLibraryErrorCode, String str, HashMap<String, Object> hashMap, Exception exc) {
        super(hashMap, exc);
        this._errorCode = adobeLibraryErrorCode;
        this._description = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        return this._description;
    }

    public AdobeLibraryErrorCode getErrorCode() {
        return this._errorCode;
    }

    public AdobeLibraryException(AdobeLibraryErrorCode adobeLibraryErrorCode, String str, Exception exc) {
        this(adobeLibraryErrorCode, str, null, exc);
    }

    public AdobeLibraryException(AdobeLibraryErrorCode adobeLibraryErrorCode, String str) {
        this(adobeLibraryErrorCode, str, null, null);
    }

    public AdobeLibraryException(AdobeLibraryErrorCode adobeLibraryErrorCode) {
        this(adobeLibraryErrorCode, null, null, null);
    }
}
