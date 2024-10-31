package com.adobe.creativesdk.foundation.adobeinternal.adobe360;

/* loaded from: classes.dex */
public enum Adobe360WorkflowErrorCode {
    Adobe360WorkflowErrorBadRequest(0),
    Adobe360WorkflowErrorFileSystemError(1),
    Adobe360WorkflowErrorNotAuthenticated(2),
    Adobe360WorkflowErrorActionRegistryUpdationInProgress(3);

    private int _val;

    Adobe360WorkflowErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
