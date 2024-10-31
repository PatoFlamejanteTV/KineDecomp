package com.adobe.creativesdk.foundation.storage;

/* loaded from: classes.dex */
public enum AdobeAssetErrorCode {
    AdobeAssetErrorBadRequest(0),
    AdobeAssetErrorNetworkFailure(1),
    AdobeAssetErrorUnexpectedResponse(2),
    AdobeAssetErrorOffline(3),
    AdobeAssetErrorCancelled(4),
    AdobeAssetErrorAuthenticationFailed(5),
    AdobeAssetErrorServiceDisconnected(6),
    AdobeAssetErrorConflictingChanges(7),
    AdobeAssetErrorFileReadFailure(8),
    AdobeAssetErrorFileWriteFailure(9),
    AdobeAssetErrorExceededQuota(10),
    AdobeAssetMissingJSONData(11),
    AdobeAssetErrorUnsupportedMedia(12),
    AdobeAssetErrorWrongEndpoint(13),
    AdobeAssetErrorNotEntitledToService(14),
    AdobeAssetErrorTimeout(15),
    AdobeAssetErrorForbiddenRequest(16),
    AdobeNoStorageSpaceInDeviceToDownload(17);

    private int _val;

    AdobeAssetErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
