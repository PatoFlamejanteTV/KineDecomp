package com.adobe.creativesdk.foundation.adobeinternal.adobe360;

/* loaded from: classes.dex */
public enum Adobe360ErrorCode {
    Adobe360ErrorManifestReadFailure(0),
    Adobe360ErrorOperationCancelled(1),
    Adobe360ErrorInvalidPath(2),
    Adobe360ErrorInvalidMessageData(3),
    Adobe360ErrorUnknownMessageFormatVersion(4),
    Adobe360ErrorUnknownAssetName(5),
    Adobe360ErrorMissingAsset(6),
    Adobe360ErrorAssetFileDoesNotExist(7),
    Adobe360ErrorScalarVectorMismatch(8),
    Adobe360ErrorIncompleteElement(14),
    Adobe360ErrorUnsupportedAssetDataType(15),
    Adobe360ErrorIncorrectAssetDataType(16);

    private int _val;

    Adobe360ErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
