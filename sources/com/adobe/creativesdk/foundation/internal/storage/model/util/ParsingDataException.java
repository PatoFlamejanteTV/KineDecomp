package com.adobe.creativesdk.foundation.internal.storage.model.util;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* loaded from: classes.dex */
public class ParsingDataException extends Exception {
    private AdobeAssetException _error;

    public ParsingDataException(AdobeAssetException adobeAssetException) {
        this._error = adobeAssetException;
    }

    public AdobeAssetException getError() {
        return this._error;
    }
}
