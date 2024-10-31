package com.adobe.creativesdk.foundation.network;

import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdobeNetworkException extends AdobeCSDKException {
    static final String _domain = "AdobeNetworkErrorDomain";
    static final String _responseKey = "Response";
    private final AdobeNetworkErrorCode errorCode;

    /* loaded from: classes.dex */
    public enum AdobeNetworkErrorCode {
        AdobeNetworkErrorBadRequest,
        AdobeNetworkErrorNetworkFailure,
        AdobeNetworkErrorOffline,
        AdobeNetworkErrorCancelled,
        AdobeNetworkErrorAuthenticationFailed,
        AdobeNetworkErrorServiceDisconnected,
        AdobeNetworkErrorRequestForbidden,
        AdobeNetworkErrorInvalidDeviceId,
        AdobeNetworkErrorFileDoesNotExist,
        AdobeNetworkErrorNoCloudSpecified,
        AdobeNetworkErrorNotEntitledToService,
        AdobeNetworkErrorTimeout,
        AdobeNetworkErrorNoEnoughDeviceStorage
    }

    @Deprecated
    public AdobeNetworkException(AdobeNetworkErrorCode adobeNetworkErrorCode, HashMap<String, Object> hashMap, Exception exc) {
        super(hashMap, exc);
        this.errorCode = adobeNetworkErrorCode;
    }

    @Deprecated
    public static String getKeyForResponse() {
        return _responseKey;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        StringBuilder sb = new StringBuilder("Error : " + this.errorCode + " : ");
        HashMap<String, Object> hashMap = this._data;
        if (hashMap != null && hashMap.containsKey(_responseKey)) {
            l lVar = (l) this._data.get(_responseKey);
            if (lVar != null) {
                sb.append(lVar.d());
            }
        } else {
            sb.append(getErrorCode());
        }
        return sb.toString();
    }

    public AdobeNetworkErrorCode getErrorCode() {
        return this.errorCode;
    }

    public Integer getStatusCode() {
        HashMap<String, Object> hashMap = this._data;
        if (hashMap == null || !hashMap.containsKey(_responseKey)) {
            return null;
        }
        return Integer.valueOf(((l) this._data.get(_responseKey)).g());
    }

    @Deprecated
    public AdobeNetworkException(AdobeNetworkErrorCode adobeNetworkErrorCode, HashMap<String, Object> hashMap) {
        this(adobeNetworkErrorCode, hashMap, null);
    }

    @Deprecated
    public AdobeNetworkException(AdobeNetworkErrorCode adobeNetworkErrorCode) {
        this(adobeNetworkErrorCode, null, null);
    }
}
