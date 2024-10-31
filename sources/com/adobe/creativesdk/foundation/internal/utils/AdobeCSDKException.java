package com.adobe.creativesdk.foundation.internal.utils;

import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class AdobeCSDKException extends Exception {
    public static final String AdobeErrorOtherErrorsKey = "AdobeErrorOtherErrorsKey";
    public static final String AdobeErrorPathKey = "AdobeErrorPathKey";
    protected HashMap<String, Object> _data;

    public AdobeCSDKException(HashMap<String, Object> hashMap) {
        this._data = hashMap;
    }

    public HashMap<String, Object> getData() {
        return this._data;
    }

    public abstract String getDescription();

    public AdobeCSDKException(HashMap<String, Object> hashMap, Exception exc) {
        super(exc);
        this._data = hashMap;
    }
}
