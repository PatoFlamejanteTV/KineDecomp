package com.adobe.creativesdk.foundation.sendtodesktop;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeSendToDesktopException extends AdobeCSDKException {
    private String description;
    private final AdobeSendToDesktopErrorCode errorCode;

    public AdobeSendToDesktopException(AdobeSendToDesktopErrorCode adobeSendToDesktopErrorCode, HashMap<String, Object> hashMap, String str, Exception exc) {
        super(hashMap, exc);
        this.description = str;
        this.errorCode = adobeSendToDesktopErrorCode;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        return this.description;
    }

    public AdobeSendToDesktopErrorCode getErrorCode() {
        return this.errorCode;
    }

    public AdobeSendToDesktopException(AdobeSendToDesktopErrorCode adobeSendToDesktopErrorCode, HashMap<String, Object> hashMap, String str) {
        this(adobeSendToDesktopErrorCode, hashMap, str, null);
    }

    public AdobeSendToDesktopException(AdobeSendToDesktopErrorCode adobeSendToDesktopErrorCode) {
        this(adobeSendToDesktopErrorCode, null, null);
    }
}
