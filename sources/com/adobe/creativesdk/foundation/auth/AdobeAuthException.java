package com.adobe.creativesdk.foundation.auth;

import android.text.TextUtils;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class AdobeAuthException extends AdobeCSDKException {
    public static final String KEY_ERROR_DESCRIPTION = "error_description";
    private final AdobeAuthErrorCode errorCode;

    public AdobeAuthException(AdobeAuthErrorCode adobeAuthErrorCode, HashMap<String, Object> hashMap) {
        super(hashMap);
        this.errorCode = adobeAuthErrorCode;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        HashMap<String, Object> data = getData();
        String obj = (data == null || TextUtils.isEmpty(data.get("error_description").toString())) ? null : data.get("error_description").toString();
        if (obj != null) {
            return obj;
        }
        return "Adobe Authentication Error. Error code: " + this.errorCode;
    }

    public AdobeAuthErrorCode getErrorCode() {
        return this.errorCode;
    }

    public AdobeAuthException(AdobeAuthErrorCode adobeAuthErrorCode) {
        this(adobeAuthErrorCode, null);
    }
}
